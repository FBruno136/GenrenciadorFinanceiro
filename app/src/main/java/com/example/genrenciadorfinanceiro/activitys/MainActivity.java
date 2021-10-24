package com.example.genrenciadorfinanceiro.activitys;
/* Criado
por bruno fernandes ^^,
*/
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.genrenciadorfinanceiro.R;
import com.example.genrenciadorfinanceiro.activitys.Aplicacao.AplicacaoActivity;
import com.example.genrenciadorfinanceiro.activitys.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

//tela inicial

    //criando variavel
    //botoes
    private Button botaologar, botaodeslogar;
    private FirebaseAuth usuario = FirebaseAuth.getInstance();
    private TextView textInicial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //indicando o contesto da classe
        setContentView(R.layout.activity_main);

        //atribuindo um valor a essa variavel
        botaologar = findViewById(R.id.buttonInicial);
        botaodeslogar = findViewById(R.id.buttonSingOut);
        textInicial = findViewById(R.id.textoInicial);

        if( usuario.getCurrentUser() != null ){
            textInicial.setText("Usuario logado");
        }else {
            textInicial.setText("usuario Deslogado");
            botaodeslogar.setVisibility(View.INVISIBLE); //Torna o botao de deslogar invisivel
        }

        //Colocando um evento de click nessa variavel
        botaologar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Verifica usuario logado*/
                if( usuario.getCurrentUser() != null ){
                    Intent intent = new Intent(getApplicationContext(), AplicacaoActivity.class);
                    startActivity( intent );
                }else {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity( intent );
                }
            }
        });
        botaodeslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Verifica usuario logado*/
                if( usuario.getCurrentUser() != null ){
                    signOut();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity( intent );
                }else {
                    Toast.makeText(MainActivity.this, "Usuario ja deslogado", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void signOut() {
        // [START auth_sign_out]
        FirebaseAuth.getInstance().signOut();
        // [END auth_sign_out]
    }
}