import { Footer } from "antd/es/layout/layout"
import HeaderHome from "../components/Header/HeaderHome"
import { Outlet } from "react-router-dom"
import FooterHome from "../components/Footer/FooterHome"

const HomeLayout = () => {
  return (
    <div>
        <HeaderHome></HeaderHome>
        <div className="home-layout">
            <Outlet></Outlet>
        </div>
        <FooterHome></FooterHome>
    </div>
  )
}

export default HomeLayout