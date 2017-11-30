import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class createWindow {
	public static void addLabel(JFrame window, JLabel label, String displayString, int gridx, int gridy, int gridw, int gridh) {
		label = new JLabel (displayString);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints GridLayout = new GridBagConstraints();
		GridLayout.fill = GridBagConstraints.HORIZONTAL;
		GridLayout.gridx = gridx;
		GridLayout.gridy = gridy;
		GridLayout.gridwidth = gridw;
		GridLayout.gridheight = gridh;
		window.add(label, GridLayout);
	}
}
