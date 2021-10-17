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
import com.example.genrenciadorfinanceiro.activitys.MainActivity;
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
    private Usuario usuario;
    private FirebaseAuth autenticacao;

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
                String nomeEmail = textoEmail.getText().toString();
                String nomeSenha = textoSenha.getText().toString();

                if (!nomeEmail.isEmpty()) {
                    if (!nomeSenha.isEmpty()) {
                        usuario = new Usuario();
                        usuario.setEmail(nomeEmail);
                        usuario.setSenha(nomeSenha);
                        validacaodelogin();
                    } else{
                        Toast.makeText(LoginActivity.this, "Senha Invalida", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "email invalido", Toast.LENGTH_SHORT).show();
                }
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
    public void validacaodelogin(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Login Executado", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity( intent );
                }else{
                    Toast.makeText(LoginActivity.this, "Erro ao fazer login", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}