package com.onclick.angie.oneclick_v20;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Angie on 9/28/2017.
 */

public class PicassoClient {

    public static void downloadImage(Context context, String url, ImageView image){
        if(url != null && url.length()>0){
            Picasso.with(context).load(url).placeholder(R.drawable.placeholder).into(image);
        }
        else{
            Picasso.with(context).load(R.drawable.placeholder).into(image);
        }
    }
}
