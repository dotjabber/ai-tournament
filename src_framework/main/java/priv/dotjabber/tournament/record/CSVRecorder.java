/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.record;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import priv.dotjabber.tournament.player.PlayerType;
import priv.dotjabber.tournament.utils.ConfigUtil;

/**
 * Class defines the log format (or game recording), where should the log files be stored, what is
 * the file name patter and what entries are inside.
 * @author Maciej Kowalski
 * @version 1.0
 *
 */
public class CSVRecorder extends Recorder {
	private static final String LOG_FILE_NAME = "{0}/AITournament_{1}_{2}.log";
	private static final String LOG_TIMESTAMP_FORMAT = "yyyy-MM-dd_HH-mm-ss";
	
	private static final String LOG_PLAYER_ENTRY = "{0} - {1}: {2}";
	private static final String LOG_MOVE_ENTRY = "{0} - {1}, MOVE: {2}";
	private static final String LOG_RESULT_ENTRY = "{0} - RESULT: {1}";
	
	private Format format;
	private PrintWriter writer;
	
	public CSVRecorder() throws FileNotFoundException {
		format = new SimpleDateFormat(LOG_TIMESTAMP_FORMAT);
		
		String fileName = MessageFormat.format(LOG_FILE_NAME,
				ConfigUtil.getLogDirectory(),
				ConfigUtil.getGame(),
				format.format(new Date()));
		
		writer = new PrintWriter(new FileOutputStream(new File(fileName)), true);
	}
	
	@Override
	public void addMove(PlayerType player, Object playerMove) {
		String playerLog = MessageFormat.format(LOG_MOVE_ENTRY,
				format.format(new Date()),
				player.toString(),
				playerMove.toString());
		
		writer.println(playerLog);
	}

	@Override
	public void addPlayer(PlayerType player, String playerName) {
		String playerLog = MessageFormat.format(LOG_PLAYER_ENTRY,
				format.format(new Date()),
				player.toString(),
				playerName);
		
		writer.println(playerLog);	
	}
	
	@Override
	public void setResult(String result) {
		String playerLog = MessageFormat.format(LOG_RESULT_ENTRY,
				format.format(new Date()),
				result);
		
		writer.println(playerLog);	
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		
		writer.flush();
		writer.close();
	}


}
