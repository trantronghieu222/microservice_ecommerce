import { useEffect, useState } from "react";
import { Row, Col, Select, Typography, Pagination } from "antd";
import ProductCard from "../../components/ProductCard/ProductCard";
import { useDispatch, useSelector } from "react-redux";
import { DispatchType, RootState } from "../../redux/store";
import { getAllProductApi, getProductByName } from "../../redux/reducers/ProductReducer";
import { useLocation } from "react-router-dom";

const { Title } = Typography;
const { Option } = Select;

const useQuery = () => {
  return new URLSearchParams(useLocation().search);
};

const ProductPage = () => {
  const dispatch: DispatchType = useDispatch();
  const query = useQuery();
  const [category, setCategory] = useState("all");
  const { arrProduct } = useSelector((state: RootState) => state.productReducer);
  const [currentPage, setCurrentPage] = useState(1);
  const pageSize = 6;
  const keyword = query.get("keyword") || "";

  // useEffect(() => {
  //   dispatch(getAllProductApi());
  // }, [dispatch]);

  useEffect(() => {
    if (keyword) {
      dispatch(getProductByName(keyword));
    } else {
      dispatch(getAllProductApi());
    }
  }, [dispatch, keyword]);

  // Lấy sản phẩm theo trang
  const paginatedProducts = arrProduct.slice((currentPage - 1) * pageSize, currentPage * pageSize);

  const handlePageChange = (page: number) => {
    setCurrentPage(page);
  };

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
          </div>
        </Col>

        {/* Danh sách sản phẩm */}
        <Col xs={24} md={18}>
          <Row gutter={[16, 16]}>
            {paginatedProducts.map((product) => (
              <Col xs={24} sm={12} lg={8} key={product.productId}>
                <ProductCard product={product} />
              </Col>
            ))}
          </Row>
        </Col>
      </Row>

      {/* Phân trang */}
      <div style={{ display: "flex", justifyContent: "center", marginTop: "20px" }}>
        <Pagination
          current={currentPage}
          total={arrProduct.length}
          pageSize={pageSize}
          onChange={handlePageChange}
        />
      </div>
    </div>
  );
};

export default ProductPage;