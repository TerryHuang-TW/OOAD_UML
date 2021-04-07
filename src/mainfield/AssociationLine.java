package mainfield;

import java.awt.Graphics;
import java.awt.geom.Path2D;

public class AssociationLine extends ConnectionLine {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void paintEndPoint(Graphics g, int toport, int startX, int startY)
	{
		//child class draw end point here
	}

	AssociationLine(CaseItem fromCase, int fromport, CaseItem toCase, int toport)
	{
		super(fromCase, fromport, toCase, toport);
	}
	
	
	public class Arrow extends Path2D.Double {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int xloc = 50;
		int yloc = 50;
        public Arrow() {
            moveTo(0 + xloc, 10 + yloc);
            lineTo(36 + xloc, 10 + yloc);
            moveTo(36 - 16 + xloc, 0 + yloc);
            lineTo(36 + xloc, 10 + yloc);
            moveTo(36 - 16 + xloc, 20 + yloc);
            lineTo(36 + xloc, 10 + yloc);
        }

    }
}
