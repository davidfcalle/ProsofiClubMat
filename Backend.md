#Backend

El Backend está hecho es Spring Boot y tiene dos funcionalidades principales. El primero, es guardar los archivos estáticos (frontend) y exponer la lógica de negocio a través de un servicio REST al igual que el trabajo de grado sobre el cual se basa este proyecto


Este archivo explica brevemente los componentes del Backend explicados a través de los paquetes Java de la aplicación, para información sobre cómo funciona el frontend ver el archivo Frontend.md .


## com.prosofi.clubmat.ClubmatbackendApplication

Esta clase se encarga de inicializar el servidor. No se debe modificar por ningún motivo.

## com.prosofi.clubmat.configuration

Este paquete contiene información sobre la configuración del servidor. Específicamente configura la ruta de los archivos estáticos y la configuración del API Rest.

## com.prosofi.clubmat.datalayer

Este paquete contiene la capa de acceso a datos, Es decir a través de esta se hacen las consutas básicas (CRUD) a la base de datos. Hay una clase por cada entidad persistente.

## com.prosofi.clubmat.dto

Este paquete contiene los DTO (Data Transfer Objetos), estas clases son enviadas de negocio a presentación y viceversa cuando las entidades no tienen los datos necesarios.

## com.prosofi.clubmat.entities

Este paquete contiene todas las entidades JPA del sistema. Las entidades son las mismas del proyecto original de ClubmatbackendApplication

## com.prosofi.clubmat.projections

Acá se encuentran las proyecciones del sistema. Una proyección es un concepto de Spring y hace referencia al conjunto de atributos que se van a serializar de una entidad. Por ejemplo una proyección de la entidad usuario podría no contener el atributo password con el fin de no enviarla a través de la red.

## com.prosofi.clubmat.web

Este paquete contiene el enrutador principal de la aplicación. Se encarga de regidigir las posibles URL's al template HTML.

## com.prosofi.clubmat.webservices

Este paquete contiene el API REST de la aplicación. Su funcionamiento consiste básicamente en deserializar la información enviada por presentación, llamar al método de negocio necesario y finalmente enviar la respuesta a la presentación.
