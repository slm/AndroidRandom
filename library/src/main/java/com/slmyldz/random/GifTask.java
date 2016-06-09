package com.slmyldz.random;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by slmyldz on 09.06.2016.
 */
@TargetApi(Build.VERSION_CODES.CUPCAKE)
public class GifTask extends AsyncTask<String,byte[],byte[]> {

    WeakReference<GifListener> listener;
    Exception e;
    public void setListener(GifListener listener) {
        this.listener = new WeakReference<GifListener>(listener);
    }

    @Override
    protected byte[] doInBackground(String... params) {

        try {
            URL imageUrl = new URL(params[0]);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setInstanceFollowRedirects(true);
            InputStream is = conn.getInputStream();


            return readFully(is);
          }catch (Exception e){
            Log.i("Randoms", "BitmapTask =>"+ e.getMessage());
            this.e = e;
            return null;
        }
    }

    @Override
    protected void onPostExecute(byte[] bitmap) {
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

    public static byte[] readFully(InputStream input) throws IOException
    {
        byte[] buffer = new byte[8192];
        int bytesRead;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        while ((bytesRead = input.read(buffer)) != -1)
        {
            output.write(buffer, 0, bytesRead);
        }
        return output.toByteArray();
    }
}
