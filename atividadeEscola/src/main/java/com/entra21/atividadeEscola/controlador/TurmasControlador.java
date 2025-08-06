package com.entra21.atividadeEscola.controlador;

import com.entra21.atividadeEscola.dtos.TurmasResponseDTO;
import com.entra21.atividadeEscola.entidade.Turmas;
import com.entra21.atividadeEscola.repositorio.TurmasRepositorio;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/turmas")
public class TurmasControlador {

    private final TurmasRepositorio turmasRepositorio;

    public TurmasControlador(TurmasRepositorio turmasRepositorio) {
        this.turmasRepositorio = turmasRepositorio;
    }
    @GetMapping
    public List<TurmasResponseDTO> listarTurmas() {
        List<Turmas> turmas = turmasRepositorio.findAll();
        List<TurmasResponseDTO> listaDTO = new ArrayList<>();

        for (Turmas turma : turmas) {
            listaDTO.add(new TurmasResponseDTO(turma));
        }
        return listaDTO;
//        List<Turmas> buscar = turmasRepositorio.findAll();
//        // Converter lista de Turmas para lista de TurmasResponseDTO
//        List<TurmasResponseDTO> listaDTO = buscar.stream()
//                .map(turma -> new TurmasResponseDTO(turma))
//                .collect(Collectors.toList());

    }


    @GetMapping("/{idTurma}")
    public TurmasResponseDTO buscarTurmas(@PathVariable Integer idTurma){
        Turmas buscar = turmasRepositorio.findById(idTurma).orElseThrow();
        TurmasResponseDTO DTO = new TurmasResponseDTO(buscar);
        return DTO;
    }

    @PostMapping
    public TurmasResponseDTO adicionarTurma(@RequestBody TurmasResponseDTO dto){
        Turmas novo = new Turmas();
        novo.setIdentificador(dto.getIdentificador());
        novo.setRegistro(LocalDateTime.now());
        this.turmasRepositorio.save(novo);
        return dto;
    }

}
