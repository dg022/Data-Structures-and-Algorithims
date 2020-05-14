
/**
 * This class finds the shortest path from the WPC to a customer. 
 * @author David George
 * @westernId 251004930
 */

import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ShortestPath {

	Map cityMap;

	public ShortestPath(String filename) {

		try {
			cityMap = new Map(filename);
		} catch (InvalidMapException | IOException e) {
			
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {

		if (args.length < 1) {
			System.out.println("You must provide the name of the input file");
			System.exit(0);
		}

		String mapFileName = args[0];
		ShortestPath Newpath = new ShortestPath(mapFileName);

		DLList<MapCell> nodePath = new DLList<MapCell>();

		MapCell start = Newpath.cityMap.getStart();

		nodePath.insert(start, 0);
		start.markInList();

		boolean found = false;

		MapCell CurrentNodeMap = null;
		MapCell neighbour = null;
		int distance = 0;
		int distanceCellNode = 0;

		while (!nodePath.isEmpty() && !found) {
			CurrentNodeMap = nodePath.getSmallest();
			CurrentNodeMap.markOutList();

			if (CurrentNodeMap.isCustomer()) {
				found = true;
				break;
			}

			else {

				while (Newpath.nextCell(CurrentNodeMap) != null) {
					neighbour = Newpath.nextCell(CurrentNodeMap);

					distance = 1 + CurrentNodeMap.getDistanceToStart();
					distanceCellNode = neighbour.getDistanceToStart();

					if (distanceCellNode > distance) {
						neighbour.setDistanceToStart(distance);
						neighbour.setPredecessor(CurrentNodeMap);
					}

					int changeDistanceStart = neighbour.getDistanceToStart();

					if (neighbour.isMarkedInList() && changeDistanceStart < nodePath.getDataValue(neighbour)) {
						nodePath.changeValue(neighbour, changeDistanceStart);
					}

					if (!neighbour.isMarkedInList()) {
						nodePath.insert(neighbour, changeDistanceStart);
						neighbour.markInList();

					}

				}

			}

		}

		if (CurrentNodeMap.isCustomer() && found == true) {
			System.out.println("The shortest path is: " + (CurrentNodeMap.getDistanceToStart() + 1) + " cells");
		}

		if (nodePath.isEmpty() && found == false) {
			System.out.println("There is no path");
		}

	}

	/**
	 * This method returns the next possible move
	 * 
	 * @return returns the next possbile cell
	 */

	private MapCell nextCell(MapCell cell) {

		ArrayList<MapCell> list = new ArrayList<MapCell>();
		ArrayList<Integer> lister = new ArrayList<Integer>();

		/**
		 * This method has differnt cases for each type of switch, hence the if
		 * statments checking what type it is.
		 */

		/**
		 * list is being used filter for potential moves
		 */

		if (cell.isVerticalSwitch()) {

			/**
			 * Vertical switches can only move to indexes 0 and 2 This adds the possible
			 * moves to the array list
			 */

			for (int i = 0; i <= 2; i = i + 2) {
				// Add to the list if the cell is not marked
				if ((cell.getNeighbour(i) != null) && !(cell.getNeighbour(i).isMarked())
						&& !(cell.getNeighbour(i).isBlock())) {
					lister.add((i));
				}
			}
			/**
			 * If the list is empty, that means there are no possible moves
			 */

			if (lister.isEmpty()) {
				return null;
			}

			/**
			 * Return the first possible move
			 */

			else {
				return cell.getNeighbour(lister.get(0));
			}

		}

		else if (cell.isHorizontalSwitch()) {

			/**
			 * Horz switches can only move to indexes 1 and 3
			 */

			for (int i = 1; i <= 3; i = i + 2) {

				if ((cell.getNeighbour(i) != null) && !(cell.getNeighbour(i).isMarked())
						&& !(cell.getNeighbour(i).isBlock())) {
					lister.add(i);
				}
			}

			/**
			 * If the list is empty, that means there are no possibe moves
			 */

			if (lister.isEmpty()) {
				return null;
			}

			/**
			 * Return the first possible move
			 */

			else {
				return cell.getNeighbour(lister.get(0));
			}

		}

		/**
		 * Checks for omni cells and power stations, they have the exact same behaviour
		 */
		else if (cell.isOmniSwitch() || cell.isPowerStation()) {

			/**
			 * Adds to the list if its not marked
			 */

			for (int i = 0; i < 4; i++) {

				if ((cell.getNeighbour(i) != null) && !(cell.getNeighbour(i).isMarked())
						&& !(cell.getNeighbour(i).isBlock())) {

					lister.add(i);
				}

			}

			/**
			 * If the list is null, then return null because there are no possible moves
			 */

			if (lister.isEmpty()) {
				return null;
			}

			else {

				/**
				 * Since its omni or power, it can go up or down, if the cells above it or below
				 * it are vertical or omni Same but vise versa if index is 1 or 3 will handle it
				 * the same way.
				 * 
				 */

				for (int i = 0; i < lister.size(); i++) {

					if (cell.getNeighbour(lister.get(i)).isCustomer()) {
						return cell.getNeighbour(lister.get(i));
					}

					if (lister.get(i) == 0
							&& (cell.getNeighbour(0).isOmniSwitch() || cell.getNeighbour(0).isVerticalSwitch())) {
						return cell.getNeighbour(lister.get(i));
					}

					if (lister.get(i) == 2
							&& (cell.getNeighbour(2).isOmniSwitch() || cell.getNeighbour(2).isVerticalSwitch())) {
						return cell.getNeighbour(lister.get(i));
					}

					if (lister.get(i) == 1
							&& (cell.getNeighbour(1).isOmniSwitch() || cell.getNeighbour(1).isHorizontalSwitch())) {
						return cell.getNeighbour(lister.get(i));
					}

					if (lister.get(i) == 3
							&& (cell.getNeighbour(3).isOmniSwitch() || cell.getNeighbour(3).isHorizontalSwitch())) {
						return cell.getNeighbour(lister.get(i));
					}

				}
			}

		}
		return null;
	}
}