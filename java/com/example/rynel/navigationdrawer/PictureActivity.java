package com.example.rynel.navigationdrawer;


import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//activity not reaching onClick from first layout to PictureActivity:

//java.lang.IllegalStateException: Could not find method btnTakePicture(View) in a parent or
// ancestor Context for android:onClick attribute defined on view class
// android.support.v7.widget.AppCompatButton with id 'btnTakePicture'

public class PictureActivity extends AppCompatActivity {

    //declaring variables for taking photo
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


         //attempted action bar customization
        ActionBar mActionBar = getActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        //setting color of action bar
        mActionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));


        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setText("My Custom Bar!");

        ImageButton imageButton = (ImageButton) mCustomView
                .findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {


            //There may be some redundancy
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Refresh Clicked!",
                        Toast.LENGTH_LONG).show();
            }
        });

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
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