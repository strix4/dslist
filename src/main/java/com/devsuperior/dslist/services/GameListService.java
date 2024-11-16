package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;


// @Component ou @Service
@Service
public class GameListService {
	
//	Objeto gameRepository instânciado para realizar a busca no repositório
//	usando findById da classe GameRepository
	@Autowired
	private GameListRepository gameListRepository;
	
	// Realiza uma busca no banco de dados e retorna em forma de lista
	// utilizando a instância do repositorio gameRepository com a função findAll 'buscar todos'
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
}
