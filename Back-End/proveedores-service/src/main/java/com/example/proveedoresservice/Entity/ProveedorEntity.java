package com.example.proveedoresservice.Entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorEntity {
    @Id
    @NotNull
    private Long id;

    private String codigo;
    private String nombre;
    private String categoria;
    private String retencion;

}
