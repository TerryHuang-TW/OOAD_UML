package mainfield;

import static java.awt.Color.BLACK;
import java.awt.Graphics;

import javax.swing.JPanel;

public class CaseItem extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String _name = "New item";
	protected boolean _isSelected = false;
	protected boolean[] _individualport = {false, false, false, false};
	
	
	@Override
    public void paintComponent(Graphics g) {
		g.setColor(BLACK);
		paintCirclePanel(g);
		// paint all when selected
		if(_isSelected == true)
		{
			paintPorts(g);
			return;
		}
		
		//paint individual when connecting
		paintNorthport(g, _individualport[0]);
		paintEastport(g, _individualport[1]);
		paintSouthport(g, _individualport[2]);
		paintWestport(g, _individualport[3]);
    }
	
	protected void paintPorts(Graphics g)
	{
		/*paintNorthport(g, !_individualport[0]);
		paintNorthport(g, !_individualport[1]);
		paintNorthport(g, !_individualport[2]);
		paintNorthport(g, !_individualport[3]);*/
		paintNorthport(g, true);
		paintNorthport(g, true);
		paintNorthport(g, true);
		paintNorthport(g, true);
	}
	
	protected int xcenter = 0;
	protected int ycenter = 0;
	protected int portlen = 6;
	protected void paintNorthport(Graphics g, boolean dopaint)
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
	
	public void setName(String name)
	{
		_name = name;
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
	
	protected void paintCirclePanel(Graphics g)
	{
		//add function if is circle panel
	}
	
	protected void showBorder(boolean doshow)
	{
		//child panel do show border
	}
	
	public void isPressOnPort(int press_x, int press_y)
	{
		//calculate which port should connect
	}
	
	public void initUI()
	{
		//add component here
	}
	
	CaseItem(int width, int height)
	{
		this.setSize(width, height);
		this.setLocation(Integer.MAX_VALUE, Integer.MAX_VALUE);			//I have no idea but this solve overlapping issue
																		//interesting finding: original set a (50, 50), b (60, 60)
																		//problem will resolve when x && y >= 60
		xcenter = this.getSize().width  / 2;
		ycenter = this.getSize().height / 2;
	}
}
