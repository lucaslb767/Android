package com.example.lucasbarrozo.tp6_projeto_bloco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView salLiqui = findViewById(R.id.txtSalLiq);
        TextView gastoTotal = findViewById(R.id.txtGasto);
        TextView porcentagem = findViewById(R.id.txtPorcentagem);

        Intent intent = getIntent();

        String salResultado = intent.getStringExtra("salario");

        salLiqui.setText(salResultado);

        String gasto = intent.getStringExtra("despesa");

        gastoTotal.setText(gasto);

        String porcentagemGasto = intent.getStringExtra("porcentagem");

        porcentagem.setText(porcentagemGasto);
    }


}
