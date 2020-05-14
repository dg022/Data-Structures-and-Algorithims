
// Author: David George 
// This class will display each pixel of the image as either white or black
import java.awt.Color;

public class ThresholdingOperation implements ImageOperation {

	// Method will determine the "brightnessScore" of each pixel
	// @return will return true if above 100, false otherwise.

	public static boolean Brightness(int p1R, int p1G, int p1B) {

		double BrightnessScore = 0.21 * p1R + 0.71 * p1G + 0.07 * p1B;

		if (BrightnessScore > 100) {
			return true;
		}

		else {
			return false;
		}
	}

	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;

		// 2-dimensional array to store the processed image
		Color[][] result = new Color[numOfRows][numOfColumns];

		// Scan the array and if the brightnessScore is above 100 change to black,
		// otherwise white
		for (int i = 0; i < numOfRows; i++)
			for (int j = 0; j < numOfColumns; j++) {

				if ((Brightness(imageArray[i][j].getRed(), imageArray[i][j].getGreen(), imageArray[i][j].getBlue()))) {
					result[i][j] = new Color(0, 0, 0);

				}

				else {

					result[i][j] = new Color(255, 255, 255);
				}
			}

		return result;

	}
}
