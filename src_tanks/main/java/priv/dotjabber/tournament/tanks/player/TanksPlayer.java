/**
 * AITournament (Tanks 2D)
 * Copyright (C) 2012 Maciej Kowalski (dotjabber@gmailcom)
 */
package priv.dotjabber.tournament.tanks.player;

import priv.dotjabber.tournament.player.Player;
import priv.dotjabber.tournament.tanks.model.TanksMove;
import priv.dotjabber.tournament.tanks.model.TanksModel;

public abstract class TanksPlayer extends Player<TanksModel, TanksMove> {

    @Override
    public String getGameName() {
        return "tanks";
    }
}
