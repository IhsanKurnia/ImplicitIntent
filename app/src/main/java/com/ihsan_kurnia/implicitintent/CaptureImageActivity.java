package com.ihsan_kurnia.implicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CaptureImageActivity extends AppCompatActivity {
    private  Button btnCaptureImage;
    private ImageView imgSelectedImage;
    private final int CAPTURE_IMAGE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);

        btnCaptureImage = findViewById(R.id.btn_capture_image);
        imgSelectedImage = findViewById(R.id.image_selected);

        btnCaptureImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAPTURE_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CAPTURE_IMAGE){
            if (data!=null && data.getExtras() !=null){
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imgSelectedImage.setImageBitmap(bitmap);

            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}