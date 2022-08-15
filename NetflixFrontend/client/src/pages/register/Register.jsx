import "./register.scss"
import React, { useRef, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';
import  {checkemail} from '../../services/accounts';
import {postRegsiter}  from  '../../services/accounts';
import {login} from '../login/Login'
function Register() {
    const [email,setEmail] = useState("")
    const emailRef = useRef()
    const [firstName, setFirstname] = useState('');
    const [lastName, setLastname] = useState('');
    const [login, setUsername] = useState('');


    
    const [password,setPassword] = useState("")
    const passwordRef = useRef()
    
    const handleStart = () =>{
            
        setEmail(emailRef.current.value) 
        
       
    }
    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
          const value = {email, password, login, firstName, lastName}
          await postRegsiter(value)
        } catch (error) {
          console.log(error);
        }
      };

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
            
            <Link to='/login'>
                <button className="loginButton">Sign In</button>
            </Link>
        </div>
      </div>
      <div className="container">
            <h1>Unlimited movies, TV <br/> shows, and more.</h1>
            <h2>Watch anywhere.Cancel anytime.</h2>
            <p>Ready to Watch?Enter your email to create or restart your membership</p>
            {!email ? (
                <div className="inputType">
                    <input type="email" placeholder="email address" onChange={(e) => setEmail(e.target.value)} />
                    <button className="registerButton">Get Started</button>
                </div>
            ) : (
                <form className="inputType" onSubmit={handleSubmit}>
                    <input type="password" placeholder="password" onChange={(e) => setPassword(e.target.value)} />
                    
                            <button  className="registerButton">
                             Start
                            </button>  
                       
                </form>
            )}
      </div>
    </div>
  )
}

export default Register
