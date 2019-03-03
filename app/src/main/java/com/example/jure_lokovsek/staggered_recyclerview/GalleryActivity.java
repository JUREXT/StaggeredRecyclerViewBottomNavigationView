package com.example.jure_lokovsek.staggered_recyclerview;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/**
 * Created by Jure_Lokovsek on 03. 03. 2019.
 */

public class GalleryActivity extends Activity {

    public static String CONTENT1 = "content1";
    public static String CONTENT2 = "content2";
    public static String IMAGE = "image";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galllery);
        setTitle("Details");

        getIntentData();
    }

    private void getIntentData(){
        if(getIntent().hasExtra(GalleryActivity.IMAGE) && getIntent().hasExtra(GalleryActivity.CONTENT1) && getIntent().hasExtra(GalleryActivity.CONTENT2)){
            String image = getIntent().getStringExtra(GalleryActivity.IMAGE);
            String content1 = getIntent().getStringExtra(GalleryActivity.CONTENT1);
            String content2 = getIntent().getStringExtra(GalleryActivity.CONTENT2);
            setDetails(content1, content2, image);
        }else{
            Toast.makeText(this, "No data from the Intent!", Toast.LENGTH_LONG).show();
        }
    }

    private void setDetails(String content1, String content2, String image){
        TextView content1Tv = findViewById(R.id.content1);
        content1Tv.setText(content1);
        TextView content2Tv = findViewById(R.id.content2);
        content2Tv.setText(content2);
        ImageView imageIv = findViewById(R.id.image);
        Glide.with(this).load(image).into(imageIv);
    }

}
