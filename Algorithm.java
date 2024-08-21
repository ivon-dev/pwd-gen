// This is where all the magic happens

package pwd_gen;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Algorithm extends Main_UI {		// This is the algorithm, used to generate the random string of password. Has 2 stages: Validation and Generation
	
	public String generatePassword (String pwd_length_string, Label pwd_meter, JCheckBox pwd_ltr_ucase_conf, JCheckBox pwd_ltr_lcase_conf, JCheckBox pwd_num_conf, JCheckBox pwd_sym_conf) {			// First, the values of 4 Checkboxes on the Main_UI, the Password Meter, and the Password Length, are transferred here using Parameters.
		
	StringBuilder char_appender = new StringBuilder();				// The StringBuilder class is used for for-looping a char without deleting the previous one.
	Random random = new Random();											// The Random class is used for randomly generating an int
		
	Error_UI error_popup = new Error_UI();									// "Connects" the Error_UI class
		
	if (pwd_length_string.isEmpty() || pwd_length_string.isBlank()) {		// Checks first if the Length TextField is empty, or contain only spaces and not numbers.
		error_popup.noInputLength();										// the .isEmpty() and .isBlank() operator isn't possible in int, so I need to convert what's on the TextField first in String. (Another validation takes place that is only possible if the value is int). Has an OR Logical Operator.
		pwd_meter.setText("Password Meter: LENGTH IS NULL");
	}
		
		else {
				
			boolean pwd_length_validation = pwd_length_string.matches ("[0-9]+");		// Another validation procedure: It checks the Length TextField for int
				
			if (!pwd_length_validation) {
				error_popup.invalidInputLength();										// If the Length TextField contains atleast one char that is not an int (special character, and letter), it will trigger a popup from another class, Error_UI.
				pwd_meter.setText("Password Meter: INVALID");							// Also, these Password Meter are just Labels on Main_UI that dynamically change if the password is Strong, Very Strong, or Fair, based on the length you've given.
				
			}
				
				else {
						
					int pwd_length_int = Integer.parseInt(pwd_length_string);			// Will now convert the String into an int. Because the next validation procedures aren't possible if the value is still a string.
					
					if (pwd_length_int == 0) {											// Checks if the TextField is 0 (because it doesn't make any sense if the length of password it 0!!)
						error_popup.zeroInputLength();									// Calling a method from another class, Error_UI.java (now as a variable "error_popup"). It can still detect the "Error_UI error_popup = new Error_UI()" call from earlier, as this is still under that scope (or {})
						pwd_meter.setText("Password Meter: INVALID");
					}
						
					if (pwd_length_int <= 9 && pwd_length_int >= 1) {					// Checks if the TextField is 9 or below. My program discourages it as it increases the chance of your account getting hacked.
						error_popup.insufficientInputLength();
						pwd_meter.setText("Password Meter: LENGTH IS TOO SHORT");
					}
					
					if (pwd_length_int >= 31) {											// Checks if the TextField is 31 or above. In actual, my program is capable of generating a thousand random char of string, but let's be honest, who in the world has 1000 character password in his credentials? Capping it to 30 chars is secure enough
						error_popup.tooLongInputLength();
						pwd_meter.setText("Password Meter: LENGTH IS TOO LONG");
					}
					
					if (pwd_length_int == 10) {
						pwd_meter.setText("Password Meter: Slightly Weak");
					}
					
					if (pwd_length_int >= 11 && pwd_length_int <= 13) {
						pwd_meter.setText("Password Meter: Fair");
					}
					
					if (pwd_length_int >= 14 && pwd_length_int <= 19) {
						pwd_meter.setText("Password Meter: Strong");
					}

					if (pwd_length_int >= 20 && pwd_length_int <=30) {
						pwd_meter.setText("Password Meter: Very Strong");
					}
						
					if (pwd_length_int >= 10 && pwd_length_int <= 30) {					
																						
						if (!pwd_ltr_ucase_conf.isSelected() && !pwd_ltr_lcase_conf.isSelected() && !pwd_num_conf.isSelected() && !pwd_sym_conf.isSelected()) {
							error_popup.noConfiguredCheckbox();
							pwd_meter.setText("Password Meter: INVALID");
						}
						
							else {																										// End of Validation
							
							String ucase_charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";														// A lof of if statements here. Basically, we have 4 checkboxes, and depending on the boolean (if the JCheckBox is checked), we have 15 charset, corresponding to 15 different combinations of the 4 checkboxes.
							String lcase_charset = "abcdefghijklmnopqrstuvwxyz";
							String num_charset = "0123456789";
							String sym_charset = "!@#$%^&*+";
							String ucase_lcase_charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
							String ucase_num_charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
							String ucase_sym_charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*+";
							String lcase_num_charset = "abcdefghijklmnopqrstuvwxyz0123456789";
							String lcase_sym_charset = "abcdefghijklmnopqrstuvwxyz!@#$%^&*+";
							String num_sym_charset = "0123456789!@#$%^&*+";
							String ucase_lcase_num_charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
							String ucase_lcase_sym_charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*+";
							String ucase_num_sym_charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*+";
							String lcase_num_sym_charset = "abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*+";
							String all_charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*+";				// Temp Description: 1 = pwd_ltr_ucase_conf (the "Letter (A-Z)" checkbox), 2 = pwd_ltr_lcase_conf (the "Letter (a-z)" checkbox), 3 = pwd_num_conf (the "Numbers" checkbox), and 4 = pwd_sym_conf (the "Symbols" checkbox).
							
							if (pwd_ltr_ucase_conf.isSelected() && !pwd_ltr_lcase_conf.isSelected() && !pwd_num_conf.isSelected() && !pwd_sym_conf.isSelected()) {			// If 1 is checked; and 2, 3, and 4 is unchecked [1 JCheckBox checked]
																														// Short description about the for-loop
								for (int i = 0; i < pwd_length_int; i++) {												// Basically, without the for-loop, the Algo will only return one character. So, to repeat it, we need to loop it, based on the given length on the Length Checkbox
									int index = random.nextInt(ucase_charset.length());									// We created a temporary variable (accessible only under this if statement) called "index", which generates a random int, maximum value being the charset length
									char randomChar = ucase_charset.charAt(index);										// We create another temporary variable, named "randomChar", which generates a character, by cross-referencing it into it's corresponding charset above, and taking the randomly generated int, index above one line. So for example, index returned 3, it will cross-reference it to the charset above. Checking the charset "ucase_charset", it will return char "C".
									char_appender.append(randomChar);													// Lastly, it will append the generated char (the StringBuilder is needed, so it is imported earlier as char_appender variable). If it didn't append the randomChar, the whole algorithm will only output one character.
									}
								}
								
							if (!pwd_ltr_ucase_conf.isSelected() && pwd_ltr_lcase_conf.isSelected() && !pwd_num_conf.isSelected() && !pwd_sym_conf.isSelected()) {			// If 2 is checked; and 1, 3, and 4 is unchecked
								
								for (int i = 0; i < pwd_length_int; i++) {												// Same thing happens here, but with different checkbox checked, and different charset.
									int index = random.nextInt(lcase_charset.length());
									char randomChar = lcase_charset.charAt(index);
									char_appender.append(randomChar);
									}
								}
							
							if (!pwd_ltr_ucase_conf.isSelected() && !pwd_ltr_lcase_conf.isSelected() && pwd_num_conf.isSelected() && !pwd_sym_conf.isSelected()) {			// If 3 is checked; and 1, 2, and 4 is unchecked
								
								for (int i = 0; i < pwd_length_int; i++) {
									int index = random.nextInt(num_charset.length());
									char randomChar = num_charset.charAt(index);
									char_appender.append(randomChar);
									}
								}
								
							if (!pwd_ltr_ucase_conf.isSelected() && !pwd_ltr_lcase_conf.isSelected() && !pwd_num_conf.isSelected() && pwd_sym_conf.isSelected()) {			// If 4 is checked; and 1, 2, and 3 is unchecked
								
								for (int i = 0; i < pwd_length_int; i++) {
									int index = random.nextInt(sym_charset.length());
									char randomChar = sym_charset.charAt(index);
									char_appender.append(randomChar);
									}
								}
							if (pwd_ltr_ucase_conf.isSelected() && pwd_ltr_lcase_conf.isSelected() && !pwd_num_conf.isSelected() && !pwd_sym_conf.isSelected()) {			// If 1, and 2 is checked; and 3, and 4 is unchecked [2 JCheckBoxes checked]
								
								for (int i = 0; i < pwd_length_int; i++) {
									int index = random.nextInt(ucase_lcase_charset.length());
									char randomChar = ucase_lcase_charset.charAt(index);
									char_appender.append(randomChar);
									}
								}
								
							if (pwd_ltr_ucase_conf.isSelected() && !pwd_ltr_lcase_conf.isSelected() && pwd_num_conf.isSelected() && !pwd_sym_conf.isSelected()) {			// If 1, and 3 is checked; and 2, and 4 is unchecked
								
								for (int i = 0; i < pwd_length_int; i++) {
									int index = random.nextInt(ucase_num_charset.length());
									char randomChar = ucase_num_charset.charAt(index);
									char_appender.append(randomChar);
									}
								}
							
							if (pwd_ltr_ucase_conf.isSelected() && !pwd_ltr_lcase_conf.isSelected() && !pwd_num_conf.isSelected() && pwd_sym_conf.isSelected()) {			// If 1, and 4 is checked; and 2, and 3 is unchecked
								
								for (int i = 0; i < pwd_length_int; i++) {
									int index = random.nextInt(ucase_sym_charset.length());
									char randomChar = ucase_sym_charset.charAt(index);
									char_appender.append(randomChar);
									}
								}
								
							if (!pwd_ltr_ucase_conf.isSelected() && pwd_ltr_lcase_conf.isSelected() && pwd_num_conf.isSelected() && !pwd_sym_conf.isSelected()) {			// If 2, and 3 is checked; and 1, and 4 is unchecked
								
								for (int i = 0; i < pwd_length_int; i++) {
									int index = random.nextInt(lcase_num_charset.length());
									char randomChar = lcase_num_charset.charAt(index);
									char_appender.append(randomChar);
									}
								}
							if (!pwd_ltr_ucase_conf.isSelected() && pwd_ltr_lcase_conf.isSelected() && !pwd_num_conf.isSelected() && pwd_sym_conf.isSelected()) {			// If 2, and 4 is checked; and 1, and 3 is unchecked
								
								for (int i = 0; i < pwd_length_int; i++) {
									int index = random.nextInt(lcase_sym_charset.length());
									char randomChar = lcase_sym_charset.charAt(index);
									char_appender.append(randomChar);
									}
								}
								
							if (!pwd_ltr_ucase_conf.isSelected() && !pwd_ltr_lcase_conf.isSelected() && pwd_num_conf.isSelected() && pwd_sym_conf.isSelected()) {			// If 3, and 4 is checked; and 1, and 2 is unchecked
								
								for (int i = 0; i < pwd_length_int; i++) {
									int index = random.nextInt(num_sym_charset.length());
									char randomChar = num_sym_charset.charAt(index);
									char_appender.append(randomChar);
									}
								}
							
							if (pwd_ltr_ucase_conf.isSelected() && pwd_ltr_lcase_conf.isSelected() && pwd_num_conf.isSelected() && !pwd_sym_conf.isSelected()) {			// If 1, 2, and 3 is checked; and 4 is unchecked [3 JCheckBoxes checked]
								
								for (int i = 0; i < pwd_length_int; i++) {
									int index = random.nextInt(ucase_lcase_num_charset.length());
									char randomChar = ucase_lcase_num_charset.charAt(index);
									char_appender.append(randomChar);
									}
								}
								
							if (pwd_ltr_ucase_conf.isSelected() && pwd_ltr_lcase_conf.isSelected() && !pwd_num_conf.isSelected() && pwd_sym_conf.isSelected()) {			// If 1, 2, and 4 is checked; and 3 is unchecked
								
								for (int i = 0; i < pwd_length_int; i++) {
									int index = random.nextInt(ucase_lcase_sym_charset.length());
									char randomChar = ucase_lcase_sym_charset.charAt(index);
									char_appender.append(randomChar);
									}
								}
							if (pwd_ltr_ucase_conf.isSelected() && !pwd_ltr_lcase_conf.isSelected() && pwd_num_conf.isSelected() && pwd_sym_conf.isSelected()) {			// If 1, 3, and 4 is checked; and 2 is unchecked
								
								for (int i = 0; i < pwd_length_int; i++) {
									int index = random.nextInt(ucase_num_sym_charset.length());
									char randomChar = ucase_num_sym_charset.charAt(index);
									char_appender.append(randomChar);
									}
								}
								
							if (!pwd_ltr_ucase_conf.isSelected() && pwd_ltr_lcase_conf.isSelected() && pwd_num_conf.isSelected() && pwd_sym_conf.isSelected()) {			// If 2, 3, and 4 is checked; and 1 is unchecked
								
								for (int i = 0; i < pwd_length_int; i++) {
									int index = random.nextInt(lcase_num_sym_charset.length());
									char randomChar = lcase_num_sym_charset.charAt(index);
									char_appender.append(randomChar);
									}
								}
							
							if (pwd_ltr_ucase_conf.isSelected() && pwd_ltr_lcase_conf.isSelected() && pwd_num_conf.isSelected() && pwd_sym_conf.isSelected()) {				// If all is checked (1, 2, 3, and 4) [4 JCheckBoxes checked]
								
								for (int i = 0; i < pwd_length_int; i++) {
									int index = random.nextInt(all_charset.length());
									char randomChar = all_charset.charAt(index);
									char_appender.append(randomChar);
								}
							}
						}
					}
				}
			}
		return char_appender.toString();		// Since this class' method, generatePassword, is not a void but a String, it needs to return a string value. And in that case, the appended chars earlier will be returned to Main_UI.
	}
}