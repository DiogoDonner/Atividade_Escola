package com.entra21.atividadeEscola.dtos.TurmasProfessoresDTO;

import com.entra21.atividadeEscola.entidade.Turmas;
import com.entra21.atividadeEscola.entidade.TurmasProfessores;

import java.util.ArrayList;
import java.util.List;

public class TurmasProfessoresResponseDTO {
    private List<String> turmas;
    private List<String> professores;

    public TurmasProfessoresResponseDTO(List<TurmasProfessores> lista) {
        this.turmas = new ArrayList<>();
        this.professores = new ArrayList<>();

        for (TurmasProfessores tp : lista) {
            this.turmas.add(tp.getTurmas().getIdentificador());
            this.professores.add(tp.getProfessores().getNome());
        }
    }

    public List<String> getTurmas() {
        return turmas;
    }

    public List<String> getProfessores() {
        return professores;
    }

}