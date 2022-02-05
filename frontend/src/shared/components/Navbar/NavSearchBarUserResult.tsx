import React from 'react'
import styled from 'styled-components'
import { Avatar } from 'antd'

const UserResult = styled.div`
    display: flex;
    align-items: center;
    padding: 2px;
    border-radius: 0.75rem;
    &:hover {
        background-color: lightgray;
        cursor: pointer;
    }
`

type Props = {
    firstName: string
    lastName: string
    profilePictureUrl: string
}

const NavSearchBarUserResult = ({
    firstName,
    lastName,
    profilePictureUrl,
}: Props) => {
    return (
        <UserResult onClick={() => {}}>
            <Avatar src={profilePictureUrl} />
            <div style={{ paddingLeft: 10 }}>
                {firstName} {lastName}
            </div>
        </UserResult>
    )
}

export default NavSearchBarUserResult
