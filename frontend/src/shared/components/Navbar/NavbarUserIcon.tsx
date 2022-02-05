import React, { useContext, useReducer } from 'react'
import { Link } from 'react-router-dom'
import styled from 'styled-components'
import { Avatar, Button } from 'antd'
import { Menu, Dropdown } from 'antd'
import { AuthenticationContext } from '../../../contexts/AuthenticationContextProvider'
import { UserApi } from '../../../services/UserApi'
import { User } from '../../../model/User'
import { AuthenticationActionKind } from '../../../model/actions/AuthenticationActionKind'

const api = new UserApi()

const Icon = styled.div`
    border-width: thick;
    border-color: white;
`

const NavbarUserIcon = () => {
    const { state, dispatch } = useContext(AuthenticationContext)
    const isAuthenticated = state.isAuthenticated

    const signIn = async () => {
        const userInfo = await api.getLoggedInUser()
        dispatch({
            type: AuthenticationActionKind.Login,
            payload: userInfo,
        })
    }

    const dispatchSignOut = {
        type: AuthenticationActionKind.Logout,
        payload: {} as User,
    }

    return isAuthenticated ? (
        <Dropdown
            overlay={
                <Menu>
                    <Menu.Item key="1">
                        <Link to="/profile">User profile</Link>
                    </Menu.Item>
                    <Menu.Item key="2">Setting</Menu.Item>
                    <Menu.Item
                        key="3"
                        onClick={() => dispatch(dispatchSignOut)}
                    >
                        <Link to="/">Sign out</Link>
                    </Menu.Item>
                </Menu>
            }
        >
            <Icon>
                <Avatar
                    style={{
                        borderStyle: 'groove',
                        backgroundColor: 'lightsteelblue',
                    }}
                    size={60}
                    src={state.user?.profilePictureUrl}
                />
            </Icon>
        </Dropdown>
    ) : (
        <Button
            type="primary"
            shape="round"
            size={'large'}
            onClick={() => signIn()}
        >
            Sign in
        </Button>
    )
}

export default NavbarUserIcon
