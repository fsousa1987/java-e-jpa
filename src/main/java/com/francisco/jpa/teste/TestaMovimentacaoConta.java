package com.francisco.jpa.teste;

import com.francisco.jpa.modelo.Conta;
import com.francisco.jpa.modelo.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaMovimentacaoConta {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Movimentacao movimentacao = em.find(Movimentacao.class, 1L);
        Conta conta = movimentacao.getConta();
        int quantidadeDeMovimentacoes = conta.getMovimentacoes().size();

        System.out.println("Quantidade de movimentações: " + quantidadeDeMovimentacoes);
        System.out.println("Titular da conta: " + conta.getTitular());
    }
}
