package pwd_gen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class Error_UI extends WindowAdapter implements ActionListener {		// This class contains all the possible exceptions that the program can handlie, as well as warnings.
	
	Frame error_ui;			// First, it initializes the variables
	Label err_title_txt, err_desc_txt, err_desc2_txt;
	Button ok_btn;
	
	Font err_title_font = new Font ("Consolas", Font.BOLD, 20);		// Sets the font
	Font err_desc_font = new Font ("Consolas", Font.PLAIN, 17);
	Font btn_font = new Font ("Monospace", Font.PLAIN, 17);
	
	ImageIcon error_ui_logo = new ImageIcon (getClass().getClassLoader().getResource ("pwd_gen/assets/icons/error_icon.png"));		// Loads the icon for the window with error prompt
	ImageIcon warning_ui_logo = new ImageIcon (getClass().getClassLoader().getResource ("pwd_gen/assets/icons/warning_icon.png"));	// Loads the icon for the window with warning prompt
	
	public void errorUIGlobalProperties() {		// The methods below share some common code. So, in order to reduce redundancy, a shared code is inserted in a new method, and will be called across all of the methods below, by using the syntax "errorUIGlobalProperties()"
				
		error_ui.add (err_title_txt);
		error_ui.add (err_desc_txt);
		error_ui.add (ok_btn);
		
		error_ui.addWindowListener (this);
		error_ui.setResizable(false);
		error_ui.setLayout (null);
		error_ui.setVisible (true);
		
	}
	
	public void noInputLength() {				// ERROR_001 - noInputLength() [This exception handler happens if the Length TextField is empty]
		
		error_ui = new Frame();
			
		err_title_txt = new Label ("No Length Input!");
		err_title_txt.setFont (err_title_font);
		err_title_txt.setBounds (72, 45, 400, 25);
		err_desc_txt = new Label ("TextField is empty!");
		err_desc_txt.setFont (err_desc_font);
		err_desc_txt.setBounds (74, 80, 400, 20);
		ok_btn = new Button ("OK");
		ok_btn.setFont (btn_font);
		ok_btn.setBounds(132, 125, 60, 27);
		ok_btn.addActionListener (this);
		
		error_ui.setTitle ("Error");
		error_ui.setIconImage (error_ui_logo.getImage());
		error_ui.setBounds (182, 160, 320, 165);
		
		errorUIGlobalProperties();			// Invokes the method that share the code across all warning/error popups. This syntax is also invoked in other methods.
			
		}
	
	public void invalidInputLength() {			// ERROR_002 - invalidInputLength() [This exception handler happens if the Length TextField contains non-numeric characters (contains only non-numeric characters, or non-numeric characters mixed with numeric characters), such as symbols and letters.]
		
		error_ui = new Frame();
		
		err_title_txt = new Label ("Illegal Char Found!");
		err_title_txt.setFont (err_title_font);
		err_title_txt.setBounds (128, 45, 400, 25);
		err_desc_txt = new Label ("TextField contains a char that is not an integer!");
		err_desc_txt.setFont (err_desc_font);
		err_desc_txt.setBounds (17, 80, 500, 20);
		ok_btn = new Button ("OK");
		ok_btn.setFont (btn_font);
		ok_btn.setBounds(208, 125, 60, 27);
		ok_btn.addActionListener (this);
		
		error_ui.setTitle ("Error");
		error_ui.setIconImage (error_ui_logo.getImage());
		error_ui.setBounds (110, 160, 479, 165);
		
		errorUIGlobalProperties();
		
	}
	
	public void zeroInputLength() {				// ERROR_003 - zeroInputLength() [This exception handler happens if the Length TextField is set to 0]
		
		error_ui = new Frame();
		
		err_title_txt = new Label ("Invalid Length Input!");
		err_title_txt.setFont (err_title_font);
		err_title_txt.setBounds (90, 45, 400, 25);
		err_desc_txt = new Label ("The Length of Password should not be 0!");
		err_desc_txt.setFont (err_desc_font);
		err_desc_txt.setBounds (36, 80, 400, 20);
		ok_btn = new Button ("OK");
		ok_btn.setFont (btn_font);
		ok_btn.setBounds(182, 125, 60, 27);
		ok_btn.addActionListener (this);
		
		error_ui.setTitle ("Error");
		error_ui.setIconImage (error_ui_logo.getImage());
		error_ui.setBounds (135, 160, 425, 165);
		
		errorUIGlobalProperties();
			
		}
	
	public void insufficientInputLength() {		// WARN_001 - insufficientInputLength() [This is not an exception, but rather a warning that password length from 1-8 are discouraged]
		
		error_ui = new Frame();
		
		err_title_txt = new Label ("Password at Risk!");
		err_title_txt.setFont (err_title_font);
		err_title_txt.setBounds (104, 45, 400, 25);
		err_desc_txt = new Label ("The Length of Password is less than 10 char!");
		err_desc_txt.setFont (err_desc_font);
		err_desc_txt.setBounds (13, 80, 400, 20);
		err_desc2_txt = new Label ("Your account is more likely to get hacked.");
		err_desc2_txt.setFont (err_desc_font);
		err_desc2_txt.setBounds (22, 105, 400, 20);
		ok_btn = new Button ("OK");
		ok_btn.setFont (btn_font);
		ok_btn.setBounds(182, 140, 60, 27);
		ok_btn.addActionListener (this);
		
		error_ui.add (err_desc2_txt);
		
		error_ui.setTitle ("Warning");
		error_ui.setIconImage (warning_ui_logo.getImage());
		error_ui.setBounds (135, 160, 425, 180);
		
		errorUIGlobalProperties();
			
		}
	
	public void tooLongInputLength() {			// ERROR 004 - tooLongInputLength() [Also not an exception, but the developer has capped the max pass length to 30. It's strong enough]
		
		error_ui = new Frame();
		
		err_title_txt = new Label ("Length Input is too long!");
		err_title_txt.setFont (err_title_font);
		err_title_txt.setBounds (75, 45, 400, 25);
		err_desc_txt = new Label ("Only up to 30 chars are allowable!");
		err_desc_txt.setFont (err_desc_font);
		err_desc_txt.setBounds (55, 80, 400, 20);
		ok_btn = new Button ("OK");
		ok_btn.setFont (btn_font);
		ok_btn.setBounds(182, 125, 60, 27);
		ok_btn.addActionListener (this);
		
		error_ui.setTitle ("Error");
		error_ui.setIconImage (error_ui_logo.getImage());
		error_ui.setBounds (135, 160, 425, 165);
		
		errorUIGlobalProperties();
			
		}
	
	public void noConfiguredCheckbox() {		// ERROR_005 - noConfiguredCheckbox() [This exception handler happens if there's no ticked JCheckBox on the parameters section in the Main_UI]
		
		error_ui = new Frame();
		
		err_title_txt = new Label ("No Configured Charset!");
		err_title_txt.setFont (err_title_font);
		err_title_txt.setBounds (97, 45, 400, 25);
		err_desc_txt = new Label ("Please tick atleast one checkbox!");
		err_desc_txt.setFont (err_desc_font);
		err_desc_txt.setBounds (67, 80, 400, 20);
		ok_btn = new Button ("OK");
		ok_btn.setFont (btn_font);
		ok_btn.setBounds(182, 125, 60, 27);
		ok_btn.addActionListener (this);
		
		error_ui.setTitle ("Error");
		error_ui.setIconImage (error_ui_logo.getImage());
		error_ui.setBounds(135, 175, 425, 165);
		
		errorUIGlobalProperties();
			
		}
	
	public void actionPerformed (ActionEvent btn) {		// The brains of the "OK" button.
		
		if (btn.getSource() == ok_btn) {
			error_ui.dispose();
		}
	}

	public void windowClosing (WindowEvent e) {			// To make the window/frame closable
														// Take note that you will have to invoke the .addWindowListener to the frame (in this case, i've done it on lines 42, 71, 100, 133, and 162)
		error_ui.dispose();
		
	}

}