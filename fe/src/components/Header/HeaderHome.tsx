import { Button, message } from 'antd';
import React, { useEffect, useState } from 'react'
import { NavLink, useNavigate } from 'react-router-dom'
import { getDataJsonStorage, getDataTextStorage } from '../../util/utilMethod';
import { DispatchType, RootState } from '../../redux/store';
import { useDispatch, useSelector } from 'react-redux';
import { getAllCart } from '../../redux/reducers/CartReducer';

const getRoleFromToken = (token: string) => {
    try {
        const payload = JSON.parse(atob(token.split(".")[1])); // Giải mã phần payload của JWT
        const roles = payload.roles || []; // Lấy các vai trò từ payload
        return roles.includes("ADMIN"); // Kiểm tra xem người dùng có vai trò ADMIN hay không
    } catch (error) {
        console.error("Invalid token", error);
        return false; // Trả về false nếu không thể giải mã hoặc không có vai trò ADMIN
    }
};

type Props = {}

const HeaderHome = (props: Props) => {
    const navigate = useNavigate();
    const dispatch: DispatchType = useDispatch();
    const { arrCart } = useSelector((state: RootState) => state.cartReducer)
    const [cartNumber, setCartNumber] = useState(0)
    const [searchTerm, setSearchTerm] = useState("");
    const isLoggedIn = getDataTextStorage("accessToken");
    const isAdmin = isLoggedIn ? getRoleFromToken(isLoggedIn) : false;
    // const username = localStorage.getItem("username") || "User";

    console.log(arrCart)

    useEffect(() => {
        // Gọi hàm để lấy giỏ hàng từ localStorage và cập nhật Redux store
        dispatch(getAllCart());
    }, [dispatch]); // Lần này chỉ cần chạy 1 lần khi component mount

    useEffect(() => {
        // Cập nhật số lượng giỏ hàng mỗi khi arrCart thay đổi
        const totalQuantity = arrCart.reduce((sum: any, item: any) => sum + item.quantity, 0);
        setCartNumber(totalQuantity);
    }, [arrCart]); // Lắng nghe sự thay đổi của arrCart

    const handleLogout = () => {
        localStorage.removeItem("accessToken");
        message.success("Đăng xuất thành công!");
        navigate("/");
    }

    const handleSearch = (e: React.FormEvent) => {
        e.preventDefault();
        if (searchTerm.trim()) {
            navigate(`/product?keyword=${encodeURIComponent(searchTerm)}`);
            setSearchTerm("");
        }
    };

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
                                <NavLink className={({ isActive }) => isActive ? "nav-link active-header" : "nav-link"} to="cart">Cart ({cartNumber})</NavLink>
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
                                        value={searchTerm}
                                        onChange={(e) => setSearchTerm(e.target.value)}
                                    />
                                    <button className="btn border-0 position-absolute end-0 me-2" type="submit" onClick={handleSearch}>
                                        <i className="fa fa-search"></i>
                                    </button>
                                </div>
                            </form>

                            {/* Nút Profile */}
                            {isLoggedIn ? (
                                <div className="dropdown">
                                    <button
                                        className="btn dropdown-btn dropdown-toggle d-flex align-items-center"
                                        type="button"
                                        id="dropdownMenuButton1"
                                        data-bs-toggle="dropdown"
                                        aria-expanded="false"
                                    >
                                        <i className="fa fa-user me-1"></i>
                                    </button>
                                    <ul className="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton1">
                                        <li><NavLink className="dropdown-item" to="/profile">Profile</NavLink></li>
                                        <li><NavLink className="dropdown-item" to="/order">Orders</NavLink></li>
                                        {isAdmin ? (
                                            <li><NavLink className="dropdown-item" to="/admin/Dashboard">Admin</NavLink></li> // Nội 
                                        ) : (
                                            null 
                                        )}
                                        <li><hr className="dropdown-divider" /></li>
                                        <li><Button className="dropdown-item" onClick={handleLogout}>Logout</Button></li>
                                    </ul>

                                </div>
                            ) : (
                                <NavLink to={"auth/login"} className="login-btn mx-2">
                                    Login
                                </NavLink>
                            )}
                        </div>

                    </div>
                </div>
            </nav>
        </div>
    )
}

export default HeaderHome