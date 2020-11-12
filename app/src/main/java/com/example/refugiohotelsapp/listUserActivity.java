package com.example.refugiohotelsapp;

import android.app.ListActivity;
import android.os.Bundle;

import com.example.refugiohotelsapp.Adapter.UsuarioAdapter;
import com.example.refugiohotelsapp.Banco.FuncoesBanco;
import com.example.refugiohotelsapp.Entidades.Usuario;

import java.util.List;

public class listUserActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        FuncoesBanco bd = new FuncoesBanco(this);

        List<Usuario> list = bd.ListarUsuario();
        setListAdapter(new UsuarioAdapter(this,list));
    }
}
