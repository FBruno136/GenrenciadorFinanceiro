package com.example.genrenciadorfinanceiro.activitys.login;
/* Criado
por bruno fernandes ^^,
*/

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.genrenciadorfinanceiro.R;
import com.example.genrenciadorfinanceiro.config.firebase.ConfiguracaoFirebase;
import com.example.genrenciadorfinanceiro.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    //tela de login do usuario


    //criando variavel
    //botoes
    private Button botaoCadastrar, botaoLogin;
    private EditText textoEmail, textoSenha;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //indicando o contesto da classe
        setContentView(R.layout.activity_login);

        //atribuindo um valor a essa variavel
        textoEmail = findViewById(R.id.emailLogin);
        textoSenha = findViewById(R.id.senhaLogin);
        botaoCadastrar = findViewById(R.id.buttonCadastrar);
        botaoLogin = findViewById(R.id.buttonLogin);

        //Colocando um evento de click nessa variavel

        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CadastroActivity.class);
                startActivity(intent);
            }
        });
    }

}