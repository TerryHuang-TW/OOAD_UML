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
		Diamond d = new Diamond(10, 10, startX, startY);
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

		public Diamond(double width, double height, int startX, int startY) {
	        moveTo(0 + startX, height / 2 + startY);
	        lineTo(width / 2 + startX, 0 + startY);
	        lineTo(width + startX, height / 2 + startY);
	        lineTo(width / 2 + startX, height + startY);
	        closePath();
	    }

	}
}
