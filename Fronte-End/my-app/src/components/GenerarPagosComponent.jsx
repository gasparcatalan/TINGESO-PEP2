import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import PagoService from "../services/PagoService";
import { useNavigate } from "react-router-dom";

const GenerarPagosComponent = () => {
    let navigate = useNavigate();

    const handleGenerarPagos = () => {
        const confirmacion = window.confirm("¿Estás seguro de generar los pagos? Esta acción no se puede deshacer.");
        if (confirmacion) {
            PagoService.crearPago()
                .then(res => {
                    
                    alert("Los pagos se han generado exitosamente!");
                    navigate("/"); // Redirige al usuario a la página principal
                })
                .catch(error => {
                    // Manejo de errores
                    alert("Hubo un error al generar los pagos. Por favor intenta de nuevo.");
                });
        }
    };

    return (
        <div>
            <h1>Generar Pagos</h1>
            <button className="btn btn-primary" onClick={handleGenerarPagos}>Generar Pagos</button>
        </div>
    );
};

export default GenerarPagosComponent;
