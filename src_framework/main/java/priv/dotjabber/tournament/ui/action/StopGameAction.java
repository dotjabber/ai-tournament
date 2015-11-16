/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.ui.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import priv.dotjabber.tournament.control.GameFactory;
import priv.dotjabber.tournament.ui.GameResources;

public class StopGameAction extends AbstractAction {
	private static final long serialVersionUID = 1167707806573737660L;

	private static AbstractAction action;

	public static AbstractAction getInstance() {
		if(action == null) {
			action = new StopGameAction();
		}
		
		return action;
	}
	
	public StopGameAction() {
		putValue(NAME, GameResources.getResource(GameResources.SUBMENU_STOP_PLAY));
		putValue(SMALL_ICON, new ImageIcon(GameResources.ICON_STOP));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		GameFactory.getDefault().getController().stopGame();
	}
}