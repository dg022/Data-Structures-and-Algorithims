
/**
 * Class FindConnection contains within it methods which sort, select, and return the best possible cell using a array stack collection. 
 * @author David George 
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FindConnection {

	private static Map cityMap;

	/**
	 * Constructor creates a new object of type of map
	 * @param filename takes in the name of the file
	 */

	public FindConnection(String filename) {
		try {
			cityMap = new Map(filename);
		} catch (InvalidMapException e) {
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Main method which will use the bestCell method to add the best possible next
	 * move onto the array stack, stops when customer is found.
	 */

	public static void main(String[] args) {

		try {

			FindConnection path = new FindConnection(args[0]);
			if (args.length < 1) {
				System.out.print("You must provide the name of the input file");
				System.exit(0);
			}

			String mapFileName = args[0];
			path = new FindConnection(mapFileName);

			ArrayStack<MapCell> STACK = new ArrayStack<MapCell>();

			STACK.push(cityMap.getStart());

			cityMap.getStart().markInStack();

			boolean found = false;

			// Checks the top of the stack, while loop continues until the destination is
			// found

			MapCell current = STACK.peek();
			while (!STACK.isEmpty() && !found) {

				if (found)
					break;

				current = STACK.peek();
				if (current.isCustomer()) {
					System.out.print(("CUSOMTER HAS BEEN  FOUND! The Number of moves required was:" + STACK.size()));
					found = true;
					break;
				}

				else

				{
					// Will keep calling the best cell method until a null is returned by the
					// bestCell method.
					while (path.bestCell(current) != null && !STACK.isEmpty() && !found) {

						if (current.isCustomer()) {
							System.out.print(
									("CUSOMTER HAS BEEN  FOUND! The Number of moves required was:" + STACK.size()));
							found = true;
							break;
						}

						STACK.push(path.bestCell(current));
						path.bestCell(current).markInStack();
						current = STACK.peek();

						if (current.isCustomer()) {

							System.out.print(
									("CUSOMTER HAS BEEN  FOUND! The Number of moves required was:" + STACK.size()));
							found = true;
							break;

						}

						if (current.isPowerStation()) {

							System.out.print(("No path is possible"));
							found = true;
							break;

						}

					}

					if (found) {
						break;
					}

					// If bestCell is null, pop it and mark out of the stack.
					if (path.bestCell(current) == null
							|| path.bestCell(current).isMarked() | path.bestCell(current).isBlock()) {
						STACK.peek().markOutStack();
						STACK.pop();
					}

				}

			}
		} catch (EmptyStackException e) {

			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("No starting point, invalid file");
		}

	}

	/**
	 * Constructor creates a rectangle with the given length and width
	 * 
	 * @param cell of type map cell will take in the current cell.
	 * @return will return the best possible cell, based on the rules
	 */

	private MapCell bestCell(MapCell cell) {

		/**
		 * This method has differnt cases for each type of switch, hence the if
		 * statments checking what type it is.
		 */

		/**
		 * list is being used filter for potential moves
		 */

		ArrayList<MapCell> list = new ArrayList<MapCell>();

		if (cell.isVerticalSwitch()) {

			/**
			 * Vertical switches can only move to indexes 0 and 2
			 */

			for (int i = 0; i <= 2; i = i + 2) {

				if (cell.getNeighbour(i).isCustomer()) {

					return cell.getNeighbour(i);
				}
				// Add to the list if the cell is not marked
				if (!cell.getNeighbour(i).isMarked()) {
					list.add(cell.getNeighbour(i));
				}
			}

			/**
			 * If the list is empty, that means there are no possible moves
			 */

			if (list.isEmpty()) {
				return null;
			}

			/**
			 * check for omni-directional switches
			 */
			for (int j = 0; j < list.size(); j++) {

				if (list.get(j).isOmniSwitch()) {

					return list.get(j);
				}

			}
			/**
			 * remaining cells must be vertical or horizontal
			 */
			for (int j = 0; j < list.size(); j++) {

				if (list.get(j).isVerticalSwitch()) {

					return list.get(j);

				}
				/**
				 * No possible moves fitting crtirea
				 */
				return null;

			}
		}

		/**
		 * Horiziontal switches can only move to indexes 0 and 2
		 */
		else if (cell.isHorizontalSwitch()) {

			/**
			 * Horiziontal switches can only move to indexes 1 and 3
			 */

			for (int i = 1; i <= 3; i = i + 2) {

				if (cell.getNeighbour(i).isCustomer()) {

					return cell.getNeighbour(i);
				}

				if (!cell.getNeighbour(i).isMarked()) {
					list.add(cell.getNeighbour(i));
				}
			}

			/**
			 * If the list is empty, that means there are no possibe moves
			 */

			if (list.isEmpty()) {
				return null;
			}

			/**
			 * Check for omni switches
			 */
			for (int j = 0; j < list.size(); j++) {

				if (list.get(j).isOmniSwitch()) {

					return list.get(j);
				}

			}
			/**
			 * Remaining cells must be vertical or horizontal
			 */

			for (int j = 0; j < list.size(); j++) {

				if (list.get(j).isHorizontalSwitch()) {

					return list.get(j);

				}

				/**
				 * No possible moves fitting crteria
				 */
				return null;

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

				if ((cell.getNeighbour(i) != null) && !(cell.getNeighbour(i).isMarked())) {

					list.add(cell.getNeighbour(i));
				}

			}

			/**
			 * If the list is null, then return null because there are no possible moves
			 */

			if (list.isEmpty()) {
				return null;
			}

			/**
			 * Checks for customers
			 */

			for (int i = 0; i < list.size(); i++) {

				if (list.get(i).isCustomer()) {

					return list.get(i);

				}

			}

			/**
			 * Checks for OmniSwitches
			 */

			for (int j = 0; j < list.size(); j++) {
				if (list.get(j) != null && list.get(j).isOmniSwitch()) {
					return list.get(j);
				}

			}

			/**
			 * Goes through the remaining cells in the list, which are Horizontal or
			 * vERITCAL Omni can only go up or down if there are vertical switches Omni can
			 * only go left or right if there are horziontal swithces there
			 */

			for (int j = 0; j < list.size(); j++) {

				if (cell.getNeighbour(0) != null) {
					if (list.get(j).isVerticalSwitch() && (cell.getNeighbour(0).isVerticalSwitch())) {
						return list.get(j);
					}
				}

				if (cell.getNeighbour(2) != null) {
					if (list.get(j).isVerticalSwitch() && (cell.getNeighbour(2).isVerticalSwitch())) {

						return list.get(j);
					}
				}

				if (cell.getNeighbour(1) != null) {

					if (list.get(j).isHorizontalSwitch() && (cell.getNeighbour(1).isHorizontalSwitch())) {

						return list.get(j);
					}
				}

				if (cell.getNeighbour(3) != null) {

					if (list.get(j).isHorizontalSwitch() && (cell.getNeighbour(3).isHorizontalSwitch())) {

						return list.get(j);
					}
				}

			}

		}
		/**
		 * No possible moves fitting crteria
		 */
		return null;
	}

}