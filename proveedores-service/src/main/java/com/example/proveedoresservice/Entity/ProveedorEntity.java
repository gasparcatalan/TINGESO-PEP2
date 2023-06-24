package com.example.proveedoresservice.Entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "proveedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String codigo;
    private String nombre;
    private String categoria;
    private String retencion;

}
