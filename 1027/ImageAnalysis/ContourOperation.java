// Author: David George 
//  This class will be used for contour detection, or "edge" detection of any given image. 

import java.awt.Color;

public class ContourOperation implements ImageOperation {

	// This method takes as arguments the red, green and blue values for two pixels and determine the color distance.
	// @return will return the colourDistance 
	
	public static double Distance(int p1R, int p1G, int p1B, int p2R, int p2G, int p2B) {

		int pR = p1R - p2R;
		int pG = p1G - p2G;
		int pB = p1B - p2B;

		double ColourDistance = Math.sqrt(pR * pR + pG * pG + pB * pB);

		return ColourDistance;
	}
	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;

		// 2-dimensional array to store the processed image
		Color[][] result = new Color[numOfRows][numOfColumns];
		
		// Array, that when added to the values of i and j, will "move" to the neighboring pixels to determine the distance. 
		int[] numbers = {-1,-1,0,-1,1,-1,1,0,1,1,0,1,-1,1,-1,0};
		
		// Scan the array and check neighboring pixels 
		for (int i = 0; i < numOfRows; i++)
			for (int j = 0; j < numOfColumns; j++) {

				// Only iterate over the pixels not an edge or corner
				if ((i > 0 && i < numOfRows - 1) && (j > 0 && j < numOfColumns - 1)) {

					
					int flag = 0;
					
					// Iterate over the array 
					for (int k = 0; k < 15; k++) {

						// If Distance evaluates to greater than 65, set flag to 1 and break out of loop, if not keep going. 
						if ((Distance(imageArray[i][j].getRed(), imageArray[i][j].getGreen(),imageArray[i][j].getBlue(), imageArray[i + numbers[k]][j + numbers[k + 1]].getRed(),imageArray[i + numbers[k]][j + numbers[k + 1]].getGreen(),imageArray[i + numbers[k]][j + numbers[k + 1]].getBlue()) > 65)) {
							flag = 1;
							break;
						}
					}

					// If the distance was never above 65, set pixel to white
					if (flag == 0) {
						result[i][j] = new Color(255, 255, 255);
					}
					
					// If the distance was above 65, set pixel to black 
					if (flag == 1) {
						result[i][j] = new Color(0, 0, 0);
					}
				}
				
				// For the edges and corners, keep the color the same. 
				else {
					result[i][j] = new Color(imageArray[i][j].getRed(), imageArray[i][j].getGreen(), imageArray[i][j].getBlue());
				}
			}
		return result;
	}
}
