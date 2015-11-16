/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament;

import javax.swing.WindowConstants;

import priv.dotjabber.tournament.ui.FramePanel;

/**
 * Everything starts here! 
 * @author Maciej Kowalski
 * @version 1.0
 */
public class AITournament {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	
	public static void main(String[] args) {
		FramePanel gamePanel = new FramePanel();
		
		gamePanel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		gamePanel.setSize(WIDTH, HEIGHT);
		gamePanel.setResizable(false);
		gamePanel.setVisible(true);
	}
}
