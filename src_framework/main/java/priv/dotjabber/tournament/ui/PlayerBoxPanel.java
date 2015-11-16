/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import priv.dotjabber.tournament.control.GameFactory;
import priv.dotjabber.tournament.player.PlayerType;

public class PlayerBoxPanel extends BoxPanel {
	private static final long serialVersionUID = -8199985828036603617L;

	private PlayerType playerType;
	
	public PlayerBoxPanel(PlayerType type) {
		if(type == PlayerType.PLAYER_ONE) {
			setBackground(GameResources.PLAYER_ONE_BG_COLOR);
			
		} else if(type == PlayerType.PLAYER_TWO) {
			setBackground(GameResources.PLAYER_TWO_BG_COLOR);
		}
		
		playerType = type;
		setPreferredSize(new Dimension(GameResources.PLAYER_PANEL_WIDTH, GameResources.PLAYER_PANEL_HEIGHT));
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		FontMetrics metrics = g.getFontMetrics(GameResources.PLAYER_FONT);
		
		if(getText() != null) {
			Color playerColor = GameFactory.getDefault().getPlayerColor(playerType);
			
			g.setColor(playerColor);
			g.setFont(GameResources.PLAYER_FONT);
			
			Rectangle2D rectangle = metrics.getStringBounds(getText(), g);
			int textHeight = (int)(rectangle.getHeight()); 
			int textWidth = (int)(rectangle.getWidth());

			int x = (getWidth() - textWidth)  / 2;
			int y = (getHeight() - textHeight) / 2  + metrics.getAscent();

			g.drawString(getText(), x, y);
		}
	}
}
