package com.example.pagoservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Laboratorio {

    private Double grasas;
    private Double solidos;
    private String codigoProveedor;
}
