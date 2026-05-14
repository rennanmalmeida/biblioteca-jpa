package br.com.ifg.principal;

import br.com.ifg.model.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class Principal {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("bibliotecaPU");

        EntityManager em = emf.createEntityManager();

        Autor autor = new Autor(
                "Machado de Assis",
                "Brasileiro"
        );

        Editora editora = new Editora(
                "Companhia das Letras",
                "São Paulo"
        );

        Livro livro = new Livro(
                "Dom Casmurro",
                1899,
                "123456789",
                new BigDecimal("59.90"),
                TipoPublicacao.IMPRESSO,
                autor,
                editora
        );

        em.getTransaction().begin();

        em.persist(autor);
        em.persist(editora);
        em.persist(livro);

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Livro salvo com sucesso!");

    }
}
