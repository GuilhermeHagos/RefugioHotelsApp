package com.example.refugiohotelsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class homeActivity extends Activity {

    private ImageView im;
    private ImageView im3;
    private ImageView im4;
    private TextView textview;
    private TextView textview2;
    private TextView textview5;
    private TextView textview6;
    private TextView textview7;
    private TextView textview8;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        im = (ImageView) findViewById(R.id.imageView);
        textview = (TextView) findViewById(R.id.textView);
        textview2 = (TextView) findViewById(R.id.textView2);

        im3 = (ImageView) findViewById(R.id.imageView3);
        textview5 = (TextView) findViewById(R.id.textView5);
        textview6 = (TextView) findViewById(R.id.textView6);

        im4 = (ImageView) findViewById(R.id.imageView4);
        textview7 = (TextView) findViewById(R.id.textView7);
        textview8 = (TextView) findViewById(R.id.textView8);



        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeActivity.this, ReservaActivity.class);
                startActivity(intent);
            }
        });
        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeActivity.this, ReservaActivity.class);
                startActivity(intent);
            }
        });

        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeActivity.this, ReservaActivity.class);
                startActivity(intent);
            }
        });
    }
}
