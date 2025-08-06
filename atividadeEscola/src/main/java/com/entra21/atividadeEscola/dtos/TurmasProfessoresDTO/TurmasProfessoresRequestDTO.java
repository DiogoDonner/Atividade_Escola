package com.entra21.atividadeEscola.dtos.TurmasProfessoresDTO;

import com.entra21.atividadeEscola.entidade.TurmasProfessores;

public class TurmasProfessoresRequestDTO {
    private Integer idTurma;
    private Integer idProfessor;

    public TurmasProfessoresRequestDTO() {
    }

    public TurmasProfessoresRequestDTO(TurmasProfessores turmasProfessores) {
        this.idTurma = turmasProfessores.getTurmas().getId();
        this.idProfessor = turmasProfessores.getProfessores().getId();
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public Integer getIdProfessor() {
        return idProfessor;
    }
}
