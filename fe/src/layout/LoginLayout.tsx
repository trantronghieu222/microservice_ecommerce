import { Outlet } from "react-router-dom"

const LoginLayout = () => {
  return (
    <div className="loginPage">
      <div className="loginBox">
        <div className="illustrationWrapper">
          <img
            src="/image/bg-contact.jpg"
            alt="Login"
          />
        </div>
        <Outlet></Outlet>
      </div>
    </div >
  )
}

export default LoginLayout