import { configureStore } from "@reduxjs/toolkit";
import orderReducer from "./reducers/OrderReducer";
import accountReducer from "./reducers/AccountReducer";
import productReducer from "./reducers/ProductReducer";
import cartReducer from "./reducers/CartReducer";

export const store = configureStore({
    reducer:{
        orderReducer,
        accountReducer,
        productReducer,
        cartReducer
    }
})

export type RootState = ReturnType<typeof store.getState>
export type DispatchType = typeof store.dispatch
export type GetStateMethodType = typeof store.getState