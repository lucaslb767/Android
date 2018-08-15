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

            Intent resultActivity = new Intent(getApplicationContext(), ResultActivity.class);
            resultActivity.putExtra("salario", testSalario);

            startActivity(resultActivity);
        }
    };
}




