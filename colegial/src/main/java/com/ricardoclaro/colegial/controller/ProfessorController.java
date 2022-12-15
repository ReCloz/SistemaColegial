package com.ricardoclaro.colegial.controller;

import com.ricardoclaro.colegial.entity.Materia;
import com.ricardoclaro.colegial.entity.Professor;
import com.ricardoclaro.colegial.entity.Turma;
import com.ricardoclaro.colegial.repository.MateriaRepository;
import com.ricardoclaro.colegial.repository.ProfessorRepository;
import com.ricardoclaro.colegial.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;

import javax.transaction.Transactional;
import java.util.*;

@Controller
@RequestMapping(path = "/professor")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class ProfessorController {

    @Autowired
    private ProfessorRepository profRep;

    @Autowired
    private TurmaRepository turRep;

    @Autowired
    private MateriaRepository matRep;

    @PostMapping(path = "/add")
    public @ResponseBody String addProf(@RequestParam String nome,
                                        @RequestParam String cpf) {
        Professor prof = new Professor();
        prof.setCpf(cpf);
        prof.setNome(nome);

        try {
            profRep.save(prof);
        }catch (Exception e){
            Logger.error("ProfessorSaveError: ", e);
            return "Error ";
        }

        Logger.info("Professor Salvo " + cpf);
        return "Saved";
    }

    @GetMapping(path = "/read")
    public @ResponseBody ResponseEntity<List<Professor>> readProfessor(@RequestParam String cpf) {
        Logger.info("Professor listado " + cpf);
        return new ResponseEntity(profRep.findByCpf(cpf), HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Professor> getAllProfs() {

        Logger.info("Profesores Listados ");
        return profRep.findAll();
    }

    @PostMapping(path = "/remove")
    @Transactional
    public ResponseEntity<String> deleteProf(@RequestParam String cpf) {

        try {
            profRep.deleteProfessorByCpf(cpf);
        }catch (Exception e){
            Logger.error("ProfessorDeleteError: ", e);
            return ResponseEntity.ok("Error ");
        }

        Logger.info("Professor removido " + cpf);
        return ResponseEntity.ok("Deleted");

    }

    @PostMapping(path = "/contrato")
    public ResponseEntity<String> contrato(@RequestParam String cpf,
                                           @RequestParam String mat) {
        Professor prof = profRep.findByCpf(cpf);
        Materia materia = matRep.findByNome(mat);
        prof.setMateria(materia);

        try{
            profRep.save(prof);
        }catch (Exception e){
            Logger.error("ProfessorSaveError: ", e);
            return ResponseEntity.ok("Error ");
        }

        Logger.info("Contrato realizado ");
        return ResponseEntity.ok("Contrato");
    }

    @PostMapping(path = "/aulas")
    public ResponseEntity<String> aulas(@RequestParam List<String> classe,
                                        @RequestParam String cpf) {
        Professor prof = profRep.findByCpf(cpf);
        List<Turma> turmas = new ArrayList<>();

        for (String nometurma : classe) {
            Turma turma = turRep.findByClasse(nometurma);
            turmas.add(turma);
        }
        prof.addTurmas(turmas);

        try{
            profRep.save(prof);
        }catch (Exception e){
            Logger.error("ProfessorSaveError: ", e);
            return ResponseEntity.ok("Error ");
        }

        Logger.info("Aulas salvas ");
        return ResponseEntity.ok("Aulas Salvas");

    }
}

