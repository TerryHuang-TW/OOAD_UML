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
	private ArrayList<CaseItem> _selectedCases = new ArrayList<CaseItem>();
	private int _currentmode = 0;
	private int _depth = 99;
	
	
	public void passCurrentMode(int currentmode)
	{
		_currentmode = currentmode;
		System.out.println(_currentmode);
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
			
			break;
		case 1:			//Association
			break;
		case 2:			//Generalization
			break;
		case 3:			//Composition
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
