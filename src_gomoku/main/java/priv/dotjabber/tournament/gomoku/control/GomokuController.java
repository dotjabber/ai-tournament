/**
 * AITournament (Gomoku 2D)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmailcom)
 */
package priv.dotjabber.tournament.gomoku.control;

import java.awt.Point;

import priv.dotjabber.tournament.control.GameController;
import priv.dotjabber.tournament.gomoku.model.GomokuModel;
import priv.dotjabber.tournament.player.PlayerType;
import priv.dotjabber.tournament.ui.GameResources;

public class GomokuController extends GameController<GomokuModel, Point> {
	
	public GomokuController() {
		model = new GomokuModel();
	}
	
	@Override
	protected Point movePlayerOne() {
		Point response = playerOne.getMove(model);
		model.makeMove(PlayerType.PLAYER_ONE, response);
		
		return response;
	}
	
	@Override
	protected Point movePlayerTwo() {
		Point response = playerTwo.getMove(model);
		model.makeMove(PlayerType.PLAYER_TWO, response);
		
		return response;
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
