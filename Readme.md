#ClubMat
Sistema de club de matemáticas de prosofi. El sistema se divide en 3 partes principales

## Backend

El Backend es un api rest hecho en java que expone los servicios de negocio. También se encarga de servir los archivos estáticos de la aplicación frontend.

## frontend

Es un servidor web hecho en node.js que funciona con Angular2, se encuentra en la carpeta src/main/resources/code del proyecto de backend.

## DB
La base de datos que se utilizará en MySQL 5.7. Dentro de esta carpeta se encuentra un dump base para poder correr la aplicación

# Información importante

Los dockerfiles que se encuentran definidos son para llevar la aplicación a producción y no están diseñados (aunque pueden funcionar) en desarrollo. Sin embargo, en estos se declaran las dependencias necesarias para montar un entorno de desarrollo

# Cómo Ejecutar la aplicación

## Prerrequisitos

* docker >= v1.12
* docker-compose >= 1.7

# Proceso de ejecución

Clonar el repositorio, cambiarle el nombre de la carpeta a clubmat y cambiar de directorio

```sh
$    git clone https://github.com/davidfcalle/ProsofiClubMat.git clubmat && cd clubmat
```


Crear las imagenes

```sh
$    docker-compose build
```

Ejecutar los contenedores, dada la naturaleza de Java, es posible que el contedor de Java se demore un poco en ejecutarse, en comparación a los demás.

```sh
$    docker-compose up -d
```


#Comandos útiles
Eejcutar comandos sobre un contedor que ya está corriendo 

```sh
$    docker exec -ti <nombre_contenedor> <comando>
```
