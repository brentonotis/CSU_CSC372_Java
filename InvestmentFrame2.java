package investment_frame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InvestmentFrame2 extends JFrame {
	
	// still not sure on serialVersionUID - this is c/o Eclipse to compile..
	private static final long serialVersionUID = 1L;
	
	// declare static/final instance variables
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 100;
	
	private static final double DEFAULT_RATE = 5;
	private static final double INITIAL_BALANCE = 1000;
	
	// declare component instance variables
	private JLabel rateLabel;
	private JTextField rateField;
	private JButton button;
	private JLabel resultLabel;
	private double balance;
	
	// constructor - initializes balance, label, and creates components via helper methods
	public InvestmentFrame2() {
		
		balance = INITIAL_BALANCE;
		
		resultLabel = new JLabel("Balance: " + balance);
		
		createTextField();
		createButton();
		createPanel();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);			
	}
	
	// helper method creates text field
	private void createTextField() {
		
		rateLabel = new JLabel("Interest Rate: ");
		final int FIELD_WIDTH = 10;
		rateField = new JTextField(FIELD_WIDTH);
		rateField.setText("" + DEFAULT_RATE);	
	}
	
	// inner-class creates event listener via ActionListener interface
	class AddInterestListener implements ActionListener {
		
		// ActionListener interface method
		public void actionPerformed(ActionEvent event) {
			
			// gets string value from text field, converts to numeric (double) value
			double rate = Double.parseDouble(rateField.getText());
			
			// creates variable interest, calculates balance + interest, sets text to resultLabel
			double interest = balance * rate / 100;
			balance += interest;
			resultLabel.setText("Balance: " + balance);
		}
	}
	
	// helper method creates button
	private void createButton() {
		
		// creates button & event listener, attaches listener to button
		button = new JButton("Add interest");
		ActionListener listener = new AddInterestListener();
		button.addActionListener(listener);
	}
	
	// helper method creates panel
	private void createPanel() {
		
		JPanel panel = new JPanel();
		panel.add(rateLabel);
		panel.add(rateField);
		panel.add(button);
		panel.add(resultLabel);
		add(panel);
	}

	public static void main(String[] args){ 
		
		JFrame frame = new InvestmentFrame2();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	 }
}
