/*
 * 
 * A desert marine outpost world. Conditions here are rough and supplies are sparse. The marines
 * want off this gods-forsaken hellhole and have taken up arms in mutiny!
 * 
 */

package Maps;

import Model.Base;
import Model.Map;
import Model.Tile;
import Structures.BaseDesertUprising;

/**
 * The DesertUprising game map.
 * 
 * @author Team Something
 *
 */
@SuppressWarnings("serial")
public class DesertUprising extends Map {
	private static Map theMap;
	private static int guiHeight = 600;
	private static int guiWidth = 800;

	private static int height = guiHeight / getTileWidth();// 15
	private static int width = guiWidth / getTileWidth();// 20
	private Tile spawnTile1, spawnTile2;
	private static final int BASE_X = 3;
	private static final int BASE_Y = 8;

	private DesertUprising() {
		super(height, width);
		mapImageName = "desertuprising.jpg";
		setPath();
		setBase();
		setSpawnPoints();
		setTiles();

	}

	public static DesertUprising getInstance() {
		if (theMap == null)
			theMap = new DesertUprising();
		return (DesertUprising) theMap;

	}

	@Override
	public Map reInit() {
		theMap = new DesertUprising();
		return theMap;
	}

	public static void setMap(Map map) {
		theMap = map;
	}

	@Override
	public int getBaseX() {
		return BASE_X;
	}

	@Override
	public int getBaseY() {
		return BASE_Y;
	}

	private void setTiles() {
		// Set blocked (non-buildable) tiles

		gameBoard.get(0).get(1).setBuild(false);
		gameBoard.get(0).get(2).setBuild(false);
		gameBoard.get(0).get(4).setBuild(false);
		gameBoard.get(0).get(5).setBuild(false);
		gameBoard.get(0).get(7).setBuild(false);
		gameBoard.get(0).get(8).setBuild(false);
		gameBoard.get(0).get(9).setBuild(false);
		gameBoard.get(0).get(10).setBuild(false);
		gameBoard.get(0).get(11).setBuild(false);
		gameBoard.get(0).get(13).setBuild(false);
		gameBoard.get(0).get(14).setBuild(false);

		gameBoard.get(1).get(1).setBuild(false);
		gameBoard.get(1).get(2).setBuild(false);
		gameBoard.get(1).get(3).setBuild(false);
		gameBoard.get(1).get(7).setBuild(false);
		gameBoard.get(1).get(8).setBuild(false);
		gameBoard.get(1).get(9).setBuild(false);
		gameBoard.get(1).get(10).setBuild(false);
		gameBoard.get(1).get(13).setBuild(false);
		gameBoard.get(1).get(14).setBuild(false);

		gameBoard.get(2).get(1).setBuild(false);
		gameBoard.get(2).get(2).setBuild(false);
		gameBoard.get(2).get(3).setBuild(false);
		gameBoard.get(2).get(4).setBuild(false);
		gameBoard.get(2).get(9).setBuild(false);
		gameBoard.get(2).get(11).setBuild(false);
		gameBoard.get(2).get(12).setBuild(false);
		gameBoard.get(2).get(13).setBuild(false);

		gameBoard.get(3).get(3).setBuild(false);
		gameBoard.get(3).get(4).setBuild(false);
		gameBoard.get(3).get(9).setBuild(false);
		gameBoard.get(3).get(10).setBuild(false);
		gameBoard.get(3).get(12).setBuild(false);

		gameBoard.get(4).get(3).setBuild(false);
		gameBoard.get(4).get(12).setBuild(false);
		gameBoard.get(4).get(13).setBuild(false);

		gameBoard.get(5).get(0).setBuild(false);
		gameBoard.get(5).get(1).setBuild(false);
		gameBoard.get(5).get(3).setBuild(false);
		gameBoard.get(5).get(4).setBuild(false);

		gameBoard.get(6).get(0).setBuild(false);
		gameBoard.get(6).get(2).setBuild(false);
		gameBoard.get(6).get(3).setBuild(false);
		gameBoard.get(6).get(4).setBuild(false);
		gameBoard.get(6).get(5).setBuild(false);
		gameBoard.get(6).get(13).setBuild(false);
		gameBoard.get(6).get(14).setBuild(false);

		gameBoard.get(7).get(0).setBuild(false);
		gameBoard.get(7).get(2).setBuild(false);
		gameBoard.get(7).get(3).setBuild(false);
		gameBoard.get(7).get(4).setBuild(false);
		gameBoard.get(7).get(11).setBuild(false);
		gameBoard.get(7).get(12).setBuild(false);
		gameBoard.get(7).get(13).setBuild(false);

		gameBoard.get(8).get(2).setBuild(false);
		gameBoard.get(8).get(3).setBuild(false);
		gameBoard.get(8).get(4).setBuild(false);
		gameBoard.get(8).get(5).setBuild(false);
		gameBoard.get(8).get(7).setBuild(false);
		gameBoard.get(8).get(8).setBuild(false);
		gameBoard.get(8).get(11).setBuild(false);
		gameBoard.get(8).get(12).setBuild(false);
		gameBoard.get(8).get(13).setBuild(false);

		gameBoard.get(9).get(3).setBuild(false);
		gameBoard.get(9).get(4).setBuild(false);
		gameBoard.get(9).get(7).setBuild(false);
		gameBoard.get(9).get(14).setBuild(false);

		gameBoard.get(11).get(0).setBuild(false);
		gameBoard.get(11).get(1).setBuild(false);
		gameBoard.get(11).get(2).setBuild(false);
		gameBoard.get(11).get(8).setBuild(false);
		gameBoard.get(11).get(9).setBuild(false);

		gameBoard.get(12).get(0).setBuild(false);
		gameBoard.get(12).get(1).setBuild(false);
		gameBoard.get(12).get(2).setBuild(false);
		gameBoard.get(12).get(8).setBuild(false);
		gameBoard.get(12).get(9).setBuild(false);

		gameBoard.get(13).get(2).setBuild(false);
		gameBoard.get(13).get(6).setBuild(false);
		gameBoard.get(13).get(7).setBuild(false);
		gameBoard.get(13).get(8).setBuild(false);
		gameBoard.get(13).get(12).setBuild(false);
		gameBoard.get(13).get(13).setBuild(false);

		gameBoard.get(14).get(8).setBuild(false);
		gameBoard.get(14).get(9).setBuild(false);

		gameBoard.get(15).get(0).setBuild(false);
		gameBoard.get(15).get(4).setBuild(false);
		gameBoard.get(15).get(5).setBuild(false);
		gameBoard.get(15).get(6).setBuild(false);
		gameBoard.get(15).get(8).setBuild(false);
		gameBoard.get(15).get(9).setBuild(false);
		gameBoard.get(15).get(10).setBuild(false);
		gameBoard.get(15).get(11).setBuild(false);
		gameBoard.get(15).get(13).setBuild(false);
		gameBoard.get(15).get(14).setBuild(false);

		gameBoard.get(16).get(2).setBuild(false);
		gameBoard.get(16).get(3).setBuild(false);
		gameBoard.get(16).get(4).setBuild(false);
		gameBoard.get(16).get(5).setBuild(false);
		gameBoard.get(16).get(6).setBuild(false);
		gameBoard.get(16).get(8).setBuild(false);
		gameBoard.get(16).get(9).setBuild(false);
		gameBoard.get(16).get(10).setBuild(false);
		gameBoard.get(16).get(11).setBuild(false);
		gameBoard.get(16).get(12).setBuild(false);
		gameBoard.get(16).get(13).setBuild(false);
		gameBoard.get(16).get(14).setBuild(false);

		gameBoard.get(17).get(3).setBuild(false);
		gameBoard.get(17).get(5).setBuild(false);
		gameBoard.get(17).get(7).setBuild(false);
		gameBoard.get(17).get(8).setBuild(false);
		gameBoard.get(17).get(9).setBuild(false);
		gameBoard.get(17).get(10).setBuild(false);
		gameBoard.get(17).get(13).setBuild(false);
		gameBoard.get(17).get(14).setBuild(false);

		gameBoard.get(18).get(7).setBuild(false);
		gameBoard.get(18).get(9).setBuild(false);
		gameBoard.get(18).get(10).setBuild(false);
		gameBoard.get(18).get(13).setBuild(false);

		gameBoard.get(19).get(13).setBuild(false);
		gameBoard.get(19).get(14).setBuild(false);

	}

	@Override
	public void setBase() {
		gameBoard.get(BASE_X).get(BASE_Y)
				.addStructure(new BaseDesertUprising(BASE_X, BASE_Y));

	}

	@Override
	public Base getBase() {
		return (Base) gameBoard.get(BASE_X).get(BASE_Y).getStructure();
	}

	@Override
	public void setSpawnPoints() {
		// One spawn point on opposite end of the board
		gameBoard.get(19).get(1).setSpawn(true);
		gameBoard.get(11).get(14).setSpawn(true);
		spawnTile1 = gameBoard.get(19).get(1);
		spawnTile2 = gameBoard.get(11).get(14);

	}

	// This hardcodes our path tiles
	@Override
	public void setPath() {
		// SPAWN 1 PATH
		gameBoard.get(19).get(1).setMove(true, gameBoard.get(18).get(1));
		gameBoard.get(19).get(1).setBuild(false);
		// gameBoard.get(19).get(1).setDirection(Dir.LEFT);

		gameBoard.get(18).get(1).setMove(true, gameBoard.get(17).get(1));
		gameBoard.get(18).get(1).setBuild(false);
		// gameBoard.get(18).get(1).setDirection(Dir.LEFT);

		gameBoard.get(17).get(1).setMove(true, gameBoard.get(16).get(1));
		gameBoard.get(17).get(1).setBuild(false);
		// gameBoard.get(17).get(1).setDirection(Dir.LEFT);

		gameBoard.get(16).get(1).setMove(true, gameBoard.get(15).get(1));
		gameBoard.get(16).get(1).setBuild(false);
		// gameBoard.get(16).get(1).setDirection(Dir.LEFT);

		gameBoard.get(15).get(1).setMove(true, gameBoard.get(15).get(2));
		gameBoard.get(15).get(1).setBuild(false);
		// gameBoard.get(15).get(1).setDirection(Dir.DOWN);

		gameBoard.get(15).get(2).setMove(true, gameBoard.get(15).get(3));
		gameBoard.get(15).get(2).setBuild(false);
		// gameBoard.get(15).get(2).setDirection(Dir.DOWN);

		gameBoard.get(15).get(3).setMove(true, gameBoard.get(14).get(3));
		gameBoard.get(15).get(3).setBuild(false);
		// gameBoard.get(15).get(3).setDirection(Dir.LEFT);

		gameBoard.get(14).get(3).setMove(true, gameBoard.get(13).get(3));
		gameBoard.get(14).get(3).setBuild(false);
		// gameBoard.get(14).get(3).setDirection(Dir.LEFT);

		gameBoard.get(13).get(3).setMove(true, gameBoard.get(12).get(3));
		gameBoard.get(13).get(3).setBuild(false);
		// gameBoard.get(13).get(3).setDirection(Dir.LEFT);

		gameBoard.get(12).get(3).setMove(true, gameBoard.get(12).get(4));
		gameBoard.get(12).get(3).setBuild(false);
		// gameBoard.get(12).get(3).setDirection(Dir.DOWN);

		gameBoard.get(12).get(4).setMove(true, gameBoard.get(12).get(5));
		gameBoard.get(12).get(4).setBuild(false);
		// gameBoard.get(12).get(4).setDirection(Dir.DOWN);

		gameBoard.get(12).get(5).setMove(true, gameBoard.get(12).get(6));
		gameBoard.get(12).get(5).setBuild(false);
		// gameBoard.get(12).get(5).setDirection(Dir.DOWN);

		gameBoard.get(12).get(6).setMove(true, gameBoard.get(11).get(6));
		gameBoard.get(12).get(6).setBuild(false);
		// gameBoard.get(12).get(6).setDirection(Dir.LEFT);

		gameBoard.get(11).get(6).setMove(true, gameBoard.get(10).get(6));
		gameBoard.get(11).get(6).setBuild(false);
		// gameBoard.get(11).get(6).setDirection(Dir.LEFT);

		gameBoard.get(10).get(6).setMove(true, gameBoard.get(9).get(6));
		gameBoard.get(10).get(6).setBuild(false);
		// gameBoard.get(10).get(6).setDirection(Dir.LEFT);

		gameBoard.get(9).get(6).setMove(true, gameBoard.get(8).get(6));
		gameBoard.get(9).get(6).setBuild(false);
		// gameBoard.get(9).get(6).setDirection(Dir.LEFT);

		gameBoard.get(8).get(6).setMove(true, gameBoard.get(7).get(6));
		gameBoard.get(8).get(6).setBuild(false);
		// gameBoard.get(8).get(6).setDirection(Dir.LEFT);

		gameBoard.get(7).get(6).setMove(true, gameBoard.get(7).get(7));
		gameBoard.get(7).get(6).setBuild(false);
		// gameBoard.get(7).get(6).setDirection(Dir.DOWN);

		gameBoard.get(7).get(7).setMove(true, gameBoard.get(7).get(8));
		gameBoard.get(7).get(7).setBuild(false);
		// gameBoard.get(7).get(7).setDirection(Dir.DOWN);

		gameBoard.get(7).get(8).setMove(true, gameBoard.get(7).get(9));
		gameBoard.get(7).get(8).setBuild(false);
		// gameBoard.get(7).get(8).setDirection(Dir.DOWN);

		gameBoard.get(7).get(9).setMove(true, gameBoard.get(7).get(10));
		gameBoard.get(7).get(9).setBuild(false);
		// gameBoard.get(7).get(9).setDirection(Dir.DOWN);

		gameBoard.get(7).get(10).setMove(true, gameBoard.get(6).get(10));
		gameBoard.get(7).get(10).setBuild(false);
		// gameBoard.get(7).get(10).setDirection(Dir.LEFT);

		gameBoard.get(6).get(10).setMove(true, gameBoard.get(5).get(10));
		gameBoard.get(6).get(10).setBuild(false);
		// gameBoard.get(6).get(10).setDirection(Dir.LEFT);

		gameBoard.get(5).get(10).setMove(true, gameBoard.get(5).get(9));
		gameBoard.get(5).get(10).setBuild(false);
		// gameBoard.get(5).get(10).setDirection(Dir.UP);

		gameBoard.get(5).get(9).setMove(true, gameBoard.get(5).get(8));
		gameBoard.get(5).get(9).setBuild(false);
		// gameBoard.get(5).get(9).setDirection(Dir.UP);

		gameBoard.get(5).get(8).setMove(true, gameBoard.get(5).get(7));
		gameBoard.get(5).get(8).setBuild(false);
		// gameBoard.get(5).get(8).setDirection(Dir.UP);

		gameBoard.get(5).get(7).setMove(true, gameBoard.get(5).get(6));
		gameBoard.get(5).get(7).setBuild(false);
		// gameBoard.get(5).get(7).setDirection(Dir.UP);

		gameBoard.get(5).get(6).setMove(true, gameBoard.get(5).get(5));
		gameBoard.get(5).get(6).setBuild(false);
		// gameBoard.get(5).get(6).setDirection(Dir.UP);

		gameBoard.get(5).get(5).setMove(true, gameBoard.get(4).get(5));
		gameBoard.get(5).get(5).setBuild(false);
		// gameBoard.get(5).get(5).setDirection(Dir.LEFT);

		gameBoard.get(4).get(5).setMove(true, gameBoard.get(3).get(5));
		gameBoard.get(4).get(5).setBuild(false);
		// gameBoard.get(4).get(5).setDirection(Dir.LEFT);

		gameBoard.get(3).get(5).setMove(true, gameBoard.get(3).get(6));
		gameBoard.get(3).get(5).setBuild(false);
		// gameBoard.get(3).get(5).setDirection(Dir.DOWN);

		gameBoard.get(3).get(6).setMove(true, gameBoard.get(3).get(7));
		gameBoard.get(3).get(6).setBuild(false);
		// gameBoard.get(3).get(6).setDirection(Dir.DOWN);

		// LAST TILE TO BASE!!!
		gameBoard.get(3).get(7).setMove(true, null);
		gameBoard.get(3).get(7).setBuild(false);
		// gameBoard.get(3).get(7).setDirection(Dir.DOWN);

		// SPAWN 2 PATH
		gameBoard.get(11).get(14).setMove(true, gameBoard.get(11).get(13));
		gameBoard.get(11).get(14).setBuild(false);
		// gameBoard.get(11).get(14).setDirection(Dir.UP);

		gameBoard.get(11).get(13).setMove(true, gameBoard.get(11).get(12));
		gameBoard.get(11).get(13).setBuild(false);
		// gameBoard.get(11).get(13).setDirection(Dir.UP);

		gameBoard.get(11).get(12).setMove(true, gameBoard.get(11).get(11));
		gameBoard.get(11).get(12).setBuild(false);
		// gameBoard.get(11).get(12).setDirection(Dir.UP);

		gameBoard.get(11).get(11).setMove(true, gameBoard.get(11).get(10));
		gameBoard.get(11).get(11).setBuild(false);
		// gameBoard.get(11).get(11).setDirection(Dir.UP);

		gameBoard.get(11).get(10).setMove(true, gameBoard.get(10).get(10));
		gameBoard.get(11).get(10).setBuild(false);
		// gameBoard.get(11).get(10).setDirection(Dir.LEFT);

		gameBoard.get(10).get(10).setMove(true, gameBoard.get(9).get(10));
		gameBoard.get(10).get(10).setBuild(false);
		// gameBoard.get(10).get(10).setDirection(Dir.LEFT);

		gameBoard.get(9).get(10).setMove(true, gameBoard.get(9).get(9));
		gameBoard.get(9).get(10).setBuild(false);
		// gameBoard.get(9).get(10).setDirection(Dir.UP);

		gameBoard.get(9).get(9).setMove(true, gameBoard.get(9).get(8));
		gameBoard.get(9).get(9).setBuild(false);
		// gameBoard.get(9).get(9).setDirection(Dir.UP);

		gameBoard.get(9).get(8).setMove(true, gameBoard.get(10).get(8));
		gameBoard.get(9).get(8).setBuild(false);
		// gameBoard.get(9).get(8).setDirection(Dir.RIGHT);

		gameBoard.get(10).get(8).setMove(true, gameBoard.get(10).get(7));
		gameBoard.get(10).get(8).setBuild(false);
		// gameBoard.get(10).get(8).setDirection(Dir.UP);

		gameBoard.get(10).get(7).setMove(true, gameBoard.get(10).get(6));
		gameBoard.get(10).get(7).setBuild(false);
		// gameBoard.get(10).get(7).setDirection(Dir.UP);

	}

	@Override
	public Tile getSpawnTile(int n) {
		if (n == 1)
			return spawnTile1;
		else if (n == 2)
			return spawnTile2;

		return null;
	}

}
