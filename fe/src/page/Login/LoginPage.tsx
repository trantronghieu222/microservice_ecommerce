import { Button, Checkbox, Form, Input } from 'antd'
import { LockOutlined, UserOutlined } from '@ant-design/icons';
import React from 'react'
import { NavLink } from 'react-router-dom'

type Props = {}

const LoginPage = (props: Props) => {
    return (
        <Form
            className="loginForm"
            name="login-form"
            initialValues={{ remember: true }}
            // onFinish={onFinish}
        >
            <p className="formTitle">ĐĂNG NHẬP</p>
            <Form.Item
                name="taiKhoan"
                rules={[{ required: true, message: 'Không được để trống tài khoản!' }]}
            >
                <Input prefix={<UserOutlined className="site-form-item-icon" />} className="antInput" placeholder="Tài khoản" />
            </Form.Item>

            <Form.Item
                name="matKhau"
                rules={[
                    { required: true, message: 'Không được để trống mật khẩu!' },
                ]}
            >
                <Input.Password prefix={<LockOutlined className="site-form-item-icon" />} className="antInput" placeholder="Mật khẩu" />
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