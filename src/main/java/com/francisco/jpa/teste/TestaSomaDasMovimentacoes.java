package com.francisco.jpa.teste;

import com.francisco.jpa.modelo.dao.MovimentacaoDao;

public class TestaSomaDasMovimentacoes {

    public static void main(String[] args) {

        MovimentacaoDao dao = new MovimentacaoDao();

        System.out.println("A média das movimentações é: " + dao.getSomaDasMovimentacoes());
    }
}
