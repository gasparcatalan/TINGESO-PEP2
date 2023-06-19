package com.example.proveedoresservice.Services;

import com.example.proveedoresservice.Repositories.ProveedorRepository;
import com.example.proveedoresservice.Entity.ProveedorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    public List<ProveedorEntity> obtenerProveedores(){
        return (List<ProveedorEntity>) proveedorRepository.findAll();
    }

    public ProveedorEntity encontrarPorCodigo(String codigo){
        return (ProveedorEntity) proveedorRepository.findByCodigo(codigo);
    }
    public ProveedorEntity guardarProv(ProveedorEntity proveedor){
        proveedorRepository.save(proveedor);
        return proveedor;
    }




}
