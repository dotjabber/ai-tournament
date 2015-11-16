/**
 * AITournament (Gomoku 2D)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmailcom)
 */
package priv.dotjabber.tournament.gomoku.player;

import java.awt.Point;

import priv.dotjabber.tournament.gomoku.model.GomokuModel;
import priv.dotjabber.tournament.player.Player;

public abstract class GomokuPlayer extends Player<GomokuModel, Point> {

    @Override
    public String getGameName() {
        return "gomoku";
    }
}
