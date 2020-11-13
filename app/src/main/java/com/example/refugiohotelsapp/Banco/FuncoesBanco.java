package com.example.refugiohotelsapp.Banco;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.refugiohotelsapp.Entidades.Reserva;
import com.example.refugiohotelsapp.Entidades.Usuario;
import com.example.refugiohotelsapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FuncoesBanco extends AppCompatActivity {

    //reliza funções do crud, insert, read, update e delete a respeito da Entidade Usuario
    private SQLiteDatabase bd;

    public FuncoesBanco(Context context){
        DBCore auxBd = new DBCore(context);
        bd = auxBd.getWritableDatabase();
    }

    public FuncoesBanco(){

    }
    //Inserir Usuario na tabela Usuario
    public void inserirUsuario(Usuario usuario){
        ContentValues valores = new ContentValues();
        valores.put("nome",usuario.getNome());
        valores.put("email", usuario.getEmail());
        valores.put("senha",usuario.getSenha());
    try {
        bd.insert("Usuario", null, valores);
    } catch (SQLException ex){
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle(R.string.title_erro);
        dlg.setMessage(ex.getMessage());
        dlg.setNeutralButton(R.string.action_ok, null);
        dlg.show();
    }
    }
    //update na tabela Usuario
    public void atualizarUsuario(Usuario usuario){
        ContentValues valores = new ContentValues();
        valores.put("nome",usuario.getNome());
        valores.put("email", usuario.getEmail());
        valores.put("senha",usuario.getSenha());

        bd.update("Usuario",valores,"idUsuario = ?",
                new String[]{""+usuario.getIdUsuario()});
    }
    //deletar
    public void deletarUsuario(Usuario usuario){
        bd.delete("Usuario","idUsuario = "+ usuario.getIdUsuario(),null);
    }
    //select para trazer usuarios, pôr em lista e percorrer lista
    public List<Usuario> ListarUsuario(){
        List<Usuario> list = new ArrayList<Usuario>();
        String[] colunas = new String[]{"idUsuario","nome","email","senha"};

        Cursor cursor = bd.query("Usuario", colunas, null,
                null, null,null,"nome ASC");

        if(cursor.getCount()>0){
            cursor.moveToFirst();

            do{
                Usuario u = new Usuario();
                u.setIdUsuario(cursor.getInt(0));
                u.setNome(cursor.getString(1));
                u.setEmail(cursor.getString(2));
                u.setSenha(cursor.getString(3));
                list.add(u);
            }

            while(cursor.moveToNext());
        }
        return(list);
    }

    //Funções de Banco para classe Reserva

    //Criando nova reserva
    public void inserirReserva(Reserva reserva){
        ContentValues valores = new ContentValues();
        valores.put("dataInicio", reserva.getDataInicio().toString());
        valores.put("dataFim", reserva.getDataFim().toString());
        valores.put("quantidadeAdultos", reserva.getQuantidadeAdultos());
        valores.put("quantidadeCriancas", reserva.getQuantidadeCriancas());
        valores.put("valorReserva", reserva.getValorReserva());
        valores.put("metodoPagamento", reserva.getMetodoPagamento());
        valores.put("ReservaAtiva", reserva.isReservaAtiva());
        valores.put("idUsuario", reserva.getIdUsuario());

        bd.insert("Reserva",null,valores);
    }
    //Atualizando dados da Reserva
    public void atualizarReserva(Reserva reserva){
        ContentValues valores = new ContentValues();
        valores.put("dataInicio", reserva.getDataInicio().toString());
        valores.put("dataFim", reserva.getDataFim().toString());
        valores.put("quantidadeAdultos", reserva.getQuantidadeAdultos());
        valores.put("quantidadeCriancas", reserva.getQuantidadeCriancas());
        valores.put("valorReserva", reserva.getValorReserva());
        valores.put("metodoPagamento", reserva.getMetodoPagamento());
        valores.put("ReservaAtiva", reserva.isReservaAtiva());
        valores.put("IdUsuario", reserva.getIdUsuario());
        valores.put("idReserva", reserva.getIdReserva());

        bd.update("Reserva",valores,"idReserva = ?",
                new String[]{""+reserva.getIdReserva()});
    }

    //deletar
    public void deletarReserva(Reserva reserva){
        bd.delete("Reserva","idReserva = "+ reserva.getIdReserva(),null);
    }
    //Listar reserva, checar clausula para listar somente as reservas daquele usuario
    public List<Reserva> ListarReserva(){
        List<Reserva> list = new ArrayList<Reserva>();
        String[] colunas = new String[]{"idReserva","dataInicio","dataFim","quantidadeAdultos","quantidadeCriancas","valorReserva","metodoPagamento"};

        Cursor cursor = bd.query("Reserva", colunas, null,
                null, null,null,"nome ASC");

        if(cursor.getCount()>0){
            cursor.moveToFirst();

            do{
                Reserva r = new Reserva();
                r.setIdReserva(cursor.getInt(0));

                String dataInicioRecebida = cursor.getString(1);
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                String dataFimRecebida = cursor.getString(2);
                SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date dataFormatadaInicio = formato.parse(dataInicioRecebida);
                    r.setDataInicio(dataFormatadaInicio);

                    Date dataFormatadaFim = formato2.parse(dataFimRecebida);
                    r.setDataFim(dataFormatadaFim);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                r.setQuantidadeAdultos(cursor.getInt(3));
                r.setQuantidadeCriancas(cursor.getInt(4));
                r.setValorReserva(cursor.getFloat(5));
                r.setMetodoPagamento(cursor.getString(6));
                list.add(r);
            }

            while(cursor.moveToNext());
        }
        return(list);
    }

}