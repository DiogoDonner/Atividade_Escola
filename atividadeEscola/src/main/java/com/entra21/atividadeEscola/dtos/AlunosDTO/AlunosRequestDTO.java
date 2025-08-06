package com.entra21.atividadeEscola.dtos.AlunosDTO;

public class AlunosRequestDTO {
    private String nome;
    private Integer matricula;
    private Integer idTurma;

    public String getNome() {
        return nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public Integer getIdTurma() {
        return idTurma;
    }
}

