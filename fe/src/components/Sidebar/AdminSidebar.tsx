import { NavLink, useNavigate } from "react-router-dom";
import { getDataTextStorage } from "../../util/utilMethod";
import { useEffect, useState } from "react";

const AdminSidebar = () => {
  const navigate = useNavigate();
  const [isAuthorized, setIsAuthorized] = useState<boolean>(false);
  // Check auth
  useEffect(() => {
    const token = getDataTextStorage("accessToken");
    if (!token) {
      navigate("/unauthorized");
      return;
    }
    try {
      const payload = JSON.parse(atob(token.split(".")[1]));
      const roles = payload.roles || [];

      if (roles.includes("ADMIN")) {
        setIsAuthorized(true);
      } else {
        navigate("/unauthorized");
      }
    } catch (err) {
      console.error("Lỗi giải mã token:", err);
      navigate("/unauthorized");
    }
  }, [navigate]);

  // Không render gì khi chưa check xong
  if (!isAuthorized) return null;

  const toggleNav = () => {
    const sidebar = document.getElementById("mySidebar");
    if (sidebar) {
      sidebar.classList.toggle("closed");
      if (window.innerWidth <= 768) {
        sidebar.classList.toggle("open");
      }
    }
  };

  return (
    <div id="mySidebar" className="sidebar">
      <div className="sidebarHeader">
        <h3>
          {/* <img className="w-75" src="/image/logo.png" alt="Logo Red" /> */}
          Time Zone
        </h3>
        <button className="toggleBtn" type="button" onClick={toggleNav}>
          <i className="fas fa-bars" />
        </button>
      </div>
      <NavLink to="/admin/Dashboard" className={({isActive}) => isActive ? "bg-dark text-light" : ""}>
        <i className="fa fa-tachometer-alt"></i> <span>Dashboard</span>
      </NavLink>
      <NavLink to="/admin/ProductManagement" className={({isActive}) => isActive ? "bg-dark text-light" : ""}>
        <i className="fa fa-tags"></i> <span>Product Management</span>
      </NavLink>
      <NavLink to="/admin/OrdersManagement" className={({isActive}) => isActive ? "bg-dark text-light" : ""}>
        <i className="fa fa-file-invoice-dollar"></i> <span>Orders Management</span>
      </NavLink>
      <NavLink to="/admin/AccountManagement" className={({isActive}) => isActive ? "bg-dark text-light" : ""}>
        <i className="fa fa-user"></i> <span>Account Management</span>
      </NavLink>
      <NavLink to="/admin/CustomerManagement" className={({isActive}) => isActive ? "bg-dark text-light" : ""}>
        <i className="fa fa-users"></i> <span>Customer Management</span>
      </NavLink>
      <NavLink to="/admin/EmployeeManagement" className={({isActive}) => isActive ? "bg-dark text-light" : ""}>
        <i className="fa fa-running"></i> <span>Employee Management</span>
      </NavLink>
      <NavLink to="/admin/ProfileManagement" className={({isActive}) => isActive ? "bg-dark text-light" : ""}>
        <i className="fa fa-user-tie"></i> <span>Profile Management</span>
      </NavLink>
    </div>
  );
};

export default AdminSidebar;