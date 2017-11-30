import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Nash {

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

		JTextArea aUpLeft = new JTextArea(" ");
		GridLayout.fill = GridBagConstraints.HORIZONTAL;
		GridLayout.gridx = 3;
		GridLayout.gridy = 2;
		GridLayout.gridwidth = 1;
		GridLayout.gridheight = 1;
		Window.add(aUpLeft, GridLayout);

		JLabel upLeftComma = null;
		createWindow.addLabel(Window, upLeftComma, ",", 4, 2, 1, 1);

		JTextArea bUpLeft = new JTextArea(" ");
		GridLayout.fill = GridBagConstraints.HORIZONTAL;
		GridLayout.gridx = 5;
		GridLayout.gridy = 2;
		GridLayout.gridwidth = 1;
		GridLayout.gridheight = 1;
		Window.add(bUpLeft, GridLayout);

		JLabel upLeftBraceClose = null;
		createWindow.addLabel(Window, upLeftBraceClose, ")", 6, 2, 1, 1);
		JLabel downLeftBraceOpen = null;
		createWindow.addLabel(Window, downLeftBraceOpen, "(", 2, 3, 1, 1);

		JTextArea aDownLeft = new JTextArea(" ");
		GridLayout.fill = GridBagConstraints.HORIZONTAL;
		GridLayout.gridx = 3;
		GridLayout.gridy = 3;
		GridLayout.gridwidth = 1;
		GridLayout.gridheight = 1;
		Window.add(aDownLeft, GridLayout);

		JLabel downLeftComma = null;
		createWindow.addLabel(Window, downLeftComma, ",", 4, 3, 1, 1);

		JTextArea bDownLeft = new JTextArea(" ");
		GridLayout.fill = GridBagConstraints.HORIZONTAL;
		GridLayout.gridx = 5;
		GridLayout.gridy = 3;
		GridLayout.gridwidth = 1;
		GridLayout.gridheight = 1;
		Window.add(bDownLeft, GridLayout);

		JLabel downLeftBraceClose = null;
		createWindow.addLabel(Window, downLeftBraceClose, ")", 6, 3, 1, 1);
		JLabel rightLabel = null;
		createWindow.addLabel(Window, rightLabel, "Right", 7, 1, 5, 1);
		JLabel upRightBraceOpen = null;
		createWindow.addLabel(Window, upRightBraceOpen, "(", 7, 2, 1, 1);

		JTextArea aUpRight = new JTextArea(" ");
		GridLayout.fill = GridBagConstraints.HORIZONTAL;
		GridLayout.gridx = 8;
		GridLayout.gridy = 2;
		GridLayout.gridwidth = 1;
		GridLayout.gridheight = 1;
		Window.add(aUpRight, GridLayout);

		JLabel upRightComma = null;
		createWindow.addLabel(Window, upRightComma, ",", 9, 2, 1, 1);

		JTextArea bUpRight = new JTextArea(" ");
		GridLayout.fill = GridBagConstraints.HORIZONTAL;
		GridLayout.gridx = 10;
		GridLayout.gridy = 2;
		GridLayout.gridwidth = 1;
		GridLayout.gridheight = 1;
		Window.add(bUpRight, GridLayout);

		JLabel upRightBraceClose = null;
		createWindow.addLabel(Window, upRightBraceClose, ")", 11, 2, 1, 1);
		JLabel downRightBraceOpen = null;
		createWindow.addLabel(Window, downRightBraceOpen, "(", 7, 3, 1, 1);

		JTextArea aDownRight = new JTextArea(" ");
		GridLayout.fill = GridBagConstraints.HORIZONTAL;
		GridLayout.gridx = 8;
		GridLayout.gridy = 3;
		GridLayout.gridwidth = 1;
		GridLayout.gridheight = 1;
		Window.add(aDownRight, GridLayout);

		JLabel downRightComma = null;
		createWindow.addLabel(Window, downRightComma, ",", 9, 3, 1, 1);

		JTextArea bDownRight = new JTextArea(" ");
		GridLayout.fill = GridBagConstraints.HORIZONTAL;
		GridLayout.gridx = 10;
		GridLayout.gridy = 3;
		GridLayout.gridwidth = 1;
		GridLayout.gridheight = 1;
		Window.add(bDownRight, GridLayout);

		JLabel downRightBraceClose = null;
		createWindow.addLabel(Window, downRightBraceClose, ")", 11, 3, 1, 1);

		JButton Calculate = new JButton("Calculate");
		GridLayout.fill = GridBagConstraints.HORIZONTAL;
		GridLayout.gridx = 12;
		GridLayout.gridy = 2;
		GridLayout.gridwidth = 1;
		GridLayout.gridheight = 1;
		Window.add(Calculate, GridLayout);

		JButton Reset = new JButton("Reset");
		GridLayout.fill = GridBagConstraints.HORIZONTAL;
		GridLayout.gridx = 12;
		GridLayout.gridy = 3;
		GridLayout.gridwidth = 1;
		GridLayout.gridheight = 1;
		Window.add(Reset, GridLayout);

		JLabel Answer = new JLabel("None");
		Answer.setVerticalAlignment(SwingConstants.CENTER);
		Answer.setHorizontalAlignment(SwingConstants.CENTER);
		GridLayout.fill = GridBagConstraints.HORIZONTAL;
		GridLayout.gridx = 13;
		GridLayout.gridy = 2;
		GridLayout.gridwidth = 1;
		GridLayout.gridheight = 2;
		Window.add(Answer, GridLayout);
		// createWindow.addLabel(Window, Answer, "None", 13, 2, 1, 2);

		aUpLeft.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					if (e.getModifiers() > 0) {
						aUpLeft.transferFocusBackward();
					} else {
						aUpLeft.transferFocus();
					}
					e.consume();
				}
			}
		});

		bUpLeft.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					if (e.getModifiers() > 0) {
						bUpLeft.transferFocusBackward();
					} else {
						bUpLeft.transferFocus();
					}
					e.consume();
				}
			}
		});

		aUpRight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					if (e.getModifiers() > 0) {
						aUpRight.transferFocusBackward();
					} else {
						aUpRight.transferFocus();
					}
					e.consume();
				}
			}
		});
		
		bUpRight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					if (e.getModifiers() > 0) {
						bUpRight.transferFocusBackward();
					} else {
						bUpRight.transferFocus();
					}
					e.consume();
				}
			}
		});
		
		aDownLeft.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					if (e.getModifiers() > 0) {
						aDownLeft.transferFocusBackward();
					} else {
						aDownLeft.transferFocus();
					}
					e.consume();
				}
			}
		});

		bDownLeft.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					if (e.getModifiers() > 0) {
						bDownLeft.transferFocusBackward();
					} else {
						bDownLeft.transferFocus();
					}
					e.consume();
				}
			}
		});

		aDownRight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					if (e.getModifiers() > 0) {
						aDownRight.transferFocusBackward();
					} else {
						aDownRight.transferFocus();
					}
					e.consume();
				}
			}
		});
		
		bDownRight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					if (e.getModifiers() > 0) {
						bDownRight.transferFocusBackward();
					} else {
						bDownRight.transferFocus();
					}
					e.consume();
				}
			}
		});

		Calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double aInUpLeft = Double.parseDouble(aUpLeft.getText().replace(" ", ""));
				double bInUpLeft = Double.parseDouble(bUpLeft.getText().replace(" ", ""));
				double aInDownLeft = Double.parseDouble(aDownLeft.getText().replace(" ", ""));
				double bInDownLeft = Double.parseDouble(bDownLeft.getText().replace(" ", ""));
				double aInUpRight = Double.parseDouble(aUpRight.getText().replace(" ", ""));
				double bInUpRight = Double.parseDouble(bUpRight.getText().replace(" ", ""));
				double aInDownRight = Double.parseDouble(aDownRight.getText().replace(" ", ""));
				double bInDownRight = Double.parseDouble(bDownRight.getText().replace(" ", ""));

				System.out.println(aInUpLeft);
				System.out.println(bInUpLeft);
				System.out.println(aInDownLeft);
				System.out.println(bInDownLeft);

				System.out.println(aInUpRight);
				System.out.println(bInUpRight);
				System.out.println(aInDownRight);
				System.out.println(bInDownRight);

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
		// System.out.println("Width: " + Window.getWidth() + "\nHeight: " +
		// Window.getHeight());

	}
}
