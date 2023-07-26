import React from 'react'
import { Link , Outlet} from 'react-router-dom'

const Layout = () =>{
return (
    <>
        <header>
            <h1>
              <Link to={'/'} className={'header-link'}>Pet Store</Link>
            </h1>

          <div id={'main'}>
            <Outlet/>
          </div>
        </header>
    </>
)
}

export default Layout