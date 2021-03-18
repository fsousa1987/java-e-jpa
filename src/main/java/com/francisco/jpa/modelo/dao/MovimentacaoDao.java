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

        TypedQuery<MediaComData> query = em.createNamedQuery("mediaDiariaMovimentacoes", MediaComData.class);
        return query.getResultList();
    }

    public BigDecimal getSomaDasMovimentacoes() {

        String jpql = "select sum(m.valor) from Movimentacao m";

        TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);

        return query.getSingleResult();
    }
}
