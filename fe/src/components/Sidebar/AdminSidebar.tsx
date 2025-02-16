"use client"
import Link from 'next/link'
import React from 'react'

type Props = {}

const AdminSidebar = (props: Props) => {

  return (
    <div className="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-dark">
      <div className="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
        <Link href="/" className="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-white text-decoration-none">
          <span className="fs-5 d-none d-sm-inline pt-2"><img src="/image/LogoRed.png" alt="..." /></span>
        </Link>
        <ul className="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
          <li className="nav-item">
            <Link href="/" className="nav-link align-middle px-0">
              <i className="fs-4 bi-house" /> <span className="ms-1 d-none d-sm-inline">Home</span>
            </Link>
          </li>
          <li>
            <a href="#submenu1" data-bs-toggle="collapse" className="nav-link px-0 align-middle">
              <i className="fs-4 bi-speedometer2" /> <span className="ms-1 d-none d-sm-inline">Dashboard</span> </a>
            <ul className="collapse show nav flex-column ms-1" id="submenu1" data-bs-parent="#menu">
              <li className="w-100">
                <a href="#" className="nav-link px-0"> <span className="d-none d-sm-inline">Item</span> 1 </a>
              </li>
              <li>
                <a href="#" className="nav-link px-0"> <span className="d-none d-sm-inline">Item</span> 2 </a>
              </li>
            </ul>
          </li>
          <li>
            <Link href="bookingManagement" className="nav-link px-0 align-middle">
              <i className="fs-4 bi-table" /> <span className="ms-1 d-none d-sm-inline">Booking</span>
            </Link>
          </li>
          <li>
            <Link href="locationManagement" className="nav-link px-0 align-middle ">
              <i className="fs-4 bi-geo-alt"></i> <span className="ms-1 d-none d-sm-inline">Location</span>
            </Link>

          </li>
          <li>
            <Link href="roomManagement" className="nav-link px-0 align-middle">
              <i className="fs-4 bi-grid" /> <span className="ms-1 d-none d-sm-inline">Room</span>
            </Link>
          </li>
          <li>
            <Link href="userManagement" className="nav-link px-0 align-middle">
              <i className="fs-4 bi-people" /> <span className="ms-1 d-none d-sm-inline">User</span>
            </Link>
          </li>
        </ul>
        <hr />
        <div className="dropdown pb-4">
          <a href="#" className="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
            {/* <img src={`${imgPath}${userProfile?.avatar}`} alt="hugenerd" width={30} height={30} className="rounded-circle" />
            <span className="d-none d-sm-inline mx-1">{userProfile?.ten_nguoi_dung}</span> */}
          </a>
          <ul className="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
            <li><a className="dropdown-item" href="#">New project...</a></li>
            <li><a className="dropdown-item" href="#">Settings</a></li>
            <li><a className="dropdown-item" href="#">Profile</a></li>
            <li>
              <hr className="dropdown-divider" />
            </li>
            <li><a className="dropdown-item" href="#">Sign out</a></li>
          </ul>
        </div>
      </div>
    </div>
  )
}

export default AdminSidebar