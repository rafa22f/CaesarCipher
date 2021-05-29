/**
 * This class is for the cryptography of technique copy.This returns the text as
 * it is This class implements the interface Strategy
 * 
 */
public class Copy implements Strategy {

	@Override
	/**
	 * This method encrypts the text and returns it
	 * 
	 * @param String text to be encrypted
	 */
	public String encrypt(String text,int key) {
		return text;
	}

	@Override
	/**
	 * This method decrypts the text and returns it
	 * 
	 * @param String text to be decrypted
	 */
	public String decrypt(String text,int key) {
		return text;
	}

}
