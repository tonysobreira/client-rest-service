# client-rest-service
Client Rest Service

Get all Clients (GET)

https://clientrestservice.herokuapp.com/api/clients/

Get one Client (GET)

https://clientrestservice.herokuapp.com/api/client/{id}

Create a Client (POST)

https://clientrestservice.herokuapp.com/api/client/

body json

{
    "id": null,
    "nome": "Tony",
    "cpf": "111.111.111-11",
    "dataNascimento": "1984-09-20",
    "telefone": "(71) 99103-4267",
    "email": "tonysobreira@gmail.com",
    "logradouro": "Rua da Sinagoga, N 22",
    "cep": "40450-610",
    "bairro": "Uruguai",
    "complemento": "Térreo",
    "cidade": "Salvador",
    "estado": "Bahia"
}

Update a Client (PUT)

body json

{
    "id": 1,
    "nome": "Tony",
    "cpf": "111.111.111-11",
    "dataNascimento": "1984-09-20",
    "telefone": "(71) 99103-4267",
    "email": "tonysobreira@gmail.com",
    "logradouro": "Rua da Sinagoga, N 22...",
    "cep": "40450-610",
    "bairro": "Uruguai",
    "complemento": "Térreo",
    "cidade": "Salvador",
    "estado": "Bahia"
}

Delete one Client (DELETE)

https://clientrestservice.herokuapp.com/api/client/{id}

Delete one Client (DELETE)

https://clientrestservice.herokuapp.com/api/client/

body json

{
    "id": 1,
    "nome": "Tony",
    "cpf": "111.111.111-11",
    "dataNascimento": "1984-09-20",
    "telefone": "(71) 99103-4267",
    "email": "tonysobreira@gmail.com",
    "logradouro": "Rua da Sinagoga, N 22",
    "cep": "40450-610",
    "bairro": "Uruguai",
    "complemento": "Térreo",
    "cidade": "Salvador",
    "estado": "Bahia"
}

Find a Client by cpf (GET)

https://clientrestservice.herokuapp.com/api/find-by-cpf/{cpf}


