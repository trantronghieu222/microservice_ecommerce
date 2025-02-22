import { Outlet } from 'react-router-dom'
import AdminHeader from '../components/AdminHeader/AdminHeader'
import AdminSidebar from '../components/Sidebar/AdminSidebar'

const AdminLayout = () => {
  return (
    <div className="layout-admin">
            <AdminSidebar></AdminSidebar>
            <div id="main">
                <AdminHeader></AdminHeader>
                <Outlet></Outlet>
            </div>
        </div>
  )
}

export default AdminLayout