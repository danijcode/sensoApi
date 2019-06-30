# sensoApi
Crud simples de contatos utilizando Spring boot, abaixo as rotas com seus respectivos metodos.
A porta de sua preferencia deve ser configurada no arquivo de configuração (resources/application.properties)

## GET 
http://localhost:8090/api/v1/contacts/{id}?

## GET
http://localhost:8090/api/v1/contacts/

## PUT
http://localhost:8090/api/v1/contacts/{id}?

## POST 
http://localhost:8090/api/v1/contacts/
```
{
    "name": "Rogerio Brito",
    "email": "rbrito@gmail.com",
    "phone": "(71) 5533-1255"
}
```

