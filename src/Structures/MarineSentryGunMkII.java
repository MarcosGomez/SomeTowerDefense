package Structures;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Model.SpecialAttack;
import Model.Structure;
import Model.StructureType;
import TowerFSM.TowerStates;
import TowerFSM.TowerWaiting;

/**
 * The upgraded version of the Sentry Gun. It can track and attack two separate
 * targets on the same tile simultaneously. Should not be buildable on it's own,
 * must be an upgrade to the sentry gun.
 * 
 * @author Team Something
 *
 */
@SuppressWarnings("serial")
public class MarineSentryGunMkII extends Structure {
	protected static BufferedImage waitImage;
	protected static BufferedImage attackImage;
	protected static BufferedImage upgradeImage;
	protected static BufferedImage explodeImage;

	private static final int HITPOINTS = 200;
	private static final int PRODUCTION = 0;
	private static final int RANGE = 3;
	private static final int DAMAGE = 7;
	private static final int SPLASH = 0;
	private static final int RATEOFFIRE = 5;// The smaller, the faster
	private static final int COST = 3000;

	/**
	 * The constructor, arguments are the x and y coordinates of the tower.
	 * @param x
	 * @param y
	 */
	public MarineSentryGunMkII(int x, int y) {
		super(HITPOINTS, PRODUCTION, RANGE, DAMAGE, SPLASH, RATEOFFIRE, COST,
				x, y, SpecialAttack.TWO_TARGETS);
		setImages();
		upgradeTo = StructureType.NONE;
		upgradeCost = 0;
		tower = new TowerWaiting(this);
		name = "Sentry Gun MkII";
		price = 50;
	}

	/**
	 * Establishes the images for the various states.
	 */
	@Override
	public void setImages() {
		if (waitImage == null) {
			File imageFile = new File(Structure.baseDir
					+ "MarineSentryGunMkII.png");
			try {
				waitImage = ImageIO.read(imageFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (attackImage == null) {
			File imageFile = new File(Structure.baseDir
					+ "MarineSentryGunMkIIFire.png");
			try {
				attackImage = ImageIO.read(imageFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (upgradeImage == null) {
			File imageFile = new File(Structure.baseDir
					+ "MarineSentryGunMkII.png");
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
	 * Unused
	 */
	@Override
	public void die() {

	}

	/**
	 * Determines which sprite sheet to use.
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
