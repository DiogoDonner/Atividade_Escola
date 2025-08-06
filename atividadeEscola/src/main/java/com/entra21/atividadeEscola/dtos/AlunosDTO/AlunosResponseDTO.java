package com.entra21.atividadeEscola.dtos.AlunosDTO;

import com.entra21.atividadeEscola.entidade.Alunos;
import com.entra21.atividadeEscola.entidade.Turmas;

public class AlunosResponseDTO {
    private String nome;
    private Integer matricula;
    private Turmas turmas;

    public AlunosResponseDTO(Alunos alunos){
        this.nome = alunos.getNome();
        this.matricula = alunos.getMatricula();
        this.turmas = alunos.getTurmas();
    }
}
