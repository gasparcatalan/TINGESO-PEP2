package com.example.pagoservice.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pagos")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class PagoEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (unique = true, nullable = false)
    private  Long idPago;

    private  String codigoProveedor ;
    private String nombreProveedor;
    private Date fecha;
    private Integer diasEnvios;
    private Double promLecheDia;
    //Resultados Lab
    private Double leche;
    private Double grasa;
    private Double solidos;

    //Variaciones
    private Double varLeche;
    private Double varGrasa;
    private Double varST;
    private Double varTotal;
    //Pagos
    private Double pagoCategoria;
    private Double pagoGrasa;
    private Double pagoSolido;
    private Double bonfFrec;
    private Double descVarLeche;
    private Double descVarGrasa;
    private Double descVarSolidos;
    private Double total;
    private Double montoRetencion;
    private Double montoFinal;



}
