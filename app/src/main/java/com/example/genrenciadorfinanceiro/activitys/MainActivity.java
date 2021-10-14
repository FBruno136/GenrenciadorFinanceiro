package com.example.genrenciadorfinanceiro.activitys;
/* Criado
por bruno fernandes ^^,
*/
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.genrenciadorfinanceiro.R;
import com.example.genrenciadorfinanceiro.activitys.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

//tela inicial

    //criando variavel
    //botoes
    private Button botaologar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //indicando o contesto da classe
        setContentView(R.layout.activity_main);

        //atribuindo um valor a essa variavel
        botaologar = findViewById(R.id.buttonLogar);

        //Colocando um evento de click nessa variavel
        botaologar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity( intent );
            }
        });
    }
}