import { Authentication } from '../model/Authentication'
import { AuthenticationAction } from '../model/actions/AuthenticationAction'
import { AuthenticationActionKind } from '../model/actions/AuthenticationActionKind'

export const AuthenticationReducer = (
    state: Authentication,
    action: AuthenticationAction
) => {
    switch (action.type) {
        case AuthenticationActionKind.Login:
            localStorage.setItem('user', JSON.stringify(action.payload))
            //localStorage.setItem("token", JSON.stringify(action.payload.token));
            return {
                isAuthenticated: true,
                user: action.payload,
                token: '111111111',
            }
        case AuthenticationActionKind.Logout:
            localStorage.clear()
            return {
                isAuthenticated: false,
            }
        default:
            return state
    }
}
