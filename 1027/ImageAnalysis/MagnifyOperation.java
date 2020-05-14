// Author: David George 
// This class  changes the size of the image to twice its width and twice its height

import java.awt.Color;
public class MagnifyOperation implements ImageOperation {
	

	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = 2*imageArray.length ;
		int numOfColumns = 2* imageArray[0].length;
		System.out.println(numOfRows); 
		System.out.println((numOfColumns));

		// 2-dimensional array to store the processed image
		Color[][] result = new Color[numOfRows][numOfColumns];

		// Scan the array and copy the contents of the original pixel, to the pixel above, diagonally ,to the right. 
		for (int i = 0; i < numOfRows; i++)
			for (int j = 0; j < numOfColumns; j++) {
				
				// Only magnify if pixels are not an edge or a corner
				if((i>0&& i<numOfRows- 1)&&(j>0 && j<numOfColumns-1)){
					
					// I/2 and j/2 so to retrieve the pixel color data  from the original image
			
					result[i][j] = new Color(imageArray[i/2][j/2].getRed(),imageArray[i/2][j/2].getGreen(),imageArray[i/2][j/2].getBlue());
					result[i-1][j] = new Color(imageArray[i/2][j/2].getRed(),imageArray[i/2][j/2].getGreen(),imageArray[i/2][j/2].getBlue());
					result[i-1][j+1] = new Color(imageArray[i/2][j/2].getRed(),imageArray[i/2][j/2].getGreen(),imageArray[i/2][j/2].getBlue());
					result[i][j+1] = new Color(imageArray[i/2][j/2].getRed(),imageArray[i/2][j/2].getGreen(),imageArray[i/2][j/2].getBlue());
				}
				else {
					result[i][j] = new Color(imageArray[i/2][j/2].getRed(), imageArray[i/2][j/2].getGreen(), imageArray[i/2][j/2].getBlue());
				}
			}
		return result;

} 
}