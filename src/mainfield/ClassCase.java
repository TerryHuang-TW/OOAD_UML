package mainfield;

import static java.awt.Color.BLACK;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class ClassCase extends CaseItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int DefaultClassWidth = 1*9 + 8*7 + 12;		//"New class"
	static final int DefaultClassHeight = 20 + 20 + 20 + 12;	//3 labels height sum
	private JLabel _l2 = new JLabel();
	private JLabel _l3 = new JLabel();
	private GridBagConstraints _con = new GridBagConstraints();
	
	@Override
	public void initUI()
	{
		this.setLayout(new GridBagLayout());
		_con.fill = GridBagConstraints.HORIZONTAL;
		_nameLabel.setText("New Class");
		_nameLabel.setHorizontalAlignment(JLabel.CENTER);
		_l2.setHorizontalAlignment(JLabel.CENTER);
		_l3.setHorizontalAlignment(JLabel.CENTER);
		_nameLabel.setBorder(new LineBorder(BLACK,1));
		_l2.setBorder(new LineBorder(BLACK,1));
		_l3.setBorder(new LineBorder(BLACK,1));
		
		_con.weightx = 0.5;
		_con.weighty = 0.5;
		_con.gridx = 1; _con.gridy = 1;
		_con.ipadx = 50;	_con.ipady = 20;
		this.add(_nameLabel, _con);
		_con.gridy = 2;
		this.add(_l2, _con);
		_con.gridy = 3;
		this.add(_l3, _con);
		getCenter();
	}
	
	public ClassCase() {
		super(DefaultClassWidth, DefaultClassHeight);
		initUI();
	}

}
