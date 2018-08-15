package com.example.lucasbarrozo.tp6_projeto_bloco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtSalBruto;
    private EditText edtPensaoAl;
    private EditText edtNumDep;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSalBruto = findViewById(R.id.edtSalBruto);
        edtPensaoAl = findViewById(R.id.edtPensaoAl);
        edtNumDep = findViewById(R.id.edtNumDep);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(calculaIntent);
    }

    View.OnClickListener calculaIntent = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            EditText edtSalBruto = findViewById(R.id.edtSalBruto);
            EditText edtPensaoAl = findViewById(R.id.edtPensaoAl);
            EditText edtNumDep = findViewById(R.id.edtNumDep);

            String testSalario = edtSalBruto.getText().toString();
            String testPensao = edtPensaoAl.getText().toString();
            String testDependente = edtNumDep.getText().toString();

            if(testSalario.matches("")){
                Toast.makeText(getApplicationContext(), "Você não colocou o Salário Bruto", Toast.LENGTH_SHORT).show();
                return;
            }

            if(testPensao.matches("")){
                testPensao="0";
            }

            if (testDependente.matches("")){
                testDependente="0";
            }


            double salBruto = Double.parseDouble(testSalario);
            double pensao = Double.parseDouble(testPensao);
            double dependente = Double.parseDouble(testDependente) * 189.59;
            double inss = 0;
            double irpf=0;

            if (salBruto <= 1659.38) {
                inss = .08 *salBruto;
            } else if(salBruto <=2765.66 ){
                inss = .09 * salBruto;
            } else if ( salBruto <= 5531.31) {
                inss = .11 * salBruto;
            } else {
                inss = 608.44;
            }


             if(salBruto <=1903.98 ){
                irpf = 0 * salBruto;
            } else if(salBruto <=2826.65 ){
                 irpf = .075 * salBruto;
             } else if(salBruto <=3751.05 ){
                 irpf = .15 * salBruto;
             } else if(salBruto <=4664.68 ){
                 irpf = .225 * salBruto;
             } else {
                irpf = .275 * salBruto;
             }




            double salLiquido = salBruto - pensao - dependente - inss - irpf;

            double totalDespesa = pensao + dependente + inss + irpf;

            double porcentagemDespesa = totalDespesa/salBruto*100;

            String sal2Decimals = String.format("%.2f",salLiquido);
            String salFinal = "R$" + sal2Decimals;

            String despesa2decimals = String.format("%.2f",totalDespesa);
            String despesaFinal = "R$" + despesa2decimals;

            String porcentagem = String.format("%.2f",porcentagemDespesa);
            String porcentagemFinal = porcentagem + "%";

            Intent resultActivity = new Intent(getApplicationContext(), ResultActivity.class);
            resultActivity.putExtra("salario", salFinal);
            resultActivity.putExtra("despesa", despesaFinal);
            resultActivity.putExtra("porcentagem", porcentagemFinal);

            startActivity(resultActivity);
        }
    };
}




