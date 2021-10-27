package com.example.genrenciadorfinanceiro.activitys.Aplicacao;
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
import com.example.genrenciadorfinanceiro.activitys.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

//tela inicial

    //criando variavel
    //botoes
    private Button botaologar;
    private FirebaseAuth usuario = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //indicando o contesto da classe
        setContentView(R.layout.activity_main);

        //atribuindo um valor a essa variavel
        botaologar = findViewById(R.id.buttonInicial);

        //FirebaseAuth.getInstance().signOut(); //Comando pra deslogar a conta!
        if( usuario.getCurrentUser() != null ){
            Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
            startActivity( intent );
        }

        //Colocando um evento de click nessa variavel
        botaologar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Verifica usuario logado*/
                if( usuario.getCurrentUser() != null ){
                    Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
                    startActivity( intent );
                }else {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity( intent );
                }
            }
        });
    }

}