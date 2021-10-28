package com.example.genrenciadorfinanceiro.config.auxiliar;/* Criado
por bruno fernandes ^^,
*/

import android.widget.EditText;

import com.example.genrenciadorfinanceiro.config.firebase.ConfiguracaoFirebase;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class EntradaSaida {

    private TextInputEditText campoData, campoCategoria, campoDescricao;
    private EditText campoValor;
    private Movimentacao movimentacao;
    private DatabaseReference firebaseRef = ConfiguracaoFirebase.getFirebaseDatabase();
    private FirebaseAuth autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
    private Double despesaTotal;

}
