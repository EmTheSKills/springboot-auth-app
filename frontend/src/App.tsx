import React, { Suspense } from 'react'
import { BrowserRouter } from 'react-router-dom'
import Router from './router/Router'
import Navbar from './shared/components/Navbar/Navbar'
import { AuthenticationContextProvider } from './contexts/AuthenticationContextProvider'

const App = () => {
    return (
        <AuthenticationContextProvider>
            <BrowserRouter>
                <Suspense fallback={<div>Loading...</div>}>
                    <Navbar />
                    <Router />
                </Suspense>
            </BrowserRouter>
        </AuthenticationContextProvider>
    )
}

export default App
