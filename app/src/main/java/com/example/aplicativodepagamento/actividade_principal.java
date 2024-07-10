package com.example.aplicativodepagamento;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class actividade_principal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividade_principal);

        final EditText numero_de_telefone = (EditText) findViewById(R.id.numero_de_telefone);
        final EditText password_input = (EditText) findViewById(R.id.palavra_passe_input);
        final Button botao_login_input = (Button) findViewById(R.id.botao_login_input);
        final TextView conta_nova_input = (TextView) findViewById(R.id.conta_nova_input);


        botao_login_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String numero = numero_de_telefone.getText().toString();
                final String password = password_input.getText().toString();

                if (numero.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }
                else {

                }
            }
        });
        conta_nova_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(actividade_principal.this, CriarConta.class));
            }
        });

    }
}
