/**
 * AITournament (Tanks 2D)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmailcom)
 */
package priv.dotjabber.tournament.tanks.control;

import priv.dotjabber.tournament.control.GameController;
import priv.dotjabber.tournament.player.PlayerType;
import priv.dotjabber.tournament.tanks.model.TanksMove;
import priv.dotjabber.tournament.tanks.model.TanksModel;
import priv.dotjabber.tournament.ui.GameResources;

public class TanksController extends GameController<TanksModel, TanksMove> {
	
	public TanksController() {
		model = new TanksModel();
	}
	
	@Override
	protected TanksMove movePlayerOne() {
		TanksMove move = playerOne.getMove(model);
		model.makeMove(PlayerType.PLAYER_ONE, move);
		
		return move;
	}
	
	@Override
	protected TanksMove movePlayerTwo() {
		TanksMove move = playerTwo.getMove(model);
		model.makeMove(PlayerType.PLAYER_TWO, move);
		
		return move;
	}

	@Override
	protected String getGameStatusMessage() {
		String result = null;
		switch(model.getResult()) {
			case PLAYER_ONE_WINS:
				result = GameResources.getResource(GameResources.MSG_RESULT_WINS, playerOne.getName());
			break;
			
			case PLAYER_TWO_WINS:
				result = GameResources.getResource(GameResources.MSG_RESULT_WINS, playerTwo.getName());
			break;
			
			case TIE:
				result = GameResources.getResource(GameResources.MSG_RESULT_TIE);
			break;
			
			default: 
				result = GameResources.getResource(GameResources.MSG_RESULT_INTERRUPTED);
			break;
		}
		
		return result;
	}
}
