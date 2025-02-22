import React from 'react'
import { NavLink } from 'react-router-dom'

type Props = {}

const HeaderHome = (props: Props) => {
    return (
        <div className='header-home'>
            <nav className="navbar navbar-expand-lg">
                <div className="container-fluid">
                    <NavLink className="navbar-brand px-5" to="#">Time Zone</NavLink>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon" />
                    </button>
                    <div className="collapse navbar-collapse navbar-custom" id="navbarSupportedContent">
                        <ul className="navbar-nav m-auto mb-2 mb-lg-0">
                            <li className="nav-item px-2">
                                <NavLink className={({ isActive }) => isActive ? "nav-link active-header" : "nav-link"} to="home">Home</NavLink>
                            </li>
                            <li className="nav-item px-2">
                                <NavLink className={({ isActive }) => isActive ? "nav-link active-header" : "nav-link"} to="product">Shop</NavLink>
                            </li>
                            <li className="nav-item px-2">
                                <NavLink className={({ isActive }) => isActive ? "nav-link active-header" : "nav-link"} to="about">About</NavLink>
                            </li>
                            <li className="nav-item px-2">
                                <NavLink className={({ isActive }) => isActive ? "nav-link active-header" : "nav-link"} to="contact">Contact</NavLink>
                            </li>
                            <li className="nav-item px-2">
                                <NavLink className={({ isActive }) => isActive ? "nav-link active-header" : "nav-link"} to="order">Order</NavLink>
                            </li>
                            <li className="nav-item px-2">
                                <NavLink className={({ isActive }) => isActive ? "nav-link active-header" : "nav-link"} to="auth/login">Login</NavLink>
                            </li>
                        </ul>

                        <div className="header-actions d-flex align-items-center">
                            {/* Ô tìm kiếm */}
                            <form className="search-form d-flex mx-2">
                                <div className="input-group rounded">
                                    <input
                                        type="text"
                                        className="form-control rounded-pill"
                                        placeholder="Tìm kiếm..."
                                        aria-label="Search"
                                    />
                                    <button className="btn border-0 position-absolute end-0 me-2" type="submit">
                                        <i className="fa fa-search"></i>
                                    </button>
                                </div>
                            </form>

                            {/* Nút Profile */}
                            <NavLink to={"profile"} className={({ isActive }) => isActive ? "profile-btn mx-2 active-header" : "profile-btn mx-2"}>
                                <i className="fa fa-user"></i>
                            </NavLink>

                            {/* Nút Giỏ hàng */}
                            <NavLink to={"cart"} className={({ isActive }) => isActive ? "cart-btn mx-2 active-header" : "cart-btn mx-2"}>
                                <i className="fa fa-cart-plus"></i>
                            </NavLink>
                        </div>

                    </div>
                </div>
            </nav>
        </div>
    )
}

export default HeaderHome