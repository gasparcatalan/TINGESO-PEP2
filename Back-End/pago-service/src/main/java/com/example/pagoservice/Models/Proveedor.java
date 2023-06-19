package com.example.pagoservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Proveedor {

    private String codigo;
    private String nombre;
    private String categoria;
    private String retencion;
}
