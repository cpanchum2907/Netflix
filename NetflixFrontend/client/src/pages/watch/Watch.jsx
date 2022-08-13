import { ArrowBackOutlined } from '@material-ui/icons'
import React from 'react'
import  './watch.scss'

function Watch() {
  return (
    <div className='watch'>
      <div className="back">
        <ArrowBackOutlined/>
        Home
      </div>
      <video className='video' autoplay progress controls src="https://www.w3schools.com/html/mov_bbb.mp4"/>
    </div>
  )
}

export default Watch
