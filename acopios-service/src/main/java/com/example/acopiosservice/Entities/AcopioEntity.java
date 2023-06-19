package com.example.acopiosservice.Entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "acopios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcopioEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double klsLeche;
    private String turno;
    private String codigoProveedor;
    private Date fecha;
}
