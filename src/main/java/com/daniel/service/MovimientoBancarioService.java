package com.daniel.service;

import java.util.List;

import com.daniel.entity.MovimientoBancario;
import com.daniel.entity.User;

public interface MovimientoBancarioService {
	
	public List<MovimientoBancario> findAll();
	
	public void save(MovimientoBancario movimientoBancario);
	
	public List<MovimientoBancario> getMovimientoUser(Long id);
	
}
