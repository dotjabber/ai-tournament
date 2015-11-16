/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.control;

import java.util.logging.Logger;

import priv.dotjabber.tournament.model.GameModel;
import priv.dotjabber.tournament.model.GameResult;
import priv.dotjabber.tournament.player.Player;
import priv.dotjabber.tournament.player.PlayerType;
import priv.dotjabber.tournament.record.RecorderFactory;
import priv.dotjabber.tournament.record.Recorder;
import priv.dotjabber.tournament.utils.ConfigUtil;

import static priv.dotjabber.tournament.ui.GameResources.GAME_DELAY;

/**
 * GameController is class which main function is to be an arbiter of the game (this includes
 * storing players references, data model upon which the game is played). Specific game will have
 * it's own implementation, which should specify the 'movement' methods of players and the game
 * status.
 * @author Maciej Kowalski
 * @version 1.0
 *
 * @param <M> extends GameModel<?, ?>
 * @param <R>
 */
public abstract class GameController<M extends GameModel<?, ?>, R> {
	private final static Logger LOG = Logger.getLogger(GameController.class.getName());
	private final static int STEP_LIMIT = ConfigUtil.getStepLimit();

	private boolean gameThreadFlag;
	
	protected Player<M, R> playerOne;
	protected Player<M, R> playerTwo;
	protected M model;

	protected GameResult gameResult;
	protected Recorder recorder;
	
	/**
	 * Whenever user clicks 'start game', this thread is executed. It creates game recorder
	 * and executes players alternately.
	 */
	public synchronized void startGame() {
		
		// create recorder (if the game is recorded and if factory provides a recorder);
		if(GameFactory.getDefault().isGameRecorded()) {
			try {
				recorder = RecorderFactory.getRecorder();
				
			} catch (Exception e) {
				LOG.warning(e.getMessage());
			}
		}
		
		if(recorder != null) recorder.addPlayer(playerOne.getType(), playerOne.getName());
		if(recorder != null) recorder.addPlayer(playerTwo.getType(), playerTwo.getName());

		Thread gameThread = new Thread() {

			@Override
			public void run() {

				// the game won't start until both players are selected;
				gameThreadFlag = (playerOne != null && playerTwo != null);

				// by default there is 500 steps to make a win/lose
				// otherwise there is a tie;
				int stepCount = 0;

				while (gameThreadFlag && ++stepCount < STEP_LIMIT) {

					// there are different games, some of them base on random model (or game field)
					// so it may happen that even before any move is made, there is a winner, if 
					// there is a winner, break the 'while' loop;
					gameResult = getModel().getResult();
					if (gameResult != GameResult.GAME_ONGOING) break;

					// make a move with player 1
					R playerOneMove = movePlayerOne();

					try {
						if (recorder != null) recorder.addMove(playerOne.getType(), playerOneMove);
						Thread.sleep(GAME_DELAY);

					} catch (Exception e) {
						LOG.warning(e.getMessage());
					}

					// check the game result after player 1 move, if there is a winner, break the
					// 'while' loop;
					gameResult = getModel().getResult();
					if (gameResult != GameResult.GAME_ONGOING) break;

					// make a move with player 2
					R playerTwoMove = movePlayerTwo();

					try {
						if (recorder != null) recorder.addMove(playerTwo.getType(), playerTwoMove);
						Thread.sleep(GAME_DELAY);

					} catch (Exception e) {
						LOG.warning(e.getMessage());
					}
				}

				if(gameResult == null || gameResult == GameResult.GAME_ONGOING) {
					gameResult = GameResult.TIE;
				}

				// at the end of the game, set the result on the screen;
				String gameMessage = getGameStatusMessage();
				GameFactory.getDefault().getInfoPanel().setText(gameMessage);

				if (recorder != null) recorder.setResult(gameMessage);

				// inform others that the competition ended
				synchronized (GameController.this) {
					GameController.this.notifyAll();
				}
			}
		};
		
		gameThread.start();
	}
	
	/**
	 * At any point of the tournament, the game can be stopped, by switching the 
	 * game thread flag. This will automatically result the game thread to end.
	 */
	public synchronized void stopGame() {
		gameThreadFlag = false;
	}
	
	/**
	 * Clearing a game is an action which resets the game model, clears both player
	 * references and clears all text messages previously displayed on the screen.
	 */
	public void clearGame() {
		model.resetModel();
		
		playerOne = null;
		playerTwo = null;
		
		GameFactory.getDefault().getPlayerPanel(PlayerType.PLAYER_ONE).setText(null);
		GameFactory.getDefault().getPlayerPanel(PlayerType.PLAYER_TWO).setText(null);
		GameFactory.getDefault().getInfoPanel().setText(null);
	}

	/**
	 * Reseting the game means that the game model will be regenerated and all the messages
	 * previously displayed on the screen will be erased. Players are left as is so another round
	 * can be run.
	 */
	public void resetGame() {
		GameFactory.getDefault().getInfoPanel().setText(null);
		model.resetModel();
	}

	public void setPlayer(PlayerType type, Player<M, R> player) {
		player.setType(type);
		
		switch(type) {
			case PLAYER_ONE: playerOne = player;
			break;
			
			case PLAYER_TWO: playerTwo = player;
			break;
		}
		
		String playerName = player.getName();
		GameFactory.getDefault().getPlayerPanel(type).setText(playerName);
	}

	public GameResult getGameResult() {
		return gameResult;
	}

	/**
	 * Method returns game model stored by game arbiter.
	 * @return
	 */
	public M getModel() {
		return model;
	}
	
	/**
	 * Method, which implementation will perform the move of player 1.
	 * @return <R> player's move represented by an object (dependent on model used).
	 */
	protected abstract R movePlayerOne();
	
	/**
	 * Method, which implementation will perform the move of player 2.
	 * @return <R> player's move represented by an object (dependent on model used).
	 */
	protected abstract R movePlayerTwo();
	
	/**
	 * Based on game status, this method should return a real message
	 * which can be displayed on the screen as game status.
	 * @return
	 */
	protected abstract String getGameStatusMessage();
}
