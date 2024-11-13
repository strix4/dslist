package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

// @Component ou @Service
@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	// Realiza uma busca no banco de dados e retorna em forma de lista
	// utilizando a instância do repositorio gameRepository com a função findAll 'buscar todos'
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
