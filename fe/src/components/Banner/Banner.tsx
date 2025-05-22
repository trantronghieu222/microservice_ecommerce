import React from 'react'

type Props = {}

const Banner = (props: Props) => {
  return (
    // <div className="banner">
    //   <div id="carouselExampleCaptions" className="carousel slide" data-bs-ride="carousel">
    //     <div className="carousel-indicators">
    //       <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to={0} className="active" aria-current="true" aria-label="Slide 1" />
    //       <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to={1} aria-label="Slide 2" />
    //       <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to={2} aria-label="Slide 3" />
    //     </div>
    //     <div className="carousel-inner">
    //       <div className="carousel-item active">
    //         <img src="/image/banner1.jpg" className="d-block w-100" alt="..." />
    //       </div>
    //       <div className="carousel-item">
    //         <img src="/image/banner2.jpg" className="d-block w-100" alt="..." />
    //       </div>
    //       <div className="carousel-item">
    //         <img src="/image/banner3.jpg" className="d-block w-100" alt="..." />
    //       </div>
    //     </div>
    //     <button className="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    //       <span className="carousel-control-prev-icon" aria-hidden="true" />
    //       <span className="visually-hidden">Previous</span>
    //     </button>
    //     <button className="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    //       <span className="carousel-control-next-icon" aria-hidden="true" />
    //       <span className="visually-hidden">Next</span>
    //     </button>
    //   </div>
    // </div>

    <div className="banner">
      <div className="banner-container row">
        <div className="banner-left col-12 col-md-7">
          <img src="/image/Carousel-image.png" alt="banner" className="img-fluid" />
        </div>
        <div className="banner-right col-12 col-md-5">
          <div className="banner-content">
            <p>THE ULTIMATE OFFER FOR WATCH ADDICTS</p>
            <h1>WATCHOHOLIC SALE</h1>
            <h1 className="sale-line">
              <span className="upto">UPTO</span>
              <span className="discount">40%</span>
              <span className="off">OFF</span>
            </h1>
            <p>AVAIL 0% EMI | EARN TATA NEU POINTS |
              FREE BATTERY REPLACEMENT</p>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Banner