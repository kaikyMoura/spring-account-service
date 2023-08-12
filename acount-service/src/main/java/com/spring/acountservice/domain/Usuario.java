package com.spring.acountservice.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.Objects;


@Entity
@ToString
@Table(name = "tb_users")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_users_GEN")
    @SequenceGenerator(name = "tb_users_GEN", sequenceName = "tb_users_SEQ")
    @Column(name = "usuarioid", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @NotNull
    @Column(name = "usuarionome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "contatoid")
    private Contato contato;

    public Usuario() {
    }

    public Usuario(String nome, Contato contato) {
        this.nome = nome;
        this.contato = contato;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nome, usuario.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
