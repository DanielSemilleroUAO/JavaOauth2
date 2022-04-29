package com.daniel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.entity.MovimientoBancario;
import com.daniel.service.MovimientoBancarioService;

@RestController
@RequestMapping("/api/oauth2")
public class MovimientosBancariosController {

	@Autowired
	private MovimientoBancarioService movimientoBancarioService;
	
	@GetMapping("/movimientos")
	public ResponseEntity<?> movimientos(){
		List<MovimientoBancario> movimientoBancarios = movimientoBancarioService.findAll();
		return new ResponseEntity<>(movimientoBancarios, HttpStatus.OK);
	}
	
	@GetMapping("/movimientos/{id}")
	public ResponseEntity<?> movimientosByUser(@PathVariable("id") Long id){
		List<MovimientoBancario> movimientoBancarios = movimientoBancarioService.getMovimientoUser(id);
		if(movimientoBancarios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(movimientoBancarios, HttpStatus.OK);
	}
	
}
