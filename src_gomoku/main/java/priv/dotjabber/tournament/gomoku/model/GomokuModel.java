/**
 * AITournament (Gomoku 2D)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmailcom)
 */
package priv.dotjabber.tournament.gomoku.model;

import java.awt.Point;

import priv.dotjabber.tournament.model.GameModel;
import priv.dotjabber.tournament.model.GameResult;
import priv.dotjabber.tournament.model.MoveValidity;
import priv.dotjabber.tournament.player.PlayerType;

import static priv.dotjabber.tournament.gomoku.ui.GomokuResources.GOMOKU_SIZE;
import static priv.dotjabber.tournament.gomoku.ui.GomokuResources.GOMOKU_PATTERN_SIZE;

public class GomokuModel extends GameModel<PlayerType[][], Point> {
	private int moveCount;
	
	public GomokuModel() {
		resetModel();
	}
	
	@Override
	public void resetModel() {
		modelData = new PlayerType[GOMOKU_SIZE][GOMOKU_SIZE];
		moveCount = 0;
		
		setChanged();
		notifyObservers();
	}

	@Override
	public MoveValidity makeMove(PlayerType type, Point playerResponse) {
		PlayerType fieldValue = modelData[playerResponse.x][playerResponse.y];
		
		if(fieldValue == null) {
			moveCount++;
			modelData[playerResponse.x][playerResponse.y] = type;
			
			setChanged();
			notifyObservers(playerResponse);
			
			return MoveValidity.MOVE_VALID;
			
		} else {
			return MoveValidity.MOVE_INVALID;
		}
	}

	@Override
	public GameResult getResult() {
		if(moveCount == GOMOKU_SIZE * GOMOKU_SIZE) {
			return GameResult.TIE;
		}
		
		for(int x=0; x<GOMOKU_SIZE - GOMOKU_PATTERN_SIZE; x++) {
			for(int y=0; y<GOMOKU_SIZE - GOMOKU_PATTERN_SIZE; y++) {
				PlayerType[][] planeSegment = {
						{ modelData[x + 0][y + 0], modelData[x + 1][y + 0], modelData[x + 2][y + 0], modelData[x + 3][y + 0], modelData[x + 4][y + 0] },
						{ modelData[x + 0][y + 1], modelData[x + 1][y + 1], modelData[x + 2][y + 1], modelData[x + 3][y + 1], modelData[x + 4][y + 1] },
						{ modelData[x + 0][y + 2], modelData[x + 1][y + 2], modelData[x + 2][y + 2], modelData[x + 3][y + 2], modelData[x + 4][y + 2] },
						{ modelData[x + 0][y + 3], modelData[x + 1][y + 3], modelData[x + 2][y + 3], modelData[x + 3][y + 3], modelData[x + 4][y + 3] },
						{ modelData[x + 0][y + 4], modelData[x + 1][y + 4], modelData[x + 2][y + 4], modelData[x + 3][y + 4], modelData[x + 4][y + 4] }
				};
				
				if(GomokuModelHelper.matchesPattern(PlayerType.PLAYER_ONE, planeSegment)) {
					return GameResult.PLAYER_ONE_WINS;
				}

				if(GomokuModelHelper.matchesPattern(PlayerType.PLAYER_TWO, planeSegment)) {
					return GameResult.PLAYER_TWO_WINS;
				}
			}
		}

		return GameResult.GAME_ONGOING;
	}

	@Override
	public PlayerType[][] getData() {
		return modelData.clone();
	}
}
