import React from "react";
import styled from "styled-components";
import { Link } from "react-router-dom";
import NavbarUserIcon from "./NavbarUserIcon";

const Nav = styled.header`
  display: flex;
  align-items: center;
  justify-content: space-between;
  background-color: #333;
  overflow: hidden;
  height: 70px;
`;

const Navbar = () => {
  return (
    <Nav>
      <Link to="/">
        <img
          style={{ height: "50px", width: "50px" }}
          src="https://tailwindui.com/img/logos/workflow-mark-indigo-500.svg"
          alt="Workflow"
        />
      </Link>
      <NavbarUserIcon />
    </Nav>
  );
};

export default Navbar;
