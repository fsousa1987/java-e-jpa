package com.francisco.jpa.teste;

import com.francisco.jpa.modelo.MediaComData;

import javax.persistence.*;
import java.util.List;

public class TestaMediaDiariaDasMovimentacoes {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        String jpql = "select new com.francisco.jpa.modelo.MediaComData(avg(m.valor), day(m.data), month(m.data)) " +
                "from Movimentacao m group by day(m.data), month(m.data), year(m.data)";

        TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);
        List<MediaComData> mediaDasMovimentacoes = query.getResultList();

        for (MediaComData resultado :
             mediaDasMovimentacoes) {

            System.out.println("A média das movimentações do dia " + resultado.getDia() + "/"
                    + resultado.getMes() + " é: " + resultado.getValor());
        }
    }
}
