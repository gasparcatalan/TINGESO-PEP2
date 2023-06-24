import axios from 'axios';

const API_URL = 'http://localhost:8080/laboratorio';

class LaboratorioService {

    obtenerLaboratorios() {
        return axios.get(API_URL);
    }

    subirArchivo(archivo) {
        let formData = new FormData();
        formData.append("lab", archivo);
        return axios.post(API_URL + "/subir", formData, {
            headers: {
                "Content-Type": "multipart/form-data"
            }
        });
      }

}

export default new LaboratorioService();