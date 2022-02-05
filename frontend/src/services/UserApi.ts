import { User } from '../model/User'

const user = {
    id: '123456789',
    firstName: 'Émile',
    lastName: 'Savard',
    userName: 'EmTheSkills',
    email: 'emile.savard.2@ulaval.ca',
    phoneNumber: '581-309-7373',
    profilePictureUrl: 'https://joeschmoe.io/api/v1/random',
    registrationDate: '2022-01-23',
    listPhotos: [
        'https://joeschmoe.io/api/v1/random',
        'https://joeschmoe.io/api/v1/jess',
    ],
}

export class UserApi {
    async getLoggedInUser(): Promise<User> {
        return Promise.resolve(user)
    }
}
