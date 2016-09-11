#ClubMat
Sistema de club de matemáticas de prosofi. El sistema se divide en 3 partes principales

## Backend

El Backend es un api rest hecho en java que expone los servicios de negocio

## frontend

Es un servidor web hecho en node.js que funciona con angular2

## DB
La base de datos que se utilizará en MySQL 5.7

# Información importante

Los dockerfiles que se encuentran definidos son para llevar la aplicación a producción y no están diseñados (aunque pueden funcionar) en desarrollo. Sin embargo, en estos se declaran las dependencias necesarias para montar un entorno de desarrollo

##Nota importante
Es necesario arreglar esto en el futuro, pero apenas se clone el repositorio es necesario ejecutar sudo chmod -R . 777, para que se los contenedores puedan leer y cambiar datos de los volúmenes