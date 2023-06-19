package com.example.proveedoresservice.Repositories;

import com.example.proveedoresservice.Entity.ProveedorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends CrudRepository<ProveedorEntity, Integer> {

    @Query("select p from ProveedorEntity p where p.codigo = :codigo")
    ProveedorEntity findByCodigo(@Param("codigo") String codigo);


}
