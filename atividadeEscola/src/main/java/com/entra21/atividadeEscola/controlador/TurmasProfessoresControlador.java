package com.entra21.atividadeEscola.controlador;

import com.entra21.atividadeEscola.dtos.TurmasProfessoresDTO.TurmasProfessoresRequestDTO;
import com.entra21.atividadeEscola.entidade.TurmasProfessores;
import com.entra21.atividadeEscola.repositorio.ProfessoresRepositorio;
import com.entra21.atividadeEscola.repositorio.TurmasProfessoresRepositorio;
import com.entra21.atividadeEscola.repositorio.TurmasRepositorio;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/tp")
public class TurmasProfessoresControlador {

    private final TurmasProfessoresRepositorio turmasProfessoresRepositorio;
    private final TurmasRepositorio turmasRepositorio;
    private final ProfessoresRepositorio professoresRepositorio;

    public TurmasProfessoresControlador(TurmasProfessoresRepositorio turmasProfessoresRepositorio, TurmasRepositorio turmasRepositorio, ProfessoresRepositorio professoresRepositorio) {
        this.turmasProfessoresRepositorio = turmasProfessoresRepositorio;
        this.turmasRepositorio = turmasRepositorio;
        this.professoresRepositorio = professoresRepositorio;
    }

    @PostMapping
    TurmasProfessoresRequestDTO adicionarProfessorTurma (@RequestBody TurmasProfessoresRequestDTO dto){
        TurmasProfessores turmasProfessores = new TurmasProfessores();
        Integer getTurma = dto.getIdTurma();
        turmasProfessores.setRegistro(LocalDateTime.now());
        Integer getProfessor = dto.getIdProfessor();
        turmasProfessores.setProfessores(professoresRepositorio.findById(getProfessor).orElseThrow());
        turmasProfessores.setTurmas(turmasRepositorio.findById(getTurma).orElseThrow());

        turmasProfessoresRepositorio.save(turmasProfessores);
        return dto;

    }
}
