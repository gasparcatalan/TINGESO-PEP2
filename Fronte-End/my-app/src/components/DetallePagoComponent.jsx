import React, { useEffect, useState } from 'react';
import PagoService from '../services/PagoService';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useParams } from 'react-router-dom';

function DetallePagoComponent() {
    const [pago, setPago] = useState(null);
    const { idPago } = useParams();

    useEffect(() => {
        PagoService.obtenerPago(idPago)
            .then(response => {
                setPago(response.data);
            })
            .catch(error => {
                console.error('Error al obtener el pago:', error);
            });
    }, [idPago]);

    return (
        <div className="container">
            {pago ? (
                <div>
                    <h1>Pago del Proveedor {pago.nombreProveedor}</h1>
                        <p>Código: {pago.codigoProveedor}</p>
                        <p>Fecha: {pago.fecha}</p>
                        <p>Días de envíos: {pago.diasEnvios}</p>
                        <p>Promedio de leche por día: {pago.promLecheDia}</p>
                        <p>Leche: {pago.leche}</p>
                        <p>Grasa: {pago.grasa}</p>
                        <p>Sólidos: {pago.solidos}</p>
                        <p>Variación de Leche: {pago.varLeche}</p>
                        <p>Variación de Grasa: {pago.varGrasa}</p>
                        <p>Variación de Sólidos: {pago.varST}</p>
                        <p>Variación Total: {pago.varTotal}</p>
                        <p>Pago por Categoría: {pago.pagoCategoria}</p>
                        <p>Pago por Grasa: {pago.pagoGrasa}</p>
                        <p>Pago por Sólido: {pago.pagoSolido}</p>
                        <p>Bonificación por Frecuencia: {pago.bonfFrec}</p>
                        <p>Descuento por Variación de Leche: {pago.descVarLeche}</p>
                        <p>Descuento por Variación de Grasa: {pago.descVarGrasa}</p>
                        <p>Descuento por Variación de Sólidos: {pago.descVarSolidos}</p>
                        <p>Total: {pago.total}</p>
                        <p>Monto de Retención: {pago.montoRetencion}</p>
                        <p>Monto Final: {pago.montoFinal}</p>
                </div>
            ) : (
                <p>Cargando datos del pago...</p>
            )}
        </div>
    );
}

export default DetallePagoComponent;
