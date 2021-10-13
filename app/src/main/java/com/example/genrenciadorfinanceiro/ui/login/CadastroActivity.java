package com.example.genrenciadorfinanceiro.ui.login;
/* Criado
por bruno fernandes ^^,
*/
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.genrenciadorfinanceiro.R;
import com.example.genrenciadorfinanceiro.databinding.ActivityLoginBinding;

public class CadastroActivity extends AppCompatActivity {


    private ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //indicando o contesto da classe
        setContentView(R.layout.activity_cadastro);

        };

}