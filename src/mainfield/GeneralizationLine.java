package mainfield;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

public class GeneralizationLine extends ConnectionLine {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void paintEndPoint(Graphics g, int toport, int startX, int startY)
	{
		Triangle d = new Triangle(arrowSize, arrowSize, startX, startY, toport);
		((Graphics2D) g).draw(d);
	}
	
	GeneralizationLine(CaseItem fromCase, int fromport, CaseItem toCase, int toport)
	{
		super(fromCase, fromport, toCase, toport);
	}
	
	
	class Triangle extends Path2D.Double {		
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Triangle(int width, int height, int startX, int startY, int toport) {
			int startdrawX = startX;
			int startdrawY = startY;
			
			switch(toport)
			{
			case northPort:
				startdrawX = startX - width / 2;
				startdrawY = startY;
				moveTo(startdrawX, startdrawY);
				lineTo(startdrawX + width, startdrawY);
				lineTo(startdrawX + width / 2, startdrawY + height);
				break;
			case eastPort:
				startdrawX = startX;
				startdrawY = (int) (startY - height / 2);
				moveTo(startdrawX, startdrawY);
				lineTo(startdrawX, startdrawY + height);
				lineTo(startdrawX - width, startdrawY + height / 2);
				break;
			case southPort:
				startdrawX = (int) (startX + width / 2);
				startdrawY = startY;
				moveTo(startdrawX, startdrawY);
				lineTo(startdrawX - width, startdrawY);
				lineTo(startdrawX - width / 2, startdrawY - height);
				break;
			case westPort:
				startdrawX = startX;
				startdrawY = (int) (startY + height / 2);
				moveTo(startdrawX, startdrawY);
				lineTo(startdrawX, startdrawY - height);
				lineTo(startdrawX + width, startdrawY - height / 2);
				break;
				
			}
	        /*moveTo(0 + 100, 5 + 100);
	        lineTo(-5 + 100, -5 + 100);
	        lineTo(5 + 100, -5 + 100);*/
	        /*moveTo(5 + 100, 0 + 100);
	        lineTo(-5 + 100, 5 + 100);
	        lineTo(-5 + 100, -5 + 100);*/
	        closePath();
	    }
	}
}
