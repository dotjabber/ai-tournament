/**
 * AITournament (Tanks 2D)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmailcom)
 */
package priv.dotjabber.tournament.tanks.model;

import priv.dotjabber.tournament.tanks.ui.TanksResources;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum TanksTerrain {
	FOREST {
		public Image getImage() throws IOException {
			return ImageIO.read(TanksResources.IMAGE_TREE);
		}
	},
	
	MOUNTAIN {
		public Image getImage() throws IOException {
			return ImageIO.read(TanksResources.IMAGE_MOUNTAIN);
		}
	},
	
	WATER {
		public Image getImage() throws IOException {
			return ImageIO.read(TanksResources.IMAGE_WATER);
		}
	},
	
	GRASS {
		public Image getImage() throws IOException {
			return ImageIO.read(TanksResources.IMAGE_GRASS);
		}
	},
	
	PLAYER_ONE_LEFT {
		public Image getImage() throws IOException {
			return ImageIO.read(TanksResources.IMAGE_TANK_BLUE_LEFT);
		}
	},
	
	PLAYER_ONE_RIGHT {
		public Image getImage() throws IOException {
			return ImageIO.read(TanksResources.IMAGE_TANK_BLUE_RIGHT);
		}
	},
	
	PLAYER_ONE_UP {
		public Image getImage() throws IOException {
			return ImageIO.read(TanksResources.IMAGE_TANK_BLUE_UP);
		}
	},
	
	PLAYER_ONE_DOWN {
		public Image getImage() throws IOException {
			return ImageIO.read(TanksResources.IMAGE_TANK_BLUE_DOWN);
		}
	},
	
	PLAYER_TWO_LEFT {
		public Image getImage() throws IOException {
			return ImageIO.read(TanksResources.IMAGE_TANK_RED_LEFT);
		}
	},
	
	PLAYER_TWO_RIGHT {
		public Image getImage() throws IOException {
			return ImageIO.read(TanksResources.IMAGE_TANK_RED_RIGHT);
		}
	},
	
	PLAYER_TWO_UP {
		public Image getImage() throws IOException {
			return ImageIO.read(TanksResources.IMAGE_TANK_RED_UP);
		}
	},
	
	PLAYER_TWO_DOWN {
		public Image getImage() throws IOException {
			return ImageIO.read(TanksResources.IMAGE_TANK_RED_DOWN);
		}
	},
	
	ASHES {
		public Image getImage() throws IOException {
			return ImageIO.read(TanksResources.IMAGE_ASHES);
		}
	};
	
	public Image getImage() throws IOException {
		return ImageIO.read(TanksResources.IMAGE_GRASS);
	}
}
