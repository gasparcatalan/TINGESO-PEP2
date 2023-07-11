import axios from 'axios';


const API_URL = 'http://localhost:53545/acopios';

class AcopioService {


    cargarAcopios(archivo) {
        let formData = new FormData();
        formData.append("nombre", archivo);
        return axios.post(API_URL, formData, {
            headers: {
                "Content-Type": "multipart/form-data"
            }
        });
      }

    obtenerAcopios() {
        return axios.get(API_URL);
    }
}
export default new AcopioService();