package pwd_gen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Help_UI extends WindowAdapter implements ActionListener {
	
	Frame help_ui;			// Initializes the variables and their corresponding types, without values
	Label txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10, txt11, txt12;		// Initializes the variable types
	Button about_btn, ok_btn;																// The Class Help_UI.java has a lot of Label (so talaga namang ma-effort talaga!)
	
	Font txt_font = new Font ("Consolas", Font.PLAIN, 18);		// Sets the font
	Font btn_font = new Font ("Monospace", Font.PLAIN, 17);
	
	public void helpFrame() {		// The Help Frame
			
			help_ui = new Frame ();
			
			ImageIcon help_ui_logo = new ImageIcon (getClass().getClassLoader().getResource ("pwd_gen/assets/icons/help_icon.png"));		// Gets the Icon in the Project Resource folder.
			
			txt1 = new Label ("Using this password generator is supposed to be self-explanatory.");		// Sets the properties of the elements
			txt1.setFont (txt_font);
			txt1.setBounds (40, 65, 800, 20);	// 45
			txt2 = new Label ("But there's this help page, just in case!");
			txt2.setFont (txt_font);
			txt2.setBounds (40, 90, 800, 20);
			txt3 = new Label ("To generate a random string of password, first choose a password length,");
			txt3.setFont (txt_font);
			txt3.setBounds (40, 130, 800, 20);
			txt4 = new Label ("and input your password length on the TextField, and you can configure");
			txt4.setFont (txt_font);
			txt4.setBounds (40, 155, 800, 20);
			txt5 = new Label ("your password to have Numbers, Symbols, etc. And then, you can press the");
			txt5.setFont (txt_font);
			txt5.setBounds (40, 180, 800, 20);
			txt6 = new Label ("'Generate' button below.");
			txt6.setFont (txt_font);
			txt6.setBounds (40, 205, 800, 20);
			txt7 = new Label ("However, the length of the password is limited only to 10-30 characters.");
			txt7.setFont (txt_font);
			txt7.setBounds (40, 245, 800, 20);
			txt8 = new Label ("Also, 9 characters and below are not allowed for the security of your ");
			txt8.setFont (txt_font);
			txt8.setBounds (40, 270, 800, 20);
			txt9 = new Label ("account.");
			txt9.setFont (txt_font);
			txt9.setBounds (40, 295, 800, 20);
			txt10 = new Label ("Then you can copy-paste the output password into a password manager,");
			txt10.setFont (txt_font);
			txt10.setBounds (40, 335, 800, 20);
			txt11 = new Label ("if you have one.");
			txt11.setFont (txt_font);
			txt11.setBounds (40, 360, 800, 20);
			txt12 = new Label ("Pressing the 'Need Help' button only brings up this page.");
			txt12.setFont (txt_font);
			txt12.setBounds (40, 400, 800, 20);
			about_btn = new Button ("About");
			about_btn.setFont (btn_font);
			about_btn.setBounds (140, 450, 120, 40);
			about_btn.addActionListener (this);
			ok_btn = new Button ("OK");
			ok_btn.setFont (btn_font);
			ok_btn.setBounds (540, 450, 120, 40);
			ok_btn.addActionListener (this);
			
			help_ui.add (txt1);		// Adds the properties into the frame
			help_ui.add (txt2);
			help_ui.add (txt3);
			help_ui.add (txt4);
			help_ui.add (txt5);
			help_ui.add (txt6);
			help_ui.add (txt7);
			help_ui.add (txt8);
			help_ui.add (txt9);
			help_ui.add (txt10);
			help_ui.add (txt11);
			help_ui.add (txt12);
			help_ui.add (about_btn);
			help_ui.add (ok_btn);
			
			help_ui.setTitle ("Password Generator Help");
			help_ui.setBounds (120, 85, 0, 0);
			help_ui.setIconImage (help_ui_logo.getImage());
			help_ui.addWindowListener (this);
			help_ui.setResizable(false);
			help_ui.setSize (805, 518);
			help_ui.setLayout (null);
			help_ui.setVisible (true);
			
	}
		
	public void actionPerformed (ActionEvent btn) {		// What I like to call the "Button's Brain"
			
			if (btn.getSource() == about_btn) {			// If the "About" button is pressed
				help_ui.dispose();						// Disposes/closes the Help_UI window/frame
				
				About_UI about_ui = new About_UI();		// Launches the About_UI window/frame
				about_ui.aboutFrame();
			}
			
			if (btn.getSource() == ok_btn) {			// If the "OK" button is pressed	
				help_ui.dispose();						// Disposes/closes the Help_UI window/frame
				
				Main_UI main_class = new Main_UI();		// Launches the Main_UI window/frame
				main_class.mainFrame();
			}
	}
	
	public void windowClosing (WindowEvent e) {			// To make the window/frame closable
														// Take note that you will have to invoke the .addWindowListener to the frame (in this case, I've done it on line 85)
		help_ui.dispose();								// Disposes/closes the Help_UI window/frame
		
		Main_UI main_class = new Main_UI();				// Launches the Main_UI window/frame
		main_class.mainFrame();
		
	}
}
