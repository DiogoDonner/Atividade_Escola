package com.entra21.atividadeEscola.controlador;

import com.entra21.atividadeEscola.dtos.AlunosDTO.AlunosPutRequestDTO;
import com.entra21.atividadeEscola.dtos.AlunosDTO.AlunosRequestDTO;
import com.entra21.atividadeEscola.dtos.AlunosDTO.AlunosResponseDTO;
import com.entra21.atividadeEscola.dtos.TurmasResponseDTO;
import com.entra21.atividadeEscola.entidade.Alunos;
import com.entra21.atividadeEscola.entidade.Professores;
import com.entra21.atividadeEscola.entidade.Turmas;
import com.entra21.atividadeEscola.repositorio.AlunosRepositorio;
import com.entra21.atividadeEscola.repositorio.ProfessoresRepositorio;
import com.entra21.atividadeEscola.repositorio.TurmasRepositorio;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunosControlador {

    private final AlunosRepositorio alunosRepositorio;
    private final TurmasRepositorio turmasRepositorio;


    public AlunosControlador(AlunosRepositorio alunosRepositorio, ProfessoresRepositorio professoresRepositorio, TurmasRepositorio turmasRepositorio) {
        this.alunosRepositorio = alunosRepositorio;
        this.turmasRepositorio = turmasRepositorio;
    }

    @GetMapping
    public List<AlunosResponseDTO> listarAlunos(){
        List<Alunos> alunos = alunosRepositorio.findAll();
        List<AlunosResponseDTO> listaDTO = new ArrayList<>();

        for (Alunos aluno : alunos) {
            listaDTO.add(new AlunosResponseDTO(aluno));
        }
        return listaDTO;
    }

    @GetMapping("/{idAluno}")
    public AlunosResponseDTO buscarAluno(@PathVariable Integer idAluno){
        Alunos alunos = alunosRepositorio.findById(idAluno).orElseThrow();
        AlunosResponseDTO dto = new AlunosResponseDTO(alunos);
        return dto;
    }

    @PostMapping
    public AlunosRequestDTO adicionarAluno(@RequestBody AlunosRequestDTO dto){
        Integer turma = dto.getIdTurma();
        Alunos aluno = new Alunos();
        aluno.setRegistro(LocalDateTime.now());
        aluno.setNome(dto.getNome());
        aluno.setMatricula(dto.getMatricula());
        aluno.setTurmas(turmasRepositorio.findById(turma).orElseThrow());
        alunosRepositorio.save(aluno);
        return dto;
    }

    @DeleteMapping("/{idAluno}")
    public AlunosResponseDTO deletarAluno(@PathVariable Integer idAluno){
        Alunos del = alunosRepositorio.findById(idAluno).orElseThrow();
        AlunosResponseDTO dto = new AlunosResponseDTO(del);
        this.alunosRepositorio.deleteById(idAluno);
        return dto;
    }
    @PutMapping("/{idAluno}")
    public AlunosPutRequestDTO atualizarAluno(@RequestBody AlunosPutRequestDTO dto, @PathVariable Integer idAluno){
        Alunos aluno = alunosRepositorio.findById(idAluno).orElseThrow();
        aluno.setNome(dto.getNome());
        aluno.setMatricula(dto.getMatricula());
        this.alunosRepositorio.save(aluno);

        return dto;
    }



}
