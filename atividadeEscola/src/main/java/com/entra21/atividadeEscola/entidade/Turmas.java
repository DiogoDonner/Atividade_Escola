package com.entra21.atividadeEscola.entidade;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Turmas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String identificador;
    private LocalDateTime registro = LocalDateTime.now();
    @OneToMany(mappedBy = "turmas", cascade = CascadeType.ALL)
    private List<Alunos> alunos;
    @OneToMany(mappedBy = "turmas", cascade = CascadeType.ALL)
    private List<TurmasProfessores> turmasProfessores;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public LocalDateTime getRegistro() {
        return registro;
    }

    public void setRegistro(LocalDateTime registro) {
        this.registro = registro;
    }

    public List<Alunos> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Alunos> alunos) {
        this.alunos = alunos;
    }

    public List<TurmasProfessores> getTurmasProfessores() {
        return turmasProfessores;
    }

    public void setTurmasProfessores(List<TurmasProfessores> turmasProfessores) {
        this.turmasProfessores = turmasProfessores;
    }
}
