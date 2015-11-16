/**
 * AITournament (Tanks 2D)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmailcom)
 */
package priv.dotjabber.tournament.tanks.model;

import java.awt.Point;
import java.util.List;
import java.util.Random;

import priv.dotjabber.tournament.model.GameModel;
import priv.dotjabber.tournament.model.GameResult;
import priv.dotjabber.tournament.model.MoveValidity;
import priv.dotjabber.tournament.player.PlayerType;
import priv.dotjabber.tournament.tanks.utils.TanksUtil;
import priv.dotjabber.tournament.tanks.ui.TanksResources;

public class TanksModel extends GameModel<TanksTerrain[][], TanksMove> {
	private static final TanksTerrain[] terrainOptions = {
		TanksTerrain.FOREST,
		TanksTerrain.MOUNTAIN,
		TanksTerrain.WATER
	};

	private Random random;
	private Point playerOne;
	private Point playerTwo;
	
	public TanksModel() {
		random = new Random();	
		modelData = new TanksTerrain[TanksResources.POLYGON_SIZE][TanksResources.POLYGON_SIZE];
		
		resetModel();
	}
	
	@Override
	public void resetModel() {
		playerOne = new Point(random.nextInt(TanksResources.POLYGON_SIZE), random.nextInt(TanksResources.POLYGON_SIZE));
		playerTwo = new Point(random.nextInt(TanksResources.POLYGON_SIZE), random.nextInt(TanksResources.POLYGON_SIZE));
		
		int range = 0;
		
		for(int i=0; i< TanksResources.POLYGON_SIZE; i++) {
			for(int j=0; j< TanksResources.POLYGON_SIZE; j++) {
				
				modelData[i][j] = TanksTerrain.GRASS;
				if(random.nextDouble() < TanksUtil.getObstacleRandomFactor()) {
					range = random.nextInt(terrainOptions.length);
					modelData[i][j] = terrainOptions[range];
				}
			}
		}
		
		range = random.nextInt(TanksModelHelper.playerOneOption.size());
		modelData[playerOne.x][playerOne.y] = (TanksTerrain) TanksModelHelper.playerOneOption.toArray()[range];
		
		range = random.nextInt(TanksModelHelper.playerTwoOption.size());
		modelData[playerTwo.x][playerTwo.y] = (TanksTerrain) TanksModelHelper.playerTwoOption.toArray()[range];
		
		setChanged();
		notifyObservers();
	}

	@Override
	public MoveValidity makeMove(PlayerType type, TanksMove playerMove) {
		Point playerPosition = TanksModelHelper.getPlayerPosition(modelData, type);
		List<Point> updateList = TanksModelHelper.move(modelData, type, playerPosition, playerMove);

		setChanged();
		notifyObservers(updateList);
		
		return (updateList.isEmpty()) ? MoveValidity.MOVE_INVALID : MoveValidity.MOVE_VALID;
	}

	@Override
	public GameResult getResult() {
		Point playerOne = TanksModelHelper.getPlayerPosition(modelData, PlayerType.PLAYER_ONE);
		Point playerTwo = TanksModelHelper.getPlayerPosition(modelData, PlayerType.PLAYER_TWO);
		
		GameResult result = GameResult.GAME_ONGOING;
		if(playerOne == null && playerTwo != null) result = GameResult.PLAYER_TWO_WINS;
		if(playerOne != null && playerTwo == null) result = GameResult.PLAYER_ONE_WINS;
		if(playerOne == null && playerTwo == null) result = GameResult.TIE;
		
		return result;
	}

	@Override
	public TanksTerrain[][] getData() {
		return modelData.clone();
	}
}
