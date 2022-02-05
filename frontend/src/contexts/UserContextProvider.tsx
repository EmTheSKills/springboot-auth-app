import React, { createContext } from "react";
import type { User } from "../model/User";
import { UserApi } from "../services/UserApi";

const api = new UserApi();
const initialContext = api.getLoggedInUser();

const UserContext = createContext<User>(initialContext);

type Props = {
  children: JSX.Element;
};

const UserContextProvider = ({ children }: Props) => {
  return (
    <UserContext.Provider value={initialContext}>
      {children}
    </UserContext.Provider>
  );
};

export { UserContext, UserContextProvider };
