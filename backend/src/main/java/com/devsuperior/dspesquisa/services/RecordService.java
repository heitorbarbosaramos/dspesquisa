package com.devsuperior.dspesquisa.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dspesquisa.dto.RecordDTO;
import com.devsuperior.dspesquisa.dto.RecordInsertDTO;
import com.devsuperior.dspesquisa.entity.Game;
import com.devsuperior.dspesquisa.entity.Record;
import com.devsuperior.dspesquisa.repositories.GameRepository;
import com.devsuperior.dspesquisa.repositories.RecordRepository;

@Service
public class RecordService {

	@Autowired
	private RecordRepository reporisoty;
	@Autowired
	private GameRepository gameRepository; 
	
	@Transactional
	public RecordDTO insert (RecordInsertDTO dto) {
		Record entity = new Record();
		entity.setAge(dto.getAge());
		entity.setMoment(Instant.now());
		entity.setName(dto.getName());
		
		Game game = gameRepository.getOne(dto.getGameId());
		entity.setGame(game);

		return new RecordDTO(reporisoty.save(entity));
	}
}