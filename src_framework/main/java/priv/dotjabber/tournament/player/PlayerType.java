/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.player;

/**
 * Well, it his version of AITorunament (1.0), our staff assumed that there could be only
 * two players - there is no exception from this rule... maybe some other time...
 * @author Maciej Kowalski
 * @version 1.0
 *
 */
public enum PlayerType {
	PLAYER_ONE {

		@Override
		public String toString() {
			return "Player One";
		}
	},
	
	PLAYER_TWO {

		@Override
		public String toString() {
			return "Player Two";
		}
	};
}
