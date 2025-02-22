import React from 'react'
type Props = {}

const AdminHeader = (props: Props) => {
    return (
        <div className="adminHeader">
            <div className="">
                Hello + Name
            </div>
            <button className="adminExit">
                <i className="fa fa-sign-out-alt"></i>
            </button>
        </div>
    )
}

export default AdminHeader