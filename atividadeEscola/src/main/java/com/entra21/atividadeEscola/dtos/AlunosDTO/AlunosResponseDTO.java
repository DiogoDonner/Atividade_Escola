package com.entra21.atividadeEscola.dtos.AlunosDTO;

import com.entra21.atividadeEscola.entidade.Alunos;
import com.entra21.atividadeEscola.entidade.Turmas;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class AlunosResponseDTO {
    private String nome;
    private Integer matricula;
    private Integer idTurmas;

    public AlunosResponseDTO(Alunos alunos){
        this.nome = alunos.getNome();
        this.matricula = alunos.getMatricula();
        this.idTurmas = alunos.getTurmas().getId();
    }

    public String getNome() {
        return nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public Integer getIdTurmas() {
        return idTurmas;
    }
}
