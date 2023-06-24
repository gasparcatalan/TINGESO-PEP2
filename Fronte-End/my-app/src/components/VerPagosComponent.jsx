import React, { useEffect, useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import PagoService from "../services/PagoService";
import NavBar from "./navbar";
import { Table } from "react-bootstrap";
import { Link, useParams } from "react-router-dom";

function VerPagosComponent() {
    const [pagos, setPagos] = useState([]);
    const { codigo } = useParams();

    useEffect(() => {
        PagoService.obtenerPagos(codigo).then((res) => {
            setPagos(res.data);
        });
    }, [codigo]);

    return (
        <div>
            <h1>Lista de Proveedores</h1>
        {pagos && pagos.length > 0 ? (
          <Table striped bordered hover>
            <thead>
              <tr>
                <th>Nombre Proveedor</th>
                <th>Monto Total</th>
                <th>Fecha</th>
                <th>Detalle</th>
              </tr>
            </thead>
            <tbody>
              {pagos.map((pago) => (
                <tr key={pago.nombreProveedor}>
                  <td>{pago.nombreProveedor}</td>
                  <td>{pago.montoFinal}</td>
                  <td>{pago.fecha}</td>
                  <td><Link to={`/detalle-pago/${pago.idPago}`} className="btn btn-primary">Ver Detalle</Link></td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          <p>No hay pagos disponibles.</p>
        )}
        </div>
    );
}

export default VerPagosComponent;
