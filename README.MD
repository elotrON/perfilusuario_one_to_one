# Ejercicio: relación One to One entre Usuario y Perfil

Crea una aplicación Spring Boot con dos entidades:

- **Usuario**
- **Perfil**

## Reglas del ejercicio

- Un **usuario** tiene un único **perfil**.
- Un **perfil** pertenece a un único **usuario**.

## Datos básicos

### Usuario
Debe tener al menos:

- `id`
- `nombre`
- `email`

### Perfil
Debe tener al menos:

- `id`
- `telefono`
- `direccion`

## Lo que debes hacer

1. Crear la relación **One to One** entre `Usuario` y `Perfil`.
2. Hacer que una de las tablas tenga la **clave foránea única**.
3. Configurar correctamente el **lado propietario** de la relación.
4. Usar **cascade persist** para que al guardar un usuario también se guarde su perfil.
5. Crear un endpoint `POST` para guardar un usuario con su perfil.
6. Probarlo enviando un JSON desde Postman.

## Ejemplo de JSON esperado

```json
{
  "nombre": "Juan",
  "email": "juan@correo.com",
  "perfil": {
    "telefono": "600123123",
    "direccion": "Calle Mayor 10"
  }
}
```

## Objetivo

Que al guardar un usuario:
- se cree también su perfil,
- queden relacionados en base de datos,
- y cada perfil solo pueda pertenecer a un usuario