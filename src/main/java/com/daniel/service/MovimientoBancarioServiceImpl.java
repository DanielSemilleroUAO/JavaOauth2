package com.daniel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.dao.MovimientoBancarioDao;
import com.daniel.entity.MovimientoBancario;
import com.daniel.entity.User;

@Service
public class MovimientoBancarioServiceImpl implements MovimientoBancarioService {
	
	@Autowired
	private MovimientoBancarioDao movimientoBancarioDao;

	@Override
	@Transactional(readOnly = true)
	public List<MovimientoBancario> findAll() {
		// TODO Auto-generated method stub
		return (List<MovimientoBancario>) movimientoBancarioDao.findAll();
	}

	@Override
	@Transactional
	public void save(MovimientoBancario movimientoBancario) {
		// TODO Auto-generated method stub
		movimientoBancarioDao.save(movimientoBancario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MovimientoBancario> getMovimientoUser(Long id) {
		// TODO Auto-generated method stub
		return movimientoBancarioDao.findByUserId(id);
	}

}
