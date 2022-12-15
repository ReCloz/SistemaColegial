package com.ricardoclaro.colegial.repository;

import com.ricardoclaro.colegial.entity.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Integer> {

    Professor findByCpf(String cpf);

    void deleteProfessorByCpf(String cpf);
}
