package com.example.aplicativodepagamento;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Menu_atividade extends AppCompatActivity {

    TextView opcao_pagamento = findViewById(R.id.opcao_pagamento);
    TextView opcao_informacoes = findViewById(R.id.opcao_informacoes);
    TextView opcao_historico = findViewById(R.id.opcao_historico);
    TextView opcao_configuracoes = findViewById(R.id.opcao_configuracoes);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        opcao_pagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

    }
}