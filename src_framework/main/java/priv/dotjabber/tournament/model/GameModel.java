/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.model;

import java.util.Observable;

import priv.dotjabber.tournament.player.PlayerType;

/**
 * GameModel is representation of data which give information of players, terrain
 * and game status. For example in tic-tac-toe game, it will be 2d array with 
 * information where players made their moves.
 * @author Maciej Kowalski
 * @version 1.0
 *
 * @param <M>
 * @param <R>
 */
public abstract class GameModel<M, R> extends Observable {
	
	/**
	 * Place holder for data model. What the data model's type ism it depends
	 * on a specific game implementation.
	 */
	protected M modelData;
	
	/**
	 * Getter for model data.
	 * @return
	 */
	public abstract M getData();
	
	/**
	 * Game can be renewed, which means that clear data model is needed. GameModel must
	 * implement the way how it is generated. It can be done by using randomness or 
	 * by simply reading the whole data model from file. It is up to you :)
	 */
	public abstract void resetModel();

	/**
	 * Each player makes a move. It means that player by performing a move, returns an 
	 * object (player move) which is applied to model (and alters it at some point).
	 * @param type
	 * @param playerResponse
	 * @return
	 */
	public abstract MoveValidity makeMove(PlayerType type, R playerResponse);

	/**
	 * It is up to the game model to figgure out who is the game winner (or weather
	 * there is game tie).
	 * @return
	 */
	public abstract GameResult getResult();

}
