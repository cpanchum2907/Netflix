const mongoose = require("mongoose")

const FavSchema = new mongoose.Schema({

    movieName:{type:String,required:true},
    movieDesc:{type:String,required:true},

    },
    {timestamps:true}
);

module.exports = mongoose.model("like", FavSchema)