package com.francisco.jpa.teste;

import com.francisco.jpa.modelo.MediaComData;
import com.francisco.jpa.modelo.dao.MovimentacaoDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestaMediaDiariaDasMovimentacoes {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        List<MediaComData> mediaDasMovimentacoes = new MovimentacaoDao(em).getMediaDiariaDasMovimentacoes();

        for (MediaComData resultado :
             mediaDasMovimentacoes) {

            System.out.println("A média das movimentações do dia " + resultado.getDia() + "/"
                    + resultado.getMes() + " é: " + resultado.getValor());
        }
    }
}
