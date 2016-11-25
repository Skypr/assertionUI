package GUI;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class AssertionStatusField extends JPanel implements WindowListener, ActionListener {

	JButton enlarge = new JButton();
	
	JButton checkBox = new JButton();
	
	JButton editButton = new JButton();
	
	private int id;
	private AssertionContainer parent;
	private boolean expanded = false;
	private InfoTextField textField;
	
	

	public AssertionStatusField(AssertionContainer parent, int id, int width, int height, int textHeight) {
		this.setLayout(null);
		this.parent = parent;
		this.id = id;
		this.setOpaque(true);
		this.setSize(width, height);
		
		enlarge.setSize(10, 10);
		checkBox.setSize(10, 10);
		editButton.setSize(50, 15);
		
		checkBox.setLocation((getWidth() / 10) * 8, (getHeight() - checkBox.getHeight()) / 2);
		enlarge.setLocation((getWidth() / 10) * 1 , ((getHeight() - enlarge.getHeight()) / 10) * 9);
		this.add(checkBox);
		this.add(enlarge);
		checkBox.setVisible(true);
		enlarge.setVisible(true);
		enlarge.addActionListener(this);
		textField = new InfoTextField(width, textHeight);
		textField.setSize(width, textHeight);
		textField.setLocation(0, height);
		this.add(textField);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), 2);
		g.fillRect(0, getHeight() - 2, getWidth(), 2);
	}

	public void succes() {
		this.setBackground(Color.green);
		repaint();
	}

	public void fail() {
		this.setBackground(Color.red);
		super.repaint();
	}

	public void reset() {
		super.paintComponent(getGraphics());
		getGraphics().setColor(Color.green);
		this.setBackground(Color.white);
		super.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if (expanded) {
			textField.setVisible(false);
			this.setSize(500, 50);
			parent.collapse(id);
			expanded = false;
		} else {
			textField.setVisible(true);
			this.setSize(500, 50 + 250);
			parent.clicked(id);
			expanded = true;
		}
	}

	public void collapse() {
		if (expanded) {
			textField.setVisible(false);
			this.setSize(500, 50);
			parent.collapse(id);
			expanded = false;
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
	
	public void updateID(int newID) {
		id = newID;
	}

}
