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
	
	@Override
	protected boolean isPointOnPort_moreCondition(int point_x, int point_y)
	{
		double dradius = (double) this.getWidth() / 2;
		double dx = (double) Math.abs(dradius - point_x);
		double dy = (double) Math.abs(dradius - point_y);
		
		if(dradius * dradius >= dx * dx + dy * dy)	// c^2 = a^2 + b^2
			return true;
		else
			return false;
	}
	
	@Override
	protected void paintCirclePanel(Graphics g)
	{
		g.drawOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
	}
	
	@Override
	public void initUI()
	{
		this.setLayout(new GridBagLayout());
		_con.fill = GridBagConstraints.HORIZONTAL;
		_nameLabel.setText("New case");
		_nameLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(_nameLabel, _con);
		getCenter();
	}
	
	UseCase() {
		super(DefaultUsecaseWidth, DefaultUsecaseHeigth);
		initUI();
	}

}
