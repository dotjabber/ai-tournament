/**
 * AITournament (Tanks 2D)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmailcom)
 */
package priv.dotjabber.tournament.tanks.ui;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JPanel;

import priv.dotjabber.tournament.tanks.model.TanksTerrain;

public class PolygonField extends JPanel {
	private static final long serialVersionUID = 7183451327695590161L;
	
	private TanksTerrain terrainType;
	
	public PolygonField(TanksTerrain terrain) {
		setBackground(TanksResources.POLYGON_COLOR);
		terrainType = terrain;
	}
	
	public void setField(TanksTerrain type) {
		terrainType = type;
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		try {
			g.drawImage(terrainType.getImage(), 0, 0, getWidth(), getHeight(), this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
