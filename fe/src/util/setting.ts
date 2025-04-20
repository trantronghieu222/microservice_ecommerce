import axios, { AxiosError, AxiosResponse, InternalAxiosRequestConfig } from "axios";
import { getDataTextStorage } from "./utilMethod";

export const AccessToken: string = 'accessToken';

export const DOMAIN: string = 'http://localhost:8080';

export const api = axios.create({
    baseURL: DOMAIN,
    timeout: 30000
})

api.interceptors.request.use(
    (req: InternalAxiosRequestConfig<any>) => {
        let token = getDataTextStorage(AccessToken);
        if (token) {
            token = token.replace(/^"(.*)"$/, '$1');
        }
        if (req.headers) {
            req.headers['Authorization'] = token ? `Bearer ${token}` : '';
        }
        return req;
    }, (err: AxiosError) => {
        return Promise.reject(err);
    })

api.interceptors.response.use(
    (response: AxiosResponse<any>) => {
        return response
    },
    (error: AxiosError) => {
        return Promise.reject(error);
    }
)