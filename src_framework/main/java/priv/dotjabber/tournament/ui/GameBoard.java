/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.ui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public abstract class GameBoard<M extends Observable> extends JPanel implements Observer {
	private static final long serialVersionUID = 8826035055492290900L;
	
	protected M model;
	
	public GameBoard(M dataModel) {
		setLayout(null);
		
		model = dataModel;
		model.addObserver(this);
	}
}
