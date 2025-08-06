package com.entra21.atividadeEscola.entidade;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class TurmasProfessores {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private LocalDateTime registro;
    @ManyToOne
    @JoinColumn(name = "professores")
    private Professores professores;

    @ManyToOne
    @JoinColumn(name = "turmas")
    private Turmas turmas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getRegistro() {
        return registro;
    }


    public void setRegistro(LocalDateTime registro) {
        this.registro = registro;
    }

    public Professores getProfessores() {
        return professores;
    }

    public void setProfessores(Professores professores) {
        this.professores = professores;
    }

    public Turmas getTurmas() {
        return turmas;
    }

    public void setTurmas(Turmas turmas) {
        this.turmas = turmas;
    }
}
