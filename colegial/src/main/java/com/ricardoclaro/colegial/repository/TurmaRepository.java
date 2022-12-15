package com.ricardoclaro.colegial.repository;

import com.ricardoclaro.colegial.entity.Turma;
import org.springframework.data.repository.CrudRepository;

public interface TurmaRepository extends CrudRepository<Turma, Integer> {

    void deleteTurmaByClasse(String classe);

    Turma findByClasse(String classe);
}
