package mainfield;

import static java.awt.Color.BLACK;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CaseItem extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean _isSelected = false;
	private boolean _isgrouped = false;
	private boolean[] _individualport = {false, false, false, false};
	protected JLabel _nameLabel = new JLabel();
	
	
	@Override
    public void paintComponent(Graphics g) {
		g.setColor(BLACK);
		paintCirclePanel(g);
		if(_isSelected == true)		// paint all when selected
			paintPorts(g);
		else						//paint individual when connecting
		{
			paintNorthport(g, _individualport[0]);
			paintEastport(g, _individualport[1]);
			paintSouthport(g, _individualport[2]);
			paintWestport(g, _individualport[3]);
		}
    }
	
	protected void paintPorts(Graphics g)
	{
		/*paintNorthport(g, !_individualport[0]);
		paintNorthport(g, !_individualport[1]);
		paintNorthport(g, !_individualport[2]);
		paintNorthport(g, !_individualport[3]);*/
		paintNorthport(g, true);
		paintEastport(g, true);
		paintSouthport(g, true);
		paintWestport(g, true);
	}
	
	public void portisConnect(int portnum)
	{
		_individualport[portnum] = true;
	}
	
	public boolean porthasUsed(int portnum)
	{
		return _individualport[portnum];
	}
	
	private int xcenter = 0;
	private int ycenter = 0;
	private int portlen = 6;
	private void paintNorthport(Graphics g, boolean dopaint)
	{
		if(dopaint == false)
			return;
		g.fillRect(xcenter - portlen/2, 0					, portlen, portlen);
	}
	protected void paintEastport(Graphics g, boolean dopaint)
	{
		if(dopaint == false)
			return;
		g.fillRect(xcenter*2 - portlen, ycenter - portlen/2	, portlen, portlen);
	}
	protected void paintSouthport(Graphics g, boolean dopaint)
	{
		if(dopaint == false)
			return;
		g.fillRect(xcenter - portlen/2, ycenter*2 - portlen	, portlen, portlen);
	}
	protected void paintWestport(Graphics g, boolean dopaint)
	{
		if(dopaint == false)
			return;
		g.fillRect(0, ycenter - portlen/2					, portlen, portlen);
	}
	
	public void SelectSwitch()
	{
		if(_isSelected == true)
		{
			showBorder(false);
			_isSelected = false;
		}
		else
		{
			showBorder(true);
			_isSelected = true;
		}
	}
	
	public void changeIndividualPort(int index)
	{
		_individualport[index] = true;
	}
	
	protected void getCenter()
	{
		xcenter = this.getSize().width  / 2;
		ycenter = this.getSize().height / 2;
	}
	
	public int isPointOnPort(int point_x, int point_y)
	{
		Double dw = (double) this.getWidth();
		Double dh = (double) this.getHeight();
		Double slope1 = dh / dw;
		Double slope2 = (-1)*slope1;
		Double intercept1 = 0.0;
		Double intercept2 = dh;
		boolean aboveline1 = false;
		boolean aboveline2 = false;
		
		//additional method for child class
		if(isPointOnPort_moreCondition(point_x, point_y) == false)
			return -1;
		
		if(point_y >= slope1 * point_x + intercept1)
			aboveline1 = true;
		if(point_y >= slope2 * point_x + intercept2)
			aboveline2 = true;
		if(aboveline1 == true && aboveline2 == false)
			return ConnectionLine.westPort;
		if(aboveline1 == true && aboveline2 == true)
			return ConnectionLine.southPort;
		if(aboveline1 == false && aboveline2 == true)
			return ConnectionLine.eastPort;
		if(aboveline1 == false && aboveline2 == false)
			return ConnectionLine.northPort;
		return ConnectionLine.notaPort;
	}
	protected boolean isPointOnPort_moreCondition(int point_x, int point_y)
	{
		return true;		//override child class condition here
	}
	
	
	protected void paintCirclePanel(Graphics g)
	{
		//add function if is circle panel
	}
	
	protected void showBorder(boolean doshow)
	{
		//child panel do show border
	}
	
	public boolean getGroupStatus()
	{
		return _isgrouped;
	}
	
	public void setGroupStatus(boolean b)
	{
		_isgrouped = b;
	}
	
	public void setName(String name)
	{
		_nameLabel.setText(name);
	}
	
	public void initUI()
	{
		//add component and getCenter() here
	}
	
	CaseItem(int width, int height)
	{
		this.setSize(width, height);
		//_nameLabel.setOpaque(true);
		this.setLocation(Integer.MAX_VALUE, Integer.MAX_VALUE);			//I have no idea but this solve overlapping issue
																		//interesting finding: original set a (50, 50), b (60, 60)
																		//problem will resolve when x && y >= 60
	}
}
