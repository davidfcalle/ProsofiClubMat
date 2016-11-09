#Frontend

Esta aplicación esta hecha en angular2 y la explicación principal del funcionamiento es muy simple entiendiendo los conceptos de angular.

## Componentes

Hay 3 tipos de componentes principales

### Pantallas

Hay un componente por cada entidad de la aplicación. Dentro de cada componente se encuentra el CRUD de cada entidad. Es decir, está el controlador de eventos y la vista de cada operación.

### Guards

Los guards (guardianes) son los encargados de determinar si  un usuario tiene o no acceso a una pantall. Para ver qué usuarios tienen acceso a qué funcionalidad ver el archivo app.routing.ts

### Services

Los servicios son la capa de integración con el API REST / lógica de negocio, se encargan de hacer invocaciones HTTP y retornar Promesas (Javascript). Estos servicios son usados por el controlador de eventos de cada pantalla.
Actualmente se utiliza superagent para integrar el api con el servidor debido a un error con el módulo HTTP de Angular.
