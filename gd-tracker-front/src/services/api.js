import axios from 'axios';

const API = axios.create({baseURL: '/api'});

export const demonService = {
    getAll: () => API.get('/demons'),
    create: (data) => API.post('/demons', data),
    delete: (id) => API.delete(`/demons/${id}`)
};