package com.ricardoclaro.colegial.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "aluno_materia")
@IdClass(AlunoMateriaId.class)
public class AlunoMateria {

    @JsonIgnore
    @ManyToOne
    @Id
    @JoinColumn(name = "idAluno")
    private Aluno aluno;

    @ManyToOne
    @Id
    @JoinColumn(name = "idMateria")
    private Materia materia;

    private double nota;

}
