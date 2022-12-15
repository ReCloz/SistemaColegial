package com.ricardoclaro.colegial.repository;

import com.ricardoclaro.colegial.entity.Materia;
import org.springframework.data.repository.CrudRepository;

public interface MateriaRepository extends CrudRepository<Materia, Integer> {

    void deleteMateriaByNome(String nome);

    Materia findByNome(String nome);
}
