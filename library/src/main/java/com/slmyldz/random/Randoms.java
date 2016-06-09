package com.slmyldz.random;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;

import com.slmyldz.library.R;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by slmyldz on 09.06.2016.
 */
public class Randoms {


    private static Random random = new Random();
    /**
     * Random integer betweeb a-b
     * @param min
     * @param max
     * @return
     */
    public static int Integer(int min , int max){
        return random.nextInt(max - min + 1) + min;
    }

    public static double Double(double min , double max){
        return min + (max - min) * random.nextDouble();
    }

    public static float Float(float min , float max){
        return random.nextFloat() * (max - min) + min;
    }

    public static boolean Boolean(){
        return new boolean[]{true,false}[Integer(0,1)];
    }

    public static String alphaNumericString(int length){
        return new RandomAlphaNumeric(length).nextString();
    }

    public static Date dateBefore(){
        Calendar gc = Calendar.getInstance();
        int year = Integer(1970,gc.get(Calendar.YEAR)-1);
        gc.set(gc.YEAR, year);
        int dayOfYear = Integer(1, gc.getActualMaximum(gc.DAY_OF_MONTH));
        gc.set(gc.DAY_OF_MONTH, dayOfYear);
        return gc.getTime();
    }

    public static Date dateAfter(){
        Calendar gc = Calendar.getInstance();
        int year = Integer(gc.get(Calendar.YEAR)+1,2500);
        gc.set(gc.YEAR, year);
        int dayOfYear = Integer(1,365);
        gc.set(gc.DAY_OF_YEAR, dayOfYear+1);
        return gc.getTime();
    }

    public static String url(Context context){
        String[] urls= context.getResources().getStringArray(R.array.urls);
        return urls[Integer(0,urls.length-1)];
    }

    public static String name(Context context){
        String[] names= context.getResources().getStringArray(R.array.names);
        return names[Integer(0,names.length-1)];
    }

    public static String nameWithEnglishHonorific(Context context){
        String[] honorifics= context.getResources().getStringArray(R.array.honorifics);
        return honorifics[Integer(0,honorifics.length-1)]+" "+name(context);
    }

    public static String gender(){
        return new String[]{"Female","Male"}[Integer(0,1)];
    }

    public static String sentence(Context context){
        String[] sentences= context.getResources().getStringArray(R.array.sentences);
        return sentences[Integer(0,sentences.length-1)];
    }

    public static String currency(Context context){
        String[] currencies= context.getResources().getStringArray(R.array.currencies);
        return currencies[Integer(0,currencies.length-1)];
    }

    /**
     * random cat images
     * @param type jpg png gif
     * @return
     */
    public static String imageUrl(String type){
        return "http://thecatapi.com/api/images/get?format=src&type="+type;
    }


    /**
     * random cat images bitmap
     * @param type jpg png gif
     * @return
     */
    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    public static void image(BitmapListener listener, String type){
        BitmapTask task = new BitmapTask();
        task.setListener(listener);
        task.execute(imageUrl(type));
    }

    public static String imageUrl(int width,int height){
        return "http://loremflickr.com/"+width+"/"+height;
    }

    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    public static void imageGif(GifListener listener){
        GifTask task = new GifTask();
        task.setListener(listener);
        task.execute(imageUrl("gif"));
    }



    public static void image(BitmapListener listener,int width,int height){
        BitmapTask task = new BitmapTask();
        task.setListener(listener);
        task.execute(imageUrl(width,height));
    }


    public static String imagePlaceholderUrl(String text,int textSize,int width,int height){
        return "https://placeholdit.imgix.net/~text?txtsize="+textSize+"&txt="+text+"&w="+width+"&h="+height;
    }

   
    public static void imagePlaceHolder(BitmapListener listener,String text,int textSize,int width,int height){
        BitmapTask task = new BitmapTask();
        task.setListener(listener);
        task.execute(imagePlaceholderUrl(text,textSize,width,height));
    }

    public static String imageAvatarUrl(int size){
        return "http://www.avatarpro.biz/avatar?s="+size;
    }
    
    public static void imageAvatar(BitmapListener listener,int size){
        BitmapTask task = new BitmapTask();
        task.setListener(listener);
        task.execute(imageAvatarUrl(size));
    }

    public static String email(Context context){
        return name(context).replace(" ","").toLowerCase()+Integer(10,99)+"@example.com";
    }



}
