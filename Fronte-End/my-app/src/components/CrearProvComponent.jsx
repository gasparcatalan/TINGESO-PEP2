import React, { Component } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import ProveedorService from "../services/ProveedorService";
import NavBar from "./navbar";
import axios from "axios";

class CrearProvComponent extends Component{

    constructor(props) {
        super(props);
        this.state = {
            codigo: "",
            nombre: "",
            categoria: "",
            retencion: ""
        }
        this.changeCodigoHandler = this.changeCodigoHandler.bind(this);
        this.changeNombreHandler = this.changeNombreHandler.bind(this);
        this.changeCategoriaHandler = this.changeCategoriaHandler.bind(this);
        this.changeRetencionHandler = this.changeRetencionHandler.bind(this);
    }

    changeCodigoHandler = (event) => {
        this.setState({codigo: event.target.value});
    }

    changeNombreHandler = (event) => {
        this.setState({nombre: event.target.value});
    }

    changeCategoriaHandler = (event) => {
        this.setState({categoria: event.target.value});
    }

    changeRetencionHandler = (event) => {
        this.setState({retencion: event.target.value});
    }

    guardarProveedor = (e) => {
        e.preventDefault();
        let proveedor = {
            codigo: this.state.codigo,
            nombre: this.state.nombre,
            categoria: this.state.categoria,
            retencion: this.state.retencion};
        
        ProveedorService.crearProveedor(proveedor).then(res =>{
            window.location.href = "/listar-proveedores";
        })
    }

    render() {
        return (
          <div>

            <h1>Crear Proveedor</h1>
            <div className="container">
              <form onSubmit={this.guardarProveedor}>
                <div className="mb-3">
                  <label htmlFor="codigo" className="form-label">Código</label>
                  <input type="text" className="form-control" id="codigo" value={this.state.codigo} onChange={this.changeCodigoHandler} />
                </div>
                <div className="mb-3">
                  <label htmlFor="nombre" className="form-label">Nombre</label>
                  <input type="text" className="form-control" id="nombre" value={this.state.nombre} onChange={this.changeNombreHandler} />
                </div>
                <div className="mb-3">
                  <label htmlFor="categoria" className="form-label">Categoría</label>
                  <select className="form-control" id="categoria" value={this.state.categoria} onChange={this.changeCategoriaHandler}>
                    <option value="">Seleccione una categoría</option>
                    <option value="A">A</option>
                    <option value="B">B</option>
                    <option value="C">C</option>
                    <option value="D">D</option>
                  </select>
                </div>
                <div className="mb-3">
                  <label htmlFor="retencion" className="form-label">Retención</label>
                  <select className="form-control" id="retencion" value={this.state.retencion} onChange={this.changeRetencionHandler}>
                    <option value="">Seleccione una opción</option>
                    <option value="Si">Sí</option>
                    <option value="No">No</option>
                  </select>
                </div>
                <button className="btn2" onClick={this.guardarProveedor}>Guardar</button>
              </form>
            </div>
          </div>
        );
      }



}

export default CrearProvComponent;
