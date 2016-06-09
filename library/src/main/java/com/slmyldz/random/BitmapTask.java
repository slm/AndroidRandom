package com.slmyldz.random;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by slmyldz on 09.06.2016.
 */
@TargetApi(Build.VERSION_CODES.CUPCAKE)
public class BitmapTask extends AsyncTask<String,Bitmap,Bitmap> {

    WeakReference<BitmapListener> listener;
    Exception e;
    public void setListener(BitmapListener listener) {
        this.listener = new WeakReference<BitmapListener>(listener);
    }

    @Override
    protected Bitmap doInBackground(String... params) {

        try {
            URL imageUrl = new URL(params[0]);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setInstanceFollowRedirects(true);
            InputStream is = conn.getInputStream();

            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            bmOptions.inSampleSize = 1;
            Bitmap bitmap = BitmapFactory.decodeStream(is, null, bmOptions);
            is.close();

            return bitmap;
          }catch (Exception e){
            Log.i("Randoms", "BitmapTask =>"+ e.getMessage());
            this.e = e;
            return null;
        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(listener.get() == null){
            Log.i("Randoms","Listener NULL");
            return;
        }
        if(bitmap==null){
            if(e!=null){
                listener.get().onFailure(e);
            }
        }

        listener.get().onSuccess(bitmap);

    }
}
