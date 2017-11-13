package com.controleconta.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.controleconta.model.Conta;
/**
 * Interface de serviço
 * @author Thiago Henrique Carvalho Prudente
 *
 */
public interface ContaService {
	
	Conta findById(Long id);
	
	void saveConta(Conta conta);
	
	void deleteContaById(Long id);
	
	List<Conta> findAllContas();
}
