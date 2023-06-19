package com.example.acopiosservice.Repositories;

import com.example.acopiosservice.Entities.AcopioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AcopioRepository extends CrudRepository<AcopioEntity, Long> {
    @Query("select a from AcopioEntity a where a.codigoProveedor = :codigo")
    ArrayList<AcopioEntity> findAllByCodigo_proveedor(@Param("codigo") String codigo);

    @Query("select  sum (a.klsLeche) from AcopioEntity a where a.codigoProveedor = :codigo")
    Double totalLeche(@Param("codigo") String codigo);


    @Query("select count(a) from AcopioEntity a where a.codigoProveedor =:codigo "+
            "and a.turno =:turno")
    Integer countTurno(@Param("codigo") String codigo,
                       @Param("turno") String turno);
}
