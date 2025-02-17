import React from 'react'
import styles from "../../assets/sass/layout/AdminHeader.module.scss"
type Props = {}

const AdminHeader = (props: Props) => {
    return (
        <div className={`${styles.adminHeader}`}>
            <div className="">
                Hello + Name
            </div>
            <div className="adminDropdown">
                <img className='rounded-circle' src="https://www.gravatar.com/avatar/00000000000000000000000000000000?d=mp" alt="Default Avatar" width={40} height={40} />
            </div>
        </div>
    )
}

export default AdminHeader