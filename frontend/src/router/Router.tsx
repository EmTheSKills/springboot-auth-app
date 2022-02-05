import React from 'react'
import { Routes, Route } from 'react-router-dom'
import Home from '../views/Home'
import Profile from '../views/Profile'

const Router = () => {
    return (
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/profile" element={<Profile />} />
        </Routes>
    )
}

export default Router
