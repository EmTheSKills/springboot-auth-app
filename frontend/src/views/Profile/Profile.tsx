import React, { useContext } from "react";
import { UserContext } from "../../contexts/UserContextProvider";
import { Avatar, Image } from "antd";
import styled from "styled-components";

const PROFILE_PICTURE_SIZE = 300;

type ProfileProps = {};

const CenteredDiv = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const Profile = ({}: ProfileProps) => {
  const {
    firstName,
    lastName,
    email,
    phoneNumber,
    profilePictureUrl,
    registrationDate,
  } = useContext(UserContext);
  return (
    <CenteredDiv>
      <Avatar
        size={PROFILE_PICTURE_SIZE}
        style={{
          marginTop: "20px",
          marginBottom: "20px",
          borderStyle: "groove",
          backgroundColor: "lightsteelblue",
        }}
        src={
          <Image
            src={profilePictureUrl}
            style={{ width: PROFILE_PICTURE_SIZE }}
          />
        }
      />
      <h1>
        {firstName} {lastName}
      </h1>
      <h1>{email}</h1>
      <h1>{phoneNumber}</h1>
      <h1>Registrer date : {registrationDate}</h1>
    </CenteredDiv>
  );
};

export default Profile;
