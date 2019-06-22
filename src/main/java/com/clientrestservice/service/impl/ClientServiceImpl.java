package com.clientrestservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientrestservice.model.Client;
import com.clientrestservice.repository.ClientRepository;
import com.clientrestservice.service.ClientService;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Client> findAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public Client saveOrUpdate(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client findById(Integer id) {
		Optional<Client> optionalClient = clientRepository.findById(id);

		if (optionalClient.isPresent()) {
			return optionalClient.get();
		} else {
			return null;
		}

	}

	@Override
	public void deleteById(Integer id) {
		clientRepository.deleteById(id);
	}

	@Override
	public void delete(Client client) {
		clientRepository.delete(client);
	}

	@Override
	public Client findByCpf(String cpf) {
		return clientRepository.findByCpf(cpf);
	}

}
