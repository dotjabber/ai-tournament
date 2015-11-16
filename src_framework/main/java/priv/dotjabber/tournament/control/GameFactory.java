/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.control;

import java.awt.Color;

import priv.dotjabber.tournament.model.GameModel;
import priv.dotjabber.tournament.player.PlayerType;
import priv.dotjabber.tournament.ui.BoxPanel;
import priv.dotjabber.tournament.ui.GameBoard;
import priv.dotjabber.tournament.ui.GameBoxPanel;
import priv.dotjabber.tournament.ui.PlayerBoxPanel;
import priv.dotjabber.tournament.utils.ClassUtil;
import priv.dotjabber.tournament.utils.ConfigUtil;

/**
 * GameFactory class is focal point in AITournament architecture for UI
 * and GameController. Class provides a way for Controllers to display messages
 * on the UI and to read user options (for example checking if the game is 
 * recorded or not).
 * @author Maciej Kowalski
 * @version 1.0
 *
 * @param <M>
 * @param <R>
 */
public abstract class GameFactory<M extends GameModel<?, ?>, R> {
	private static GameFactory<?, ?> factory;
	private boolean recordedGame;
	
	/**
	 * UI field for storing player's one name.
	 */
	protected BoxPanel playerOnePanel;
	
	/**
	 * UI field for storing player's two name.
	 */
	protected BoxPanel playerTwoPanel;
	
	/**
	 * UI field for storing game result (which comes from game controller).
	 */
	protected BoxPanel infoPanel;
	
	/**
	 * GameBoard is another UI component which represent the game board or 
	 * graphical representation of the game model.
	 */
	protected GameBoard<M> gameBoard;
	
	/**
	 * Place holder for game controller, which is created by specific implementation
	 * of GameFactory.
	 */
	protected GameController<M, R> controller;
	
	/**
	 * Method returns GameFactory by looking into configuration and creating 
	 * an instance of GameFactory specific class.
	 * @return
	 */
	public static GameFactory<?, ?> getDefault() {
		if(factory == null) {
			String className = ConfigUtil.getGameFactoryName();
			factory = ClassUtil.getGameFactory(className);
		}
		
		return factory;
	}

	public static GameFactory<?, ?> get(String key) {
		String className = ConfigUtil.getGameFactoryName(key);
		return ClassUtil.getGameFactory(className);
	}
	
	/**
	 * Method returns UI field for given player.
	 * @param type
	 * @return
	 */
	public final BoxPanel getPlayerPanel(PlayerType type) {
		BoxPanel tempInfoPanel = null;
		
		switch(type) {
			case PLAYER_ONE:
				playerOnePanel = (playerOnePanel == null) ? new PlayerBoxPanel(type) : playerOnePanel;
				tempInfoPanel = playerOnePanel;
			break;
		
			case PLAYER_TWO:
				playerTwoPanel = (playerTwoPanel == null) ? new PlayerBoxPanel(type) : playerTwoPanel;
				tempInfoPanel = playerTwoPanel;
			break;
		}
	
		return tempInfoPanel;
	}

	/**
	 * Method returns UI field for game status.
	 * @return
	 */
	public final BoxPanel getInfoPanel() {
		if(infoPanel == null) {
			infoPanel = new GameBoxPanel();
		}
		return infoPanel;
	}
	

	public void setGameRecorded(boolean recorded) {
		recordedGame = recorded;
	}
	
	public boolean isGameRecorded() {
		return recordedGame;
	}
	
	/**
	 * Method for creating and retrieving GameController. It should be implemented as 
	 * lazy initiator.
	 * @return
	 */
	public abstract GameController<?, ?> getController();

	/**
	 * Player colors are very important weather there is a checkers game implemented
	 * and color of the checkers used should match player colors. This method is used
	 * mostly for UI purposes and should be implemented by specific GameFactory. 
	 * @param type
	 * @return
	 */
	public abstract Color getPlayerColor(PlayerType type);
	
	/**
	 * Method creates and retrieves GameBoard (an UI component). It should be implemented as 
	 * lazy initiator.
	 * @return
	 */
	public abstract GameBoard<M> getGameBoard();
}
