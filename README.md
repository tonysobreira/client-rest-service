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
	"name": "Tony", 
	"cpf": "111.111.111-11", 
	"birthDate": "1984-09-20", 
	"phone": "(71) 99999-9999", 
	"email": "tonysobreira@gmail.com", 
	"address": "Rua XXX, N X", 
	"postalCode": "40000-000", 
	"neighborhood": "Bairro XXX", 
	"complement": "Complemento XXX", 
	"city": "Cidade XXX", 
	"state": "Estado XXX"
}

Update a Client (PUT)

body json

{ 
	"id": 1, 
	"name": "Tony", 
	"cpf": "111.111.111-11", 
	"birthDate": "1984-09-20", 
	"phone": "(71) 99999-9999", 
	"email": "tonysobreira@gmail.com", 
	"address": "Rua XXX, N XX", 
	"postalCode": "40000-000", 
	"neighborhood": "Bairro XXX", 
	"complement": "Complemento XXX", 
	"city": "Cidade XXX", 
	"state": "Estado XXX"
}

Delete one Client (DELETE)

https://clientrestservice.herokuapp.com/api/client/{id}

Delete one Client (DELETE)

https://clientrestservice.herokuapp.com/api/client/

body json

{ 
	"id": 1, 
	"name": "Tony", 
	"cpf": "111.111.111-11", 
	"birthDate": "1984-09-20", 
	"phone": "(71) 99999-9999", 
	"email": "tonysobreira@gmail.com", 
	"address": "Rua XXX, N X", 
	"postalCode": "40000-000", 
	"neighborhood": "Bairro XXX", 
	"complement": "Complemento XXX", 
	"city": "Cidade XXX", 
	"state": "Estado XXX"
}

Find a Client by cpf (GET)

https://clientrestservice.herokuapp.com/api/find-by-cpf/{cpf}


