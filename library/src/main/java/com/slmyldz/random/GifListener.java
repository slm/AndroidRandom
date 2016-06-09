package com.slmyldz.random;

import android.graphics.Bitmap;

/**
 * Created by slmyldz on 09.06.2016.
 */
public interface GifListener {

    void onSuccess(byte[] bitmap);
    void onFailure(Exception e);


}
