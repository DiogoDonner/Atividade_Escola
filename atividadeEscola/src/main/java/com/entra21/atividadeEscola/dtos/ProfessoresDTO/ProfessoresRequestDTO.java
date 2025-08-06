package com.entra21.atividadeEscola.dtos.ProfessoresDTO;

import com.entra21.atividadeEscola.entidade.Professores;

import java.util.List;

public class ProfessoresRequestDTO {
    private String nome;
    private String materia;

    public ProfessoresRequestDTO() {}

    public ProfessoresRequestDTO(Professores professores){
        this.nome = professores.getNome();;
        this.materia= professores.getMateria();
    }

    public String getNome() {
        return nome;
    }

    public String getMateria() {
        return materia;
    }
}
