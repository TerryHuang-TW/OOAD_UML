package mainfield;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionButtonList extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton[] _optionbuttons;
	private GridBagConstraints _con = new GridBagConstraints();
	
	
	public JButton[] getList()
	{
		return _optionbuttons;
	}
	
	OptionButtonList(String[] buttonNameList, int buttonlistwidth, int buttonlistheight)
	{
		_con.fill = GridBagConstraints.HORIZONTAL;
		_con.gridx = 0; _con.gridy = 0;
		this.setLayout(new GridBagLayout());
		_optionbuttons = new JButton[buttonNameList.length];
		for(int i = 0; i < buttonNameList.length; i++)
		{
			_optionbuttons[i] = new JButton(buttonNameList[i]);
			_optionbuttons[i].setBounds(130, 100, 100, 40);
			_optionbuttons[i].setFocusPainted(false);
			this.add(_optionbuttons[i], _con);
			_con.gridy += 1;
			if(i < buttonNameList.length - 1)
			{
				this.add(Box.createRigidArea(new Dimension(0, 15)), _con);
				_con.gridy += 1;
			}
		}
		this.setMaximumSize(new Dimension(buttonlistwidth, buttonlistheight));
	}
}
