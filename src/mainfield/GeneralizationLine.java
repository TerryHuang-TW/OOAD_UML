package mainfield;

import java.awt.Graphics;
import java.awt.geom.Path2D;

public class GeneralizationLine extends ConnectionLine {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void paintEndPoint(Graphics g, int toport, int startX, int startY)
	{
		//child class draw end point here
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

		public Triangle() {
	        moveTo(0 + 100, 5 + 100);
	        lineTo(-5 + 100, -5 + 100);
	        lineTo(5 + 100, -5 + 100);
	        /*moveTo(5 + 100, 0 + 100);
	        lineTo(-5 + 100, 5 + 100);
	        lineTo(-5 + 100, -5 + 100);*/
	        closePath();
	    }
	}
}
