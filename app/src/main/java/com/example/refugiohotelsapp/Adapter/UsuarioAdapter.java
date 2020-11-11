package com.example.refugiohotelsapp.Adapter;

import android.widget.BaseAdapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.refugiohotelsapp.Entidades.Usuario;
import com.example.refugiohotelsapp.loginUsarioActivity;
import com.example.refugiohotelsapp.R;
import com.example.refugiohotelsapp.cadastroUsuarioActivity;

import java.util.List;


public class UsuarioAdapter extends BaseAdapter {
    private Context context;
    private List<Usuario> list;

    public UsuarioAdapter(Context context, List<Usuario> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0).getIdUsuario();
    }

    @Override
    public View getView(int position, View arg1, final ViewGroup arg2) {
        final int auxPosition = position;
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout layout = (LinearLayout)
                inflater.inflate(R.layout.activity_main, null);
               // inflater.inflate(R.layout.usuario, null);
       // TextView tv = (TextView) layout.findViewById(R.id.email);
        //TextView tv2 = (TextView) layout.findViewById(R.id.senha);
        //tv.setText(list.get(position).getEmail());
        //tv2.setText(list.get(position).getSenha());

        EditText etEmail = (EditText) layout.findViewById(R.id.editTextTextEmailAddress);
        EditText etSenha = (EditText) layout.findViewById(R.id.editTextTextPassword);

        etEmail.setText(list.get(position).getEmail());
        etSenha.setText(list.get(position).getSenha());

        //Evento para efetuar o login do Usuario no Sistema
        Button loginBt = (Button) layout.findViewById(R.id.buttonLogin);
        loginBt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, loginUsarioActivity.class);
                intent.putExtra("email", list.get(auxPosition).getEmail());
                intent.putExtra("senha", list.get(auxPosition).getSenha());
                intent.putExtra("id", list.get(auxPosition).getIdUsuario());
                context.startActivity(intent);
            }
        });
        //Evento responsavél pelo cadastro, encaminha para outra tela para realziar cadastro
        Button cadastrarBt = (Button) layout.findViewById(R.id.buttonCadastro);
        cadastrarBt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //BD bd = new BD(context);
                //bd.deletar(list.get(auxPosition));
                layout.setVisibility(View.GONE);
                Intent intent = new Intent(context, cadastroUsuarioActivity.class);
                context.startActivity(intent);
            }
        });
        return layout;
    }
}
