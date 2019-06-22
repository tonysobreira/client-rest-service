package com.clientrestservice.service;

import java.util.List;

import com.clientrestservice.model.Client;

public interface ClientService {

	public List<Client> findAll();

	public Client saveOrUpdate(Client data);

	public Client getById(Integer id);

	public void deleteById(Integer id);

	public void delete(Client data);

	public Client findByCpf(String cpf);

}
