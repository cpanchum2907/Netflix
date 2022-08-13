import "./register.scss"
import React, { useRef, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';
import  {checkemail} from '../../services/accounts';
function Register() {
    const [email,setEmail] = useState("")
    const emailRef = useRef()
    
    const [password,setPassword] = useState("")
    const passwordRef = useRef()
    
    const handleStart = () =>{
            
        if ( checkemail(emailRef.current.value) == 1) {
            setEmail(emailRef.current.value);
        } else {
        alert("Email already exists...");
        }
       
    }

    const handleFinish = () =>{
        setPassword(passwordRef.current.value) 
    }

  return (
    <div className="register">
      <div className="top">
        <div className="wrapper">
            <img 
                className="logo" 
                src="https://cdn.futura-sciences.com/buildsv6/images/wide1920/0/3/0/030dc01da7_50145928_netflix-logo.jpg"
                alt="">
            </img>
            <button className="loginButton">Sign In</button>
        </div>
      </div>
      <div className="container">
            <h1>Unlimited movies, TV <br/> shows, and more.</h1>
            <h2>Watch anywhere.Cancel anytime.</h2>
            <p>Ready to Watch?Enter your email to create or restart your membership</p>
            {!email ? (
                <div className="inputType">
                    <input type="email" placeholder="email address" ref={emailRef}/>
                    <button className="registerButton" onClick={handleStart}>Get Started</button>
                </div>
            ) : (
                <form className="inputType">
                    <input type="password" placeholder="password" ref={passwordRef}/>
                    <Link to='/home'>

                            <button  className="registerButton" onClick={handleFinish}>

                             Start

                            </button>  

                        </Link>
                </form>
            )}
      </div>
    </div>
  )
}

export default Register
