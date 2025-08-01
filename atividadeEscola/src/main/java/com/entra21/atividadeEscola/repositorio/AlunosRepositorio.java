package com.entra21.atividadeEscola.repositorio;

import com.entra21.atividadeEscola.entidade.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunosRepositorio extends JpaRepository<Alunos, Integer> {
}
