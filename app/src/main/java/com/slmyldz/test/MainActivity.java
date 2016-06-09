package com.slmyldz.test;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.felipecsl.gifimageview.library.GifImageView;
import com.slmyldz.random.BitmapListener;
import com.slmyldz.random.GifListener;
import com.slmyldz.random.Randoms;
import com.slmyldz.test.R;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity implements GifListener {



    GifImageView gif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.id_toolbar));
        gif = (GifImageView) findViewById(R.id.gif);
        refresh();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.refresh){
            refresh();
        }

        return super.onOptionsItemSelected(item);
    }

    private void refresh() {
        TextView name = (TextView) findViewById(R.id.name);
        TextView description = (TextView) findViewById(R.id.description);
        TextView age = (TextView) findViewById(R.id.age);
        final ImageView profile = (ImageView) findViewById(R.id.profile);
        TextView mail = (TextView) findViewById(R.id.mail);
        TextView gender = (TextView) findViewById(R.id.gender);

        name.setText(Randoms.nameWithEnglishHonorific(this));

        description.setText(Randoms.sentence(this));

        age.setText(Randoms.Integer(35,65)+"");

        Randoms.imageAvatar(new BitmapListener() {
            @Override
            public void onSuccess(Bitmap bitmap) {
                profile.setImageBitmap(bitmap);
            }

            @Override
            public void onFailure(Exception e) {

            }
        },150);

        mail.setText(Randoms.email(this));

        gender.setText(Randoms.gender());

        Randoms.imageGif(this);

    }

    byte[] getBytes(Bitmap bitmap){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onSuccess(byte[] bitmap) {
        gif.setBytes(bitmap);
        gif.startAnimation();
    }

    @Override
    public void onFailure(Exception e) {

    }
}
