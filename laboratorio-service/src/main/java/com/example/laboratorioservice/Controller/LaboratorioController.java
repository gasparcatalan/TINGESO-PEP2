package com.example.laboratorioservice.Controller;

import com.example.laboratorioservice.Entities.LaboratorioEntity;
import com.example.laboratorioservice.Services.LaboratorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/laboratorio")
public class LaboratorioController {

    @Autowired
    LaboratorioService laboratorioService;

    @GetMapping
    public ResponseEntity<List<LaboratorioEntity>> getAllLabs(){
        List<LaboratorioEntity> labs = laboratorioService.getAll();
        if (labs.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(labs);

    }

    @GetMapping("/{codigo}")
    public ResponseEntity<LaboratorioEntity> getBycodigo(String codigo){
        LaboratorioEntity lab = laboratorioService.getBycodigo(codigo);
        if (lab == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lab);

    }

    @PostMapping("/subir")
    public String cargarArchivo(@RequestParam ("lab")MultipartFile lab){
        laboratorioService.guardar(lab);
        laboratorioService.leerCsv("resultados.csv");
        return "Archivo Cargado Exitosamente";

    }
}
