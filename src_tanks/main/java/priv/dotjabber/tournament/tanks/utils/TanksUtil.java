package priv.dotjabber.tournament.tanks.utils;

import java.text.MessageFormat;

import priv.dotjabber.tournament.utils.ConfigUtil;

public class TanksUtil extends ConfigUtil {
	private static final String OBSTACLE_RANDOM_FACTOR_KEY = "{0}.obstacleFactor";
	
	public static double getObstacleRandomFactor() {
		String key = MessageFormat.format(OBSTACLE_RANDOM_FACTOR_KEY, getGame());
		return Double.parseDouble(getGameProperty(key));
	}
}
