import { configureStore } from "@reduxjs/toolkit";
import orderReducer from "./reducers/OrderReducer";
import accountReducer from "./reducers/AccountReducer";
import productReducer from "./reducers/ProductReducer";

export const store = configureStore({
    reducer:{
        orderReducer,
        accountReducer,
        productReducer,
    }
})

export type RootState = ReturnType<typeof store.getState>
export type DispatchType = typeof store.dispatch
export type GetStateMethodType = typeof store.getState