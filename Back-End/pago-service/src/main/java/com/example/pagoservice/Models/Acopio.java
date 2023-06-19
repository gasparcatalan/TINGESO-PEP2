package com.example.pagoservice.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Acopio {
    private Double klsLeche;
    private String turno;
    private String codigoProveedor;
    private Date fecha;
}
