/**
 * AITournament (Framework)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmail.com)
 */
package priv.dotjabber.tournament.model;

/**
 * Each of players can make a move, but not every move can be valid. Let's imagine a tic-tac-toe
 * game where player tries to tap the field which was already taken by another guy. This move is 
 * invalid. It is up to GameModel to figgure it out and it is up to GameController to do something about
 * it. Mostly an invalid move is just ignored and player looses his turn.
 * @author Maciej Kowalski
 *
 */
public enum MoveValidity {
	MOVE_VALID,
	MOVE_INVALID
}
