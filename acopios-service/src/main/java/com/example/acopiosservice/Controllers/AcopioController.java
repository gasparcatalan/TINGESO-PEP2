package com.example.acopiosservice.Controllers;

import com.example.acopiosservice.Entities.AcopioEntity;
import com.example.acopiosservice.Services.AcopioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin (origins = "*")
@RestController
@RequestMapping("/acopios")
public class AcopioController {

    @Autowired
    AcopioService acopioService;

    @GetMapping
    public ResponseEntity<List<AcopioEntity>> allAcopios(){
        List<AcopioEntity> acop = acopioService.getAll();
        if (acop.isEmpty()){
            return ResponseEntity.noContent().build();}
        return ResponseEntity.ok(acop);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<List<AcopioEntity>> acopiosCodigo(@PathVariable String codigo){
    List<AcopioEntity> acop = acopioService.showByCodigo(codigo);
    if (acop.isEmpty()){
        return ResponseEntity.noContent().build();}
    return ResponseEntity.ok(acop);
    }

    @PostMapping
    public String leerAcopios(@RequestParam("nombre")MultipartFile nombre){
        acopioService.guardar(nombre);
        acopioService.leerCsv("Acopio.csv");
        return "Archivo correctamente registrado";
    }

    @GetMapping("/klsLeche/{codigo}")
    public Double KlsTotalesProv(@PathVariable String codigo){
        return acopioService.totalKlsLecheByCodigo(codigo);
    }


    @GetMapping("/{codigo}/{turno}")
    public Integer totalTurno(@PathVariable String codigo, @PathVariable String turno){
        return acopioService.totalTurnos(codigo, turno);
    }
}
