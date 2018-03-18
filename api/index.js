const express=require('express');
const mongoose=require('mongoose');
const bodyparser=require('body-parser');
const app=express();
app.use(bodyparser.urlencoded({extended:true}));
//db
mongoose.Promise=global.Promise;
var dbConn=mongoose.connect('mongodb://localhost:27017/mydb');
//db

//schema
var productschema=new mongoose.Schema({
  name:String,
  price:String
})

var animeschema=new mongoose.Schema({
  name:String,
  description:String,
  rating:String,
  episodes:String,
  categorie:String,
  img:String
})
var Anime=mongoose.model('a3',animeschema);
var Product=mongoose.model('p1',productschema);
var salesperson=new mongoose.Schema({
  name:String,
  username:String,
  password:String
})
var salesPerson=mongoose.model('p1sales',salesperson);
app.listen(4000,()=>console.log("Listening to port 4000"));
//post
app.post('/add',function(req,res){
console.log("add detected");
  var name1=req.body.name;
  var price1=req.body.price;
  //console.log(name);
  var p1=Product({name:name1,price:price1}).save(function(err){
    if(err){
      console.log("error");
      res.send("success")
    }
    else {
      console.log("success");
      res.send("error");
    }
  })

})
app.post('/insert',function(req,res){
  var name=req.body.name;
  var des=req.body.description;
  var rating=req.body.rating;
  var episodes=req.body.episodes;
  var categorie=req.body.categorie;
  var img=req.body.img;
  var a=Anime({name:name,description:des,rating:rating,episodes:episodes,categorie:categorie,img:img}).save(function(err,inserted){
    if(err){
      console.log("error");
    }
    res.send(inserted);
  })
})
app.post('/login',function(req,res){
  console.log("login called");
  var sname=req.body.name;
  var suser=req.body.username;
  var spassword=req.body.password;
  var s1=salesPerson({name:sname,username:suser,password:spassword}).save(function(err){
    if(err){
      res.send("error");
    }
    else {
      res.send("success");
    }
  })
})

//post
