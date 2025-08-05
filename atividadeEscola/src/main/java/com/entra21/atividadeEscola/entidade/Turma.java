package com.entra21.atividadeEscola.entidade;

import java.time.LocalTime;
import java.util.List;

public class Turma {
    private Integer id;
    private String nome;
    private LocalTime registro;
    private List<Alunos> alunos;
    private List<Professores> professores;

}
