import { User } from "../model/User";

export class UserApi {
  getLoggedInUser(): User {
    return {
      id: "123456789",
      firstName: "Émile",
      lastName: "Savard",
      email: "emile.savard.2@ulaval.ca",
      phoneNumber: "581-309-7373",
      profilePictureUrl: "https://joeschmoe.io/api/v1/random",
      registrationDate: "2022-01-23",
    };
  }
}
