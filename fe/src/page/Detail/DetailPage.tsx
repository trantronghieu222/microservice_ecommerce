import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { Row, Col, Card, Typography, Button, Divider, Image, InputNumber } from "antd";
import { ShoppingCartOutlined, HeartOutlined } from "@ant-design/icons";
import { products, Product } from "../../util/ProductJson";
const { Title, Text, Paragraph } = Typography;

const DetailPage = () => {
  const {id} = useParams();
  const [prodDetail, setProdDetail] = useState<Product | undefined>();
  const [quantity, setQuantity] = useState(1); // State để lưu số lượng sản phẩm

  useEffect(() => {
    const foundProduct = products.find((prod) => prod.id === Number(id));
    setProdDetail(foundProduct);
  }, [id]);
  
  return (
    <div className="product-detail">
      <Row gutter={[32, 32]} align="middle">
        {/* Hình ảnh sản phẩm */}
        <Col xs={24} md={12}>
          <Image.PreviewGroup>
            <Image className="product-image" src={prodDetail?.image} alt="Watch" />
          </Image.PreviewGroup>
        </Col>

        {/* Thông tin sản phẩm */}
        <Col xs={24} md={12}>
          <Card className="product-item">
            <Title level={3}>{prodDetail?.name}</Title>
            <Text type="secondary">Mã sản phẩm: {prodDetail?.id}</Text>
            <Divider />
            <Title level={4} className="price">{prodDetail?.price}</Title>
            <Paragraph>
              {prodDetail?.description}
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
              <Button type="primary" icon={<ShoppingCartOutlined />} size="large">
                Thêm vào giỏ hàng ({quantity})
              </Button>
              <Button icon={<HeartOutlined />} size="large">
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