package com.spring.acountservice.domain;


import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@ToString
@Table(name = "tb_contatos")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_contatos_GEN")
    @SequenceGenerator(name = "tb_contatos_GEN", sequenceName = "tb_contatos_SEQ")
    @Column(name = "contatoid", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @Column(name = "user_email", nullable = false)
    private String email;

    @Column(name = "user_number", nullable = false)
    private String number;

    @ManyToOne
    @JoinColumn(name = "usuarioid")
    private Usuario usuario;

    public Contato() {
    }

    public Contato(String email, String number, Usuario usuario) {
        this.email = email;
        this.number = number;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
