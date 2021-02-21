package com.francisco.jpa.teste;

import com.francisco.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestandoEstados {

    public static void main(String[] args) {

        // Transient
        Conta conta = new Conta();
        conta.setTitular("Almiro");
        conta.setAgencia(123123);
        conta.setNumero(1234567);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Transient -> Managed
        em.persist(conta);

        // Managed -> Removed
        em.remove(conta);

        em.getTransaction().commit();
    }
}
