/**
 * This class represents finding the shortest path from the WPC to a specific customer given a map.
 * @author Raahim Salman
 * @westernId 251004873
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ShortestPath {

	// Creating an object of class map to be used
	private static Map cityMap;

	/**
	 * Constructor to find the shortest from WPC to customer C
	 * @param filename is the filename for the map
	 */
	public ShortestPath(String filename) throws IOException, FileNotFoundException, InvalidMapException {
		
		try {
		cityMap = new Map(filename);
		}
		
		catch (InvalidMapException e) {
			System.out.println("The map is invalid.");
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found.");
		} catch (IOException e) {
			System.out.println("The input was incorrect.");
		}
	}

	public static void main(String[] args) throws IOException, FileNotFoundException {

		if (args.length < 1) {
			System.out.println("You must provide the name of your input file");
			System.exit(0);
		}
		
		String mapFileName = args[0];
		ShortestPath path = new ShortestPath(args[0]);
		path = new ShortestPath(mapFileName);

		//creating a new doubly linked list to contain type map cell
		DLList<MapCell> shortPath = new DLList<MapCell>();
		
		//obtains the starting location
		MapCell start = path.cityMap.getStart();

		int distance = 0;
		int nDistance = 0;

		shortPath.insert(start, distance);
		start.markInList();

		MapCell cellNode = null; // change
		MapCell neighbour = null; // change
		int count = 0;

		boolean found = false;

		while (!shortPath.isEmpty() && found == false) {
			cellNode = shortPath.getSmallest();
			cellNode.markOutList();

			if (cellNode.isCustomer()) {
				MapCell prev = cellNode;
			
				found = true;
				break;
			}

			else {

				while (path.nextCell(cellNode) != null) {
					MapCell c = path.nextCell(cellNode);

					int D = 1 + cellNode.getDistanceToStart();

					int D2 = c.getDistanceToStart();

					if (D2 > D) {
						c.setDistanceToStart(D);
						c.setPredecessor(cellNode);
					}

					int P = c.getDistanceToStart();

					if (c.isMarkedInList() && P < shortPath.getDataValue(c)) {
						shortPath.changeValue(c, P);
					}

					if (!c.isMarkedInList()) {
						shortPath.insert(c, P);
						c.markInList();
					}
				}

			}

		}
		if (found) 
			System.out.println("There were" + count + "used to findthe shortest path");
		else
			System.out.println("There is no path to the customer");

	}

	private MapCell nextCell(MapCell cell) {

		ArrayList<Integer> filter = new ArrayList<Integer>();
		for (int i = 0; i <= 3; i++) {
			if (cell.getNeighbour(i) != null && !cell.getNeighbour(i).isMarked() && !cell.getNeighbour(i).isBlock()) {
				filter.add(i);
			}
		}

		if (filter.size() == 0)
			return null;

		for (int i = 0; i <= (filter.size() - 1); i++) {
			int j = filter.get(i);

			if (cell.getNeighbour(j) != null) {

				if ((cell.isOmniSwitch() || cell.isPowerStation()) && (!cell.getNeighbour(j).isMarked())
						&& (cell.getNeighbour(j).isCustomer()))
					return cell.getNeighbour(j);
				else if ((cell.isHorizontalSwitch() && (j == 1 || j == 3)))
					return cell.getNeighbour(j);
				else if (cell.isVerticalSwitch() && (j == 0 || j == 2))
					return cell.getNeighbour(j);

				else if ((cell.isOmniSwitch() || cell.isPowerStation()
						|| (cell.isHorizontalSwitch() && (j == 1 || j == 3))
						|| (cell.isVerticalSwitch() && (j == 0 || j == 2)))
						&& (!cell.getNeighbour(j).isMarked())
						&& (cell.getNeighbour(j).isOmniSwitch()
								|| (cell.getNeighbour(j).isHorizontalSwitch() && (j == 1 || j == 3))
								|| (cell.getNeighbour(j).isVerticalSwitch() && (j == 0 || j == 2))))
					return cell.getNeighbour(j);
			}

		}
		return null;
	}
}
