package com.entra21.atividadeEscola.dtos;

import com.entra21.atividadeEscola.entidade.Alunos;
import com.entra21.atividadeEscola.entidade.Professores;
import com.entra21.atividadeEscola.entidade.Turmas;
import com.entra21.atividadeEscola.entidade.TurmasProfessores;

import java.util.List;

public class TurmasResponseDTO {
    private String identificador;
    private List<Alunos> alunos;
    private List<TurmasProfessores> professores;


    public TurmasResponseDTO() {

    }

    public TurmasResponseDTO(Turmas turmas){
        this.identificador = turmas.getIdentificador();
        this.alunos = turmas.getAlunos();
        this.professores = turmas.getTurmasProfessores();
    }


    public String getIdentificador() {
        return identificador;
    }

    public List<Alunos> getAlunos() {
        return alunos;
    }

    public List<TurmasProfessores> getProfessores() {
        return professores;
    }
}
