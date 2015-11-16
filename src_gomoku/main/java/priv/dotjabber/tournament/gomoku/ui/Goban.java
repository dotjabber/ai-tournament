/**
 * AITournament (Gomoku 2D)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmailcom)
 */
package priv.dotjabber.tournament.gomoku.ui;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Observable;

import priv.dotjabber.tournament.gomoku.model.GomokuModel;
import priv.dotjabber.tournament.ui.GameBoard;

public class Goban extends GameBoard<GomokuModel> {
	private static final long serialVersionUID = 2940586852098252447L;
	
	private GobanField[][] fields;
	
	public Goban(GomokuModel model) {
		super(model);
		
		fields = new GobanField[GomokuResources.GOMOKU_SIZE][GomokuResources.GOMOKU_SIZE];
		
		for(int i = 0; i < GomokuResources.GOMOKU_SIZE; i++) {
			for(int j = 0; j < GomokuResources.GOMOKU_SIZE; j++) {
				fields[i][j] = new GobanField();
				
				int x = GomokuResources.GOBAN_FIELD_MARGIN * (i + 1) + GomokuResources.GOBAN_FIELD_WIDTH * i;
				int y = GomokuResources.GOBAN_FIELD_MARGIN * (j + 1) + GomokuResources.GOBAN_FIELD_HEIGHT * j;
				
				fields[i][j].setBounds(x, y, GomokuResources.GOBAN_FIELD_WIDTH, GomokuResources.GOBAN_FIELD_HEIGHT);
				add(fields[i][j]);
			}
		}
		
		setPreferredSize(new Dimension(GomokuResources.GOBAN_WIDTH, GomokuResources.GOBAN_HEIGHT));
	}
	
	@Override
	public void update(Observable observable, Object obj) {
		if(obj instanceof Point) {
			int i = ((Point)obj).x;
			int j = ((Point)obj).y;
			
			fields[i][j].mark(model.getData()[i][j]);
			
		} else {
			
			for(int i = 0; i < GomokuResources.GOMOKU_SIZE; i++) {
				for(int j = 0; j < GomokuResources.GOMOKU_SIZE; j++) {
					fields[i][j].mark(model.getData()[i][j]);
				}
			}
		}
	}
}
