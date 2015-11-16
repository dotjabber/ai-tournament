/**
 * AITournament (Gomoku 2D)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmailcom)
 */
package priv.dotjabber.tournament.gomoku.ui;

import java.awt.Color;

public class GomokuResources {
	public static final Color GOMOKU_COLOR = new Color(163, 111, 15);

	public static final int GOMOKU_SIZE = 19;
	public static final int GOMOKU_PATTERN_SIZE = 5;
	
	public static final int GOBAN_FIELD_WIDTH = 18;
	public static final int GOBAN_FIELD_HEIGHT = 18;
	public static final int GOBAN_FIELD_MARGIN = 3;
	public static final int GOBAN_WIDTH = (GOBAN_FIELD_WIDTH + GOBAN_FIELD_MARGIN) * GOMOKU_SIZE + GOBAN_FIELD_MARGIN; 
	public static final int GOBAN_HEIGHT = (GOBAN_FIELD_HEIGHT + GOBAN_FIELD_MARGIN) * GOMOKU_SIZE + GOBAN_FIELD_MARGIN; 
	
	public static final Color GOBAN_PLAYER_ONE_COLOR = new Color(0, 0, 0);
	public static final Color GOBAN_PLAYER_TWO_COLOR = new Color(255, 255, 255);
}
