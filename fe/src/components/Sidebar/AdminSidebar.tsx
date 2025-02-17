"use client";
import React from "react";
import Link from "next/link";
import styles from "@/assets/sass/components/Sidebar.module.scss";

const Sidebar: React.FC = () => {
  const toggleNav = () => {
    const sidebar = document.getElementById("mySidebar");
    if (sidebar) {
      sidebar.classList.toggle(styles.closed);
      if (window.innerWidth <= 768) {
        sidebar.classList.toggle(styles.open);
      }
    }
  };

  return (
    <div id="mySidebar" className={styles.sidebar}>
      <div className={styles.sidebarHeader}>
        <h3>
          <img className="w-75" src="/image/logo.png" alt="Logo Red" />
        </h3>
        <button className={styles.toggleBtn} type="button" onClick={toggleNav}>
          <i className="fas fa-bars" />
        </button>
      </div>
      <Link href="/admin/dashboard">
        <i className="fa fa-tachometer-alt"></i> <span>Dashboard</span>
      </Link>
      <Link href="/admin/productManagement">
        <i className="fa fa-tags"></i> <span>Product Management</span>
      </Link>
      <Link href="/admin/ordersManagement">
        <i className="fa fa-file-invoice-dollar"></i> <span>Orders Management</span>
      </Link>
      <Link href="/admin/userManagement">
        <i className="fa fa-user"></i> <span>User Management</span>
      </Link>
      <Link href="/admin/supplierManagement">
        <i className="fa fa-store"></i> <span>Supplier Management</span>
      </Link>
      <Link href="/admin/receivedManagement">
      <i className="fa fa-clipboard-list"></i> <span>Received Management</span>
      </Link>
    </div>
  );
};

export default Sidebar;