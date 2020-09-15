package com.example.stackimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import app.com.stackimageview.customviews.StackImageView;
import app.com.stackimageview.interfaces.OnImageClickListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "로그";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final StackImageView stackImageView = findViewById(R.id.stackImageView);
        stackImageView.setImageLists(setImageResources());

        stackImageView.setOnImageClickListener(new OnImageClickListener() {
            @Override
            public void onClick() {
                // Handle StackImageView Click.

            }
        });

        // TODO: 주석달기
        stackImageView.setMaxVisibleImage(3);
        stackImageView.setImageGap(-20);
        stackImageView.setImageDimen(45);
        stackImageView.setImageBorderWidth(2);
        stackImageView.setImageBorderColor(R.color.white);
        stackImageView.setImageLoaderVisibility(true);
        stackImageView.setImageLoaderDimen(16);
        stackImageView.setImageLoaderColor(R.color.white);
        stackImageView.setImagePHVisibility(true);
        stackImageView.setImagePHDimen(30);
        stackImageView.setImagePlaceHolder(R.drawable.ic_launcher_foreground);
        stackImageView.setImageBackgroundColor(R.color.dark_cyan);

        stackImageView.setCountDimen(45);
//        stackImageView.setCountBorderColor(R.color.white);
        stackImageView.setCountViewPosition(StackImageView.COUNT_POSITION_AFTER);
//        stackImageView.setCountBgColor(R.color.light_white);
//        stackImageView.setCountTextColor(#FFFFFFFF);
        stackImageView.setCountTextSize(20);

        stackImageView.setCountTextFont(R.font.lobster);
        stackImageView.setCountImageInsteadOfText(false);
        stackImageView.setCountImageDimen(30);
//        stackImageView.setCountImageSource(R.drawable.ic_more_icon);
        stackImageView.setOverlapType(StackImageView.BOTTOM_TO_TOP_OVERLAP);



    }

    private ArrayList<Object> setImageResources() {
        ArrayList<Object> imageLists = new ArrayList<>();
        imageLists.add(R.drawable.demo_face_1);
        imageLists.add(R.drawable.demo_face_2);
        imageLists.add(R.drawable.demo_face_3);
        imageLists.add(R.drawable.demo_face_4);
        imageLists.add(R.drawable.demo_face_5);
        imageLists.add(R.drawable.demo_face_6);
        imageLists.add(R.drawable.demo_face_1);
        imageLists.add(R.drawable.demo_face_2);
        imageLists.add(R.drawable.demo_face_3);
        imageLists.add(R.drawable.demo_face_4);
        imageLists.add(R.drawable.demo_face_5);
        imageLists.add(R.drawable.demo_face_6);

        return imageLists;
    }
}