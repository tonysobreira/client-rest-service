package com.clientrestservice.service;

import java.util.List;

import com.clientrestservice.model.Client;

public interface ClientService {

	public List<Client> findAllClients();

	public Client findById(Integer id);

	public Client saveOrUpdate(Client data);

	public void deleteById(Integer id);

	public void delete(Client data);

	public Client findByCpf(String cpf);

}
