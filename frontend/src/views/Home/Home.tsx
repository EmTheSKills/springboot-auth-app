import React from 'react'
import { Link } from 'react-router-dom'
import { Button, Radio } from 'antd'
import { UserOutlined } from '@ant-design/icons'
import Navbar from '../../shared/components/Navbar/Navbar'
import styled from 'styled-components'

type HomeProps = {}

const Home = ({}: HomeProps) => {
    return (
        <div>
            <h1>This is home!</h1>
            <div>Il va y avoir un feed insta un jour</div>
        </div>
    )
}

export default Home
