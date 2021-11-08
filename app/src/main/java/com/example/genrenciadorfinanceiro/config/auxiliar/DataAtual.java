package com.example.genrenciadorfinanceiro.config.auxiliar;/* Criado
por bruno fernandes ^^,
*/

import java.text.SimpleDateFormat;

public class DataAtual {

    public static String dataAtual(){

        long data = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataString = simpleDateFormat.format(data);
        return dataString;

    }

    public static String mesAnoDataEscolhida(String data){

        String retornoData[] = data.split("/");
        String dia = retornoData[0];//dia 23
        String mes = retornoData[1];//mes 01
        String ano = retornoData[2];//ano 2018

        String mesAno = mes + ano;
        return mesAno;

    }
}
