package br.ufsc.cursofs.AulaSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufsc.cursofs.AulaSpringBoot.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
}
