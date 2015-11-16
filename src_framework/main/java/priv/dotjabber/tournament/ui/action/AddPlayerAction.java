/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.ui.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import priv.dotjabber.tournament.control.GameFactory;
import priv.dotjabber.tournament.player.Player;
import priv.dotjabber.tournament.player.PlayerType;
import priv.dotjabber.tournament.ui.GameResources;
import priv.dotjabber.tournament.utils.ClassUtil;
import priv.dotjabber.tournament.utils.ConfigUtil;

public class AddPlayerAction extends AbstractAction {
	private static final long serialVersionUID = 1167707806573737660L;
	
	private static final Logger LOG = Logger.getGlobal();
	
	private static AbstractAction playerOneAction;
	private static AbstractAction playerTwoAction;
	
	private PlayerType playerType;

	public static AbstractAction getInstance(PlayerType type) {
		if(type == PlayerType.PLAYER_ONE && playerOneAction == null) {
			playerOneAction = new AddPlayerAction(type);
			playerOneAction.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));
			
			return playerOneAction;
		}
		
		else if(type == PlayerType.PLAYER_TWO && playerTwoAction == null) {
			playerTwoAction = new AddPlayerAction(type);
			playerTwoAction.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
			
			return playerTwoAction;
		}
		
		return null;
	}
	
	public AddPlayerAction(PlayerType type) {
		playerType = type;
		
		putValue(NAME, GameResources.getResource(GameResources.SUBMENU_SET_PLAYER, type));
		putValue(SMALL_ICON, new ImageIcon(GameResources.ICON_NEW_PLAYER));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void actionPerformed(ActionEvent evt) {
		String playersPackage = ConfigUtil.getPlayersPackage();
		Object[] possibilities = ClassUtil.getClasses(playersPackage).toArray();

		Class<?> selectedPlayer = (Class<?>) JOptionPane.showInputDialog(
				null, 
				GameResources.getResource(GameResources.MSG_PLAYER_SELECT, playerType.toString()),
				GameResources.CAPTION_PLAYER_SELECT,
				JOptionPane.PLAIN_MESSAGE,
				null,
				possibilities,
				null
		);
		
		if(selectedPlayer != null) {
			try {
				Player<?, ?> playerInstance = (Player<?, ?>) selectedPlayer.newInstance();
				GameFactory.getDefault().getController().setPlayer(playerType, (Player)playerInstance);
				
			} catch (InstantiationException e) {
				LOG.log(Level.FINER, e.getMessage(), e);
				
			} catch (IllegalAccessException e) {
				LOG.log(Level.FINER, e.getMessage(), e);
				
			} catch (ClassCastException e) {
				LOG.log(Level.FINER, e.getMessage(), e);
			}
		}
	}
}
