/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

import priv.dotjabber.tournament.control.GameFactory;
import priv.dotjabber.tournament.player.PlayerType;
import priv.dotjabber.tournament.ui.action.AboutAction;
import priv.dotjabber.tournament.ui.action.AddPlayerAction;
import priv.dotjabber.tournament.ui.action.ClearBoardAction;
import priv.dotjabber.tournament.ui.action.ExitAction;
import priv.dotjabber.tournament.ui.action.RecordAction;
import priv.dotjabber.tournament.ui.action.ResetGameAction;
import priv.dotjabber.tournament.ui.action.StartGameAction;
import priv.dotjabber.tournament.ui.action.StopGameAction;
import priv.dotjabber.tournament.utils.ConfigUtil;

public class FramePanel extends JFrame {
	private static final long serialVersionUID = 1552746400473185110L;

	static {
    	String[] jproperties = { 
    			"Button.font", "CheckBox.font", "CheckBoxMenuItem.acceleratorfont", "CheckBoxMenuItem.font", "ColorChooser.font", "ComboBox.font", 
    			"DesktopIcon.font", "EditorPane.font", "FormattedTextField.font", "InternalFrame.titlefont", "Label.font", "List.font", "Menu.acceleratorfont",
    			"MenuItem.font", "OptionPane.font", "Panel.font", "PasswordField.font", "PopupMenu.font", "ProgressBar.font", "RadioButton.font",
    			"RadioButtonMenuItem.acceleratorfont", "RadioButtonMenuItem.font", "ScrollPane.font", "Spinner.font", "TabbedPane.font", "Table.font",
    			"TableHeader.font", "TextArea.font", "TextField.font", "TextPane.font", "TitledBorder.font", "ToggleButton.font", "ToolBar.font",
    			"ToolTip.font", "Tree.font", "Viewport.font", "Menu.font"
    	};
  
    	for(String jprop : jproperties) {
    		UIManager.put(jprop, GameResources.FRAME_FONT);
    	}
	}
	
	private JMenuBar menuBar;
	private JMenu fileMenu, gameMenu, aboutMenu;
	private JMenuItem exitMenuItem, setPlayer1MenuItem, setPlayer2MenuItem, startGameMenuItem, stopGameMenuItem, resetBoardMenuItem, clearBoardMenuItem, aboutMenuItem;
	private JCheckBoxMenuItem recordMenuItem;
	
	private JPanel gameBoard;
	private JPanel playerOneTag, playerTwoTag, infoTag;
	private JPanel gameFrame;
	private JPanel boardFrame, playerOneFrame, playerTwoFrame, infoTagFrame;
	
	public FramePanel() {
		super(GameResources.getResource(GameResources.CAPTION_MAIN, ConfigUtil.getDescription()));
		
		setLayout(null);
		initializeGamePanel();
		addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent evt) {
				componentResized(evt);
			}
			
			@Override
			public void componentResized(ComponentEvent evt) {
				if(menuBar != null) menuBar.setBounds(0, 0, getWidth() - 5, 20);
				if(gameFrame != null) gameFrame.setBounds(0, 20, FramePanel.this.getWidth() - 5, getHeight() - 50);
			}
			
			@Override
			public void componentMoved(ComponentEvent evt) {
			}
			
			@Override
			public void componentHidden(ComponentEvent evt) {
			}
		});
	}
		
	public void initializeGamePanel() {
		menuBar = new JMenuBar();

		fileMenu = new JMenu(GameResources.getResource(GameResources.MENU_FILE));
		gameMenu = new JMenu(GameResources.getResource(GameResources.MENU_GAME));
		aboutMenu = new JMenu(GameResources.getResource(GameResources.MENU_ABOUT));
		menuBar.add(fileMenu);
		menuBar.add(gameMenu);
		menuBar.add(aboutMenu);
		
		exitMenuItem = new JMenuItem(ExitAction.getInstance());
		fileMenu.add(exitMenuItem);
		
		recordMenuItem = new JCheckBoxMenuItem(new RecordAction());

		setPlayer1MenuItem = new JMenuItem(AddPlayerAction.getInstance(PlayerType.PLAYER_ONE));
		setPlayer2MenuItem = new JMenuItem(AddPlayerAction.getInstance(PlayerType.PLAYER_TWO));
		startGameMenuItem = new JMenuItem(StartGameAction.getInstance());
		stopGameMenuItem = new JMenuItem(StopGameAction.getInstance());
		resetBoardMenuItem = new JMenuItem(ResetGameAction.getInstance());
		clearBoardMenuItem = new JMenuItem(ClearBoardAction.getInstance());
		
		gameMenu.add(recordMenuItem);
		gameMenu.addSeparator();
		gameMenu.add(setPlayer1MenuItem);
		gameMenu.add(setPlayer2MenuItem);
		gameMenu.addSeparator();
		gameMenu.add(startGameMenuItem);
		gameMenu.add(stopGameMenuItem);
		gameMenu.add(resetBoardMenuItem);
		gameMenu.addSeparator();
		gameMenu.add(clearBoardMenuItem);
		
		aboutMenuItem = new JMenuItem(AboutAction.getInstance());
		aboutMenu.add(aboutMenuItem);
		
		add(menuBar);

		gameFrame = new JPanel();
		gameFrame.setBorder(BorderFactory.createTitledBorder(ConfigUtil.getGame()));
		gameFrame.setLayout(new BorderLayout(GameResources.FRAME_BORDER_MARGIN, GameResources.FRAME_BORDER_MARGIN));
		add(gameFrame);
		
		boardFrame = new JPanel(new FlowLayout());
		playerOneFrame = new JPanel(new FlowLayout());
		playerTwoFrame = new JPanel(new FlowLayout());
		infoTagFrame = new JPanel(new FlowLayout());

		gameBoard = GameFactory.getDefault().getGameBoard();
		boardFrame.add(gameBoard);
		gameFrame.add(boardFrame, BorderLayout.CENTER);
		
		playerOneTag = GameFactory.getDefault().getPlayerPanel(PlayerType.PLAYER_ONE);
		playerOneFrame.add(playerOneTag);
		gameFrame.add(playerOneFrame, BorderLayout.LINE_START);
		
		infoTag = GameFactory.getDefault().getInfoPanel();
		infoTagFrame.add(infoTag);
		gameFrame.add(infoTagFrame, BorderLayout.PAGE_END);
		
		playerTwoTag = GameFactory.getDefault().getPlayerPanel(PlayerType.PLAYER_TWO);
		playerTwoFrame.add(playerTwoTag);
		gameFrame.add(playerTwoFrame, BorderLayout.LINE_END);
	}
}
