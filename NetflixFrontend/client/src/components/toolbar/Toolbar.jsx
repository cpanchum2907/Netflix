import { ArrowDropDown, Notifications, Search, Settings } from '@material-ui/icons';
import React, { useState } from 'react';
import "./toolbar.scss";

const Toolbar = () => {
  const [isScrolled, setIsScrolled] = useState(false);
  window.onscroll = () =>{
    setIsScrolled(window.pageYOffset === 0 ? false: true);
    return () => (window.onscroll = null);
  }
  console.log(isScrolled);
  return (
    <div className={isScrolled ? "toolbar scrolled" : "toolbar"}>
       <div className="container">
            <div className="leftside">
            <img src="https://cdn.futura-sciences.com/buildsv6/images/wide1920/0/3/0/030dc01da7_50145928_netflix-logo.jpg"
                     alt="">
                 </img>
                 <span>Home</span>
                 <span>Characters</span>
                 <span>TV Shows</span>
                 <span>Movies</span>
                 <span>New & Popular</span>
                 <span>My List</span>
            </div>
            <div className="rightside">
                <Search className='icon'/>
                <span>kids</span>
                <Notifications className='icon'/>
                <img src="data:image/jpeg;base64,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" alt="" />
                <div className="profile">
                    <ArrowDropDown className='icon'/>
                    <div className='options'>
                        <span>Settings</span>
                        <span>Logout</span>
                    </div>
                </div>
            </div>
       </div>
    </div>
  )
}

export default Toolbar
