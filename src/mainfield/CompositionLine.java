package mainfield;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

public class CompositionLine extends ConnectionLine {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void paintEndPoint(Graphics g, int toport, int startX, int startY)
	{
		Diamond d = new Diamond(arrowSize, arrowSize, startX, startY, toport);
		((Graphics2D) g).draw(d);
	}
	
	CompositionLine(CaseItem fromCase, int fromport, CaseItem toCase, int toport)
	{
		super(fromCase, fromport, toCase, toport);
	}
	
	
	public class Diamond extends Path2D.Double {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Diamond(int width, int height, int startX, int startY, int toport) {
			int startdrawX = startX;
			int startdrawY = startY;
			
			switch(toport)
			{
			case northPort:
				startdrawX = startX;
				startdrawY = startY;
				break;
			case eastPort:
				startdrawX = (int) (startX - width / 2);
				startdrawY = (int) (startY - height / 2);
				break;
			case southPort:
				startdrawX = startX;
				startdrawY = (int) (startY - height);
				break;
			case westPort:
				startdrawX = (int) (startX + width / 2);
				startdrawY = (int) (startY - height / 2);
				break;
				
			}
			//all start at north point
			moveTo(startdrawX, startdrawY);
			lineTo(startdrawX + width / 2, startdrawY + height / 2);
			lineTo(startdrawX, startdrawY + height);
			lineTo(startdrawX - width / 2, startdrawY + height / 2);
	        closePath();
	    }

	}
}
