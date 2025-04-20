import React from "react";
import { useNavigate } from "react-router-dom";

const NotFound: React.FC = () => {
  const navigate = useNavigate();

  const handleBackHome = () => {
    navigate("/");
  };

  return (
    <div className="d-flex flex-column justify-content-center align-items-center vh-100 bg-light text-center px-3">
      <h1 className="display-1 text-danger fw-bold mb-3">404</h1>
      <h2 className="mb-2">Oops! Trang không tồn tại</h2>
      <p className="text-muted mb-4">
        Có thể bạn đã nhập sai địa chỉ hoặc trang đã bị xóa.
      </p>
      <button
        onClick={handleBackHome}
        className="btn btn-primary btn-lg px-4"
      >
        Quay về trang chủ
      </button>
    </div>
  );
};

export default NotFound;