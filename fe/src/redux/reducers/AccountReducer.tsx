import { createSlice, PayloadAction } from '@reduxjs/toolkit'
import { AccountModelType } from '../../models/AccountModelType';
import { DispatchType } from '../store';
import axios from 'axios';

export interface AccountStateType {
    arrAccount: AccountModelType[];
}

const initialState: AccountStateType = {
    arrAccount: [],
}

const AccountReducer = createSlice({
    name: "AccountReducer",
    initialState,
    reducers: {
        setArrAccountAction: (state: AccountStateType, action: PayloadAction<AccountModelType[]>) => {
            state.arrAccount = action.payload;
        }
    }
});

export const { setArrAccountAction } = AccountReducer.actions

export default AccountReducer.reducer

/* -------------------------------------------------------------------------------------------------------- */
export const getAllAccountApi = () => {
    return async (dispatch: DispatchType) => {
        const res = await axios.get("http://localhost:8080/account-service/account");
        const action: PayloadAction<AccountModelType[]> = setArrAccountAction(res.data.content);
        dispatch(action);
    }
}

export const addAccountApi = (account: AccountModelType) => {
    return async(dispatch: DispatchType) => {
        const res = await axios.post("http://localhost:8080/account-service/account", account);
        return res.data;
    }
}