package pwd_gen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class About_UI extends WindowAdapter {
	
	Frame about_ui;			// Initializes the variables and their corresponding types, without values
	Label dev_name, software_info, license, copyleft;
	
	Font about_font = new Font ("Monospace", Font.PLAIN, 16);		// Sets the font
	Font about_dev_font = new Font ("Monospace", Font.BOLD, 18);
	
	public void aboutFrame() {		// The About Frame
		
		about_ui = new Frame ();
		
		ImageIcon about_ui_logo = new ImageIcon (getClass().getClassLoader().getResource ("pwd_gen/assets/icons/about_icon.png"));		// Gets the Icon in the Project Resource folder.
		
		dev_name = new Label ("Made by Paul Begino");		// The elements of the about screen
		dev_name.setFont (about_dev_font);
		dev_name.setBounds (70, 60, 400, 23);
		software_info = new Label ("Password Generator [Build v1.0.0]");
		software_info.setFont (about_font);
		software_info.setBounds (40, 88, 400, 18);
		license = new Label ("Licensed under Apache License");
		license.setFont (about_font);
		license.setBounds (50, 123, 250, 18);
		copyleft = new Label ("COPYLEFT! COPYLEFT!");
		copyleft.setFont (about_font);
		copyleft.setBounds (85, 158, 250, 18);
		
		about_ui.add (dev_name);
		about_ui.add (software_info);
		about_ui.add (license);
		about_ui.add (copyleft);
		
		about_ui.setTitle ("About Password Generator");
		about_ui.setBounds (240, 160, 0, 0);
		about_ui.setIconImage (about_ui_logo.getImage());
		about_ui.addWindowListener (this);
		about_ui.setResizable(false);
		about_ui.setSize (355, 215);
		about_ui.setLayout (null);
		about_ui.setVisible (true);
		
	}
	
	public void windowClosing (WindowEvent e) {			// To make the window/frame closable
														// Take note that you will have to invoke the .addWindowListener to the frame (in this case, i've done it on line 42)
		about_ui.dispose();								// Disposes/closes the About_UI window/frame
		
		Help_UI help_ui = new Help_UI();				// Launches the Help_UI window/frame
		help_ui.helpFrame();
		
	}
}
