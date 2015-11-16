package priv.dotjabber.tournament.tanks.model;

import java.util.List;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import priv.dotjabber.tournament.player.PlayerType;

import static priv.dotjabber.tournament.tanks.ui.TanksResources.POLYGON_SIZE;

public class TanksModelHelper {
	static Set<TanksTerrain> playerOneOption = new HashSet<TanksTerrain>() {
		private static final long serialVersionUID = 1L;

		{
			add(TanksTerrain.PLAYER_ONE_DOWN);
			add(TanksTerrain.PLAYER_ONE_LEFT);
			add(TanksTerrain.PLAYER_ONE_RIGHT);
			add(TanksTerrain.PLAYER_ONE_UP);
		}
	};
	
	static Set<TanksTerrain> playerTwoOption = new HashSet<TanksTerrain>() {
		private static final long serialVersionUID = 1L;

		{
			add(TanksTerrain.PLAYER_TWO_DOWN);
			add(TanksTerrain.PLAYER_TWO_LEFT);
			add(TanksTerrain.PLAYER_TWO_RIGHT);
			add(TanksTerrain.PLAYER_TWO_UP);
		}
	};
	
	static Set<TanksTerrain> openTerrain = new HashSet<TanksTerrain>() {
		private static final long serialVersionUID = 1L;

		{
			add(TanksTerrain.ASHES);
			add(TanksTerrain.GRASS);
			add(TanksTerrain.WATER);
		}
	};
	
	static List<Point> move(TanksTerrain[][] model, PlayerType type, Point playerPosition, TanksMove playerMove) {
		int x = playerPosition.x;
		int y = playerPosition.y;

		List<Point> modelUpdateList = new ArrayList<Point>();
		
		switch(playerMove) {
		
			case MOVE_UP:
				if(y - 1 >= 0 && model[x][y - 1] == TanksTerrain.GRASS) {
					model[x][y] = TanksTerrain.GRASS;
					model[x][y - 1] = (type == PlayerType.PLAYER_ONE) ? TanksTerrain.PLAYER_ONE_UP : TanksTerrain.PLAYER_TWO_UP;
					
					modelUpdateList.add(new Point(x, y));
					modelUpdateList.add(new Point(x, y - 1));
				}
				
			break;
			
			case MOVE_DOWN:
				if(y + 1 < POLYGON_SIZE && model[x][y + 1] == TanksTerrain.GRASS) {
					model[x][y] = TanksTerrain.GRASS;
					model[x][y + 1] = (type == PlayerType.PLAYER_ONE) ? TanksTerrain.PLAYER_ONE_DOWN : TanksTerrain.PLAYER_TWO_DOWN;
					
					modelUpdateList.add(new Point(x, y));
					modelUpdateList.add(new Point(x, y + 1));
				}
				
			break;
			
			case MOVE_LEFT:
				if(x - 1 >= 0 && model[x - 1][y] == TanksTerrain.GRASS) {
					model[x][y] = TanksTerrain.GRASS;
					model[x - 1][y] = (type == PlayerType.PLAYER_ONE) ? TanksTerrain.PLAYER_ONE_LEFT : TanksTerrain.PLAYER_TWO_LEFT;
					
					modelUpdateList.add(new Point(x, y));
					modelUpdateList.add(new Point(x - 1, y));
				}
				
			break;
			
			case MOVE_RIGHT:
				if(x + 1 < POLYGON_SIZE && model[x + 1][y] == TanksTerrain.GRASS) {
					model[x][y] = TanksTerrain.GRASS;
					model[x + 1][y] = (type == PlayerType.PLAYER_ONE) ? TanksTerrain.PLAYER_ONE_RIGHT : TanksTerrain.PLAYER_TWO_RIGHT;
					
					modelUpdateList.add(new Point(x, y));
					modelUpdateList.add(new Point(x + 1, y));
				}
				
			break;
			
			case FIRE_UP:
				for(int i = 1; y - i >= 0; i++) {
					
					if(!openTerrain.contains(model[x][y - i])) {
						model[x][y - i] = TanksTerrain.ASHES;
						model[x][y] = (type == PlayerType.PLAYER_ONE) ? TanksTerrain.PLAYER_ONE_UP : TanksTerrain.PLAYER_TWO_UP;
						
						modelUpdateList.add(new Point(x, y));
						modelUpdateList.add(new Point(x, y - i));
						break;
					}
				}
			break;
			
			case FIRE_DOWN:
				for(int i = 1; y + i < POLYGON_SIZE; i++) {
					
					if(!openTerrain.contains(model[x][y + i])) {
						model[x][y + i] = TanksTerrain.ASHES;
						model[x][y] = (type == PlayerType.PLAYER_ONE) ? TanksTerrain.PLAYER_ONE_DOWN : TanksTerrain.PLAYER_TWO_DOWN;
						
						modelUpdateList.add(new Point(x, y));
						modelUpdateList.add(new Point(x, y + i));
						break;
					}
				}
			break;
			
			case FIRE_LEFT:
				for(int i = 1; x - i >= 0; i++) {
					
					if(!openTerrain.contains(model[x - i][y])) {
						model[x - i][y] = TanksTerrain.ASHES;
						model[x][y] = (type == PlayerType.PLAYER_ONE) ? TanksTerrain.PLAYER_ONE_LEFT : TanksTerrain.PLAYER_TWO_LEFT;
						
						modelUpdateList.add(new Point(x, y));
						modelUpdateList.add(new Point(x - i, y));
						break;
					}
				}
			break;
				
			case FIRE_RIGHT:
				for(int i = 1; x + i < POLYGON_SIZE; i++) {
					
					if(!openTerrain.contains(model[x + i][y])) {
						model[x + i][y] = TanksTerrain.ASHES;
						model[x][y] = (type == PlayerType.PLAYER_ONE) ? TanksTerrain.PLAYER_ONE_RIGHT : TanksTerrain.PLAYER_TWO_RIGHT;
						
						modelUpdateList.add(new Point(x, y));
						modelUpdateList.add(new Point(x + i, y));
						break;
					}
				}
			break;
		}
		
		return modelUpdateList;
	}

	static Point getPlayerPosition(TanksTerrain[][] model, PlayerType type) {
		Point playerPosition = null;
		
		for(int x=0; x<model.length; x++) {
			for(int y=0; y<model[x].length; y++) {
				
				if(type == PlayerType.PLAYER_ONE && playerOneOption.contains(model[x][y])) {
					playerPosition = new Point(x, y);
					
				} else if(type == PlayerType.PLAYER_TWO && playerTwoOption.contains(model[x][y])) {
					playerPosition = new Point(x, y);
				}
			}
		}
		
		return playerPosition;
	}
}
