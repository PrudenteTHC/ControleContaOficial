package com.controleconta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controleconta.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{
}
