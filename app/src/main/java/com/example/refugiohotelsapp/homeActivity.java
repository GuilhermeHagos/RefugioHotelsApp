package com.example.refugiohotelsapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class homeActivity extends Activity {

    private ImageView im;
    private TextView textview;
    private TextView textview2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        im = (ImageView) findViewById(R.id.imageView);
        textview = (TextView) findViewById(R.id.textView);
        textview = (TextView) findViewById(R.id.textView2);
    }
}
