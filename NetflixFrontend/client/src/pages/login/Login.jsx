import "./login.scss"
import React  from 'react'

function Login() {
  return (
    <div className="login">
      <div className="top">
        <div className="wrapper">
            <img 
                className="logo" 
                src="https://cdn.futura-sciences.com/buildsv6/images/wide1920/0/3/0/030dc01da7_50145928_netflix-logo.jpg"
                alt="">
            </img>
        </div>
      </div>
      <div className="container">
            <form>
                <h1>Sign In</h1>
                <input type="email" placeholder="Email or Phone number" />
                <input type="password" placeholder="Password" />
                <button className="loginButton">Sign In</button>
                <span>
                    New to Netflix? <b>Sign up now.</b>
                </span>
                <small>
                    This page is protected by Google reCAPTCHA to ensure you're not a
                    bot. <b>Learn more</b>.
                </small>
            </form>
      </div>
    </div>
  )
}

export default Login
