import React, { useState } from 'react'
import { Input } from 'antd'
import { SearchOutlined, CloseOutlined } from '@ant-design/icons'
import styled from 'styled-components'
import NavSearchBarUserResult from './NavSearchBarUserResult'

const Icon = (
    <SearchOutlined
        style={{
            fontSize: 16,
            color: 'gray',
        }}
    />
)

const SearchBarInput = (
    <Input
        placeholder="Search ugram"
        size="large"
        style={{ borderRadius: 25 }}
        prefix={Icon}
    />
)

const NavSearchContainer = styled.div`
    position: relative;
    width: 330px;
`

const SearchBar = styled.div`
    display: flex;
    align-items: center;
    padding: 15px;
`

const SearchResult = styled.div`
    overflow-y: scroll;
    //max-height: 150px;
    position: fixed;
    width: inherit;
    padding: 15px;
    padding-top: 0px;
    background-color: white;
    border-bottom-left-radius: 0.75rem;
    border-bottom-right-radius: 0.75rem;
    box-shadow: 0 10px 15px -3px rgb(0 0 0 / 0.1),
        0 4px 6px -4px rgb(0 0 0 / 0.1);
`

const userList = [
    {
        id: 0,
        firstName: 'Émile',
        lastName: 'Savard',
        profilePictureUrl: 'https://joeschmoe.io/api/v1/jane',
    },
    {
        id: 1,
        firstName: 'Louis',
        lastName: 'Rochette Laplante',
        profilePictureUrl: 'https://joeschmoe.io/api/v1/jack',
    },
    {
        id: 2,
        firstName: 'Marc-Antoine Robin',
        lastName: 'Savard',
        profilePictureUrl: 'https://joeschmoe.io/api/v1/jean',
    },
    {
        id: 3,
        firstName: 'Simon',
        lastName: 'Martineau',
        profilePictureUrl: 'https://joeschmoe.io/api/v1/jon',
    },
    {
        id: 4,
        firstName: 'Jérôme',
        lastName: 'Bergeron',
        profilePictureUrl: 'https://joeschmoe.io/api/v1/jed',
    },
]

const NavSearchBar = () => {
    const [isClicked, setIsClicked] = useState(false)

    return (
        <NavSearchContainer
            onBlur={() => setIsClicked(false)}
            onFocus={() => setIsClicked(true)}
        >
            {isClicked ? (
                <>
                    <SearchBar style={{ backgroundColor: 'white' }}>
                        <CloseOutlined
                            style={{ paddingRight: 10, color: 'black' }}
                            onClick={() => setIsClicked(false)}
                        />
                        {SearchBarInput}
                    </SearchBar>
                    <SearchResult>
                        {userList.map((user) => (
                            <NavSearchBarUserResult
                                key={user.id}
                                firstName={user.firstName}
                                lastName={user.lastName}
                                profilePictureUrl={user.profilePictureUrl}
                            />
                        ))}
                    </SearchResult>
                </>
            ) : (
                <SearchBar>{SearchBarInput}</SearchBar>
            )}
        </NavSearchContainer>
    )
}

export default NavSearchBar
