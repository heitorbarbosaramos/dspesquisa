package com.devsuperior.dspesquisa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dspesquisa.dto.GameDTO;
import com.devsuperior.dspesquisa.services.GameService;

@RestController
@RequestMapping(value = "/game")
public class GameResource {

	@Autowired
	private GameService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<GameDTO>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
}
