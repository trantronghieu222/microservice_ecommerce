import React, { useState } from "react";
import { Row, Col, Select, Slider, Typography } from "antd";
import ProductCard from "../../components/ProductCard/ProductCard";
import { products } from "../../util/ProductJson";
const { Title } = Typography;
const { Option } = Select;

const ProductPage = () => {
  const [priceRange, setPriceRange] = useState<[number, number]>([100, 250]);
  const [category, setCategory] = useState("all");

  const filteredProducts = products.filter(
    (product) => product.price >= priceRange[0] && product.price <= priceRange[1]
  );

  return (
    <div style={{ padding: "20px" }}>
      <Row gutter={[32, 32]}>
        {/* Bộ lọc */}
        <Col xs={24} md={6}>
          <div style={{ padding: "20px", background: "#f9f9f9", borderRadius: "10px" }}>
            <Title level={4}>Filters</Title>
            <Title level={5}>Product Type</Title>
            <Select
              style={{ width: "100%", marginBottom: "20px" }}
              value={category}
              onChange={(value) => setCategory(value)}
            >
              <Option value="all">All</Option>
              <Option value="luxury">Luxury</Option>
              <Option value="sport">Sport</Option>
            </Select>

            <Title level={5}>Filter by Price</Title>
            <Slider
              range
              min={100}
              max={300}
              defaultValue={priceRange}
              onChange={(value) => setPriceRange(value as [number, number])}
            />
          </div>
        </Col>

        {/* Danh sách sản phẩm */}
        <Col xs={24} md={18}>
          <Row gutter={[16, 16]}>
            {filteredProducts.map((product) => (
              <Col xs={24} sm={12} lg={8} key={product.id}>
                <ProductCard product={product} />
              </Col>
            ))}
          </Row>
        </Col>
      </Row>
    </div>
  );
}

export default ProductPage