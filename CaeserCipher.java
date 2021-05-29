/**
 * This class is for the cryptography of technique Ceaser Cipher. This class
 * implements the interface Strategy It takes in a key and shifts each letter by
 * that key and then returns it
 */
public class CaeserCipher implements Strategy {
	@Override
	/**
	 * This method encrypts the text passed in and shifts each letter by the key in
	 * the Ascii table
	 * 
	 * @param String text to be encrypted
	 */
	public String encrypt(String text,int key) {
		char[] array = text.toCharArray();//get the array of character in the text
		for (int i = 0; i < array.length; i++) {
			//we then add the key value to each of the letter and mod to allow for wrapping
			array[i] =  (char) ((array[i] + key) % 256);
		}
		//return the array in form of a string
		return String.valueOf(array);
	}

	@Override
	/**
	 * This method decrypts the text passed in and shifts each letter by the key in
	 * the Ascii table
	 * 
	 * @param String text to be decrypted
	 */
	public String decrypt(String text,int key) {
		char[] array = text.toCharArray();
		for (int i = 0; i < array.length; i++) {
			//we then subtract the key value to each of the letter and mod to allow for wrapping
			array[i] = (char) ((array[i] - key) % 256);
		}
		//return the array in form of a string
		return String.valueOf(array);
	}

}
