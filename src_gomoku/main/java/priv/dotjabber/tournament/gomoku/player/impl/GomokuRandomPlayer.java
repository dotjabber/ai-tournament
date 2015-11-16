/**
 * AITournament (Gomoku 2D)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmailcom)
 */
package priv.dotjabber.tournament.gomoku.player.impl;

import java.awt.Point;
import java.util.Random;

import priv.dotjabber.tournament.gomoku.model.GomokuModel;
import priv.dotjabber.tournament.gomoku.player.GomokuPlayer;

public class GomokuRandomPlayer extends GomokuPlayer {
	private static boolean option;

	private Random rand;
	private String name;

	public GomokuRandomPlayer() {
		rand = new Random();

		if(option) {
			name = "Marusia";
			option = !option;

		} else {
			name = "Lidka";
			option = !option;
		}
	}

	@Override
	public Point getMove(GomokuModel model) {
		int width = model.getData().length;
		int height = model.getData()[0].length;

		int i = rand.nextInt(width);
		int j = rand.nextInt(height);

		while(model.getData()[i][j] != null) {
			i = rand.nextInt(width);
			j = rand.nextInt(height);
		}

		return new Point(i, j);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getEmail() {
		return "dotjabber@gmail.com";
	}
}
