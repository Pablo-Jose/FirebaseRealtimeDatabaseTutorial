package com.pablo.firebasetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private TextView nome, input;
    private Button botaoOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        input = (AutoCompleteTextView) findViewById(R.id.input);
        nome = (TextView) findViewById(R.id.nome);
        botaoOk = (Button) findViewById(R.id.botao_ok);

        Onclik();
    }

    private void Onclik() {
        botaoOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.getText().length() <=0){
                    input.setError("Digite um nome");
                }else{
                    String nomeUsuario = input.getText().toString().trim();
                    databaseReference.push().child("Nome").setValue(nomeUsuario);
                    nome.setText(", " + nomeUsuario);
                    nome.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}