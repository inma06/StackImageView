package com.example.stackimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import app.com.stackimageview.customviews.StackImageView;
import app.com.stackimageview.interfaces.OnImageClickListener;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "로그";
    private boolean isCountOfText = false;
    private Button btn_setChange, btn_addImage, btn_removeImage, btn_setMaxImage;
    private EditText et_setMaxImage;
    private StackImageView stackImageView;

    private ArrayList<Object> imageLists = new ArrayList<>();

    /* TOAST VIEW
     * Just Once Toast View
     * This is SingleTon Pattern
     * */
    private static Toast sToast;
    public static void showToast(Context context, String message) {
        if (sToast == null) {
            sToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(message);
        }
        sToast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* View Id Matching */
        btn_addImage = findViewById(R.id.btn_addImage);
        btn_removeImage = findViewById(R.id.btn_removeImage);
        btn_setChange = findViewById(R.id.btn_setChange);
        btn_setMaxImage = findViewById(R.id.btn_setMaxImage);
        stackImageView = findViewById(R.id.stackImageView);
        et_setMaxImage = findViewById(R.id.et_setMaxImage);

        /* On Click Listener */
        findViewById(R.id.btn_addImage).setOnClickListener(btnClickListener);
        findViewById(R.id.btn_setChange).setOnClickListener(btnClickListener);
        findViewById(R.id.btn_removeImage).setOnClickListener(btnClickListener);
        findViewById(R.id.btn_setMaxImage).setOnClickListener(btnClickListener);
        findViewById(R.id.stackImageView).setOnClickListener(btnClickListener);

        /* init for imageList with Demo Images */
        imageLists.add(R.drawable.demo_face_1);
        imageLists.add(R.drawable.demo_face_2);
        imageLists.add(R.drawable.demo_face_3);
        imageLists.add(R.drawable.demo_face_4);
        imageLists.add(R.drawable.demo_face_5);
        imageLists.add(R.drawable.demo_face_6);

        // Binding ImageLists to stackImageView
        stackImageView.setImageLists(imageLists);
        // Settings SIV
        stackImageViewSettings();

      }

    private Button.OnClickListener btnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btn_addImage:
                    // 이미지 추가
                    if (!imageLists.isEmpty()) {
                        imageLists.add(imageLists.size() - 1, R.drawable.demo_face_1);
                    } else {
                        imageLists.add(R.drawable.demo_face_1);
                        stackImageViewSettings();
                    }
                    stackImageView.setImageLists(imageLists);
                    break;

                case R.id.btn_removeImage:
                    // 이미지 제거
                    if (!imageLists.isEmpty()){
                        imageLists.remove(imageLists.size() - 1);
                        stackImageView.setImageLists(imageLists);
                    } else {
                        showToast(MainActivity.this, "Empty Images");
                    }
                    break;

                case R.id.btn_setChange:
                    // 더보기 이미지 표시 변경
                    if(isCountOfText == false){
                        stackImageView.setCountImageInsteadOfText(true);
                        isCountOfText = true;
                        showToast(MainActivity.this, "Changed Image");

                    } else {
                        stackImageView.setCountImageInsteadOfText(false);
                        isCountOfText = false;
                        showToast(MainActivity.this, "Changed Text");
                    }
                    break;

                case R.id.btn_setMaxImage:
                    int maxImage = Integer.parseInt(et_setMaxImage.getText().toString());
                    stackImageView.setMaxVisibleImage(maxImage);
                    showToast(MainActivity.this, "Change Max Visible is : " + maxImage);
                    break;

                case R.id.stackImageView:
                    showToast(MainActivity.this, "Clicked Stack Image View");
                    break;


            }
        }
    };

    private void stackImageViewSettings() {
        // TODO: 주석달기 Plz Writing Comment :)
        // SIV is meaning stackImageView
        stackImageView.setMaxVisibleImage(4); // 이미지 최대 출력 수
        stackImageView.setImageGap(-20); // 이미지간 간격
        stackImageView.setImageDimen(45); // 이미지 크기
        stackImageView.setImageBorderWidth(2); // 이미지 테두리 굵기
        stackImageView.setImageBorderColor(R.color.white); // 이미지 테두리 색상
//        stackImageView.setImageLoaderVisibility(false); // ?
//        stackImageView.setImageLoaderDimen(16); // ?
//        stackImageView.setImageLoaderColor(R.color.white); // ?
//        stackImageView.setImagePHVisibility(true);
//        stackImageView.setImagePHDimen(30);
//        stackImageView.setImagePlaceHolder(R.drawable.ic_launcher_foreground);
//        stackImageView.setImageBackgroundColor(R.color.dark_cyan);

        stackImageView.setCountDimen(40); // 이미지 카운트 뷰 크기
//        stackImageView.setCountBorderColor(R.color.white);
        stackImageView.setCountViewPosition(StackImageView.COUNT_POSITION_AFTER); // 카운트 뷰 위치
        stackImageView.setCountBgColor(R.color.colorPrimary);
//        stackImageView.setCountTextColor(#FFFFFFFF);
        stackImageView.setCountTextSize(20);

//        stackImageView.setCountTextFont(R.font.lobster);
//        stackImageView.setCountImageInsteadOfText(true); // default ->  false -> 숫자로 표시, true -> 이미지(...) 으로표시
        stackImageView.setCountImageDimen(30);
        stackImageView.setCountImageSource(R.drawable.ic_more_icon);
        stackImageView.setOverlapType(StackImageView.BOTTOM_TO_TOP_OVERLAP);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }
}