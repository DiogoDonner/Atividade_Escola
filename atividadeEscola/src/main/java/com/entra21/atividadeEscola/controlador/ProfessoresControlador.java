package com.entra21.atividadeEscola.controlador;

import com.entra21.atividadeEscola.dtos.ProfessoresDTO.ProfessoresRequestDTO;
import com.entra21.atividadeEscola.entidade.Alunos;
import com.entra21.atividadeEscola.entidade.Professores;
import com.entra21.atividadeEscola.repositorio.AlunosRepositorio;
import com.entra21.atividadeEscola.repositorio.ProfessoresRepositorio;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        return null;
    }

    @PostMapping
    public ProfessoresRequestDTO adicionarProfessor (@RequestBody ProfessoresRequestDTO dto){
        Professores professores = new Professores();
        professores.setRegistro(LocalDateTime.now());
        professores.setNome(dto.getNome());
        professores.setMateria(dto.getMateria());
        professoresRepositorio.save(professores);
        return dto;
    }

    @DeleteMapping("/{idProfessor}")
    public Professores deletarProfessor (@PathVariable Integer idProfessor){
        Professores del = this.professoresRepositorio.findById(idProfessor).orElseThrow();
        this.professoresRepositorio.deleteById(idProfessor);
        return del;
    }
}
