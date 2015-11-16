/**
 * AITournament (Gomoku 2D)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmailcom)
 */
package priv.dotjabber.tournament.gomoku.ui;

import java.awt.Graphics;

import javax.swing.JPanel;

import priv.dotjabber.tournament.control.GameFactory;
import priv.dotjabber.tournament.player.PlayerType;

import static priv.dotjabber.tournament.gomoku.ui.GomokuResources.GOMOKU_COLOR;

public class GobanField extends JPanel {
	private static final long serialVersionUID = 6400079414006804961L;
	
	private PlayerType playerType;

	public GobanField() {
		setBackground(GOMOKU_COLOR);
	}
	
	public void mark(PlayerType type) {
		playerType = type;
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		if(playerType != null) {
			g.setColor(GameFactory.getDefault().getPlayerColor(playerType));
			g.fillOval(1, 1, getWidth() - 2, getHeight() - 2);
		}
	}
}
