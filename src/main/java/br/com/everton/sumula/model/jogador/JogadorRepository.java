package br.com.everton.sumula.model.jogador;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de jogadores
 */
@Repository
public interface JogadorRepository  extends CrudRepository<Jogador, InscricaoCBF> {
}
