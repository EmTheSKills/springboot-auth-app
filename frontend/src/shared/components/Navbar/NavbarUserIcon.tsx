import React, { useContext } from "react";
import { Link } from "react-router-dom";
import styled from "styled-components";
import { Avatar } from "antd";
import { Menu, Dropdown } from "antd";
import { UserContext } from "../../../contexts/UserContextProvider";

const Icon = styled.div`
  border-width: thick;
  border-color: white;
`;

const NavbarUserIcon = () => {
  const { profilePictureUrl } = useContext(UserContext);

  return (
    <Dropdown
      overlay={
        <Menu>
          <Menu.Item key="1">
            <Link to="/profile">User profile</Link>
          </Menu.Item>
          <Menu.Item key="2">Setting</Menu.Item>
          <Menu.Item key="3">Sign out</Menu.Item>
        </Menu>
      }
    >
      <Icon>
        <Avatar
          style={{ borderStyle: "groove", backgroundColor: "lightsteelblue" }}
          size={60}
          src={profilePictureUrl}
        />
      </Icon>
    </Dropdown>
  );
};

export default NavbarUserIcon;
