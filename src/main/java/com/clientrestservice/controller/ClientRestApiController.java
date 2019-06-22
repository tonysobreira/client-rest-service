package com.clientrestservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.clientrestservice.model.Client;
import com.clientrestservice.service.ClientService;

//@CrossOrigin(origins = "https://clientsapp.herokuapp.com")
@CrossOrigin(origins = "*") // All origins
@RestController("clientRestController")
@RequestMapping("/api")
public class ClientRestApiController {

	public static final Logger logger = LoggerFactory.getLogger(ClientRestApiController.class);

	@Autowired
	private ClientService clientService;

	// Retrieve All Clients

	@RequestMapping(value = "/clients/", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<List<Client>> listAllClients() {
		List<Client> clientList = clientService.findAllClients();

		if (clientList.isEmpty()) {
			return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}

		return new ResponseEntity<List<Client>>(clientList, HttpStatus.OK);
	}

	// Retrieve Single Client

	@RequestMapping(value = "/client/{id}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<?> getClient(@PathVariable("id") Integer id) {
		logger.info("Fetching Client with id {}", id);

		Client client = clientService.findById(id);

		if (client == null) {
			logger.error("Client with id {} not found.", id);
			return new ResponseEntity("Client with id " + id + " not found.", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	// Create a Client

	@RequestMapping(value = "/client/", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<?> createClient(@RequestBody Client client, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Client : {}", client);

		Client c = clientService.findByCpf(client.getCpf());

		if (c != null) {
			logger.error("Unable to create. A Client with cpf {} already exist.", client.getCpf());

			return new ResponseEntity("Unable to create. A Client with cpf " + client.getCpf() + " already exist.",
					HttpStatus.CONFLICT);
		}

		Client createdClient = clientService.saveOrUpdate(client);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/client/{id}").buildAndExpand(client.getId()).toUri());

		return new ResponseEntity<Client>(createdClient, HttpStatus.CREATED);

	}

	// Update a Client

	@RequestMapping(value = "/client/{id}", //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateClient(@PathVariable("id") Integer id, @RequestBody Client client) {
		logger.info("Updating Client with id {}", id);

		Client c1 = clientService.findById(id);

		if (c1 == null) {
			logger.error("Unable to update. Client with id {} not found.", id);
			return new ResponseEntity("Unable to upate. Client with id " + id + " not found.", HttpStatus.NOT_FOUND);
		}

		Client c2 = clientService.findByCpf(c1.getCpf());

		if (c2 != null) {
			logger.error("Unable to create. A Client with cpf {} already exist.", client.getCpf());

			return new ResponseEntity("Unable to create. A Client with cpf " + client.getCpf() + " already exist.",
					HttpStatus.CONFLICT);
		}

		c1.setNome(client.getNome());
		c1.setCpf(client.getCpf());
		c1.setDataNascimento(client.getDataNascimento());
		c1.setTelefone(client.getTelefone());
		c1.setEmail(client.getEmail());
		c1.setLogradouro(client.getLogradouro());
		c1.setCep(client.getCep());
		c1.setBairro(client.getBairro());
		c1.setComplemento(client.getComplemento());
		c1.setCidade(client.getCidade());
		c1.setEstado(client.getEstado());

		Client updatedClient = clientService.saveOrUpdate(client);

		return new ResponseEntity<Client>(updatedClient, HttpStatus.OK);
	}

	// Delete a Client

	@RequestMapping(value = "/client/{id}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteClient(@PathVariable("id") Integer id) {
		logger.info("Fetching & Deleting Client with id {}", id);

		Client c = clientService.findById(id);

		if (c == null) {
			logger.error("Unable to delete. Client with id {} not found.", id);
			return new ResponseEntity("Unable to delete. Client with id " + id + " not found.", HttpStatus.NOT_FOUND);
		}

		clientService.deleteById(id);
		return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
	}

	// Delete a Client

	@RequestMapping(value = "/client/", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<?> delete(@RequestBody Client client) {
		logger.info("Fetching & Deleting Client {}", client);

		Client c = clientService.findById(client.getId());

		if (c == null) {
			logger.error("Unable to delete. Client {} not found.", client);
			return new ResponseEntity("Unable to delete. Client " + client + " not found.", HttpStatus.NOT_FOUND);
		}

		clientService.delete(client);
		return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
	}

	// Find a Client by cpf

	@RequestMapping(value = "/find-by-cpf/{cpf}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<?> findByCpf(@PathVariable("cpf") String cpf) {
		logger.info("Fetching Client with cpf {}", cpf);

		Client client = clientService.findByCpf(cpf);

		if (client == null) {
			logger.error("Client with cpf {} not found.", cpf);
			return new ResponseEntity("Client with cpf " + cpf + " not found.", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

}
