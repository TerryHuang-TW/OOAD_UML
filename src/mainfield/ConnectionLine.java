package mainfield;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class ConnectionLine extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int Fromindex = 0;
	static final int Toindex = 1;
	static final int northPort = 0;
	static final int eastPort = 1;
	static final int southPort = 2;
	static final int westPort = 3;
	static final int notaPort = -1;
	static final int arrowSize = 10;
	protected int[][] portPoint = {{0, 0}, {0, 0}};
	private CaseItem _fromCase = null;
	private CaseItem _toCase = null;
	private int _fromport = 0;
	private int _toport = 0;
	private int _fromX = 0;
	private int _fromY = 0;
	private int _toX = 0;
	private int _toY = 0;
	
	
	private int _fromXcost = 0;
	private int _fromYcost = 0;
	private int _toXcost = 0;
	private int _toYcost = 0;
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintEndPoint(g, _toport, portPoint[Toindex][0] + _toXcost, portPoint[Toindex][1] + _toYcost);
		
		Line2D lin = new Line2D.Float(portPoint[Fromindex][0], portPoint[Fromindex][1],
				portPoint[Toindex][0] + _toXcost, portPoint[Toindex][1] + _toYcost);			//this is a line Float(x1,y1,x2,y2)
		((Graphics2D) g).draw(lin);
    }
	
	public void resetline()
	{
		/*if(_fromX == _fromCase.getLocation().x && _fromY == _fromCase.getLocation().y &&
				_toX == _toCase.getLocation().x && _toY == _toCase.getLocation().y)
			return;*/
		_fromX = _fromCase.getLocation().x;
		_fromY = _fromCase.getLocation().y;
		_toX = _toCase.getLocation().x;
		_toY = _toCase.getLocation().y;
		definePoint();
	}
	
	public void definePoint()
	{
		_fromXcost = 0;
		_fromYcost = 0;
		_toXcost = 0;
		_toYcost = 0;
		switch(_fromport)
		{
		case northPort:
			portPoint[Fromindex][0] = _fromX + _fromCase.getWidth() / 2;
			portPoint[Fromindex][1] = _fromY;
			_fromYcost -= arrowSize;
			break;
		case eastPort:
			portPoint[Fromindex][0] = _fromX + _fromCase.getWidth();
			portPoint[Fromindex][1] = _fromY + _fromCase.getHeight() / 2;
			_fromXcost += arrowSize;
			break;
		case southPort:
			portPoint[Fromindex][0] = _fromX + _fromCase.getWidth() / 2;
			portPoint[Fromindex][1] = _fromY + _fromCase.getHeight();
			_fromYcost += arrowSize;
			break;
		case westPort:
			portPoint[Fromindex][0] = _fromX;
			portPoint[Fromindex][1] = _fromY + _fromCase.getHeight() / 2;
			_fromXcost -= arrowSize;
			break;
		}
		switch(_toport)
		{
		case northPort:
			portPoint[Toindex][0] = _toX + _toCase.getWidth() / 2;
			portPoint[Toindex][1] = _toY;
			_toYcost -= arrowSize;
			break;
		case eastPort:
			portPoint[Toindex][0] = _toX + _toCase.getWidth();
			portPoint[Toindex][1] = _toY + _toCase.getHeight() / 2;
			_toXcost += arrowSize;
			break;
		case southPort:
			portPoint[Toindex][0] = _toX + _toCase.getWidth() / 2;
			portPoint[Toindex][1] = _toY + _toCase.getHeight();
			_toYcost += arrowSize;
			break;
		case westPort:
			portPoint[Toindex][0] = _toX;
			portPoint[Toindex][1] = _toY + _toCase.getHeight() / 2;
			_toXcost -= arrowSize;
			break;
		}
	}
	
	public void initUI()
	{
		this.setSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		this.setOpaque(false);
	}
	
	protected void paintEndPoint(Graphics g, int toport, int startX, int startY)
	{
		//child class draw end point here
	}
	
	ConnectionLine(CaseItem fromCase, int fromport, CaseItem toCase, int toport)
	{
		_fromCase = fromCase;
		_fromport = fromport;
		_toCase = toCase;
		_toport = toport;
		_fromX = fromCase.getLocation().x;
		_fromY = fromCase.getLocation().y;
		_toX = toCase.getLocation().x;
		_toY = toCase.getLocation().y;
		fromCase.portisConnect(fromport);
		toCase.portisConnect(toport);
		definePoint();
		initUI();
	}
}
