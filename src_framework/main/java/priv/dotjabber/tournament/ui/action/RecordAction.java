/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.ui.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.KeyStroke;

import priv.dotjabber.tournament.control.GameFactory;
import priv.dotjabber.tournament.ui.GameResources;

public class RecordAction extends AbstractAction {
	private static final long serialVersionUID = -4408351480669114419L;
	
	private static AbstractAction action;

	public static AbstractAction getInstance() {
		if(action == null) {
			action = new RecordAction();
		}
		
		return action;
	}
	
	public RecordAction() {
		putValue(NAME, GameResources.getResource(GameResources.SUBMENU_RECORD));
		putValue(SMALL_ICON, new ImageIcon(GameResources.ICON_RECORD_GAME));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) evt.getSource();
		GameFactory.getDefault().setGameRecorded(menuItem.isSelected());
	}
}
