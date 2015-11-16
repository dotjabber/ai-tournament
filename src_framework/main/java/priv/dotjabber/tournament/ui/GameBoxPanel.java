/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.ui;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class GameBoxPanel extends BoxPanel {
	private static final long serialVersionUID = -614450850199558978L;

	public GameBoxPanel() {
		setBackground(GameResources.INFO_BG_COLOR);
		setPreferredSize(new Dimension(GameResources.INFO_PANEL_WIDTH, GameResources.INFO_PANEL_HEIGHT));
	}

	@Override
	public void paint(Graphics g) {
		FontMetrics metrics = g.getFontMetrics(GameResources.PLAYER_FONT);
		
		if(getText() != null) {
			super.paint(g);
			
			g.setColor(GameResources.INFO_COLOR);
			g.setFont(GameResources.INFO_FONT);
			
			Rectangle2D rectangle = metrics.getStringBounds(getText(), g);
			int textHeight = (int)(rectangle.getHeight()); 
			int textWidth = (int)(rectangle.getWidth());

			int x = (getWidth() - textWidth)  / 2;
			int y = (getHeight() - textHeight) / 2  + metrics.getAscent();

			g.drawString(getText(), x, y);
		}
	}
}
