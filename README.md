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
	"phone": "(71) 99103-4267", 
	"email": "tonysobreira@gmail.com", 
	"address": "Rua da Sinagoga, N 22", 
	"postalCode": "40450-610", 
	"neighborhood": "Uruguai", 
	"complement": "Térreo", 
	"city": "Salvador", 
	"state": "Bahia"
}

Update a Client (PUT)

body json

{ 
	"id": 1, 
	"name": "Tony", 
	"cpf": "111.111.111-11", 
	"birthDate": "1984-09-20", 
	"phone": "(71) 99103-4267", 
	"email": "tonysobreira@gmail.com", 
	"address": "Rua da Sinagoga, N 22...", 
	"postalCode": "40450-610", 
	"neighborhood": "Uruguai", 
	"complement": "Térreo", 
	"city": "Salvador", 
	"state": "Bahia"
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
	"phone": "(71) 99103-4267", 
	"email": "tonysobreira@gmail.com", 
	"address": "Rua da Sinagoga, N 22", 
	"postalCode": "40450-610", 
	"neighborhood": "Uruguai", 
	"complement": "Térreo", 
	"city": "Salvador", 
	"state": "Bahia"
}

Find a Client by cpf (GET)

https://clientrestservice.herokuapp.com/api/find-by-cpf/{cpf}


