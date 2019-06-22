package com.clientrestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clientrestservice.model.Client;

@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client, Integer> {

	Client findByCpf(String cpf);

}
