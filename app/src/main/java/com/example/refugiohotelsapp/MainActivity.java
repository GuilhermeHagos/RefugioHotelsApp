package com.example.refugiohotelsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void getActivity(View view){
            Button bt = (Button) view;
            Intent intent;

            if (bt.getText().toString().equalsIgnoreCase("Cadastre-se")) {
                intent = new Intent(this, cadastroUsuarioActivity.class);
            } else {
                //intent = new Intent(this, loginUsarioActivity.class);

                intent = new Intent(this, listUserActivity.class);
            }

            startActivity(intent);

    }
}