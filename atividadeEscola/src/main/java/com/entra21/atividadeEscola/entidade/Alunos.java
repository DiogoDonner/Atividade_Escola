package com.entra21.atividadeEscola.entidade;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Alunos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private LocalDateTime registro;
    private Integer matricula;

    @ManyToOne
    @JoinColumn(name = "turmas")
    private Turmas turmas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getRegistro() {
        return registro;
    }

    public void setRegistro(LocalDateTime registro) {
        this.registro = LocalDateTime.from(registro);
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Turmas getTurmas() {
        return turmas;
    }

    public void setTurmas(Turmas turmas) {
        this.turmas = turmas;
    }
}