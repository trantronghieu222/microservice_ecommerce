import AdminSidebar from "@/components/Sidebar/AdminSidebar";
import styles from "../../assets/sass/components/Sidebar.module.scss"
import AdminHeader from "@/components/AdminHeader/AdminHeader";

export default function RootLayout({ children }: { children: React.ReactNode }) {
    return (
        <div className="layout-admin">
            <AdminSidebar></AdminSidebar>
            <div id={styles.main}>
                <AdminHeader></AdminHeader>
                {children}
            </div>
        </div>
    );
}
