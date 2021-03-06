package Model;

import View.TilePanel;
import Attackers.Cannoneer;
import Attackers.Marine;
import Attackers.Scout;
import Controller.GameController;
/**
 * 
 * @author Team Something
 *
 */
public class Wave {
	public int waveCount = 1;
	
	private int innerCount = 1;
	public boolean enemiesAlive = true;
	
	public Wave(){
		TilePanel.getInstance().display = true;
	}
	/**
	 * 
	 * @param num - (int)waveCount
	 */
	public void setWave(int num){
		waveCount = num;
		innerCount = 1;
		TilePanel.getInstance().display = true;
	}
	/**
	 * Starts a wave
	 */
	public void startingAWave(){
		innerCount = 1;
		waveCount++;
		TilePanel.getInstance().tileMap.waveNumber = waveCount;
		GameController.getInstance().saveData();
		System.out.println("Starting wave " + waveCount);
		TilePanel.getInstance().display = true;
	}
		/**
		 * All waves complete, trigger win condition.
		 */
	public void finishedWaves(){
		innerCount = 1;
		waveCount++;
		TilePanel.getInstance().tileMap.waveNumber = waveCount;
		GameController.getInstance().saveData();
		System.out.println("YOU WON");
		TilePanel.getInstance().display1 = true;
	}
	/**
	 * 
	 * @param bool - set enemiesAlive
	 */
	public void setEnemiesAlive(boolean bool){
		enemiesAlive = bool;
	}
	/**
	 * Begin to spawn waves
	 * @param tick - (int)
	 */
	public void attemptSpawn(int tick){
		if(tick % 70 == 0){
			System.out.println("Wave: attempting to spawn wave:" + waveCount + " inner:" + innerCount);
			TilePanel.getInstance().display = false;
			switch(waveCount){
			case 1:
				
				if(innerCount == 1){
					TilePanel.getInstance().tileMap.getSpawnTile(1).addAttacker(
							new Marine(TilePanel.getInstance().tileMap.getSpawnTile(1)));
				}else if(innerCount == 2){
					TilePanel.getInstance().tileMap.getSpawnTile(2).addAttacker(
							new Marine(TilePanel.getInstance().tileMap.getSpawnTile(2)));
					
				}else if(!enemiesAlive){
					startingAWave();
				}
				break;
			case 2:
				if(innerCount == 1){
					TilePanel.getInstance().tileMap.getSpawnTile(1).addAttacker(
							new Marine(TilePanel.getInstance().tileMap.getSpawnTile(1)));
				}else if(innerCount == 2){
					TilePanel.getInstance().tileMap.getSpawnTile(2).addAttacker(
							new Scout(TilePanel.getInstance().tileMap.getSpawnTile(2)));
					
				}else if(innerCount == 3){
				TilePanel.getInstance().tileMap.getSpawnTile(2).addAttacker(
						new Marine(TilePanel.getInstance().tileMap.getSpawnTile(2)));
				
				}else if(!enemiesAlive){
					startingAWave();
				}
				break;
			case 3:
				if(innerCount == 1){
					TilePanel.getInstance().tileMap.getSpawnTile(1).addAttacker(
							new Scout(TilePanel.getInstance().tileMap.getSpawnTile(1)));
				}else if(innerCount == 2){
					TilePanel.getInstance().tileMap.getSpawnTile(2).addAttacker(
							new Scout(TilePanel.getInstance().tileMap.getSpawnTile(2)));
					
				}else if(innerCount == 3){
				TilePanel.getInstance().tileMap.getSpawnTile(2).addAttacker(
						new Cannoneer(TilePanel.getInstance().tileMap.getSpawnTile(2)));
				
				}else if(!enemiesAlive){
					finishedWaves();
				}
				break;
			}
			innerCount ++;
		}
		
		
	}
}
