import React, { createContext, Dispatch, useReducer } from 'react'
import { Authentication } from '../model/Authentication'
import { AuthenticationReducer } from '../reducers/AuthenticationReducer'
import { AuthenticationAction } from '../model/actions/AuthenticationAction'

type ContextType = {
    state: Authentication
    dispatch: Dispatch<AuthenticationAction>
}

type Props = {
    children: JSX.Element
}

const AuthenticationContext = createContext<ContextType>(undefined!)

const AuthenticationContextProvider = ({ children }: Props) => {
    const initialAuthentication = {
        isAuthenticated: false,
    }

    const [state, dispatch] = useReducer(
        AuthenticationReducer,
        initialAuthentication
    )

    return (
        <AuthenticationContext.Provider value={{ state, dispatch }}>
            {children}
        </AuthenticationContext.Provider>
    )
}

export { AuthenticationContext, AuthenticationContextProvider }
