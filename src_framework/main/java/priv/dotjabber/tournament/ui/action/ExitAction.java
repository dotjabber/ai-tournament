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

import static priv.dotjabber.tournament.ui.GameResources.getResource;
import static priv.dotjabber.tournament.ui.GameResources.SUBMENU_EXIT;
import static priv.dotjabber.tournament.ui.GameResources.ICON_EXIT;

public class ExitAction extends AbstractAction {
	private static final long serialVersionUID = 1167707806573737660L;

	private static AbstractAction action;

	public static AbstractAction getInstance() {
		if(action == null) {
			action = new ExitAction();
		}
		
		return action;
	}
	
	public ExitAction() {
		putValue(NAME, getResource(SUBMENU_EXIT));
		putValue(SMALL_ICON, new ImageIcon(ICON_EXIT));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		GameFactory.getDefault().getController().stopGame();
		System.exit(0);
	}
}
