import React, { Suspense } from "react";
import { BrowserRouter } from "react-router-dom";
import Router from "./router/Router";
import { UserContextProvider } from "./contexts/UserContextProvider";
import Navbar from "./shared/components/Navbar/Navbar";

const App = () => {
  return (
    <UserContextProvider>
      <BrowserRouter>
        <Suspense fallback={<div>Loading...</div>}>
          <Navbar />
          <Router />
        </Suspense>
      </BrowserRouter>
    </UserContextProvider>
  );
};

export default App;
