import { unstable_HistoryRouter as HistoryRouter, Routes, Route } from 'react-router-dom'
import { createBrowserHistory } from 'history'
import { Provider } from 'react-redux'
import AdminLayout from './layout/AdminLayout'
import ProductManagement from './admin/ProductManagement/ProductManagement'
import ReceivedManagement from './admin/ReceivedManagement/ReceivedManagement'
import OrdersManagement from './admin/OrdersManagement/OrdersManagement'
import Dashboard from './admin/Dashboard/Dashboard'
import AccountManagement from './admin/AccountManagement/AccountManagement'
import SupplierManagement from './admin/SupplierManagement/SupplierManagement'
export const routeLink: any = createBrowserHistory()
import { store } from './redux/store'
import CustomerManagement from './admin/CustomerManagement/CustomerManagement'
import EmployeeManagement from './admin/EmployeeManagement/EmployeeManagement'
import HomeLayout from './layout/HomeLayout'
import HomePage from './page/Home/HomePage'
import AdminProfile from './admin/AdminProfile/AdminProfile'
import ProductPage from './page/Product/ProductPage'
import AboutPage from './page/About/AboutPage'
import CartPage from './page/Cart/CartPage'
import ProfilePage from './page/Profile/ProfilePage'
import ContactPage from './page/Contact/ContactPage'
import LoginPage from './page/Login/LoginPage'
import LoginLayout from './layout/LoginLayout'
import RegisterPage from './page/Register/RegisterPage'
import DetailPage from './page/Detail/DetailPage'
import OrderPage from './page/Order/OrderPage'
import CheckoutPage from './page/Checkout/CheckoutPage'

function App() {
  return (
    <>
      <Provider store={store}>
        <HistoryRouter history={routeLink}>
          <Routes>
            {/* Home template */}
            <Route path='' element={<HomeLayout></HomeLayout>} >
              <Route index element={<HomePage></HomePage>}></Route>
              <Route path='home' element={<HomePage></HomePage>}></Route>
              <Route path='product' element={<ProductPage></ProductPage>}></Route>
              <Route path='about' element={<AboutPage></AboutPage>}></Route>
              <Route path='cart' element={<CartPage></CartPage>}></Route>
              <Route path='profile' element={<ProfilePage></ProfilePage>}></Route>
              <Route path='contact' element={<ContactPage></ContactPage>}></Route>
              <Route path='order' element={<OrderPage></OrderPage>}></Route>
              <Route path='checkout' element={<CheckoutPage></CheckoutPage>}></Route>
              <Route path='detail'>
                <Route path=':id' element={<DetailPage></DetailPage>}></Route>
              </Route>
            </Route>

            {/* Login template */}
            <Route path='auth' element={<LoginLayout></LoginLayout>}>
              <Route path='login' element={<LoginPage></LoginPage>}></Route>
              <Route path='register' element={<RegisterPage></RegisterPage>}></Route>
            </Route>

            {/* Admin template */}
            <Route path='admin' element={<AdminLayout></AdminLayout>}>
              <Route path='Dashboard' element={<Dashboard></Dashboard>}></Route>
              <Route path='AccountManagement' element={<AccountManagement></AccountManagement>}></Route>
              <Route path='CustomerManagement' element={<CustomerManagement></CustomerManagement>}></Route>
              <Route path='EmployeeManagement' element={<EmployeeManagement></EmployeeManagement>}></Route>
              <Route path='ProductManagement' element={<ProductManagement></ProductManagement>}></Route>
              <Route path='ReceivedManagement' element={<ReceivedManagement></ReceivedManagement>}></Route>
              <Route path='OrdersManagement' element={<OrdersManagement></OrdersManagement>}></Route>
              <Route path='SupplierManagement' element={<SupplierManagement></SupplierManagement>}></Route>
              <Route path='ProfileManagement' element={<AdminProfile></AdminProfile>}></Route>
            </Route>
          </Routes>
        </HistoryRouter>
      </Provider>
    </>
  )
}

export default App
