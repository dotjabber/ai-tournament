/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.ui;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import java.text.MessageFormat;

public class GameResources {
	
	//
	public static final Font FRAME_FONT = new Font("Tahoma", Font.PLAIN, 11);
	public static final int FRAME_BORDER_MARGIN = 7;
	
	//
	public static final int GAME_DELAY = 100;
	
	//
	public static final Color PLAYER_ONE_BG_COLOR = new Color(210, 0, 0);
	public static final Color PLAYER_TWO_BG_COLOR = new Color(210, 0, 0);
	
	//
	public static final int PLAYER_PANEL_HEIGHT = 80;
	public static final int PLAYER_PANEL_WIDTH = 150;
	public static final Font PLAYER_FONT = new Font("Tahoma", Font.BOLD, 18);
	
	//
	public static final Color INFO_BG_COLOR = Color.RED;
	public static final Color INFO_COLOR = Color.YELLOW;
	public static final Font INFO_FONT = new Font("Tahoma", Font.BOLD, 18);
	public static final int INFO_PANEL_HEIGHT = 80;
	public static final int INFO_PANEL_WIDTH = 200;
	
	//
	public static final String CAPTION_MAIN = "<{0}> brought to you by ACME!";
	public static final String CAPTION_PLAER_CHOOSER = "Choose {0}...";
	
	//
	public static final String MENU_FILE = "File";
	public static final String MENU_GAME = "Game";
	public static final String MENU_ABOUT = "About";
	
	//
	public static final String SUBMENU_EXIT = "Exit";
	public static final String SUBMENU_RECORD = "Record Game";
	public static final String SUBMENU_SET_PLAYER = "Choose {0}";
	public static final String SUBMENU_START_PLAY = "Start Game";
	public static final String SUBMENU_STOP_PLAY = "End Game";
	public static final String SUBMENU_CLEAR_BOARD = "Clear Game Board";
	public static final String SUBMENU_RESET_BOARD = "Reset Game Board";
	public static final String SUBMENU_ABOUT = "About...";
	
	//
	public static final String MSG_ABOUT_GAMER = "AITournament brought to you by ACME!";
	
	//
	public static final String CAPTION_PLAYER_SELECT = "Select a Player...";
	public static final String MSG_PLAYER_SELECT = "Select {0}:";
	
	//
	public static final String MSG_RESULT_TIE = "Tie!";
	public static final String MSG_RESULT_WINS = "{0} Wins!";
	public static final String MSG_RESULT_INTERRUPTED = "Game Interrupted!";
	
	//
	public static final URL ICON_EXIT = GameResources.class.getResource("icons/ICON_EXIT.PNG");
	public static final URL ICON_INFO = GameResources.class.getResource("icons/ICON_INFO.PNG");
	public static final URL ICON_NEW_GAME = GameResources.class.getResource("icons/ICON_NEW_GAME.PNG");
	public static final URL ICON_NEW_PLAYER = GameResources.class.getResource("icons/ICON_NEW_PLAYER.PNG");
	public static final URL ICON_RESET_GAME = GameResources.class.getResource("icons/ICON_RESET_GAME.PNG");
	public static final URL ICON_CLEAR_GAME = GameResources.class.getResource("icons/ICON_CLEAR_GAME.PNG");
	public static final URL ICON_START = GameResources.class.getResource("icons/ICON_START.PNG");
	public static final URL ICON_STOP = GameResources.class.getResource("icons/ICON_STOP.PNG");
	public static final URL ICON_RECORD_GAME = GameResources.class.getResource("icons/ICON_RECORD_GAME.PNG");
	
	//
	public static String getResource(String message, Object... params) {
		return MessageFormat.format(message, params);
	}
}
