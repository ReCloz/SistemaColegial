package com.ricardoclaro.colegial.repository;

import com.ricardoclaro.colegial.entity.Aluno;
import org.springframework.data.repository.CrudRepository;

public interface AlunoRepository extends CrudRepository<Aluno, Integer> {

    Aluno findByRa(String ra);

    void deleteAlunoByRa(String ra);
}
