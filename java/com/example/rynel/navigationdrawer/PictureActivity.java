package com.example.rynel.navigationdrawer;


import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PictureActivity extends AppCompatActivity {

    //declaring variables holding int 1-100 during drag and holding photo taken
    private ImageView pictureTaken;
    static final int takePicture = 1;

    //declaring action to button for onClick in xml
    public Button btnTakePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting reference from xml to java
        pictureTaken = (ImageView) findViewById(R.id.ivPicture);
        btnTakePicture = (Button) findViewById(R.id.btnTakePicture);

    }



    //Creating intent to take a picture
    public void btnTakePicture(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, takePicture);

        }
    }


    //Creating a thumbnail as picture placeholder in imageview
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (requestCode == takePicture && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            pictureTaken.setImageBitmap(imageBitmap);
        }

    }



}