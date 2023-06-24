import React, { Component } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import AcopioService from "../services/AcopioService";
import LaboratorioService from "../services/LaboratorioService";


class SubirAcopComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      selectedFile: null,
      selectedFileResults: null
    };
    this.fileInputRef = React.createRef();
    this.fileInputResultsRef = React.createRef();
    this.handleFileChange = this.handleFileChange.bind(this);
    this.handleFileResultsChange = this.handleFileResultsChange.bind(this);
    this.handleFormSubmit = this.handleFormSubmit.bind(this);
  }

  handleFileChange(event) {
    this.setState({ selectedFile: event.target.files[0] });
  }

  handleFileResultsChange(event) {
    this.setState({ selectedFileResults: event.target.files[0] });
  }

  handleFormSubmit(event) {
    event.preventDefault();
    const { selectedFile, selectedFileResults } = this.state;

    // Subir archivo de acopios
    AcopioService.cargarAcopios(selectedFile)
      .then(res => {
        // Mensaje de éxito sin salir de la página que está en un cuadro de alerta
        alert("Acopios cargados con éxito");
      })
      .catch(error => {
        //Mensaje de alerta de error
        alert("Error al cargar los acopios");
      });

    // Subir archivo de resultados
    LaboratorioService.subirArchivo(selectedFileResults)
      .then(res => {
        // Mensaje de éxito sin salir de la página que está en un cuadro de alerta
        alert("Archivo de resultados cargado con éxito");
      })
      .catch(error => {
        //Mensaje de alerta de error
        alert("Error al cargar el archivo de resultados");
      });
  }

  render() {
    return (
      <div>
        <h1>Subir Acopios y Resultados</h1>
        <div className="container">
          <form onSubmit={this.handleFormSubmit}>
            <div className="mb-3">
              <label htmlFor="fileInput" className="form-label">Seleccionar archivo de acopios</label>
              <input type="file" className="form-control" id="fileInput" onChange={this.handleFileChange} ref={this.fileInputRef} />
            </div>
            <div className="mb-3">
              <label htmlFor="fileInputResults" className="form-label">Seleccionar archivo de resultados</label>
              <input type="file" className="form-control" id="fileInputResults" onChange={this.handleFileResultsChange} ref={this.fileInputResultsRef} />
            </div>
            <button type="submit" className="btn btn-primary">Subir</button>
          </form>
        </div>
      </div>
    );
  }
}

export default SubirAcopComponent;
