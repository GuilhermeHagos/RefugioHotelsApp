package com.example.refugiohotelsapp;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class DBCore extends SQLiteOpenHelper {
    private static final String NomeBanco= "RefugioHotelsDatabase";
    private static final int VersaoBanco = 1;

    public DBCore(Context ctx){
        super(ctx, NomeBanco, null, VersaoBanco);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("create table usuario" +
                "(_id integer primary key autoincrement, nome text not null, email text not null," +
                " senha text not null)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
        bd.execSQL("drop table usuario;");
        onCreate(bd);
    }

}
