import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import GenerarPagos from './components/GenerarPagosComponent';
import CrearProv from './components/CrearProvComponent';
import ListProv from './components/ListProvComponent';
import SubirAcopComponent from './components/SubirAcopComponent';
import DetallePago from './components/DetallePagoComponent';
import VerPagos from './components/VerPagosComponent';
import NavBar from './components/navbar';

import './App.css';
import { BrowserRouter, Route, Routes } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <NavBar />

     <BrowserRouter>
     <Routes>
        <Route path="/" element={<h1>Home</h1>} />
        <Route path="/listar-proveedores" element={<ListProv />} />
        <Route path="/crear-proveedor" element={<CrearProv />} />
        <Route path="/generar-pagos" element={<GenerarPagos />} />
        <Route path="/subir-acopio" element={<SubirAcopComponent />} />
        <Route path="/pagos-proveedor/:codigo"element={<VerPagos />} />
        <Route  path="/detalle-pago/:idPago"element={<DetallePago/>} />
      </Routes>

     </BrowserRouter>
    </div>
  );
}

export default App;
