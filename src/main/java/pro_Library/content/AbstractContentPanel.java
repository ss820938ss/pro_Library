package pro_Library.content;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class AbstractContentPanel<P> extends JPanel {

	public AbstractContentPanel() {}
	
	public abstract void setItem(P item);
	public abstract P getItem();
	public abstract void validCheck();
	public abstract void clearTf();
	

}
