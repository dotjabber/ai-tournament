/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.ui.action;

import priv.dotjabber.tournament.ui.GameResources;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class AboutAction extends AbstractAction {
	private static final long serialVersionUID = 1167707806573737660L;
	
	private static AbstractAction action;

	public static AbstractAction getInstance() {
		if(action == null) {
			action = new AboutAction();
		}
		
		return action;
	}
	
	public AboutAction() {
		putValue(NAME, GameResources.getResource(GameResources.SUBMENU_ABOUT));
		putValue(SMALL_ICON, new ImageIcon(GameResources.ICON_INFO));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, ActionEvent.CTRL_MASK));
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(null, GameResources.getResource(GameResources.MSG_ABOUT_GAMER));
	}
}