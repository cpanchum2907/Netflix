const router = require("express").Router();
const Fav = require("../models/like");
const express = require('express')
const app = express();


  router.post("/like", async (req, res) => {

    const newFav = new like({
        movieName: req.body.movieName,
        movieDesc: req.body.movieDesc,
        
      });
    
      try {
        const user = await newFav.save();
        res.status(201).json(user);
      } catch (err) {
        res.status(500).json(err);
      }
    
    
  });

  module.exports = router;


