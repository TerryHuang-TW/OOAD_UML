package mainfield;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

public class AssociationLine extends ConnectionLine {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void paintEndPoint(Graphics g, int toport, int startX, int startY)
	{
		Arrow d = new Arrow(arrowSize, arrowSize, startX, startY, toport);
		((Graphics2D) g).draw(d);
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
		
        public Arrow(int width, int height, int startX, int startY, int toport) {
        	int startdrawX = startX;
			int startdrawY = startY;
			moveTo(startdrawX, startdrawY);
			
			switch(toport)
			{
			case northPort:
				lineTo(startdrawX, startdrawY + height);
				moveTo(startdrawX - width / 2, startdrawY + height / 2);
				lineTo(startdrawX, startdrawY + height);
				moveTo(startdrawX + width / 2, startdrawY + height / 2);
				lineTo(startdrawX, startdrawY + height);
				break;
			case eastPort:
				lineTo(startdrawX - width, startdrawY);
				moveTo(startdrawX - width / 2, startdrawY - height / 2);
				lineTo(startdrawX - width, startdrawY);
				moveTo(startdrawX - width / 2, startdrawY + height / 2);
				lineTo(startdrawX - width, startdrawY);
				break;
			case southPort:
				lineTo(startdrawX, startdrawY - height);
				moveTo(startdrawX - width / 2, startdrawY - height / 2);
				lineTo(startdrawX, startdrawY - height);
				moveTo(startdrawX + width / 2, startdrawY - height / 2);
				lineTo(startdrawX, startdrawY - height);
				break;
			case westPort:
				lineTo(startdrawX + width, startdrawY);
				moveTo(startdrawX + width / 2, startdrawY + height / 2);
				lineTo(startdrawX + width, startdrawY);
				moveTo(startdrawX + width / 2, startdrawY - height / 2);
				lineTo(startdrawX + width, startdrawY);
				break;
				
			}
            /*moveTo(0 + xloc, 10 + yloc);
            lineTo(36 + xloc, 10 + yloc);
            moveTo(36 - 16 + xloc, 0 + yloc);
            lineTo(36 + xloc, 10 + yloc);
            moveTo(36 - 16 + xloc, 20 + yloc);
            lineTo(36 + xloc, 10 + yloc);*/
        }

    }
}
