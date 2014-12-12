package command;

import java.util.Vector;

import Controller.TDClient;
import Controller.TDServer;
import Model.Tile;

public class UpdateMiniMapCommand extends Command{
	
	Vector<Vector<Tile>> gameMap;

	public UpdateMiniMapCommand(String username, Vector<Vector<Tile>> mapUpdate) {
		super(username);
		gameMap = mapUpdate;
	}

	@Override
	public void serverExecute(TDServer server) {
		// TODO Auto-generated method stub
		//server
	}

	@Override
	public void clientExecute(TDClient client) {
		// TODO Auto-generated method stub
		//client
	}

}