package com.entra21.atividadeEscola.controlador;

import com.entra21.atividadeEscola.entidade.Alunos;
import com.entra21.atividadeEscola.entidade.Professores;
import com.entra21.atividadeEscola.repositorio.AlunosRepositorio;
import com.entra21.atividadeEscola.repositorio.ProfessoresRepositorio;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunosControlador {

    private final AlunosRepositorio alunosRepositorio;
    private final ProfessoresRepositorio professoresRepositorio;

    public AlunosControlador(AlunosRepositorio alunosRepositorio, ProfessoresRepositorio professoresRepositorio) {
        this.alunosRepositorio = alunosRepositorio;
        this.professoresRepositorio = professoresRepositorio;
    }

    @GetMapping
    public List<Alunos> listarAlunos(){
        return this.alunosRepositorio.findAll();
    }

    @GetMapping("/{idAluno}")
    public Alunos buscarAluno(@PathVariable Integer idAluno){
        return this.alunosRepositorio.findById(idAluno).orElseThrow();
    }

    @PostMapping("/novo/{idProfessor}")
    public Alunos adicionarAluno(@RequestBody Alunos alunos, @PathVariable Integer idProfessor){
        Professores prof = this.professoresRepositorio.findById(idProfessor).orElseThrow();
        alunos.setProfessores(prof);
        alunos.setRegistro(LocalDate.now());

        return this.alunosRepositorio.save(alunos);
    }

    @DeleteMapping("/delete/{idUsuario}")
    public Alunos deletarAluno(@PathVariable Integer idUsuario){
        Alunos del = this.alunosRepositorio.findById(idUsuario).orElseThrow();
        this.alunosRepositorio.deleteById(idUsuario);
        return del;
    }



}
