package priv.dotjabber.tournament.tanks.player.impl;

import java.util.Random;

import priv.dotjabber.tournament.tanks.model.TanksMove;
import priv.dotjabber.tournament.tanks.model.TanksModel;
import priv.dotjabber.tournament.tanks.player.TanksPlayer;

public class TanksRandomPlayer extends TanksPlayer {
	private static boolean option = false;
	
	private Random rand;
	private String name;
	
	public TanksRandomPlayer() {
		rand = new Random();
		
		if(option) {
			name = "Olgierd";
			option = !option;
			
		} else {
			name = "Gustlik";
			option = !option;
		}
	}
	
	@Override
	public TanksMove getMove(TanksModel model) {
		return TanksMove.values()[rand.nextInt(TanksMove.values().length)];
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getEmail() {
		return "dotjabber@gmail.com";
	}
}
