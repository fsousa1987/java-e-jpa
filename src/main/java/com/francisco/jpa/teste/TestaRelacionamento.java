package com.francisco.jpa.teste;

import com.francisco.jpa.modelo.Conta;
import com.francisco.jpa.modelo.Movimentacao;
import com.francisco.jpa.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestaRelacionamento {

    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setAgencia(123456);
        conta.setNumero(654321);
        conta.setSaldo(300.0);
        conta.setTitular("Leonardo");

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setDescricao("Churrascaria");
        movimentacao.setValor(new BigDecimal("200.0"));
        movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTADA);
        movimentacao.setConta(conta);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(conta);
        em.persist(movimentacao);
        em.getTransaction().commit();

        em.close();
    }
}
