import React from 'react'
import styled from 'styled-components'
import { Link } from 'react-router-dom'
import NavbarUserIcon from './NavbarUserIcon'
import NavSearchBar from './NavSearchBar'
import Logo from '../../../assets/ugram.png'

const Nav = styled.header`
    position: sticky; /* Set the navbar to fixed position */
    top: 0; /* Position the navbar at the top of the page */
    width: 100%; /* Full width */
    z-index: 50;
    display: flex;
    align-items: center;
    justify-content: space-between;
    background-color: #333;
    overflow: hidden;
    height: 70px;
`

const Navbar = () => {
    return (
        <Nav>
            <Link to="/">
                <img
                    style={{ height: '50px', width: '50px', paddingLeft: '5px' }}
                    src={Logo}
                    alt="Workflow"
                />
            </Link>
            <NavSearchBar />
            <NavbarUserIcon />
        </Nav>
    )
}

export default Navbar
