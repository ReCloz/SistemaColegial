package com.ricardoclaro.colegial.controller;


import com.ricardoclaro.colegial.entity.Aluno;
import com.ricardoclaro.colegial.entity.AlunoMateria;
import com.ricardoclaro.colegial.entity.Materia;
import com.ricardoclaro.colegial.entity.Turma;
import com.ricardoclaro.colegial.repository.AlunoMateriaRepository;
import com.ricardoclaro.colegial.repository.AlunoRepository;
import com.ricardoclaro.colegial.repository.MateriaRepository;
import com.ricardoclaro.colegial.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;

import javax.transaction.Transactional;
import java.util.List;


@Controller
@RequestMapping(path = "/aluno")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRep;

    @Autowired
    private TurmaRepository turmaRep;

    @Autowired
    private MateriaRepository matRep;

    @Autowired
    private AlunoMateriaRepository alunoMateriaRep;


    @PostMapping(path = "/add")
    public @ResponseBody String addAluno(@RequestParam String nome, @RequestParam String ra) {
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setRa(ra);

        try{
            alunoRep.save(aluno);
        }catch (Exception e){
            Logger.error("AlunoDeleteError: ", e);
            return "Error ";
        }

        Logger.info("Aluno Salvo " + ra);
        return "Saved ";
    }

    @PostMapping(path = "/update")
    public @ResponseBody String updateAluno(@RequestParam String ra, @RequestParam String nome,@RequestParam String tur) {
        Aluno aluno = alunoRep.findByRa(ra);
        aluno.setNome(nome);
        Turma turma = turmaRep.findByClasse(tur);

        aluno.setTurmaSet(turma);

        try {
            alunoRep.save(aluno);
        } catch (Exception e){
            Logger.error("AlunoSaveError: ", e);
            return "Error ";
        }

        return "Updated ";

    }

    @GetMapping(path = "/read")
    public @ResponseBody ResponseEntity<List<Aluno>> readAluno(@RequestParam String ra) {
        Logger.info("Listado ");
        return new ResponseEntity(alunoRep.findByRa(ra), HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Aluno> getAllAlunos() {

        Logger.info("Listado todos ");
        return alunoRep.findAll();
    }


    @PostMapping(path = "/remove")
    @Transactional
    public ResponseEntity<String> deleteAluno(@RequestParam String ra) {
        alunoRep.deleteAlunoByRa(ra);
        Logger.info("Aluno Removido " + ra);
        return ResponseEntity.ok("Deleted");

    }

    @PostMapping(path = "/matricula")
    public ResponseEntity<String> matricula(@RequestParam String ra,
                                            @RequestParam String tur) {
        Aluno aluno = alunoRep.findByRa(ra);
        Turma turma = turmaRep.findByClasse(tur);
        aluno.setTurmaSet(turma);

        try {
            alunoRep.save(aluno);
        }catch (Exception e){
            Logger.error("AlunoSaveError: ", e);
            return ResponseEntity.ok("Error ");
        }

        Logger.info("Matricula feita ra " + ra + " turma " + tur);
        return ResponseEntity.ok("Matriculado");
    }

    @PreAuthorize("hasAnyAuthority()")
    @PostMapping(path = "/nota")
    public @ResponseBody String inserirnotas(@RequestParam String ra,
                                             @RequestParam String nomeMateria,
                                             @RequestParam double nota) {
        Aluno aluno = alunoRep.findByRa(ra);
        Materia mat = matRep.findByNome(nomeMateria);
        AlunoMateria alunoMateria = new AlunoMateria();
        alunoMateria.setAluno(aluno);
        alunoMateria.setMateria(mat);
        alunoMateria.setNota(nota);

        try {
            alunoMateriaRep.save(alunoMateria);
        } catch (Exception e){
            Logger.error("AlunoMateriaSaveError: ", e);
            return "Erro ";
        }

        aluno.addNota(alunoMateria);

        try {
            alunoRep.save(aluno);
        }catch (Exception e){
            Logger.error("AlunoSaveError: ", e);
            return "Error ";
        }

        Logger.info("Nota Salva nome:" + nomeMateria);
        return "Nota salva ";
    }
}

