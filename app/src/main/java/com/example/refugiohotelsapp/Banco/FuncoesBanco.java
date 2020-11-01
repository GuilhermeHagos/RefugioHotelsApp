package com.example.refugiohotelsapp.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.refugiohotelsapp.Entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

class FuncoesBanco {
//reliza funções do crud, insert, read, update e delete
     private SQLiteDatabase bd;

    public FuncoesBanco(Context context){
        DBCore auxBd = new DBCore(context);
        bd = auxBd.getWritableDatabase();
    }
    //Inserir Usuario na tabela Usuario
    public void inserir(Usuario usuario){
        ContentValues valores = new ContentValues();
        valores.put("nome",usuario.getNome());
        valores.put("email", usuario.getEmail());
        valores.put("senha",usuario.getSenha());

        bd.insert("Usuario",null,valores);
    }
    //update na tabela Usuario
    public void atualizar(Usuario usuario){
        ContentValues valores = new ContentValues();
        valores.put("nome",usuario.getNome());
        valores.put("email", usuario.getEmail());
        valores.put("senha",usuario.getSenha());

        bd.update("Usuario",valores,"idUsuario = ?",
                new String[]{""+usuario.getIdUsuario()});
    }
    //deletar
    public void deletar(Usuario usuario){
        bd.delete("Usuario","idUsuario = "+ usuario.getIdUsuario(),null);
    }
    //select para trazer usuarios, pôr em lista e percorrer lista
    public List<Usuario> buscar(){
        List<Usuario> list = new ArrayList<Usuario>();
        String[] colunas = new String[]{"idUsuario","nome","email","senha"};

        Cursor cursor = bd.query("Usuario", colunas, null,
                null, null,null,"nome ASC");

        if(cursor.getCount()>0){
            cursor.moveToFirst();

            do{
                Usuario u = new Usuario();
                u.setIdUsuario(cursor.getLong(0));
                u.setNome(cursor.getString(1));
                u.setEmail(cursor.getString(2));
                u.setSenha(cursor.getString(3));
                list.add(u);
            }

            while(cursor.moveToNext());
        }
        return(list);
    }

}
