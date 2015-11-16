/**
 * AITournament (Tanks 2D)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmailcom)
 */
package priv.dotjabber.tournament.tanks.ui;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;
import java.util.Observable;

import priv.dotjabber.tournament.tanks.model.TanksTerrain;
import priv.dotjabber.tournament.tanks.model.TanksModel;
import priv.dotjabber.tournament.ui.GameBoard;

import static priv.dotjabber.tournament.tanks.ui.TanksResources.POLYGON_SIZE;
import static priv.dotjabber.tournament.tanks.ui.TanksResources.POLYGON_HEIGHT;
import static priv.dotjabber.tournament.tanks.ui.TanksResources.POLYGON_WIDTH;
import static priv.dotjabber.tournament.tanks.ui.TanksResources.POLYGON_FIELD_MARGIN;
import static priv.dotjabber.tournament.tanks.ui.TanksResources.POLYGON_FIELD_HEIGHT;
import static priv.dotjabber.tournament.tanks.ui.TanksResources.POLYGON_FIELD_WIDTH;


public class Polygon extends GameBoard<TanksModel> {
	private static final long serialVersionUID = 9135471744327404299L;

	private PolygonField[][] fields;
	
	public Polygon(TanksModel dataModel) {
		super(dataModel);
		
		fields = new PolygonField[POLYGON_SIZE][POLYGON_SIZE];
		
		update(dataModel);
		setPreferredSize(new Dimension(POLYGON_WIDTH, POLYGON_HEIGHT));
	}
	
	public void update(TanksModel dataModel) {
		for(int i=0; i<POLYGON_SIZE; i++) {
			for(int j=0; j<POLYGON_SIZE; j++) {
				int x = POLYGON_FIELD_MARGIN * (i + 1) + POLYGON_FIELD_WIDTH * i;
				int y = POLYGON_FIELD_MARGIN * (j + 1) + POLYGON_FIELD_HEIGHT * j;
				
				TanksTerrain terrain = dataModel.getData()[i][j];
				
				if(fields[i][j] == null) {
					fields[i][j] = new PolygonField(terrain);
					fields[i][j].setBounds(x, y, POLYGON_FIELD_WIDTH, POLYGON_FIELD_HEIGHT);
					add(fields[i][j]);
					
				} else {
					fields[i][j].setField(terrain);
				}
			}
		}
	}

	@Override
	public void update(Observable observable, Object obj) {
		TanksModel dataModel = (TanksModel) observable;
		List<?> updatedFields = (List<?>) obj;
		
		
		if(updatedFields != null) {
			for(Object updatedField : updatedFields) {
				int x = ((Point) updatedField).x;
				int y = ((Point) updatedField).y;
				
				fields[x][y].setField(dataModel.getData()[x][y]);
			}
			
		} else {
			update(dataModel);
		}
	}
}
