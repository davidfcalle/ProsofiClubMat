var express = require('express');

var app = express();
app.use(express.static('public'));
app.use(express.static('node_modules'));
app.use(express.static(__dirname +'/systemjs.config.js'))

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