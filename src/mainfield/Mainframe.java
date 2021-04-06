package mainfield;

import static java.awt.Color.BLACK;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Mainframe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String[] ButtonNameList = {"Select", 
			"Association", "Generalization", "Composition", "Class", "Use case"};
	private static int framewidth = 800;
	private static int frameheight = 600;
	private static int buttonlistwidth = 400;
	private static int buttonlistheight = 600;
	
	private OptionButtonList _buttonlist = new OptionButtonList(ButtonNameList, buttonlistwidth, buttonlistheight);
	private ActionListener _ButtonEvent = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			findButton(e.getSource());				
		}			
	};
	private Canvas _canvas = new Canvas();
	private JPanel _enlist = new JPanel();
	private JMenuBar _menubar = new JMenuBar();
	private JMenu _filemenu = new JMenu("file"), _editmenu = new JMenu("edit");
	private JMenuItem _groupitem = new JMenuItem("group"), _ungroupitem = new JMenuItem("ungroup");
	
	
	private void findButton(Object b)
	{
		Border pressborder = BorderFactory.createLoweredBevelBorder();
		Border releaseborder = new JButton().getBorder();
		for(int i = 0; i < _buttonlist.getList().length; i++)
		{
			if(b.equals(_buttonlist.getList()[i]))
			{
				_buttonlist.getList()[i].setBorder(pressborder);
				_buttonlist.getList()[i].setPreferredSize(new Dimension(_buttonlist.getList()[i].getWidth(), 
						_buttonlist.getList()[i].getHeight()));
				_canvas.passCurrentMode(i);
			}
			else if(_buttonlist.getList()[i].getBorder() != releaseborder)
			{
				_buttonlist.getList()[i].setBorder(releaseborder);
			}
		}
	}
	
	Mainframe()
	{
		// default item initialize //
		super("UML Editor");
		
		// button list panel //
		for(int i = 0; i < _buttonlist.getList().length; i++)
			_buttonlist.getList()[i].addActionListener(_ButtonEvent);
		int originwidth = _buttonlist.getList()[0].getPreferredSize().width;
		int originheight = _buttonlist.getList()[0].getPreferredSize().height;
		_buttonlist.getList()[0].setBorder(BorderFactory.createLoweredBevelBorder());	//select mode as default
		_buttonlist.getList()[0].setPreferredSize(new Dimension(originwidth, originheight));
				
		// canvas panel //
		
		
		// enlist //
		_enlist.setLayout(new BoxLayout(_enlist, BoxLayout.X_AXIS));
		_enlist.add(Box.createRigidArea(new Dimension(10, 0)));
		_enlist.add(_buttonlist);
		_enlist.add(Box.createRigidArea(new Dimension(10, 0)));
		_enlist.add(_canvas);
		
		// menu bar //
		_editmenu.add(_groupitem);
		_editmenu.add(_ungroupitem);
		_menubar.add(_filemenu);
		_menubar.add(_editmenu);
		
		// frame //
		this.add(_enlist);
		this.setJMenuBar(_menubar);
		this.setSize(framewidth, frameheight);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Mainframe();
		System.out.println("initialized");
	}

}
