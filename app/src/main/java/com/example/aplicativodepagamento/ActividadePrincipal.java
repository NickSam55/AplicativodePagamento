package com.example.aplicativodepagamento;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActividadePrincipal extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView criar_conta_input = findViewById(R.id.criar_conta_input);
        final Button login_input = findViewById(R.id.login_input);
        final EditText numerotelefone = findViewById(R.id.numerotelefone);
        final EditText password_input = findViewById(R.id.password_input);


        login_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String numero = numerotelefone.getText().toString();
                final String password = password_input.getText().toString();

                if (numero.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }
                else {
                    startActivity(new Intent(ActividadePrincipal.this, Menu_atividade.class));

                }
            }
        });
        criar_conta_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActividadePrincipal.this, CriarcaoDeConta.class));
            }
        });

    }

}