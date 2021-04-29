package pro_Library.ui.content;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class BookrgContentPanel extends JPanel {

	public BookrgContentPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);

	}

}
