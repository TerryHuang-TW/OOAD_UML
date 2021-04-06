package mainfield;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

public class UseCase extends CaseItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int DefaultUsecaseWidth = 1 * 9 + 7 * 7 + 12;	//"New case"
	static final int DefaultUsecaseHeigth = 1 * 9 + 7 * 7 + 12;
	private GridBagConstraints _con = new GridBagConstraints();
	private JLabel _lcase = new JLabel(_name = "New case");
	
	
	@Override
	protected void paintCirclePanel(Graphics g)
	{
		g.drawOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
	}
	
	@Override
	protected void showBorder(boolean doshow)
	{
		//child panel do show border
	}
	
	@Override
	public void isPressOnPort(int press_x, int press_y)
	{
		//calculate which port should connect
	}
	
	@Override
	public void initUI()
	{
		this.setLayout(new GridBagLayout());
		_con.fill = GridBagConstraints.HORIZONTAL;
		_lcase.setHorizontalAlignment(JLabel.CENTER);
		this.add(_lcase, _con);
	}
	
	UseCase() {
		super(DefaultUsecaseWidth, DefaultUsecaseHeigth);
		initUI();
	}

}
