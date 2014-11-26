package View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ConcurrentModificationException;
import java.util.Vector;

import javax.swing.JPanel;

import Maps.DesertUprising;
import Model.Attacker;
import Model.Map;
import Model.MasterList;
import Model.Tile;

/**
 * A clear panel that is used to display Structures and Attackers in the game
 * 
 * @author Team Something
 *
 */

public class TilePanel extends JPanel {
	private static TilePanel tilePanel;
	public Map tileMap;
	MasterList masterList;

	/**
	 * Constructs the TilePanel for use in the GameGUI
	 */
	private TilePanel() {
		//this.setPreferredSize(new Dimension(WIDTH, HEIGHT)); already set
		this.setOpaque(false);
		this.setVisible(true);
		tileMap = new DesertUprising();
		masterList = MasterList.getInstance();
	}

	public static TilePanel getInstance() {
		if (tilePanel == null) {
			tilePanel = new TilePanel();
		}
		return tilePanel;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		try{
			
		for(Vector<Tile> vec: tileMap.getGameBoard()){
			for(Tile tile: vec){
				if(tile.getStructure() != null){
					tile.getStructure().draw(g2);
				}
				for(Attacker attacker: tile.getAttackers()){
					attacker.draw(g2);
				}
			}
		}
		}catch(ConcurrentModificationException e){
			System.out.println("TilePanel: repaint error, ConcurrentModificationException\n");
			e.printStackTrace();
		}
//		synchronized(masterList){
//			Iterator<Drawable> itr = masterList.iterator();
//			while(itr.hasNext()){
//				System.out.println("drawing");
//				itr.next().draw(g2);
//			}
//		}
		
		
		
	}
	
	public Map getMap(){
		return tileMap;
	}
}
