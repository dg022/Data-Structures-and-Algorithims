//Author: David George
//Student ID: 251004930
public final class Location {

	int x;
	int y;

	public Location(int x, int y) {

		this.x = x;
		this.y = y;

	}

	public int xCoord() {

		return this.x;

	}

	public int yCoord() {

		return this.y;
	}

	//Compared to as defined by the assignment specifications
	public int compareTo(Location p) {

		if (this.x == p.x & this.y < p.y) {
			return -1;
		}
		if (this.x < p.x) {
			return -1;
		}

		if (this.x == p.x & this.y == p.y) {
			return 0;
		}
		return 1;

	}
}
