// Author: David George 
// This class changes the brightness of each pixel  depending its Euclidean distance from the upper-left corner of the image. 

import java.awt.Color;
public class AdjustmentOperation implements ImageOperation {

	// Method to determine maximum distance from any pixel to the upper left corner of the image 
	// @return returns this max distance 
	public static double MaxDistance(int NumberOfRows, int NumberofColumns) {

		double Max = Math.sqrt(NumberofColumns * NumberofColumns + NumberOfRows * NumberOfRows);

		return Max;
	}

	// Method to determine the distance from any pixel to the upper left corner of the image 
	// @return returns this distance
	
	public static double DistFromCorner(int x, int y) {

		double Dist = Math.sqrt(x * x + y * y);

		return Dist;
	}

	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;

		// 2-dimensional array to store the processed image
		Color[][] result = new Color[numOfRows][numOfColumns];

		// Scan the array and adjust each color based on "adjustBrightness" calculation
		for (int i = 0; i < numOfRows; i++)
			for (int j = 0; j < numOfColumns; j++) {

				double adjustBrightness = DistFromCorner(i, j) / MaxDistance(numOfRows, numOfColumns);

				int red = (int) (imageArray[i][j].getRed() * adjustBrightness);
				int green = (int) (imageArray[i][j].getGreen() * adjustBrightness);
				int blue = (int) (imageArray[i][j].getBlue() * adjustBrightness);
				result[i][j] = new Color(red, green, blue);
			}
		return result;
	}

}