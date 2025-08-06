package com.entra21.atividadeEscola.entidade;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Professores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private LocalDate registro;
    private String materia;
    @OneToMany(mappedBy = "professores", cascade = CascadeType.ALL)
    private List<TurmasProfessores> turmasProfessores;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getRegistro() {
        return registro;
    }

    public void setRegistro(LocalDate registro) {
        this.registro = registro;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public List<TurmasProfessores> getTurmasProfessores() {
        return turmasProfessores;
    }

    public void setTurmasProfessores(List<TurmasProfessores> turmasProfessores) {
        this.turmasProfessores = turmasProfessores;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
