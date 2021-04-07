package mainfield;

import static java.awt.Color.BLACK;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;

public class Canvas extends JLayeredPane implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int CANVAS_BORDER_WIDTH = 1;
	private ArrayList<CaseItem> _caselist = new ArrayList<CaseItem>();
	private ArrayList<CaseItem> _selectedlist = new ArrayList<CaseItem>();
	private ArrayList<ConnectionLine> _linelist = new ArrayList<ConnectionLine>();
	private int _currentmode = 0;
	private int _depth = 99;
	private int _depthline = _depth + 1;
	
	
	public void passCurrentMode(int currentmode)
	{
		_currentmode = currentmode;
	}
	
	public void clickInRange(ArrayList<CaseItem> clist, ArrayList<CaseItem> slist, int point_x, int point_y)
	{
		int largest_depth = Integer.MIN_VALUE;
		CaseItem resultc = null;
		for(int i = 0; i < clist.size(); i++)
		{
			CaseItem c = clist.get(i);
			if(c.getLocation().x <= point_x && point_x <= c.getLocation().x + c.getWidth())
			{
				if(c.getLocation().y <= point_y && point_y <= c.getLocation().y + c.getHeight())
				{
					if(JLayeredPane.getLayer(c) > largest_depth)
					{
						largest_depth = JLayeredPane.getLayer(c);
						resultc = c;
					}
				}
			}
		}
		if(resultc != null)
			slist.add(resultc);
	}
	
	public void circleInRange(ArrayList<CaseItem> clist, ArrayList<CaseItem> slist)
	{
		for(int i = 0; i < clist.size(); i++)
		{
			CaseItem c = clist.get(i);
			if(press_x <= c.getLocation().x && c.getLocation().x + c.getWidth() <= release_x)
			{
				if(press_y <= c.getLocation().y && c.getLocation().y + c.getHeight() <= release_y)
					slist.add(c);
			}
		}
	}
	
	public void releaseInRange(ArrayList<CaseItem> clist, ArrayList<CaseItem> slist, int point_x, int point_y)
	{
		clickInRange(clist, slist, point_x, point_y);
	}
	
	public void changeSelectSwitch(ArrayList<CaseItem> slist)
	{
		if(slist.isEmpty())
			return;
		for(int i = 0; i < slist.size(); i++)
			slist.get(i).SelectSwitch();
		this.refreshScreen();
	}
	
	public CaseItem getSelectItem()
	{
		if(_selectedlist.isEmpty())
			return null;
		return _selectedlist.get(0);
	}
	
	public void refreshScreen()
	{
		this.revalidate();
		this.repaint();
	}
	
	Canvas()
	{
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(BLACK, CANVAS_BORDER_WIDTH),
				BorderFactory.createEmptyBorder()));
		this.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private int press_x;
	private int press_y;
	private int release_x;
	private int release_y;
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.print("pressed: ");
		System.out.println(e.getX() + " " + e.getY());
		press_x = e.getX();
		press_y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.print("released: ");
		System.out.println(e.getX() + " " + e.getY());
		release_x = e.getX();
		release_y = e.getY();
		int delta_x = release_x - press_x;
		int delta_y = release_y - press_y;
		boolean isclick;
		if(delta_x != 0 || delta_y != 0)
			isclick = false;
		else
			isclick = true;
		
		switch(_currentmode)
		{
		case 0:			//Select
			changeSelectSwitch(_selectedlist);		//undo select
			_selectedlist = new ArrayList<CaseItem>();
			if(isclick == true)
				clickInRange(_caselist, _selectedlist, press_x, press_y);
			else
				circleInRange(_caselist, _selectedlist);
			changeSelectSwitch(_selectedlist);		//do select
			break;
		case 1:			//Association
		case 2:			//Generalization
		case 3:			//Composition
			clickInRange(_caselist, _selectedlist, press_x, press_y);
			releaseInRange(_caselist, _selectedlist, release_x, release_y);
			if(_selectedlist.size() != 2)
			{
				_selectedlist = new ArrayList<CaseItem>();
				break;
			}		
			CaseItem fromCase = _selectedlist.get(0);
			CaseItem toCase = _selectedlist.get(1);
			int fromportnum = fromCase.isPointOnPort(press_x, press_y);
			int toportnum = toCase.isPointOnPort(release_x, release_y);
			if(fromportnum == ConnectionLine.notaPort || toportnum == ConnectionLine.notaPort)
			{
				_selectedlist = new ArrayList<CaseItem>();
				break;
			}
			if(_currentmode == 1)
				;
			else if(_currentmode == 2)
				;
			else
				;
			
			_selectedlist = new ArrayList<CaseItem>();
			break;
		default:		//Class, Use case
			if(isclick == false || _depth < 0)
				break;
			int xcenter;
			int ycenter;
			if(_currentmode == 4)				//Class
			{
				_caselist.add(new ClassCase());
				xcenter = ClassCase.DefaultClassWidth / 2;
				ycenter = ClassCase.DefaultClassHeight / 2;
			}
			else								//Use case
			{
				_caselist.add(new UseCase());
				xcenter = UseCase.DefaultUsecaseWidth / 2;
				ycenter = UseCase.DefaultUsecaseHeigth / 2;
			}			
			int new_element_index = _caselist.size() - 1;
			CaseItem newItem = _caselist.get(new_element_index);
			
			this.add(newItem, _depth);
			this.setLayer(newItem, this.getIndexOf(newItem));
			_depth -= 1;
			newItem.setLocation(press_x - xcenter, press_y - ycenter);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
