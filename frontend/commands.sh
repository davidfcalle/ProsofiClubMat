#Ejecutar un comando sobre el contenedor corriendo
docker exec -ti <nombre_contenedor> <comando>

#cambiar el comando por defecto del contenedor y ejecutarlo
docker run -ti --entrypoint=bash -v $(pwd)/frontend/code:/code -v /code/node_modules  -v /code/typings clubmat_clubmatfrontend