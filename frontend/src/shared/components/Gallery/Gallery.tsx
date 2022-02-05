import React, { useContext } from 'react'
import styled from 'styled-components'
import { AuthenticationContext } from '../../../contexts/AuthenticationContextProvider'
import { Image } from 'antd'
import { User } from '../../../model/User'

const Gallery = () => {
    const { listPhotos } = useContext(AuthenticationContext).state.user as User
    let i = 0
    return (
        <div>
            {listPhotos.map((item) => (
                <Image key={i++} src={item} />
            ))}
        </div>
    )
}

export default Gallery
