import AdminSidebar from "@/components/Sidebar/AdminSidebar";

export default function RootLayout({ children }: { children: React.ReactNode }) {
    return (
        <div className="container-fluid">
            <div className="row flex-nowrap">
                <AdminSidebar></AdminSidebar>
                <div className="col py-3">
                    {children}
                </div>
            </div>
        </div>
    );
}
