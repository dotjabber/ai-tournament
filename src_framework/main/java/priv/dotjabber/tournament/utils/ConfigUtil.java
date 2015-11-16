/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.utils;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import priv.dotjabber.tournament.AITournament;

/**
 * Utility class for handling AITournament configuration. By default configuration is stored in
 * aitournament.properties file.
 * @author Maciej Kowalski
 * @version 1.0
 */
public class ConfigUtil {
	
	/**
	 * Configuration file URL.
	 */
	private static final URL URL_CONFIG_FILE = AITournament.class.getResource("aitournament.properties");
	
	/**
	 * Selected game property.
	 */
	private static final String SELECTED_GAME_KEY = "aitournament.selectedGame";
	
	/**
	 * Recorded games directory.
	 */
	private static final String RECORD_DIRECTORY_KEY = "aitournament.recordedGames";

	/**
	 *
	 */
	private static final String PROJECT_DIRECTORY_KEY = "aitournament.projectDir";

	/**
	 *
	 */
	private static final String BINARY_DIRECTORY_KEY = "aitournament.binaryDir";

	/**
	 *
	 */
	private static final String STEP_LIMIT_KEY = "aitournament.stepLimit";

	/**
	 * Game name property.
	 */
	private static final String GAME_NAME_KEY = "{0}.gameName";
	
	/**
	 * Game factory class property.
	 */
	private static final String GAME_FACTORY_KEY = "{0}.factoryClass";
	
	/**
	 * Package name property for configuring where exactly lie player implementations.
	 */
	private static final String GAME_PLAYER_PACKAGE_KEY = "{0}.playersPackage";

	/**
	 * Class logger.
	 */
	private static final Logger LOG = Logger.getGlobal();
	
	/**
	 * Property loaded for AITournament.
	 */
	private static Properties tournamentProperties;
	
	/**
	 * Static block is used for instantiating properties map.
	 */
	static {
		if(tournamentProperties == null) {
			tournamentProperties = new Properties();
			
			try {
				tournamentProperties.load(URL_CONFIG_FILE.openStream());
				
			} catch (IOException e) {
				LOG.log(Level.FINER, e.getMessage(), e);
			}
		}
	}
	
	/**
	 * Generic method for retrieving value for given key from aitournament.properties
	 * configuration file.
	 * @param key
	 * @return String
	 */
	public static String getGameProperty(String key) {
		return tournamentProperties.getProperty(key);
	}
	
	/**
	 * Method returns selected game name (or game key). This property is stored
	 * under 'AITournament.selectedGame' property.
	 * @return String
	 */
	public static String getGame() {
		return tournamentProperties.getProperty(SELECTED_GAME_KEY);
	}
	
	/**
	 * Method returns players package name for selected game. Property is stored
	 * under '{game_key}.playersPackage' property. Framework will only recognize
	 * players which are stored in this package.
	 * @return String
	 */
	public static String getPlayersPackage() {
		String key = MessageFormat.format(GAME_PLAYER_PACKAGE_KEY, getGame());
		return tournamentProperties.getProperty(key);
	}

	/**
	 * Method returns factory class for selected game. Property is stored
	 * under '{game_key}.factoryClass' property. 
	 * @return String
	 */
	public static String getGameFactoryName() {
		String key = MessageFormat.format(GAME_FACTORY_KEY, getGame());
		return tournamentProperties.getProperty(key);
	}

	public static String getGameFactoryName(String gameName) {
		String key = MessageFormat.format(GAME_FACTORY_KEY, gameName);
		return tournamentProperties.getProperty(key);
	}

	/**
	 * Method returns description for selected game. Property is stored
	 * under '{game_key}.gameName' property. 
	 * @return String
	 */
	public static String getDescription() {
		String key = MessageFormat.format(GAME_NAME_KEY, getGame());
		return tournamentProperties.getProperty(key);
	}
	
	/**
	 * Method returns the directory for recorded games (or game logs if you will). 
	 * Property is stored under 'AITournamens.recordedGames' property. 
	 * @return String
	 */
	public static String getLogDirectory() {
		return tournamentProperties.getProperty(RECORD_DIRECTORY_KEY);
	}

	/**
	 *
	 * @return
	 */
	public static String getProjectDirectory() {
		return tournamentProperties.getProperty(PROJECT_DIRECTORY_KEY);
	}

	/**
	 *
	 * @return
	 */
	public static String getBinaryDirectory() {
		return tournamentProperties.getProperty(BINARY_DIRECTORY_KEY);
	}

	/**
	 *
	 * @return
	 */
	public static int getStepLimit() {
		return Integer.parseInt(tournamentProperties.getProperty(STEP_LIMIT_KEY));
	}
}
