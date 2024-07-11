package com.example.aplicativodepagamento;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CriarcaoDeConta extends AppCompatActivity {

    //@SuppressLint("MissingInflatedId")
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://aplicativo-de-pagamento-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_criarcao_de_conta);
        final TextView ja_tem_conta_password = findViewById(R.id.ja_tem_conta_password);
        final EditText nome_input = findViewById(R.id.nome_input);
        final EditText password_input = findViewById(R.id.password_input);
        final EditText numero_input = findViewById(R.id.numero_input);
        final EditText numero_matricula_input = findViewById(R.id.numero_matricula_input);
        final Button continuar_input = findViewById(R.id.continuar_input);


        continuar_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nome = nome_input.getText().toString();
                final String password = password_input.getText().toString();
                final String numero = numero_input.getText().toString();
                final String numero_matricula = numero_matricula_input.getText().toString();

                if (nome.isEmpty() || password.isEmpty() || numero.isEmpty() || numero_matricula.isEmpty()) {
                    Toast.makeText(CriarcaoDeConta.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }
                else if(password.length() < 8){
                    Toast.makeText(CriarcaoDeConta.this, "Palavra-passe deve ter no mínimo 8 caracteres", Toast.LENGTH_SHORT).show();

                }
                else {
                    databaseReference.child("usuarios").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(numero)){
                                Toast.makeText(CriarcaoDeConta.this, "Número de telefone já existe", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                databaseReference.child("usuarios").child(numero).child("nome completo").setValue(nome);
                                databaseReference.child("usuarios").child(numero).child("palavra-passe").setValue(password);
                                databaseReference.child("usuarios").child(numero).child("numero").setValue(numero);
                                databaseReference.child("usuarios").child(numero).child("numero de matricula").setValue(numero_matricula);

                                Toast.makeText(CriarcaoDeConta.this, "Conta criada com sucesso", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(CriarcaoDeConta.this, Menu_atividade.class));

                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });

        ja_tem_conta_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CriarcaoDeConta.this, ActividadePrincipal.class));
            }
        });

    }
}