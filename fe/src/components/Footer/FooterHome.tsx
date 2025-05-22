import React from 'react'

type Props = {}

const FooterHome = (props: Props) => {
  return (
    <div className="footer">
      <div className="footer-top container">
        <div className="row">
          <div className="footer-top-item col-12 col-md-6 col-lg-3">
            <div className="footer-title">
              <h5>KNOW WAYNE</h5>
            </div>
            <div className="footer-content">
              <ul>
                <li><a href="#"><i className="fa fa-angle-right"></i><span>About Us</span></a></li>
                <li><a href="#"><i className="fa fa-angle-right"></i><span>About Wayne Watch Store</span></a></li>
                <li><a href="#"><i className="fa fa-angle-right"></i><span>Bulk Purchase & Corporate Gifts</span></a></li>
              </ul>
            </div>
          </div>

          <div className="footer-top-item col-12 col-md-6 col-lg-3">
            <div className="footer-title">
              <h5>TERMS & CONDITIONS</h5>
            </div>
            <div className="footer-content">
              <ul>
                <li><a href="#"><i className="fa fa-angle-right"></i><span>Shipping & Return Policies</span></a></li>
                <li><a href="#"><i className="fa fa-angle-right"></i><span>Privacy Policy</span></a></li>
                <li><a href="#"><i className="fa fa-angle-right"></i><span>FAQ’s</span></a></li>
              </ul>
            </div>
          </div>

          <div className="footer-top-item col-12 col-md-6 col-lg-3">
            <div className="footer-title">
              <h5>CONTACT US</h5>
            </div>
            <div className="footer-content">
              <ul>
                <li><a href="#"><i className="fa fa-angle-right"></i><span>For Sale: <span className="highlight">Waynewatch@co.in</span></span></a></li>
                <li><a href="#"><i className="fa fa-angle-right"></i><span>Call: <span className="highlight">+91 9876543210</span></span></a></li>
                <li><a href="#"><i className="fa fa-angle-right"></i><span>For Complaints: <span className="highlight">1800 202 2022</span></span></a></li>
                <li><a href="#"><i className="fa fa-angle-right"></i><span>Chat Time: <span className="highlight">Our Team is Available From Monday to Saturday from 9.00AM to 8.00PM</span></span></a></li>
                <li><a href="#"><i className="fa fa-angle-right"></i><span>For Complaints: <span className="highlight">customercare.com</span></span></a></li>
              </ul>
            </div>
          </div>

          <div className="footer-top-item col-12 col-md-6 col-lg-3">
            <div className="footer-title">
              <h5>FOLLOW US</h5>
            </div>
            <div className="footer-content">
              <div className="footer-icon">
                <a href="#"><i className="fab fa-instagram" /></a>
                <a href="#"><i className="fab fa-facebook" /></a>
                <a href="#"><i className="fab fa-twitter" /></a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div className="footer-bottom"></div>
    </div>
  )
}

export default FooterHome