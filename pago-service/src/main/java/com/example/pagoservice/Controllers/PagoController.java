package com.example.pagoservice.Controllers;

import com.example.pagoservice.Entities.PagoEntity;
import com.example.pagoservice.Services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pago")
public class PagoController {

    @Autowired
    PagoService pagoService;

    @GetMapping
    public ResponseEntity<List<PagoEntity>> todosPagos(){
        List<PagoEntity> pagos = pagoService.obtenerPagos();
        if (pagos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pagos);

    }

    @GetMapping("/{codigo}")
    public ResponseEntity<List<PagoEntity>> PagosCodigo(@PathVariable String codigo){
        List<PagoEntity> pagos = pagoService.obtenerPagosProv(codigo);
        if (pagos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pagos);

    }
    @GetMapping("pago/{id}")
    public ResponseEntity<PagoEntity> PagosCodigo(@PathVariable Long id){
        PagoEntity pago = pagoService.obtenerporID(id);
        if (pago == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pago);

    }

    @PostMapping("/crear/{codigo}")
    public PagoEntity crear1Pago(@PathVariable String codigo) {
        PagoEntity p = pagoService.crearPago(codigo);
        return p;

    }

    @PostMapping("/crearpagos")
    public String crearPagos(){
        pagoService.generarPagos();
        return "Pagos Generados!";
    }

}
