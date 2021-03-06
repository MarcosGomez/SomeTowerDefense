package Structures;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Model.Base;
import Model.SpecialAttack;
import Model.Structure;
import TowerFSM.TowerStates;
/**
 * This class represents the player's base in "Beach Betrayal". It cannot
 * attack, but if it is destroyed, the game is over.
 * @author Team Something
 *
 */
@SuppressWarnings("serial")
public class BaseBeachBetrayal extends Base {

	protected static BufferedImage waitImage;
	protected static BufferedImage attackImage;
	protected static BufferedImage upgradeImage;
	protected static BufferedImage explodeImage;

	/**
	 * The constructor, arguments are the x and y coordinates of the base.
	 * @param x
	 * @param y
	 */
	public BaseBeachBetrayal(int x, int y) {
		super(500, 0, 0, 0, 0, 0, 0, x, y, SpecialAttack.NONE);
		name = "Beach Betrayal Base";
		price = 0;
	}

	
	/**
	 * Establishes the images for the various states.
	 */
	@Override
	public void setImages() {
		if (waitImage == null) {
			File imageFile = new File(Structure.baseDir + "BeachBetrayal.png");
			try {
				waitImage = ImageIO.read(imageFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (attackImage == null) { // cannot attack
			File imageFile = new File(Structure.baseDir + "error.png");
			try {
				attackImage = ImageIO.read(imageFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (upgradeImage == null) { // cannot upgrade
			File imageFile = new File(Structure.baseDir + "error.png");
			try {
				upgradeImage = ImageIO.read(imageFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (explodeImage == null) {
			File imageFile = new File(Structure.baseDir
					+ "explosion-sprite40.png");
			try {
				explodeImage = ImageIO.read(imageFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Determines which image to use.
	 */
	@Override
	protected BufferedImage getImage(TowerStates newState) {
		BufferedImage correctImage = null;
		switch (newState) {
		case ATTACK:
			correctImage = attackImage;
			break;
		case WAIT:
			correctImage = waitImage;
			break;
		case EXPLODE:
			correctImage = explodeImage;
			break;
		case UPGRADE:
			correctImage = upgradeImage;
			break;
		default:
			System.out.println("Problem Encountered in getImage()");
		}
		return correctImage;
	}
}
