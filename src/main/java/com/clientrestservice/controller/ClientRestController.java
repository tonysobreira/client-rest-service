package com.clientrestservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.clientrestservice.model.Client;
import com.clientrestservice.service.ClientService;

//@CrossOrigin(origins = "https://clientsapp.herokuapp.com")
@CrossOrigin(origins = "*") // All origins
@RestController("clientRestController")
public class ClientRestController {

	@Autowired
	private ClientService clientService;

	@RequestMapping(value = "/clients", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Client> findAll() {
		List<Client> list = clientService.findAll();
		return list;
	}

	@RequestMapping(value = "/client", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Client addClient(@RequestBody Client client) {
		return clientService.saveOrUpdate(client);
	}

	@RequestMapping(value = "/client", //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Client update(@RequestBody Client client) {
		return clientService.saveOrUpdate(client);
	}

	@RequestMapping(value = "/client/{id}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Client getById(@PathVariable("id") Integer id) {
		Client client = clientService.getById(id);
		return client;
	}

	@RequestMapping(value = "/delete/{id}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void deleteById(@PathVariable("id") Integer id) {
		clientService.deleteById(id);
	}

	@RequestMapping(value = "/delete", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void delete(@RequestBody Client client) {
		clientService.delete(client);
	}

	@RequestMapping(value = "/findByCpf/{cpf}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Client findByCpf(@PathVariable("cpf") String cpf) {
		return clientService.findByCpf(cpf);
	}

}
