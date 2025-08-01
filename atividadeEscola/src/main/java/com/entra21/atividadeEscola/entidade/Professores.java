package com.entra21.atividadeEscola.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @OneToMany (mappedBy = "professores", cascade = CascadeType.ALL)
    private List<Alunos> alunos;

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

    public List<Alunos> getAlunos() {
        return alunos;
    }

    public void setAlunos(Alunos alunos) {
        this.alunos = (List<Alunos>) alunos;
    }
}
