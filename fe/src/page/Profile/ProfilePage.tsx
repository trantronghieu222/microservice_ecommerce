import { Card, Input, Button, Form, message } from "antd";
import { getDataTextStorage, getIdFromToken } from "../../util/utilMethod";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { DispatchType, RootState } from "../../redux/store";
import { getAccountByIdApi } from "../../redux/reducers/AccountReducer";
import { useForm } from "antd/es/form/Form";

const ProfilePage = () => {
  const [ frmProfile ] = Form.useForm()
  const dispatch: DispatchType = useDispatch();
  const [accessToken, setAccessToken] = useState<string | null>(null);
  const { accountDetail } = useSelector((state: RootState) => state.accountReducer);
  const navigate = useNavigate();

  useEffect(() => {
    const token = getDataTextStorage("accessToken");
    if (!token) {
      message.error("Vui lòng đăng nhập để truy cập!");
      navigate("/home");
    } else {
      setAccessToken(token);
    }
  }, [navigate]);

  useEffect(() => {
    if (accessToken) {
      const userId = getIdFromToken(accessToken);
      if (userId) {
        dispatch(getAccountByIdApi(Number(userId)));
      }
    }
  }, [accessToken, dispatch]);

  useEffect(() => {
    if (accountDetail && frmProfile) {
      frmProfile.setFieldsValue({
        customerName: accountDetail.customerName,
        customerEmail: accountDetail.customerEmail,
        customerPhone: accountDetail.customerPhone,
        customerAddress: accountDetail.customerAddress,
      });
    }
  }, [accountDetail]);

  return (
    <div style={{ padding: "20px", maxWidth: "600px", margin: "auto" }}>
      <Card title="Profile Information">
        <Form
          layout="vertical"
          form={frmProfile}
        >
          <Form.Item label="Full Name" name="customerName" rules={[{ required: true, message: "Please enter your full name!" }]}>
            <Input placeholder="Enter your full name" />
          </Form.Item>

          <Form.Item label="Email" name="customerEmail" rules={[{ required: true, type: "email", message: "Please enter a valid email!" }]}>
            <Input placeholder="Enter your email" />
          </Form.Item>

          <Form.Item label="Phone" name="customerPhone" rules={[{ required: true, message: "Please enter your phone number!" }]}>
            <Input placeholder="Enter your phone number" />
          </Form.Item>

          <Form.Item label="Address" name="customerAddress" rules={[{ required: true, message: "Please enter your address!" }]}>
            <Input placeholder="Enter your address" />
          </Form.Item>

          <Form.Item>
            <Button type="primary" style={{ marginRight: "10px" }}>
              Save
            </Button>
            <Button type="default">Change Password</Button>
          </Form.Item>
        </Form>
      </Card>
    </div>
  );
};

export default ProfilePage;
