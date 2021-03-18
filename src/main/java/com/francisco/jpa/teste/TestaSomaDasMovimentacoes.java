package com.francisco.jpa.teste;

import com.francisco.jpa.modelo.dao.MovimentacaoDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaSomaDasMovimentacoes {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        MovimentacaoDao dao = new MovimentacaoDao(em);

        System.out.println("A média das movimentações é: " + dao.getSomaDasMovimentacoes());
    }
}
