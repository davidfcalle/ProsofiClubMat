var express = require('express');
var path = require('path');

var app = express();

app.use('/public',express.static(path.join(__dirname, 'public/')));
app.use('/node_modules',express.static(path.join(__dirname, 'node_modules/')));
app.use('/app',express.static(path.join(__dirname, 'app/')));
app.use('/images',express.static(path.join(__dirname, 'images/')));

app.set('view engine', 'pug');

app.get( '/' , function ( req , res ) {
    res.render('index.pug');
}); 

app.get( '/signup' , function ( req , res ) {
    res.render('index');
});

app.get( '/signin' , function ( req , res ) {
    res.render('index');
});


app.listen( 3000 , function(err){
    if( err ) console.log("Error Fatal");
    console.log("Aplicación escuchando en el puerto 3000")
});