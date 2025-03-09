import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { Row, Col, Card, Typography, Button, Divider, Image, InputNumber, message } from "antd";
import { ShoppingCartOutlined, HeartOutlined } from "@ant-design/icons";
import { useDispatch, useSelector } from "react-redux";
import { DispatchType, RootState } from "../../redux/store";
import { getProductByIdApi } from "../../redux/reducers/ProductReducer";
const { Title, Text, Paragraph } = Typography;

const DetailPage = () => {
  const { id } = useParams();
  const dispatch: DispatchType = useDispatch();
  const [quantity, setQuantity] = useState(1);
  const { productDetail } = useSelector((state: RootState) => state.productReducer);

  useEffect(() => {
    dispatch(getProductByIdApi(Number(id)));
  }, [])

  const handleAddToCart = () => {
    if (!productDetail) return;

    const cart = JSON.parse(localStorage.getItem("cart") || "[]");

    const existingProductIndex = cart.findIndex((item: any) => item.productId === productDetail.productId);
    if (existingProductIndex !== -1) {
      cart[existingProductIndex].quantity += quantity;
    } else {
      cart.push({
        productId: productDetail.productId,
        productName: productDetail.productName,
        productImage: productDetail.productImage,
        productSaleprice: productDetail.productSaleprice,
        quantity: quantity,
      });
    }

    localStorage.setItem("cart", JSON.stringify(cart));
    message.success("Sản phẩm đã được thêm vào giỏ hàng!");
  };


  return (
    <div className="product-detail">
      <Row gutter={[32, 32]} align="middle">
        {/* Hình ảnh sản phẩm */}
        <Col xs={24} md={12}>
          <Image.PreviewGroup>
            <Image className="product-image" src={productDetail?.productImage} alt="Watch" />
          </Image.PreviewGroup>
        </Col>

        {/* Thông tin sản phẩm */}
        <Col xs={24} md={12}>
          <Card className="product-item">
            <Title level={3}>{productDetail?.productName}</Title>
            <Text type="secondary">Mã sản phẩm: {productDetail?.productId}</Text>
            <Divider />
            <Title level={4} className="price">{productDetail?.productSaleprice}</Title>
            <Paragraph>
              <span dangerouslySetInnerHTML={{ __html: productDetail?.productDescription ?? "" }} />
            </Paragraph>
            <Divider />

            {/* Thêm phần chọn số lượng */}
            <div className="quantity">
              <Text strong>Số lượng: </Text>
              <InputNumber
                min={1}
                max={10} // Giới hạn tối đa
                defaultValue={1}
                onChange={(value) => setQuantity(value ?? 1)}
                style={{ marginLeft: 10 }}
              />
            </div>
            <Divider />

            <div className="action-buttons">
              <Button
                type="primary"
                icon={<ShoppingCartOutlined />}
                size="large"
                onClick={handleAddToCart}
              >
                Thêm vào giỏ hàng ({quantity})
              </Button>
              <Button
                icon={<HeartOutlined />}
                size="large"
              >
                Yêu thích
              </Button>
            </div>
          </Card>
        </Col>
      </Row>
    </div>
  );
};

export default DetailPage;