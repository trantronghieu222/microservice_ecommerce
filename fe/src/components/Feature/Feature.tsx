import React from 'react'

type Props = {
    id: string; // ID duy nhất cho mỗi carousel
}

const Feature = ({ id }: Props) => {
    return (
        <div className="feature">
            <div id={id} className="carousel slide" data-bs-ride="carousel">
                <div className="carousel-indicators">
                    <button type="button" data-bs-target={`#${id}`} data-bs-slide-to={0} className="active" aria-current="true" aria-label="Slide 1" />
                    <button type="button" data-bs-target={`#${id}`} data-bs-slide-to={1} aria-label="Slide 2" />
                    <button type="button" data-bs-target={`#${id}`} data-bs-slide-to={2} aria-label="Slide 3" />
                    <button type="button" data-bs-target={`#${id}`} data-bs-slide-to={3} aria-label="Slide 4" />
                </div>
                <div className="carousel-inner">
                    <div className="carousel-item active">
                        <div className="row">
                            <div className='col-12 col-md-6 carousel-img'>
                                <img src="/image/divers-resized1.png" className="d-block w-100 img-fluid" alt="..." />
                            </div>
                            <div className='col-12 col-md-6 carousel-content'>
                                <div className="card">
                                    <p className="card-featured">FEATURED</p>
                                    <h2 className="card-title">BEST PERPETUAL<br />CALENDER WATCHES</h2>
                                    <p className="card-description">
                                        Imagine a world where you never have to adjust your calendar manually. Well, that world is closer than you think! Explore the world of "Perpetual Calendar Watches," where timekeeping meets precision at its finest.
                                    </p>
                                    <button className="card-btn">EXPLORE</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="carousel-item">
                        <div className="row">
                            <div className='col-12 col-md-6 carousel-img'>
                                <img src="/image/divers-resized2.png" className="d-block w-100 img-fluid" alt="..." />
                            </div>
                            <div className='col-12 col-md-6 carousel-content'>
                            <div className="card">
                                    <p className="card-featured">FEATURED</p>
                                    <h2 className="card-title">BEST PERPETUAL<br />CALENDER WATCHES</h2>
                                    <p className="card-description">
                                        Imagine a world where you never have to adjust your calendar manually. Well, that world is closer than you think! Explore the world of "Perpetual Calendar Watches," where timekeeping meets precision at its finest.
                                    </p>
                                    <button className="card-btn">EXPLORE</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="carousel-item">
                        <div className="row">
                            <div className='col-12 col-md-6 carousel-img'>
                                <img src="/image/divers-resized3.png" className="d-block w-100 img-fluid" alt="..." />
                            </div>
                            <div className='col-12 col-md-6 carousel-content'>
                            <div className="card">
                                    <p className="card-featured">FEATURED</p>
                                    <h2 className="card-title">BEST PERPETUAL<br />CALENDER WATCHES</h2>
                                    <p className="card-description">
                                        Imagine a world where you never have to adjust your calendar manually. Well, that world is closer than you think! Explore the world of "Perpetual Calendar Watches," where timekeeping meets precision at its finest.
                                    </p>
                                    <button className="card-btn">EXPLORE</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="carousel-item">
                        <div className="row">
                            <div className='col-12 col-md-6 carousel-img'>
                                <img src="/image/divers-resized4.png" className="d-block w-100 img-fluid" alt="..." />
                            </div>
                            <div className='col-12 col-md-6 carousel-content'>
                            <div className="card">
                                    <p className="card-featured">FEATURED</p>
                                    <h2 className="card-title">BEST PERPETUAL<br />CALENDER WATCHES</h2>
                                    <p className="card-description">
                                        Imagine a world where you never have to adjust your calendar manually. Well, that world is closer than you think! Explore the world of "Perpetual Calendar Watches," where timekeeping meets precision at its finest.
                                    </p>
                                    <button className="card-btn">EXPLORE</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <button className="carousel-control-prev" type="button" data-bs-target={`#${id}`} data-bs-slide="prev">
                    <span className="carousel-control-prev-icon bg-dark rounded-circle" aria-hidden="true" />
                    <span className="visually-hidden">Previous</span>
                </button>
                <button className="carousel-control-next" type="button" data-bs-target={`#${id}`} data-bs-slide="next">
                    <span className="carousel-control-next-icon bg-dark rounded-circle" aria-hidden="true" />
                    <span className="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    )
}

export default Feature;