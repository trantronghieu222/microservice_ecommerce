import { createSlice, PayloadAction } from '@reduxjs/toolkit'
import { LoginModelType } from '../../models/LoginModelType';
import { DispatchType } from '../store';
import { setDataTextStorage } from '../../util/utilMethod';
import { RegisterModelType } from '../../models/RegisterModelType';
import { api } from '../../util/setting';
import axios from 'axios';

export interface AuthStateType {
    userLogin: LoginModelType | null,
    userRegis: RegisterModelType | null,
}

const initialState: AuthStateType = {
    userLogin: null,
    userRegis: null,
}

const AuthReducer = createSlice({
    name: "AuthReducer",
    initialState,
    reducers: {
        setLoginAction(state: AuthStateType, action: PayloadAction<LoginModelType>) {
            state.userLogin = action.payload;
        },

        setRegisterAction(state: AuthStateType, action: PayloadAction<RegisterModelType>) {
            state.userRegis = action.payload;
        }
    }
});

export const { setLoginAction, setRegisterAction } = AuthReducer.actions

export default AuthReducer.reducer

/* -------------------------------------------------------------------------------------------------------- */
export const loginActionApi = (login: LoginModelType) => {
    return async (dispatch: DispatchType) => {
        try {
            const res = await api.post("http://localhost:8080/auth-service/auth/login", login);
            // const action: PayloadAction<LoginModelType> = setLoginAction(res.data.content)
            // dispatch(action);
            setDataTextStorage("accessToken", res.data.content.accessToken);
            return res.data;
        } catch (error) {
            console.log(error);
        }
    }
}

export const registerActionApi = (register: RegisterModelType) => {
    return async (dispatch: DispatchType) => {
        try {
            const res = await api.post("http://localhost:8080/auth-service/auth/register", register);
            const action: PayloadAction<RegisterModelType> = setRegisterAction(res.data.content);
            dispatch(action);
        } catch (error) {
            console.log(error);
        }
    }
}