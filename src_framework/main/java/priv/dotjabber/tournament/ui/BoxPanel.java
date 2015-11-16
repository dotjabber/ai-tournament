/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.ui;

import javax.swing.JPanel;

public abstract class BoxPanel extends JPanel {
	private static final long serialVersionUID = -614450850199558978L;
	
	private String textMessage;

	public void setText(String text) {
		textMessage = text;
		repaint();
	}
	
	public String getText() {
		return textMessage;
	}
}
