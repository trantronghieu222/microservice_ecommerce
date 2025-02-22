import React from 'react'
import Banner from '../../components/Banner/Banner'
import ProductCard from '../../components/ProductCard/ProductCard'
import { products } from '../../util/ProductJson'
type Props = {}

const HomePage = (props: Props) => {
  const prodTop3 = products.slice(0, 3);
  console.log(prodTop3)
  return (
    <div className='home-page'>
      {/* Banner */}
      <Banner></Banner>

      {/* Popular */}
      <div className='popular-watch m-auto'>
        <div className='popular-title text-center py-5'>
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
    </div>
  )
}

export default HomePage