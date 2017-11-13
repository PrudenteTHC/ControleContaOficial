package com.controleconta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controleconta.model.Conta;
import com.controleconta.repo.ContaRepository;

/**
 * Implementação da interface de serviço
 * @author Thiago Henrique Carvalho Prudente
 *
 */
@Service("ContaService")
@Transactional
public class ContaServiceImpl implements ContaService{
	
	@Autowired
	private ContaRepository contaRepository;
	
	public Conta findById(Long id) {
		return contaRepository.findOne(id);
	}

	public void saveConta(Conta conta) {
		contaRepository.save(conta);
		
	}

	public void deleteContaById(Long id) {
		contaRepository.delete(id);
	}

	public List<Conta> findAllContas() {
		return contaRepository.findAll();
	}

}
