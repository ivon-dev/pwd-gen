/* **************************************************************

This Java Application was made by Paul Begino, in requirements for his INPROLA
(Introduction to Programming and Theories) Finals, using Eclipse as the IDE.

If this project goes to GitHub, it's completely free of charge, and free as in
liberty.

Completion date: March 2, 2024 @ 14:30PM

Special thanks to my Professor, Sir Herminiño C. Lagunzad for all the love
(🎵 All the love in the worrldddd.. (all the love) by The Outfield) on his Students in IT232!!!

***************************************************************** */

package pwd_gen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main_UI extends WindowAdapter implements ActionListener {
	
	Frame main_ui;		// Initializes the variables and their corresponding types, without values
	Label title_txt, desc_txt, desc2_txt, desc3_txt, desc4_txt, output_txt;
	TextField pwd_output_field, pwd_len_field;
	Label param_txt, pwd_meter, len_txt;
	Button generate_btn, howto_btn;
	JCheckBox pwd_ltr_lcase_conf, pwd_ltr_ucase_conf, pwd_num_conf, pwd_sym_conf;
	
	Font title_font = new Font ("Consolas", Font.BOLD, 35);		// Sets the font
	Font desc_font =  new Font ("Monospace", Font.PLAIN, 17);
	Font desc_font2 = new Font ("Monospace", Font.PLAIN, 17);
	Font info_font = new Font ("Arial", Font.PLAIN, 17);
	Font pwd_meter_font = new Font ("Consolas", Font.PLAIN, 19);
	Font outputpwd_font = new Font ("Consolas", Font.BOLD, 22);
	Font generate_btn_font = new Font ("Monospace", Font.BOLD, 18);
	Font howto_btn_font = new Font ("Monospace", Font.PLAIN, 17);
	
	Color main_ui_color = new Color (223, 223, 223);		// Sets the color

	public void mainFrame() {		// The Method for the Main Frame
		
		main_ui = new Frame ();
		ImageIcon main_ui_logo = new ImageIcon (getClass().getClassLoader().getResource ("pwd_gen/assets/icons/main_icon.png"));		// Gets the Icon in the Project Resource folder.
		main_ui.setIconImage (main_ui_logo.getImage());
		
		main_ui.setTitle ("Password Generator");		// Properties of the Main Frame
		main_ui.setBounds (100, 75, 200, 200);
		main_ui.addWindowListener (this);
		main_ui.setResizable (false);
		main_ui.setSize (500, 810);
		main_ui.setLayout (null);
		main_ui.setVisible (true);
		
		programDescription();		// Other parts of the Main Frame are stored on another methods, and are called here.
		passwordOutput();
		passwordParameters();
		
	}
		
	public void programDescription() {		// This is the block of Labels that provide the program description and title, as well as the Help button.
		
		title_txt = new Label ("Password Generator");
		title_txt.setFont (title_font);
		title_txt.setBounds (80, 80, 500, 35);
		desc_txt = new Label ("A simple password generator");
		desc_txt.setFont (desc_font);
		desc_txt.setBounds (127, 145, 500, 25);
		desc2_txt =  new Label ("used for generating secure");
		desc2_txt.setFont (desc_font);
		desc2_txt.setBounds (135, 170, 500, 25);
		desc3_txt = new Label ("and complex passwords");
		desc3_txt.setFont (desc_font);
		desc3_txt.setBounds (146, 195, 500, 25);
		desc4_txt = new Label ("Take back your digital security now!");
		desc4_txt.setFont (desc_font2);
		desc4_txt.setBounds (93, 240, 500, 25);
		howto_btn = new Button ("Need Help?");
		howto_btn.setFont (howto_btn_font);
		howto_btn.setBounds (170, 720, 120, 40);
		howto_btn.addActionListener (this);
		
		main_ui.add (title_txt);		// Adding the Elements on this method
		main_ui.add (desc_txt);
		main_ui.add (desc2_txt);
		main_ui.add (desc3_txt);
		main_ui.add (desc4_txt);
		main_ui.add (howto_btn);
		
	}
	
	public void passwordOutput() {		// This is the block of Elements (Label, and TextField) that contains the output of the algorithm
		
		output_txt = new Label ("Generated Password:");
		output_txt.setFont (info_font);
		output_txt.setBounds (40, 300, 400, 35);
		pwd_output_field = new TextField ();
		pwd_output_field.setFont (outputpwd_font);
		pwd_output_field.setBounds(40, 335, 400, 30);
		pwd_meter = new Label();
		pwd_meter.setText("Password Meter: NULL");
		pwd_meter.setFont(pwd_meter_font);
		pwd_meter.setBounds(40, 378, 400, 25);
		
		main_ui.add (output_txt);		// Adding the Elements on this method
		main_ui.add (pwd_output_field);
		main_ui.add (pwd_meter);
		
	}
	
	public void passwordParameters() {		// This is the block of Elements (Label, TextField, and JCheckBox) that contains the input for the algorithm (such as password length, and such)
		
		param_txt = new Label ("Parameters:");
		param_txt.setFont (info_font);
		param_txt.setBounds (40, 420, 400, 35);
		pwd_len_field = new TextField ("14");
		pwd_len_field.setFont (desc_font2);
		pwd_len_field.setBounds (40, 460, 50, 30);
		len_txt = new Label ("Length");
		len_txt.setFont (desc_font2);
		len_txt.setBounds (95, 460, 90, 30);
		pwd_ltr_ucase_conf = new JCheckBox ("       Letters (A-Z)");
		pwd_ltr_ucase_conf.setBackground (main_ui_color);
		pwd_ltr_ucase_conf.setFont (desc_font2);
		pwd_ltr_ucase_conf.setBounds (40, 490, 192, 30);
		pwd_ltr_lcase_conf = new JCheckBox ("       Letters (a-z)");
		pwd_ltr_lcase_conf.setBackground (main_ui_color);
		pwd_ltr_lcase_conf.setFont (desc_font2);
		pwd_ltr_lcase_conf.setBounds (40, 520, 192, 30);
		pwd_num_conf = new JCheckBox ("       Numbers");
		pwd_num_conf.setBackground (main_ui_color);
		pwd_num_conf.setFont (desc_font2);
		pwd_num_conf.setBounds (40, 550, 192, 30);
		pwd_sym_conf = new JCheckBox ("       Symbols");
		pwd_sym_conf.setBackground (main_ui_color);
		pwd_sym_conf.setFont (desc_font2);
		pwd_sym_conf.setBounds (40, 580, 192, 30);
		generate_btn = new Button ("Generate!");
		generate_btn.setFont (generate_btn_font);
		generate_btn.setBounds (170, 640, 120, 40);
		generate_btn.addActionListener (this);
		
		main_ui.add (param_txt);		// Adding the Elements on this method
		main_ui.add (pwd_len_field);
		main_ui.add (len_txt);
		main_ui.add (pwd_ltr_ucase_conf);
		main_ui.add (pwd_ltr_lcase_conf);
		main_ui.add (pwd_num_conf);
		main_ui.add (pwd_sym_conf);
		main_ui.add (generate_btn);
		
	}

	public void actionPerformed (ActionEvent btn) {		// What I like to call the "Button's Brain".
			
			if (btn.getSource() == howto_btn) {		// If "Get Help" button is pressed
				main_ui.dispose();					// Disposes/closes the Main_UI window/frame
				
				Help_UI help_ui = new Help_UI();	// Launches the Help_UI window/frame
				help_ui.helpFrame();
			}
			
			if (btn.getSource() == generate_btn) {		// If 'Generate' button is pressed
				
				Algorithm algorithm = new Algorithm();		// Creates an instance of the Algorithm class, to connect it from this class
				
				String pwd_length_string = pwd_len_field.getText();		// Converts the text in the Length TextField and converts it into a string
				
				String pwd_output = algorithm.generatePassword (pwd_length_string, pwd_meter, pwd_ltr_ucase_conf, pwd_ltr_lcase_conf, pwd_num_conf, pwd_sym_conf);		// Transfers the state of the 4 checkboxes, what's the password length, and the password meter, into the Algorithm, another class)
				pwd_output_field.setText(pwd_output);	// sets the output of the TextField to what the Algorithm on the other class' return value of the method "generatePassword".
			}
		}
	
	public void windowClosing (WindowEvent e) {			// To make the window/frame closable
														// Take note that you will have to invoke the .addWindowListener to the frame (in this case, I've done it on line 50)
		main_ui.dispose();
		
	}
	
	public static void main(String[] args) {		// Main Method is needed if you want to run a particular class.
		
		Main_UI main_class = new Main_UI();
		main_class.mainFrame();						// Launches the specific method in this class, that I considered to be the init method.
	}
}