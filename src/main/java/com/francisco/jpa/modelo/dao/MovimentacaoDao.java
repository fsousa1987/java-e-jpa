package com.francisco.jpa.modelo.dao;

import com.francisco.jpa.modelo.MediaComData;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class MovimentacaoDao {

    private final EntityManager em;

    public MovimentacaoDao(EntityManager em) {
        this.em = em;
    }

    public List<MediaComData> getMediaDiariaDasMovimentacoes() {

        String jpql = "select new com.francisco.jpa.modelo.MediaComData(avg(m.valor), day(m.data), month(m.data)) " +
                "from Movimentacao m group by day(m.data), month(m.data), year(m.data)";

        TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);
        return query.getResultList();
    }

    public BigDecimal getSomaDasMovimentacoes() {

        String jpql = "select sum(m.valor) from Movimentacao m";

        TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);

        return query.getSingleResult();
    }
}
