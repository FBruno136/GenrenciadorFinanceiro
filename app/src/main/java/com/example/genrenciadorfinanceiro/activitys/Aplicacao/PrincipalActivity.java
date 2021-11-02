package com.example.genrenciadorfinanceiro.activitys.Aplicacao;

import android.os.Bundle;
import android.view.Menu;

import com.example.genrenciadorfinanceiro.R;
import com.example.genrenciadorfinanceiro.databinding.ActivityPrincipalBinding;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;


public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //indicando o contesto da classe
        setContentView(R.layout.activity_principal);


    }
}

