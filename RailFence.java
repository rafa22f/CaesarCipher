/**
 * This class is for the cryptography of technique Rail fence. This class
 * implements the interface Strategy.It takes the text and writes each letter in
 * downward and then upward corresponding to the rows Using 3 rows in this
 * assignment
 * 
 */
public class RailFence implements Strategy {
	private int row = 3;// for this program we set row to be 3

	@Override
	/**
	 * This method encrypts the text passed in according to the rail fence method
	 * 
	 * @param String text to be encrypted
	 */
	public String encrypt(String text, int key) {
		int column = text.length();
		char[][] array = new char[row][column];// column cannot exceed the total number of letters
		boolean goingDown = false;
		int rowNumber = 0;// the row number

		// we first set up the rows and columns
		for (int i = 0; i < column; i++) {
			array[rowNumber][i] = text.charAt(i);// add the word
			// if row is 0 or row-1 we need to switch directions
			if (rowNumber == 0 || rowNumber == row - 1) {
				goingDown = !goingDown;
			}
			// if going down in this case 0-2
			if (goingDown) {
				rowNumber++;
			}
			// going back up 2-0
			else {
				rowNumber--;
			}

		}

		// we then read off the letters in correct order
		String encryptedText = "";
		for (int i = 0; i < row; i++) {
			for (int k = 0; k < column; k++) {
				// we only want the actual letters so we ignore the null values
				if (array[i][k] != 0)
					encryptedText = encryptedText + array[i][k];
			}
		}
		// return the encrypted word
		return encryptedText;

	}

	@Override
	/**
	 * This method decrypts the text passed in in according to the rail fence method
	 * 
	 * @param String text to be decrypted
	 */
	public String decrypt(String text, int key) {
		int column = text.length();
		char[][] array = new char[row][column];
		boolean goingDown = false;
		int rowNumber = 0;

		// we mark off the positions where the letters would exist
		for (int i = 0; i < column; i++) {
			// if row is 0 or row-1 we need to switch directions
			if (rowNumber == 0 || rowNumber == row - 1) {
				goingDown = !goingDown;
			}
			array[rowNumber][i] = '-';
			// if going down in this case 0-2
			if (goingDown) {
				rowNumber++;
			}

			else {
				// going back up 2-0
				rowNumber--;
			}

		}

		int index = 0;
		// we then set the letters into their right positions where - exists
		for (int i = 0; i < row; i++) {
			for (int k = 0; k < column; k++) {
				if (array[i][k] == '-' && index < text.length()) {
					array[i][k] = text.charAt(index++);
				}

			}

		}

		// next we create the actual word from the decrypted word
		goingDown = false;
		String decryptedText = "";
		rowNumber = 0;
		// we then set the correct word by traversing through
		for (int i = 0; i < column; i++) {
			if (rowNumber == 0 || rowNumber == row - 1) {
				goingDown = !goingDown;
			}
			decryptedText = decryptedText + array[rowNumber][i];
			// if going down in this case 0-2
			if (goingDown) {
				rowNumber++;
			}
			// going back up 2-0
			else {
				rowNumber--;
			}
		}
		return decryptedText;
	}

}
