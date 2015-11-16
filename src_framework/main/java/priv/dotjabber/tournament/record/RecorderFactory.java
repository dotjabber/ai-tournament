/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.record;

/**
 * All the recorders come from RecorderFactory class. By default there is only
 * one implementation of Recorder (CSV format). But there is nothing to block 
 * you from implementing your own recorder if you'd like :)
 * @author Maciej Kowalski
 * @version 1.0
 *
 */
public class RecorderFactory {

	/**
	 * Method gets the default recorder.
	 * @return
	 * @throws Exception
	 */
	public static Recorder getRecorder() throws Exception {
		return new CSVRecorder();
	}
}
