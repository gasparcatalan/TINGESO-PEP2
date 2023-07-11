import axios from 'axios';

const API_URL = 'http://localhost:53545/pago';


class PagoService {

    obtenerPagos(codigo) {
        return axios.get(API_URL + "/" + codigo);
    }

    obtenerPago(idPago) {
        return axios.get(API_URL + "/pago/" + idPago);
    }

    crearPago() {
        return axios.post(API_URL + "/crearpagos");
    }

}

export default new PagoService();