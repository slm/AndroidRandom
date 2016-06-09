package com.slmyldz.random;

import android.graphics.Bitmap;

/**
 * Created by slmyldz on 09.06.2016.
 */
public interface BitmapListener {

    void onSuccess(Bitmap bitmap);
    void onFailure(Exception e);


}
