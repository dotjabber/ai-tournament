/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.record;

import priv.dotjabber.tournament.player.PlayerType;

/**
 * Game recorder is class which is used to store the game history inside file.
 * What the file format should be, where should it be stored - it is up to the 
 * implementation.
 * @author Maciej Kowalski
 * @version 1.0
 *
 */
public abstract class Recorder {
	
	/**
	 * Method should log player movement.
	 * @param player
	 * @param playerMove
	 */
	public abstract void addMove(PlayerType player, Object playerMove);
	
	/**
	 * Method should log the player himself (usually at the beginning of the game, 
	 * by saying that 'this is CONNAN and he will play as 'player one').
	 * @param player
	 * @param playerName
	 */
	public abstract void addPlayer(PlayerType player, String playerName);
	
	/**
	 * At the very end of the game, we might store the game result to the log file,
	 * just to avoid tracking the game step by step.
	 * @param result
	 */
	public abstract void setResult(String result);
}
