import axios from "axios";

const baseURL = 'http://localhost:8080/netflix'

export const checkemail = async(email) => {
   await axios
   .get(`${baseURL}/users/checkByemail?email=${email}`)
   .then((res)=>{
    if(res.status===200){
        if (!res.data) {
            return 0;
        
          } else {
        
            console.log("Success!");
            return 1;
          }
        }
        
    }
)}
  
