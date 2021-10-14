package com.example.genrenciadorfinanceiro.activitys.login;
/* Criado
por bruno fernandes ^^,
*/
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.genrenciadorfinanceiro.R;
import com.example.genrenciadorfinanceiro.config.firebase.ConfiguracaoFirebase;
import com.example.genrenciadorfinanceiro.databinding.ActivityLoginBinding;
import com.example.genrenciadorfinanceiro.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroActivity extends AppCompatActivity {
    private Button botaoCadastrar;
    private EditText textoEmail, textoSenha;
    private FirebaseAuth autenticador;
    private Usuario usuario;
    private ActivityLoginBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //indicando o contesto da classe
        setContentView(R.layout.activity_cadastro);
        textoEmail = findViewById(R.id.emailCadastro);
        textoSenha = findViewById(R.id.senhaCadastro);
        botaoCadastrar = findViewById(R.id.buttonCadastrar);
        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeEmail = textoEmail.getText().toString();
                String nomeSenha = textoSenha.getText().toString();

                if (!nomeEmail.isEmpty()) {
                    if (!nomeSenha.isEmpty()) {
                        usuario = new Usuario();
                        usuario.setEmail(nomeEmail);
                        usuario.setSenha(nomeSenha);
                        CadastrarUser();
                    }
                } else {
                    Toast.makeText(CadastroActivity.this, "Por favor preenha os campos corretamente", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void CadastrarUser(){
        autenticador = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticador.createUserWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if ( task.isSuccessful() ){
                    finish();
                }else {

                    String excecao = "";
                    try {
                        throw task.getException();
                    }catch ( FirebaseAuthWeakPasswordException e){
                        excecao = "Digite uma senha mais forte!";
                    }catch ( FirebaseAuthInvalidCredentialsException e){
                        excecao= "Por favor, digite um e-mail válido";
                    }catch ( FirebaseAuthUserCollisionException e){
                        excecao = "Este conta já foi cadastrada";
                    }catch (Exception e){
                        excecao = "Erro ao cadastrar usuário: "  + e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(CadastroActivity.this,
                            excecao,
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}