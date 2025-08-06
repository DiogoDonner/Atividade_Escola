package com.entra21.atividadeEscola.dtos.ProfessoresDTO;

import com.entra21.atividadeEscola.entidade.Alunos;
import com.entra21.atividadeEscola.entidade.Professores;
import com.entra21.atividadeEscola.entidade.Turmas;
import com.entra21.atividadeEscola.entidade.TurmasProfessores;

import java.util.ArrayList;
import java.util.List;

public class ProfessoresResponseDTO {
    private String nome;
    private String materia;
    private List<String> turmas;

    public ProfessoresResponseDTO(Professores professores) {
        this.nome = professores.getNome();
        this.materia = professores.getMateria();
        this.turmas = new ArrayList<>();
        for (TurmasProfessores tp : professores.getTurmasProfessores()) {
            this.turmas.add(tp.getTurmas().getIdentificador());
        }
    }

    public String getNome() {
        return nome;
    }

    public String getMateria() {
        return materia;
    }

    public List<String> getTurmas() {
        return turmas;
    }
}
