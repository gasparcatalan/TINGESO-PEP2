package com.example.laboratorioservice.Repositories;

import com.example.laboratorioservice.Entities.LaboratorioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratorioRepository extends CrudRepository<LaboratorioEntity, Long> {

    @Query
            ("select l from LaboratorioEntity l where l.codigoProveedor = :codigo")
    LaboratorioEntity findByCodigo(@Param("codigo") String Codigo);



}
