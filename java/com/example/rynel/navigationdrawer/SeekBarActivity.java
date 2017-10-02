package com.example.rynel.navigationdrawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekBarActivity extends AppCompatActivity {

    SeekBar seekBar;

    TextView textView;

    int progress = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.SeekBar);
        seekBar.setMax(100);
        seekBar.setProgress(progress);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText("" + progress);
        textView.setTextSize(progress);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b){
                    progress = i;
                    textView.setText("" + progress);
                    textView.setTextSize(progress);
            }

            @Override
                public void onStartTrackingTouch(SeekBar seekBar){

            }

            @Override
                public void onStopTrackingTouch(SeekBar seekBar){

            }


        });
    }
}
