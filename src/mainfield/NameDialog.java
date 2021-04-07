package mainfield;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NameDialog extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int DialogDefaultWidth = 300;
	private static final int DialogDefaultHeight = 200;
	private JPanel buttonPanel = new JPanel();
	private JPanel fieldsPanel = new JPanel();
	private JLabel newname = new JLabel("New name:");
	private JTextField namefield = new JTextField();
	private JButton ok = new JButton("OK");
	private JButton cancel = new JButton("Cancel");
	private CaseItem selectItem = null;
	
	public void initUI()
	{
		fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
		buttonPanel.setLayout(new FlowLayout());
		fieldsPanel.add(newname);
		fieldsPanel.add(namefield);
		buttonPanel.add(ok);
		buttonPanel.add(cancel);
		ok.addActionListener(this);
		cancel.addActionListener(this);
		this.add(fieldsPanel, BorderLayout.PAGE_START);
        this.add(buttonPanel, BorderLayout.PAGE_END);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(ok))
		{
			selectItem.setName(namefield.getText());
			this.dispose();
		}
				
		if(e.getSource().equals(cancel))
			this.dispose();		
	}
	
	NameDialog(JFrame f, String title, boolean modal, CaseItem c)
	{
		super(f, title, modal);
		selectItem = c;
		initUI();
		this.setSize(DialogDefaultWidth, DialogDefaultHeight);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
}
