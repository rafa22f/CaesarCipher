/**
 * This class creates an interface for the type of cryptography techniques one
 * can use All the techniques implement it to allow it to function
 */
public interface Strategy {
	// method to allow for encryption
	public String encrypt(String text,int key);

	// method to allow decryption
	public String decrypt(String text,int key);
}
