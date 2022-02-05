import React, { useContext } from 'react'
import { AuthenticationContext } from '../../contexts/AuthenticationContextProvider'
import { Avatar, Button, Image } from 'antd'
import styled from 'styled-components'
import { EditOutlined } from '@ant-design/icons'
import Gallery from '../../shared/components/Gallery/Gallery'
import { User } from '../../model/User'

const PROFILE_PICTURE_SIZE = 300

type ProfileProps = {}

const CenteredDiv = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 4rem;
`

const ClassicSpan = styled.span`
    font-weight: bold;
    font-size: x-large;
    margin-left: 2rem;
    border-bottom: darkgray;
`
const UserBigContainer = styled.div`
    margin-left: 30%;
`

const UserInfoContainer = styled.div`
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    margin-left: 2rem;
    margin-top: 2rem;
    border-style: solid;
    border-color: darkgray;
    max-width: 100%;
    //border-bottom: darkgray;
`
const CustomSpan = styled.div`
    //border-style: solid;
    //border-bottom: red;
    margin-bottom: 1rem;
`

const UserInfoGeneral = styled.div`
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    padding: 1rem;
    //border-left: solid;
    //border-top: solid;
    font-size: larger;
    font-weight: bolder;
`
const BiggestContainer = styled.div`
    display: flex;
    flex-wrap: wrap;
    flex-direction: row;
`

const UserInfoUser = styled.div`
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    padding: 1rem;
    //border-left: solid;
    //border-top: solid;
    font-size: larger;
`

const BasicInfoContainer = styled.div`
    //max-width: 30%;
`

const UserNameInProfile = styled.h1`
    color: grey;
`

const Profile = ({}: ProfileProps) => {
    const contextState = useContext(AuthenticationContext).state
    const {
        firstName,
        lastName,
        userName,
        email,
        phoneNumber,
        profilePictureUrl,
        registrationDate,
    } = contextState.user as User

    return (
        <>
            <CenteredDiv>
                <Avatar
                    size={PROFILE_PICTURE_SIZE}
                    style={{
                        marginTop: '20px',
                        borderStyle: 'groove',
                        backgroundColor: 'lightsteelblue',
                    }}
                    src={
                        <Image
                            src={profilePictureUrl}
                            style={{ width: PROFILE_PICTURE_SIZE }}
                        />
                    }
                />
                <Button
                    style={{ marginLeft: '15rem', border: 'none' }}
                    icon={<EditOutlined />}
                    size="large"
                />

                <UserNameInProfile>{userName}</UserNameInProfile>
            </CenteredDiv>
            <BiggestContainer>
                <BasicInfoContainer>
                    <ClassicSpan>Basic Information</ClassicSpan>
                    <UserInfoContainer>
                        <UserInfoGeneral>
                            <CustomSpan>Fullname</CustomSpan>
                            <CustomSpan>Email Address</CustomSpan>
                            <CustomSpan>Phone Number</CustomSpan>
                            <CustomSpan>Registrer date</CustomSpan>
                        </UserInfoGeneral>
                        <UserInfoUser>
                            <CustomSpan>
                                {firstName} {lastName}
                            </CustomSpan>
                            <CustomSpan>{email}</CustomSpan>
                            <CustomSpan>{phoneNumber}</CustomSpan>
                            <CustomSpan>{registrationDate}</CustomSpan>
                        </UserInfoUser>
                    </UserInfoContainer>
                </BasicInfoContainer>
                <div>
                    <ClassicSpan style={{ marginLeft: '4%' }}>
                        Your Gallery
                    </ClassicSpan>
                    <div>
                        <Gallery />
                    </div>
                </div>
            </BiggestContainer>
        </>
    )
}

export default Profile
