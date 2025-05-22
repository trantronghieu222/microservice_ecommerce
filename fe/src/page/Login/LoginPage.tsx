import { Button, Checkbox, Form, Input, message } from 'antd'
import { LockOutlined, UserOutlined } from '@ant-design/icons';
import React from 'react'
import { NavLink } from 'react-router-dom'
import { LoginModelType } from '../../models/LoginModelType';
import { DispatchType } from '../../redux/store';
import { useDispatch } from 'react-redux';
import { loginActionApi } from '../../redux/reducers/AuthReducer';
import { useNavigate } from 'react-router-dom';
type Props = {}

const LoginPage = (props: Props) => {
    const dispatch: DispatchType = useDispatch();
    const navigate = useNavigate();
    const onFinish = async (values: LoginModelType) => {
        try {
            const initialValues = {
                ...values
            }
            // console.log(initialValues)
            const reslogin = await dispatch(loginActionApi(initialValues));
            message.success(reslogin.message);
            navigate("/");
        } catch (error) {
            message.error("Lỗi");
        }
    }

    return (
        <Form
            className="loginForm"
            name="login-form"
            initialValues={{ remember: true }}
            onFinish={onFinish}
        >
            <p className="formTitle">ĐĂNG NHẬP</p>
            <Form.Item
                name="username"
                rules={[{ required: true, message: 'Không được để trống tài khoản!' }]}
            >
                <Input prefix={<UserOutlined className="site-form-item-icon" />} className="antInput" placeholder="Username" />
            </Form.Item>

            <Form.Item
                name="password"
                rules={[
                    { required: true, message: 'Không được để trống mật khẩu!' },
                ]}
            >
                <Input.Password prefix={<LockOutlined className="site-form-item-icon" />} className="antInput" placeholder="Password" />
            </Form.Item>

            <Form.Item>
                <div className="rememberForgot">
                    <Checkbox>Ghi nhớ tài khoản</Checkbox>
                    <NavLink className="loginRegis" to="">
                        Quên mật khẩu
                    </NavLink>
                </div>
            </Form.Item>

            <Form.Item>
                <Button type="primary" htmlType="submit" id="login-button" className="loginFormButton antBtn">
                    ĐĂNG NHẬP
                </Button>
            </Form.Item>
            Bạn không có tài khoản? <NavLink to="/auth/register" className="loginRegis">đăng ký ngay!</NavLink>
            {/* <div className={`${styles.loginSocial}`}>
            <span className='text-center'>Đăng nhập với </span>
            <a href='#'><i className={`fab fa-facebook ${styles.facebook}`}></i></a>
            <a href='#'><i className={`fab fa-twitter ${styles.twitter}`}></i></a>
            <a href='#'><i className={`fab fa-google-plus-g ${styles.google}`}></i></a>
          </div> */}
        </Form>
    )
}

export default LoginPage