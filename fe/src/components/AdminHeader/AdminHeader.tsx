import React from 'react'
import { Link } from 'react-router-dom'
type Props = {}

const AdminHeader = (props: Props) => {
    return (
        <div className="adminHeader">
            <div className="">
                Hello + Name
            </div>
            {/* <button className="adminExit">
                <i className="fa fa-sign-out-alt"></i>
            </button> */}
            <Link to='/' className="adminExit">
                <i className="fa fa-sign-out-alt"></i>
            </Link>
        </div>
    )
}

export default AdminHeader