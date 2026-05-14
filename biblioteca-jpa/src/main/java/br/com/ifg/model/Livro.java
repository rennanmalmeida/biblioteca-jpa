package br.com.ifg.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    private Integer anoPublicacao;

    private String isbn;

    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    private TipoPublicacao tipo;

    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Editora editora;

    public Livro() {
    }

    public Livro(String titulo,
                 Integer anoPublicacao,
                 String isbn,
                 BigDecimal preco,
                 TipoPublicacao tipo,
                 Autor autor,
                 Editora editora) {

        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.isbn = isbn;
        this.preco = preco;
        this.tipo = tipo;
        this.autor = autor;
        this.editora = editora;
    }

    public Integer getId() {
        return id;
    }
}
