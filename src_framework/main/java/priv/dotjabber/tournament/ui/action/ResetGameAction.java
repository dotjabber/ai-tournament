/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.ui.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import priv.dotjabber.tournament.control.GameFactory;
import priv.dotjabber.tournament.ui.GameResources;

public class ResetGameAction extends AbstractAction {
	private static final long serialVersionUID = -9062540425660846707L;
	
	private static AbstractAction action;

	public static AbstractAction getInstance() {
		if(action == null) {
			action = new ResetGameAction();
		}
		
		return action;
	}
	
	public ResetGameAction() {
		putValue(NAME, GameResources.getResource(GameResources.SUBMENU_RESET_BOARD));
		putValue(SMALL_ICON, new ImageIcon(GameResources.ICON_RESET_GAME));
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		GameFactory.getDefault().getController().resetGame();
	}
}
