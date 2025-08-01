package com.entra21.atividadeEscola.controlador;

import com.entra21.atividadeEscola.entidade.Alunos;
import com.entra21.atividadeEscola.entidade.Professores;
import com.entra21.atividadeEscola.repositorio.AlunosRepositorio;
import com.entra21.atividadeEscola.repositorio.ProfessoresRepositorio;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessoresControlador {

    private final ProfessoresRepositorio professoresRepositorio;



    public ProfessoresControlador(ProfessoresRepositorio professoresRepositorio, AlunosRepositorio alunosRepositorio) {
        this.professoresRepositorio = professoresRepositorio;

    }

    @GetMapping
    public List<Professores> listarProfessores (){
        return this.professoresRepositorio.findAll();
    }
    @GetMapping("/{idProfessor}")
    public Professores buscarProfessor (@PathVariable Integer idProfessor){
        return this.professoresRepositorio.findById(idProfessor).orElseThrow();
    }

    @GetMapping("/{idProfessor}/alunos")
    public List<Alunos> listarAlunoDeProfessor(@PathVariable Integer idProfessor){
        Professores professores = this.professoresRepositorio.findById(idProfessor).orElseThrow();
        return professores.getAlunos();
    }

    @PostMapping
    public Professores adicionarProfessor (@RequestBody Professores professores){
        professores.setRegistro(LocalDate.now());
        return this.professoresRepositorio.save(professores);
    }

    @DeleteMapping("/{idProfessor}")
    public Professores deletarProfessor (@PathVariable Integer idProfessor){
        Professores del = this.professoresRepositorio.findById(idProfessor).orElseThrow();
        this.professoresRepositorio.deleteById(idProfessor);
        return del;
    }
}
