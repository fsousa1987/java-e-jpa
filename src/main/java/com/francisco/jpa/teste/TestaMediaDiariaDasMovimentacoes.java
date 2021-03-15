package com.francisco.jpa.teste;

import com.francisco.jpa.modelo.MediaComData;
import com.francisco.jpa.modelo.dao.MovimentacaoDao;

import java.util.List;

public class TestaMediaDiariaDasMovimentacoes {

    public static void main(String[] args) {

        List<MediaComData> mediaDasMovimentacoes = new MovimentacaoDao().getMediaDiariaDasMovimentacoes();

        for (MediaComData resultado :
             mediaDasMovimentacoes) {

            System.out.println("A média das movimentações do dia " + resultado.getDia() + "/"
                    + resultado.getMes() + " é: " + resultado.getValor());
        }
    }
}
