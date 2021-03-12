package com.francisco.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TestaMediaDiariaDasMovimentacoes {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        String jpql = "select avg(m.valor) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";

        TypedQuery<Double> query = em.createQuery(jpql, Double.class);
        List<Double> mediaDasMovimentacoes = query.getResultList();

        for (double media :
             mediaDasMovimentacoes) {

            System.out.println("A média das movimentações é: " + media);
        }
    }
}
