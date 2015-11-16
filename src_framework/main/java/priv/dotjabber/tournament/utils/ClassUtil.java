/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import priv.dotjabber.tournament.control.GameFactory;

/**
 * Utility for Class loading. This utility class is mostly used for retrieving
 * player classes and game factory classes and loading them to VM.
 * @author Maciej Kowalski
 * @version 1.0
 *
 */
public class ClassUtil {
	
	/**
	 * Extension which is used to identify player class.
	 */
	private static final String CLASS_EXTENTION = ".class";
	
	/**
	 * Current directory (wherever the AITournament is executed).
	 */
	private static final String PROJECT_DIR = "." + File.separatorChar;
	
	/**
	 * Bin directory (wherever the AITournament is executed).
	 */
	private static final String BINARY_DIR = "target/classes" + File.separatorChar;
	
	/**
	 * java.util.Logger
	 */
	private static final Logger LOG = Logger.getGlobal();
	
	/**
	 * Method returns all the classes for given package name (classes which are not 
	 * loaded yet to VM and may reside in ./bin or ./ directories.
	 * @param packageName
	 * @return List<Class<?>>
	 */
	public static List<Class<?>> getClasses(String packageName) {
		List<Class<?>> classesFound = new ArrayList<Class<?>>();

		File directory = null;
		File directoryBinary = new File(ConfigUtil.getBinaryDirectory() + packageName.replace('.', File.separatorChar));
		File directoryProject = new File(ConfigUtil.getProjectDirectory() + packageName.replace('.', File.separatorChar));
		
		if(directoryProject.exists()) {
			directory = directoryProject;

		} else if(directoryBinary.exists()) {
			directory = directoryBinary;
		}
		
		if(directory != null) {
			String[] fileNames = directory.list();
			
			for(String fileName : fileNames) {
				
				if(fileName.endsWith(CLASS_EXTENTION)) {	
					try {
						Class<?> classFound = Class.forName(packageName + '.' + fileName.replace(CLASS_EXTENTION, ""));
						classesFound.add(classFound);
						
					} catch (ClassNotFoundException e) {
						LOG.log(Level.FINER, e.getMessage(), e);
					}
				}
			}
		}
		
		return classesFound;
	}
	
	/**
	 * Method creates GameFactory object (which is responsible for creating specific
	 * game with it's own interface and set of rules), based on class name;
	 * @param className
	 * @return GameFactory<?, ?>
	 */
	public static GameFactory<?, ?> getGameFactory(String className) {
		GameFactory<?, ?> factoryInstance = null;
		
		try {
			Class<?> factoryClass = Class.forName(className);
			factoryInstance = (GameFactory<?, ?>) factoryClass.newInstance();
					
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			LOG.log(Level.FINER, e.getMessage(), e);
			
		}

		return factoryInstance;
	}
}