import React, { useState } from 'react'
import "./listItem.scss"
import {Add, PlayArrow,  ThumbDownOutlined,  ThumbUpOutlined} from '@material-ui/icons'

function ListItem({index,item}) {
  const [isHovered,setIsHovered] = useState(false);
  const trailer = "https://www.w3schools.com/html/mov_bbb.mp4"
  return (
    <div className='listItem' 
      style={{ left: isHovered && index * 225 - 50 + index * 2.5 }}
      onMouseEnter={() => setIsHovered(true)} 
      onMouseLeave={() => setIsHovered(false)}>
      <img
        src={`https://image.tmdb.org/t/p/w500/${item?.backdrop_path}`}
        alt=""
      />
      {isHovered && (
       <>
          <video src={trailer} autoPlay={true} loop />
          <div className="itemInfo">
            <div className="icons">
              <PlayArrow className="icon"/>
              <Add className="icon"/>
              <ThumbUpOutlined className="icon"/>
              <ThumbDownOutlined className="icon"/>
            </div>
            <div className="itemInfoTop">
              <span>1 hr 14 min</span>
              <span className="limit">+16</span>
              <span>{item?.release_date}</span>
            </div>
            <div className="description">
                {item?.overview}
            </div>
            <div className="genre">romance</div>
          </div>
        </>
      )}
    </div>
  );
}

export default ListItem




