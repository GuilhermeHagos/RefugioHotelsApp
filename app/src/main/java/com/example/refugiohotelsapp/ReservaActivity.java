package com.example.refugiohotelsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.refugiohotelsapp.Banco.FuncoesBanco;
import com.example.refugiohotelsapp.Entidades.Reserva;
import com.example.refugiohotelsapp.Entidades.Usuario;

import java.util.Date;

public class ReservaActivity extends AppCompatActivity {

    private Reserva reserva = new Reserva();

    //Adultos
    private TextView textView7;
    private TextView textView8;
    private EditText editTextNumber2;

    //Crianças
    private TextView textView10;
    private TextView textView11;
    private EditText editTextNumber3;

    //Check In
    private TextView textView12;
    private TextView textView13;
    private CalendarView calendarView4;

    //Check Out
    private TextView textView14;
    private TextView textView15;
    private CalendarView calendarView5;

    //Metódo pagamento
    private TextView textView16;
    private TextView textView17;
    private EditText editTextMetodoPagamento;

    //button

    private Button button5;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        //Adultos
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 =(TextView) findViewById(R.id.textView8);
        editTextNumber2 = (EditText) findViewById(R.id.editTextNumber2);

        //Crianças

        textView10 = (TextView) findViewById(R.id.textView10);
        textView11 =(TextView) findViewById(R.id.textView11);
        editTextNumber3 = (EditText) findViewById(R.id.editTextNumber3);

        //Check In

        textView12 = (TextView) findViewById(R.id.textView12);
        textView13 =(TextView) findViewById(R.id.textView13);
        calendarView4 = (CalendarView) findViewById(R.id.calendarView4);

        //Check Out

        textView14 = (TextView) findViewById(R.id.textView14);
        textView15 =(TextView) findViewById(R.id.textView15);
        calendarView5 = (CalendarView) findViewById(R.id.calendarView5);

        //Método de Pagamento

        textView16 = (TextView) findViewById(R.id.textView16);
        textView17 =(TextView) findViewById(R.id.textView17);
        editTextMetodoPagamento = (EditText) findViewById(R.id.editTextMetodoPagamento);

        //buttons

        button5 = (Button) findViewById(R.id.button5);
        button4 = (Button) findViewById(R.id.button4);
    }

    //Criando e Inserindo Reserva
    public void salvarReserva(View view){
        reserva.setQuantidadeAdultos(editTextNumber2.getText().toString());
        reserva.setQuantidadeCriancas(editTextNumber3.getText().toString());
        reserva.setDataInicio(calendarView4.getDate());
        reserva.setDataFim(calendarView5.getDate());
        reserva.setMetodoPagamento(editTextMetodoPagamento.getText().toString());
        reserva.setValorReserva(2000);
        FuncoesBanco bd = new FuncoesBanco(this);
        bd.inserirReserva(reserva);
        Toast.makeText(this, "Reserva inserida com sucesso!",
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, homeActivity.class);
        startActivity(intent);
    }
    // Editando Reserva
    public void editarReserva(View view){
        reserva.setQuantidadeAdultos(editTextNumber2.getText().toString());
        reserva.setQuantidadeCriancas(editTextNumber3.getText().toString());
        reserva.setDataInicio(calendarView4.getDate());
        reserva.setDataFim(calendarView5.getDate());
        reserva.setMetodoPagamento(editTextMetodoPagamento.getText().toString());
        reserva.setValorReserva(2000);
        FuncoesBanco bd = new FuncoesBanco(this);
        bd.atualizarReserva(reserva);
        Toast.makeText(this, "Reserva \""+reserva.getIdReserva()+" atualizada com sucesso."
                , Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, homeActivity.class);
        startActivity(intent);
    }


    public void retornarMenu(View view){
        Intent intent = new Intent(this, homeActivity.class);
        startActivity(intent);
    }
}