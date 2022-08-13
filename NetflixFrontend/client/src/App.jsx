import Home from "./pages/home/Home"
import "./app.scss"
import Watch from "./pages/watch/Watch";
import Register from "./pages/register/Register";
import Login from "./pages/login/Login";
import {

  BrowserRouter as Router,

  Switch,

  Route,

  Routes

 

} from "react-router-dom";

const App = () => {

  return (

    <>

      <Router>
      <Routes>

        <Route path='/' element={<Register />} />

        <Route path='/login' element={<Login />} />

        <Route path='/home' element={<Home />} />

        <Route path='/watch' element={<Watch />} />

      </Routes>

      </Router>

    </>

  );

}



export default App