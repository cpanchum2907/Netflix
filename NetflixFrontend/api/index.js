const express = require('express')
const app = express();
const dotenv = require("dotenv")
const mongoose = require("mongoose")
const likeRoute = require('./routes/like')
const authRoute = require("./routes/auth")
dotenv.config();

mongoose
  .connect(process.env.MONGO_URL, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
    
    
  })
  .then(() => console.log("DB Connection Successfull"))
  .catch((err) => {
    console.error(err);
  });

  app.use(express.json());

  app.use("/api/auth",authRoute);

  app.use("/api/like",likeRoute);


app.listen(8800,()=>{
    console.log('server running')
})