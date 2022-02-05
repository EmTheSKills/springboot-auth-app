import { User } from './User'

export type Authentication = {
    isAuthenticated: boolean
    user?: User
    token?: string
}
