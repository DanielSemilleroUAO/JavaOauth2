package com.daniel.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daniel.entity.MovimientoBancario;

public interface MovimientoBancarioDao extends CrudRepository<MovimientoBancario, Long>{
	
	public List<MovimientoBancario> findByUserId(Long id);
	
}
