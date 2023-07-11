import axios from 'axios';

const API_URL = 'http://localhost:53545/proveedores';

class ProveedorService {


    obtenerProveedores() {
        return axios.get(API_URL);
    }


    crearProveedor(proveedor) {
        return axios.post(API_URL, proveedor);
    }
        

}

export default new ProveedorService();