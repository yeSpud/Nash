import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Nash {
	/*
	 *0 			B
	 *1		Left	 Right
	 *2 	 Up (_,_)(_,_) Calculate
	 *3 A Down (_,_)(_,_) Reset		Answer
	 * 
	 */
	public static void main(String args[]) {
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame Window = new JFrame("Nash");
		Window.setLayout(new GridBagLayout());
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagConstraints GridLayout = new GridBagConstraints();
		GridLayout.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel playerA = null;
		createWindow.addLabel(Window, playerA, "Player\nA", 0, 2, 1, 2);
		JLabel upLabel = null;
		createWindow.addLabel(Window, upLabel, "Up", 1, 2, 1, 1);
		JLabel downLabel = null;
		createWindow.addLabel(Window, downLabel, "Down", 1, 3, 1, 1);
		JLabel playerB = null;
		createWindow.addLabel(Window, playerB, "Player B", 2, 0, 10, 1);
		JLabel leftLabel = null;
		createWindow.addLabel(Window, leftLabel, "Left", 2, 1, 5, 1);
		JLabel upLeftBraceOpen = null;
		createWindow.addLabel(Window, upLeftBraceOpen, "(", 2, 2, 1, 1);
		JTextArea aUpLeft = new JTextArea();
		createWindow.addText(Window, aUpLeft, " ", 3, 2, 1, 1);
		JLabel upLeftComma = null;
		createWindow.addLabel(Window, upLeftComma, ",", 4, 2, 1, 1);
		JTextArea bUpLeft = new JTextArea();
		createWindow.addText(Window, bUpLeft, " ", 5, 2, 1, 1);
		JLabel upLeftBraceClose = null;
		createWindow.addLabel(Window, upLeftBraceClose, ")", 6, 2, 1, 1);
		JLabel downLeftBraceOpen = null;
		createWindow.addLabel(Window, downLeftBraceOpen, "(", 2, 3, 1, 1);
		JTextArea aDownLeft = new JTextArea();
		createWindow.addText(Window, aDownLeft, " ", 3, 3, 1, 1);
		JLabel downLeftComma = null;
		createWindow.addLabel(Window, downLeftComma, ",", 4, 3, 1, 1);
		JTextArea bDownLeft = new JTextArea();
		createWindow.addText(Window, bDownLeft, " ", 5, 3, 1, 1);
		JLabel downLeftBraceClose = null;
		createWindow.addLabel(Window, downLeftBraceClose, ")", 6, 3, 1, 1);
		JLabel rightLabel = null;
		createWindow.addLabel(Window, rightLabel, "Right", 7, 1, 5, 1);
		JLabel upRightBraceOpen = null;
		createWindow.addLabel(Window, upRightBraceOpen, "(", 7, 2, 1, 1);
		JTextArea aUpRight = new JTextArea();
		createWindow.addText(Window, aUpRight, " ", 8, 2, 1, 1);
		JLabel upRightComma = null;
		createWindow.addLabel(Window, upRightComma, ",", 9, 2, 1, 1);
		JTextArea bUpRight = new JTextArea();
		createWindow.addText(Window, bUpRight, " ", 10, 2, 1, 1);
		JLabel upRightBraceClose = null;
		createWindow.addLabel(Window, upRightBraceClose, ")", 11, 2, 1, 1);
		JLabel downRightBraceOpen = null;
		createWindow.addLabel(Window, downRightBraceOpen, "(", 7, 3, 1, 1);
		JTextArea aDownRight = new JTextArea();
		createWindow.addText(Window, aDownRight, " ", 8, 3, 1, 1);
		JLabel downRightComma = null;
		createWindow.addLabel(Window, downRightComma, ",", 9, 3, 1, 1);
		JTextArea bDownRight = new JTextArea();
		createWindow.addText(Window, bDownRight, " ", 10, 3, 1, 1);
		JLabel downRightBraceClose = null;
		createWindow.addLabel(Window, downRightBraceClose, ")", 11, 3, 1, 1);
		JButton Calculate = new JButton();
		createWindow.addButton(Window, Calculate, "Calculate", 12, 2, 1, 1);
		JButton Reset = new JButton();
		createWindow.addButton(Window, Reset, "Reset", 12, 3, 1, 1);
		JLabel Answer = new JLabel();
		createWindow.addLabel(Window, Answer, "None", 13, 2, 1, 2);

		Calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aUpLeft.setText(" ");
				bUpLeft.setText(" ");
				aDownLeft.setText(" ");
				bDownLeft.setText(" ");
				aUpRight.setText(" ");
				bUpRight.setText(" ");
				aDownRight.setText(" ");
				bDownRight.setText(" ");
				Answer.setText("None");
			}
		});
		
		Window.setSize(302, 112);
		Window.setVisible(true);
		//System.out.println("Width: " + Window.getWidth() + "\nHeight: " + Window.getHeight());
		
		
	}
	
}
