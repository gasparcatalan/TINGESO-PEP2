package com.example.proveedoresservice.Controllers;

import com.example.proveedoresservice.Entity.ProveedorEntity;
import com.example.proveedoresservice.Services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;


    @GetMapping
    public ResponseEntity<List<ProveedorEntity>> proveedores(){
        List<ProveedorEntity> proveedores = proveedorService.obtenerProveedores();
        if (proveedores.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(proveedores);
    }

    @PostMapping
    public ResponseEntity<ProveedorEntity> crearProv(@RequestBody ProveedorEntity proveedor){
        return ResponseEntity.ok(proveedorService.guardarProv(proveedor));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ProveedorEntity> findByCodigo(@PathVariable String codigo){
        ProveedorEntity temp = proveedorService.encontrarPorCodigo(codigo);
        if (temp == null) {return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(temp);
    }




}
