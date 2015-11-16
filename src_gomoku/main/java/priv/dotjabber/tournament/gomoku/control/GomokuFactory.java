/**
 * AITournament (Gomoku 2D)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmailcom)
 */
package priv.dotjabber.tournament.gomoku.control;

import java.awt.Color;
import java.awt.Point;

import priv.dotjabber.tournament.control.GameController;
import priv.dotjabber.tournament.control.GameFactory;
import priv.dotjabber.tournament.gomoku.model.GomokuModel;
import priv.dotjabber.tournament.gomoku.ui.Goban;
import priv.dotjabber.tournament.gomoku.ui.GomokuResources;
import priv.dotjabber.tournament.player.PlayerType;
import priv.dotjabber.tournament.ui.GameBoard;

public class GomokuFactory extends GameFactory<GomokuModel, Point> {

	@Override
	public GameController<GomokuModel, Point> getController() {
		if(controller == null) {
			controller = new GomokuController();
		}
		
		return controller;
	}

	@Override
	public Color getPlayerColor(PlayerType type) {
		switch(type) {
			case PLAYER_ONE: 
				return GomokuResources.GOBAN_PLAYER_ONE_COLOR;
				
			case PLAYER_TWO: 
				return GomokuResources.GOBAN_PLAYER_TWO_COLOR;
		}
		return null;
	}

	@Override
	public GameBoard<GomokuModel> getGameBoard() {
		if(gameBoard == null) {
			gameBoard = new Goban(getController().getModel());
		}
		return gameBoard;
	}
}
