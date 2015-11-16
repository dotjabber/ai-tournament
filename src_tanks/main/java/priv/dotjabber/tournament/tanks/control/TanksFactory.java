/**
 * AITournament (Tanks 2D)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmailcom)
 */
package priv.dotjabber.tournament.tanks.control;

import java.awt.Color;

import priv.dotjabber.tournament.control.GameController;
import priv.dotjabber.tournament.control.GameFactory;
import priv.dotjabber.tournament.player.PlayerType;
import priv.dotjabber.tournament.tanks.model.TanksMove;
import priv.dotjabber.tournament.tanks.model.TanksModel;
import priv.dotjabber.tournament.tanks.ui.Polygon;
import priv.dotjabber.tournament.ui.GameBoard;
import priv.dotjabber.tournament.tanks.ui.TanksResources;

public class TanksFactory extends GameFactory<TanksModel, TanksMove> {

	@Override
	public GameController<TanksModel, TanksMove> getController() {
		if(controller == null) {
			controller = new TanksController();
		}
		
		return controller;
	}

	@Override
	public Color getPlayerColor(PlayerType type) {
		switch(type) {
			case PLAYER_ONE: 
				return TanksResources.TANKS_PLAYER_ONE_COLOR;
				
			case PLAYER_TWO: 
				return TanksResources.TANKS_PLAYER_TWO_COLOR;
		}
		return null;
	}

	@Override
	public GameBoard<TanksModel> getGameBoard() {
		if(gameBoard == null) {
			gameBoard = new Polygon(getController().getModel());
		}
		return gameBoard;
	}
}
