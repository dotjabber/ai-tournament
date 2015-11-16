/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.player;

/**
 * Very generic class of Player. Actually it has nothing... it declares only what 
 * a player can do.
 * @author Maciej Kowalski
 *
 * @param <M>
 * @param <R>
 */
public abstract class Player<M, R> {
	private PlayerType type;
	
	/**
	 * Method which will be used by player himself, to figgure out
	 * 'which checkers are mine' on game board :)
	 * @return
	 */
	public PlayerType getType() {
		return type;
	}

	/**
	 * Method used by GameController for assigning 'player one' or 'player two'
	 * label to a player.S
	 * @param playerType
	 */
	public void setType(PlayerType playerType) {
		type = playerType;
	}
	
	/**
	 * The most important method for player. For given game model (acual state of the game)
	 * it should return the next move.
	 * @param model
	 * @return
	 */
	public abstract R getMove(M model);

	/**
	 * You can name your player :) String returned here will be displayed in UI field 
	 * and will represent the player.
	 * @return
	 */
	public abstract String getName();

	/**
	 * Give us an email, so we can contact you, if your player wins :)
	 * @return
	 */
	public abstract String getEmail();

	/**
	 * Give us the game name you want to take part in.
	 * @return
	 */
	public abstract String getGameName();
}
