package com.example.pagoservice.Repositories;

import com.example.pagoservice.Entities.PagoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PagoRepository extends CrudRepository<PagoEntity,Long> {
    @Query("SELECT p FROM PagoEntity p WHERE p.codigoProveedor = :codigo_proveedor AND p.fecha < :fecha ORDER BY p.fecha DESC")
    PagoEntity findAnteriorPago(@Param("codigo_proveedor") String codigo_proveedor, @Param("fecha") Date fecha);

    @Query("SELECT p FROM PagoEntity p where p.codigoProveedor = :codigoProveedor")
    List<PagoEntity> findAllByCodigoProveedor(@Param("codigoProveedor") String codigoProveedor);

    @Query("select p from PagoEntity p where p.idPago =:id_pago")
    PagoEntity findporId(Long id_pago);
}
