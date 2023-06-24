import React from 'react';
import './navbarStyle.css';

function navbar() {
    return (
      <div>
        <header className="header">
            <div className="logo">
                <a href="/"><h1>MilkStgo</h1></a>
            </div> 
            <a class="btn" href="/"><button>Volver al menú principal</button></a>
            <a class="btn" href="/subir-acopio"><button>Subir archivos</button></a>
            <a class="btn" href="/crear-proveedor"><button>Ingresar nuevo Proveedor</button></a>
            <a class="btn" href="/listar-proveedores"><button>Ver proveedores</button></a>
            <a class="btn" href="/generar-pagos"><button>Generar pagos</button></a>
        </header>
      </div>
    );
  }
  export default navbar;
