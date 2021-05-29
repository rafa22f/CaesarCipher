import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/***
 * This class creates the GUI for the cryptography application It allows the
 * user to select any one out of the three cryptography options available and
 * outputs the encrypted/decrypted text for the user
 */
public class Cryptography extends JFrame {
	private JLabel textHeading;
	private JLabel keyInput;
	private JLabel cipherTextHeading;
	private JTextArea input;
	private JTextArea output;
	private JTextField cipherKey;
	private JComboBox<String> comboBox;
	private JButton encrypt;
	private JButton decrypt;
	private Font font = new Font("Times New Roman", Font.BOLD, 12);
	private Strategy strategy;//to create the correct strategy object later

	/**
	 * This constructor creates the frame for the application
	 */
	public Cryptography() {
		setPane();
	}

	/**
	 * This method sets the JFrame and panel completely but calling the necessary
	 * methods
	 */
	public void setPane() {
		setTextArea();
		setHeadings();
		setButtons();
		setComboBox();

		Container frame = getContentPane();
		frame.setLayout(null);
		frame.add(input);
		frame.add(output);
		frame.add(decrypt);
		frame.add(encrypt);
		frame.add(textHeading);
		frame.add(cipherTextHeading);
		frame.add(keyInput);
		frame.add(cipherKey);
		frame.add(comboBox);

	}

	/***
	 * This helper method sets the two text areas for the plain text and cipher text
	 * and text field for the key
	 */
	private void setTextArea() {
		// plain text area
		input = new JTextArea("", 15, 15);
		input.setFont(font);
		input.setLineWrap(true);
		input.setWrapStyleWord(true);
		input.setLocation(5, 25);
		input.setSize(550, 80);

		// cipher text area
		output = new JTextArea("", 50, 50);
		output.setFont(font);
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		output.setEditable(true);
		output.setLocation(5, 120);
		output.setSize(800, 80);

		// key text area
		cipherKey = new JTextField();
		cipherKey.setFont(font);
		cipherKey.setLocation(470, 210);
		cipherKey.setSize(70, 30);
		cipherKey.setText("0");//0 is set as a default value for the key
	}

	/***
	 * This helper method sets the headings for the frame
	 */
	private void setHeadings() {
		// plain text heading
		textHeading = new JLabel("Plain text");
		textHeading.setSize(1010, 40);
		textHeading.setLocation(0, 0);
		textHeading.setFont(font);
		textHeading.setSize(1010, 40);
		textHeading.setLocation(0, 0);
		textHeading.setFont(font);

		// cipher text heading
		cipherTextHeading = new JLabel("Cipher Text");
		cipherTextHeading.setSize(1010, 40);
		cipherTextHeading.setLocation(0, 93);
		cipherTextHeading.setFont(font);
		cipherTextHeading.setSize(1010, 40);
		cipherTextHeading.setLocation(0, 93);
		cipherTextHeading.setFont(font);

		// key heading
		keyInput = new JLabel("Key:");
		keyInput.setSize(30, 30);
		keyInput.setLocation(430, 210);
		keyInput.setFont(font);

	}

	/***
	 * This helper method sets the encrypt and decrypt buttons
	 */
	private void setButtons() {
		setEncrypt();
		setDecrypt();

	}

	/***
	 * This helper method sets the encrypt button as well as sets its action
	 * listener to allow for the change once it is clicked
	 */
	private void setEncrypt() {
		// sets the encrypt button and its handler
		encrypt = new JButton("Encrypt");
		encrypt.setFont(font);
		encrypt.setSize(120, 35);
		encrypt.setLocation(30, 210);
		// also sets up the response to the encrypt button clicked
		encrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sentence = input.getText();
				output.setText("");//to reset the text area
				//the corresponding encrypt method is executed and string is returned
				String encrypted = strategy.encrypt(sentence, Integer.parseInt(cipherKey.getText()));
				output.append(encrypted);

			}
		});

	}

	/***
	 * This helper method sets the decrypt button as well as sets its action
	 * listener to allow for the change once it is clicked
	 */
	private void setDecrypt() {
		// sets the decrypt button and its handler
		decrypt = new JButton("Decrypt");
		decrypt.setFont(font);
		decrypt.setSize(120, 35);
		decrypt.setLocation(150, 210);
		// also sets up the response to the decrypt button clicked
		decrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sentence = output.getText();
				input.setText("");//to reset the text area
				//the corresponding decrypt method is executed and string is returned
				String decrypted = strategy.decrypt(sentence, Integer.parseInt(cipherKey.getText()));
				input.append(decrypted);
			}
		});

	}

	/***
	 * This helper method sets the combo box for the different options for
	 * encryption
	 */
	private void setComboBox() {
		String[] options = { " ", "Copy", "Caesar cipher", "Rail Fence" };
		comboBox = new JComboBox<>(options);
		comboBox.setFont(font);
		comboBox.setSize(140, 35);
		comboBox.setLocation(275, 210);
		// sets up the response to the combo box
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) comboBox.getSelectedItem();
				//we then set the corresponding strategy pattern
				if (selectedItem.equals("Copy")) {
					strategy = new Copy();
				}

				if (selectedItem.equals("Caesar cipher")) {
					strategy = new CaeserCipher();
				}

				if (selectedItem.equals("Rail Fence")) {
					strategy = new RailFence();
				}
			}
		});

	}

	public static void main(String[] args) {
		Cryptography frame = new Cryptography();
		frame.setVisible(true);
		frame.setSize(550, 270);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}
