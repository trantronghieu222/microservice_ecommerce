import React, { useEffect, useState } from "react";
import { Row, Col, Select, Slider, Typography, Pagination } from "antd";
import ProductCard from "../../components/ProductCard/ProductCard";
import { useDispatch, useSelector } from "react-redux";
import { DispatchType, RootState } from "../../redux/store";
import { getAllProductApi } from "../../redux/reducers/ProductReducer";

const { Title } = Typography;
const { Option } = Select;

const ProductPage = () => {
  const dispatch: DispatchType = useDispatch();
  const [priceRange, setPriceRange] = useState<[number, number]>([0, 1000]);
  const [category, setCategory] = useState("all");
  const { arrProduct } = useSelector((state: RootState) => state.productReducer);

  const [currentPage, setCurrentPage] = useState(1);
  const pageSize = 6; // Số sản phẩm mỗi trang

  useEffect(() => {
    dispatch(getAllProductApi());
  }, [dispatch]);

  // Lọc sản phẩm theo khoảng giá
  const filteredProducts = arrProduct.filter(
    (product) => product.productSaleprice >= priceRange[0] && product.productSaleprice <= priceRange[1]
  );

  // Lấy sản phẩm theo trang
  const paginatedProducts = filteredProducts.slice((currentPage - 1) * pageSize, currentPage * pageSize);

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

            <Title level={5}>Filter by Price</Title>
            <Slider
              range
              min={0}
              max={1000}
              defaultValue={priceRange}
              onChange={(value) => setPriceRange(value as [number, number])}
            />
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
          total={filteredProducts.length}
          pageSize={pageSize}
          onChange={handlePageChange}
        />
      </div>
    </div>
  );
};

export default ProductPage;

// import React, { useEffect, useState } from "react";
// import { Row, Col, Select, Slider, Typography, Pagination } from "antd";
// import ProductCard from "../../components/ProductCard/ProductCard";
// import { useDispatch, useSelector } from "react-redux";
// import { DispatchType, RootState } from "../../redux/store";
// import { getAllProductPagingApi } from "../../redux/reducers/ProductReducer";

// const { Title } = Typography;
// const { Option } = Select;

// const ProductPage = () => {
//   const dispatch: DispatchType = useDispatch();
//   const [priceRange, setPriceRange] = useState<[number, number]>([0, 10000000000]);
//   const [category, setCategory] = useState("all");
//   const { arrProduct } = useSelector((state: RootState) => state.productReducer);

//   // Thêm state cho phân trang
//   const [currentPage, setCurrentPage] = useState(1);
//   const [totalPages, setTotalPages] = useState(1);
//   const pageSize = 4; // Số sản phẩm mỗi trang

//   useEffect(() => {
//     fetchProducts(currentPage);
//   }, [currentPage]);

//   const fetchProducts = async (page: number) => {
//     const pagingData = await dispatch(getAllProductPagingApi(page, pageSize));
//     setTotalPages(pagingData.totalPages);
//   };

//   const handlePageChange = (page: number) => {
//     setCurrentPage(page);
//   };

//   // Lọc sản phẩm theo khoảng giá
//   const filteredProducts = arrProduct.filter(
//     (product) => product.productSaleprice >= priceRange[0] && product.productSaleprice <= priceRange[1]
//   );

//   return (
//     <div style={{ padding: "20px" }}>
//       <Row gutter={[32, 32]}>
//         {/* Bộ lọc */}
//         <Col xs={24} md={6}>
//           <div style={{ padding: "20px", background: "#f9f9f9", borderRadius: "10px" }}>
//             <Title level={4}>Filters</Title>
//             <Title level={5}>Product Type</Title>
//             <Select
//               style={{ width: "100%", marginBottom: "20px" }}
//               value={category}
//               onChange={(value) => setCategory(value)}
//             >
//               <Option value="all">All</Option>
//               <Option value="luxury">Luxury</Option>
//               <Option value="sport">Sport</Option>
//             </Select>

//             <Title level={5}>Filter by Price</Title>
//             <Slider
//               range
//               min={0}
//               max={10000000000}
//               defaultValue={priceRange}
//               onChange={(value) => setPriceRange(value as [number, number])}
//             />
//           </div>
//         </Col>

//         {/* Danh sách sản phẩm */}
//         <Col xs={24} md={18}>
//           <Row gutter={[16, 16]}>
//             {filteredProducts.map((product) => (
//               <Col xs={24} sm={12} lg={8} key={product.productId}>
//                 <ProductCard product={product} />
//               </Col>
//             ))}
//           </Row>
//         </Col>
//       </Row>

//       {/* Phân trang */}
//       <div style={{ display: "flex", justifyContent: "center", marginTop: "20px" }}>
//         <Pagination
//           current={currentPage}
//           total={totalPages * pageSize}
//           pageSize={pageSize}
//           onChange={handlePageChange}
//         />
//       </div>

//     </div>
//   );
// };

// export default ProductPage;