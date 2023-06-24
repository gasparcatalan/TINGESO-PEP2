import axios from 'axios';

const API_URL = 'http://localhost:8080/proveedores';

class ProveedorService {


    obtenerProveedores() {
        return axios.get(API_URL);
    }


    crearProveedor(proveedor) {
        return axios.post(API_URL, proveedor);
    }
        

}

export default new ProveedorService();