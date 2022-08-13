const router = require("express").Router();
const User = require("../../../NetflixBackend/src/main/java/fr/epita/netflix/datamodel");

router.post("/register", (req,res)=>{
    const newUser = new User({
        name:req.body.name
    });
    const user = newUser.save();
    res.json(user)
});

module.exports = router;