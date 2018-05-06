package tinderapp;

//make a separate package for modal

public class Location {

	private float xCord;
	private float yCord;

	public Location(float xCord, float yCord) {
		this.xCord = xCord;
		this.yCord = yCord;
	}

	public float getxCord() {
		return xCord;
	}

	public void setxCord(float xCord) {
		this.xCord = xCord;
	}

	public float getyCord() {
		return yCord;
	}

	public void setyCord(float yCord) {
		this.yCord = yCord;
	}

	// directly retuen the distance instead of asssiging to a variable
	public static double findDistance(Location l1, Location l2) {
		double distance = (float) Math.sqrt((Math.pow(l1.xCord - l2.xCord, 2) + Math.pow(l1.yCord - l2.yCord, 2)));
		return distance;
	}
}
