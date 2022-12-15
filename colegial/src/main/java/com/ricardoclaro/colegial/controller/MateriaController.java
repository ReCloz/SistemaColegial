package com.ricardoclaro.colegial.controller;

import com.ricardoclaro.colegial.entity.Materia;
import com.ricardoclaro.colegial.repository.MateriaRepository;
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
@RequestMapping(path = "/materia")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class MateriaController {


    @Autowired
    private MateriaRepository matRep;

    @PostMapping(path = "/add")
    public @ResponseBody String addMat(@RequestParam String nome) {
        Materia mat = new Materia();
        mat.setNome(nome);

        try{
            matRep.save(mat);
        }catch (Exception e){
            Logger.error("MateriaSaveError: ", e);
            return "Error ";
        }

        Logger.info("Materia salva "+nome);
        return "Saved";
    }

    @GetMapping(path = "/read")
    public @ResponseBody ResponseEntity<List<Materia>> readMateria(@RequestParam String nome) {
        Logger.info("Materia Listada ");
        return new ResponseEntity(matRep.findByNome(nome), HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Materia> getAllMaterias() {

        Logger.info("Materias Listadas ");
        return matRep.findAll();
    }


    @PostMapping(path = "/remove")
    @Transactional
    public ResponseEntity<String> deleteMateria(@RequestParam String nome) {

        try{
            matRep.deleteMateriaByNome(nome);
        }catch (Exception e){
            Logger.error("MateriaDeleteError: ", e);
            return ResponseEntity.ok("Error");
        }

        Logger.info("Materia removida "+nome);
        return ResponseEntity.ok("Deleted");

    }


}
