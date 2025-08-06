package com.entra21.atividadeEscola.dtos;

import com.entra21.atividadeEscola.dtos.AlunosDTO.AlunosResponseDTO;
import com.entra21.atividadeEscola.entidade.Alunos;
import com.entra21.atividadeEscola.entidade.Professores;
import com.entra21.atividadeEscola.entidade.Turmas;
import com.entra21.atividadeEscola.entidade.TurmasProfessores;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TurmasResponseDTO {
    private String identificador ;
    private List<String> alunos;
    private List<TurmasProfessores> professores;


    public TurmasResponseDTO() {}

    public TurmasResponseDTO(Turmas turmas){
        this.identificador = turmas.getIdentificador();
        this.alunos = new ArrayList<>();

        for (Alunos aluno : turmas.getAlunos()) {
            this.alunos.add(aluno.getNome());
        }

        this.professores = turmas.getTurmasProfessores();
    }


    public String getIdentificador() {
        return identificador;
    }

    public List<String> getAlunos() {
        return alunos;
    }

    public List<TurmasProfessores> getProfessores() {
        return professores;
    }

}
