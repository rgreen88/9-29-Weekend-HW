package com.example.rynel.navigationdrawer;

/**
 * Created by rynel on 9/30/2017.
 */
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SecondFragment extends Fragment{

    View myView;

    @Nullable
    @Override

    //creating View object myView

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        //Instantiating myView object inside of onCreateView() method
        myView = inflater.inflate(R.layout.second_layout, container, false);
        return myView;
    }
}
