import React, { Component } from "react";
import { Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import ProveedorService from "../services/ProveedorService";
import NavBar from "./navbar";
import { Table } from "react-bootstrap";



class ListProvComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
            proveedores: []
        }
    }

    componentDidMount(){
        ProveedorService.obtenerProveedores().then((res) => {
            this.setState({ proveedores: res.data});
        });
    }

    render() {
        const { proveedores } = this.state;
    
        return (
          <div>
            <h1>Lista de Proveedores</h1>
            {proveedores.length > 0 ? (
              <Table striped bordered hover>
                <thead>
                  <tr>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Categoría</th>
                    <th>Retención</th>
                  </tr>
                </thead>
                <tbody>
                  {proveedores.map((proveedor) => (
                    <tr key={proveedor.codigo}>
                      <td>{proveedor.codigo}</td>
                      <td>{proveedor.nombre}</td>
                      <td>{proveedor.categoria}</td>
                      <td>{proveedor.retencion}</td>
                      <td><Link to={`/pagos-proveedor/${proveedor.codigo}`} className="btn btn-primary">Ir a pagos</Link></td>
                    </tr>
                  ))}
                </tbody>
              </Table>
            ) : (
              <p>No hay proveedores disponibles.</p>
            )}
          </div>
        );
      }
    }

export default ListProvComponent;