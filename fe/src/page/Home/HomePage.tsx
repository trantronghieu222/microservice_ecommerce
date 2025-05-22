import React, { useEffect } from 'react'
import Banner from '../../components/Banner/Banner'
import ProductCard from '../../components/ProductCard/ProductCard'
// import { products } from '../../util/ProductJson'
import { useDispatch, useSelector } from 'react-redux'
import { DispatchType, RootState } from '../../redux/store'
import { getAllProductApi } from '../../redux/reducers/ProductReducer'
import Feature from '../../components/Feature/Feature'
type Props = {}

const HomePage = (props: Props) => {
  const dispatch: DispatchType = useDispatch();
  const { arrProduct } = useSelector((state: RootState) => state.productReducer);
  const prodTop3 = arrProduct.slice(0, 3);

  useEffect(() => {
    dispatch(getAllProductApi());
  }, [])
  // console.log(prodTop3)
  return (
    <div className='home-page'>
      {/* Banner */}
      <Banner></Banner>

      {/* strip */}
      <div className="benefit-strip container">
        <div className="row">
          <div className="benefit-strip-item col-6 col-md-3">
            <img src="./image/trust1.png" alt="trust1" />
            <span>BUY WITH TRUST</span>
          </div>
          <div className="benefit-strip-item col-6 col-md-3">
            <img src="./image/neu1.png" alt="neu1" />
            <span>EARN NEU POINTS</span>
          </div>
          <div className="benefit-strip-item col-6 col-md-3">
            <img src="./image/battery1.png" alt="battery1" />
            <span>FREE BATTERY REPLACEMENT</span>
          </div>
          <div className="benefit-strip-item col-6 col-md-3">
            <img src="./image/interest_free_emi21.png" alt="interest_free_emi21" />
            <span>INTEREST FREE EMI</span>
          </div>
        </div>
      </div>

      {/* Feature */}
      <Feature id='carousel2'></Feature>

      {/* Popular */}
      <div className='popular-watch m-auto'>
        <div className='popular-title text-center pb-5'>
          <h3>Popular Watch</h3>
        </div>

        <div className='row popular-content'>
          {
            prodTop3.map((item, index) => {
              return (
                <div className='col-12 col-md-4 popular-item' key={index}>
                  <ProductCard product={item}></ProductCard>
                </div>
              )
            })
          }
        </div>
      </div>

      {/* Brands */}
      <div className="brands">
        <div className="brands-container text-center py-5">
          <div className="brand-title">
            <h3>40+ INTERNATIONAL BRANDS</h3>
            <p>ONE TRUSTED DESTINATION</p>
          </div>
          <div className="brand-img">
            <img src="/image/Brands-div-col.png" alt="" className="img-fluid" />
          </div>
        </div>
      </div>

      {/* Collection */}
      <div className="collection">
        <img src="/image/Collection-poster.png" alt="" className='img-fluid'/>
      </div>
    </div>
  )
}

export default HomePage