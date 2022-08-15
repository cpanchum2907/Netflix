import axios from 'axios'

export const postRegsiter = async(value) => {
    try {
        const header = {
            'Content-Type': 'application/json',
        }
        await axios.post(`/netflixJava/users`, value, {header});
        
    } catch (e) {
        throw e;
    }
}


  


