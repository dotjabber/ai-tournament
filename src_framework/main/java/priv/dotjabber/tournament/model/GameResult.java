/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.model;

/**
 * Basically there could be several game results, depending on the game
 * itself or the game configuration.
 * @author Maciej Kowalski
 * @version 1.0
 *
 */
public enum GameResult {
	
	/**
	 * This is pretty obvious :)
	 */
	PLAYER_ONE_WINS,
	
	/**
	 * This one too ;)
	 */
	PLAYER_TWO_WINS,
	
	/**
	 * There is no winner, GameModel should return this value.
	 */
	TIE,
	
	/**
	 * Game is still ongoing - there is no winner and game can be continued.
	 */
	GAME_ONGOING,
	
	/**
	 * Maybe player is missing, who knows :)
	 */
	SETUP_INCOMPLETE
}
