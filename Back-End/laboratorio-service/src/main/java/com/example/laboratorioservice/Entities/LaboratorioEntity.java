package com.example.laboratorioservice.Entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "laboratorios")
@NoArgsConstructor
@AllArgsConstructor
@Data


public class LaboratorioEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (unique = true, nullable = false)
    private Long id;

    private Double grasas;
    private Double solidos;
    private String codigoProveedor;




}
