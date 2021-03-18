package com.francisco.jpa.modelo.dao;

import com.francisco.jpa.modelo.MediaComData;
import com.francisco.jpa.modelo.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class MovimentacaoDao {

    private final EntityManager em;

    public MovimentacaoDao(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("SameReturnValue")
    public List<Movimentacao> getMovimentacoesFiltradasPorData(Integer dia, Integer mes, Integer ano) {

        String sql = "select m from Movimentacao m where";

        if (dia != null) {
            sql += " day(m.data) = :pDia";
        }

        if (mes != null) {
            sql += " and month(m.data) = :pMes";
        }

        if (ano != null) {
            //noinspection UnusedAssignment
            sql += " and year(m.data) = :pAno";
        }

        return null;
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
