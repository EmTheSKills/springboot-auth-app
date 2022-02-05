import { User } from '../User'
import { AuthenticationActionKind } from './AuthenticationActionKind'

export type AuthenticationAction = {
    type: AuthenticationActionKind
    payload: User
}
