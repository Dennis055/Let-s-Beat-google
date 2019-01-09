import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JPanel;

public class GUI extends JPanel implements ActionListener{
	
	 static JFrame frame = new JFrame();
	 static JLabel label = new JLabel("Enter Keywords:");
	 static JButton button = new JButton("Search");
	 static JTextField textfield = new JTextField();
	 
	 public static void main(String[] args) {
		 
		 frame.setSize(1500,1000);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setLayout(null);
		 label.setBounds(0,0,300,200);
		 textfield.setBounds(350, 0, 500, 200);
		 button.setBounds(670, 0, 300, 100);
		 
		 
		 frame.getContentPane().add(label);
		 frame.getContentPane().add(textfield);
		 frame.getContentPane().add(button);
		 
		 
		 frame.setVisible(true);
		 
	 }

	
	public void actionPerformed(ActionEvent e) {
	
	}

}
