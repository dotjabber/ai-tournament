/**
 * AITournament (Tanks 2D)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmailcom)
 */
package priv.dotjabber.tournament.tanks.ui;

import java.awt.Color;
import java.net.URL;

public class TanksResources {
	public static final Color POLYGON_COLOR = new Color(99, 162, 132);
	
	public static final Color TANKS_PLAYER_ONE_COLOR = new Color(90, 203, 237);
	public static final Color TANKS_PLAYER_TWO_COLOR = new Color(255, 146, 156);
	
	public static final int POLYGON_FIELD_WIDTH = 33;
	public static final int POLYGON_FIELD_HEIGHT = 33;
	
	public static final int POLYGON_SIZE = 13;
	public static final int POLYGON_FIELD_MARGIN = 0;
	public static final int POLYGON_WIDTH = (POLYGON_FIELD_WIDTH + POLYGON_FIELD_MARGIN) * POLYGON_SIZE + POLYGON_FIELD_MARGIN; 
	public static final int POLYGON_HEIGHT = (POLYGON_FIELD_HEIGHT + POLYGON_FIELD_MARGIN) * POLYGON_SIZE + POLYGON_FIELD_MARGIN;

	public static final URL IMAGE_GRASS = TanksResources.class.getResource("images/IMAGE_GRASS.PNG");
	public static final URL IMAGE_MOUNTAIN = TanksResources.class.getResource("images/IMAGE_MOUNTAIN.PNG");
	public static final URL IMAGE_TANK_BLUE_DOWN = TanksResources.class.getResource("images/IMAGE_TANK_BLUE_DOWN.PNG");
	public static final URL IMAGE_TANK_BLUE_LEFT = TanksResources.class.getResource("images/IMAGE_TANK_BLUE_LEFT.PNG");
	public static final URL IMAGE_TANK_BLUE_RIGHT = TanksResources.class.getResource("images/IMAGE_TANK_BLUE_RIGHT.PNG");
	public static final URL IMAGE_TANK_BLUE_UP = TanksResources.class.getResource("images/IMAGE_TANK_BLUE_UP.PNG");
	public static final URL IMAGE_TANK_RED_DOWN = TanksResources.class.getResource("images/IMAGE_TANK_RED_DOWN.PNG");
	public static final URL IMAGE_TANK_RED_LEFT = TanksResources.class.getResource("images/IMAGE_TANK_RED_LEFT.PNG");
	public static final URL IMAGE_TANK_RED_RIGHT = TanksResources.class.getResource("images/IMAGE_TANK_RED_RIGHT.PNG");
	public static final URL IMAGE_TANK_RED_UP = TanksResources.class.getResource("images/IMAGE_TANK_RED_UP.PNG");
	public static final URL IMAGE_TREE = TanksResources.class.getResource("images/IMAGE_TREE.PNG");
	public static final URL IMAGE_WATER = TanksResources.class.getResource("images/IMAGE_WATER.PNG");
	public static final URL IMAGE_ASHES = TanksResources.class.getResource("images/IMAGE_ASHES.PNG");
}
