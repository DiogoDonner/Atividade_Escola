package com.entra21.atividadeEscola.repositorio;

import com.entra21.atividadeEscola.entidade.Professores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessoresRepositorio extends JpaRepository<Professores, Integer> {
}
