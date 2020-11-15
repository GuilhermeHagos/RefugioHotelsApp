package com.example.refugiohotelsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, loginUsarioActivity.class);
                startActivity(intent);
            }
        });
        final Button buttonCadastro = (Button) findViewById(R.id.buttonCadastro);
        buttonCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, cadastroUsuarioActivity.class);
                startActivity(intent);
            }
        });
    }





    /*public void getActivity(View view){
            Button bt = (Button) view;
            Intent intent;

            if (bt.getText().toString().equalsIgnoreCase("BtLogin")) {
                intent = new Intent(this, loginUsarioActivity.class);
            } else {
                intent = new Intent(this, cadastroUsuarioActivity.class);

                //intent = new Intent(this, listUserActivity.class);
            }

            startActivity(intent);


     */

}