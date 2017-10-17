import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener{
	private ButtonPanel buttons;
	private MenuBar menu;
	private DrawPanel draw;
	private List<Trajectory> tList = new ArrayList();
	
	public Window(){
		buttons = new ButtonPanel();
		menu = new MenuBar();
		draw = new DrawPanel(tList);
		
		//add menu bar
		setJMenuBar(menu);
		
		//add panels
		add(buttons, BorderLayout.WEST);
		add(draw);
		pack();
		draw.setBackground(Color.WHITE);
				
		//window settings
		setSize(500, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH); //fullscreen
		setDefaultCloseOperation(EXIT_ON_CLOSE); //terminate program when closed
		setVisible(true);
		setTitle("Drone Simulator");
		
		
		buttons.addDrone.addActionListener(this);
		buttons.addTraj.addActionListener(this);
		buttons.autofill.addActionListener(this);
		buttons.autoGrid.addActionListener(this);
		buttons.removeEdges.addActionListener(this);
		buttons.removeTraj.addActionListener(this);
		buttons.showEdges.addActionListener(this);
		buttons.start.addActionListener(this);
		
		menu.load.addActionListener(this);
		menu.newGraph.addActionListener(this);
		menu.save.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == buttons.addDrone){
			
		}
		if(e.getSource() == buttons.addTraj){
			// add drone to arraylist
			// call redraw in drawPanel
			
			
			if(tList.size() == 0)
			{
				draw.createGrid(getGraphics());
				//Trajectory t = new Trajectory(0,0);
				//tList.add(t);
			}
			JTextField aField = new JTextField(5);
			JTextField bField = new JTextField(5);

			JPanel myPanel = new JPanel();
			myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));

			myPanel.add(new JLabel("Enter Angle:"));
			myPanel.add(aField);

			myPanel.add(Box.createVerticalStrut(15));

			myPanel.add(new JLabel("Trajectory's ID:"));
			myPanel.add(bField);

			myPanel.add(Box.createVerticalStrut(15));
			
			int result = JOptionPane.showConfirmDialog(null, myPanel, " Enter Values For New SCS Simulation", JOptionPane.OK_CANCEL_OPTION);
			Trajectory existingTraj = null;
			int tempInt = 0;
			
			if (result == JOptionPane.OK_OPTION) {
				String temp1 = aField.getText();
				String temp2 = bField.getText();
				int ang = Integer.parseInt(temp1);
				Trajectory t = new Trajectory(0,0);
				tList.add(t);
			}
			repaint();
		}
		if(e.getSource() == buttons.autofill){
			
		}
		if(e.getSource() == buttons.autoGrid){
			JTextField aField = new JTextField(5);
			JTextField bField = new JTextField(5);

			JPanel myPanel = new JPanel();
			myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));

			myPanel.add(new JLabel("Enter number of rows:"));
			myPanel.add(aField);

			myPanel.add(Box.createVerticalStrut(15));

			myPanel.add(new JLabel("Enter number of columns:"));
			myPanel.add(bField);

			myPanel.add(Box.createVerticalStrut(15));
			
			int result = JOptionPane.showConfirmDialog(null, myPanel, " Enter Values For New SCS Simulation", JOptionPane.OK_CANCEL_OPTION);
			Trajectory existingTraj = null;
			int tempInt = 0;
			
			if (result == JOptionPane.OK_OPTION) {
				String temp1 = aField.getText();
				String temp2 = bField.getText();
				int ang = Integer.parseInt(temp1);
				Trajectory t = new Trajectory(0,0);
				tList.add(t);
			}
		}
		if(e.getSource() == buttons.removeEdges){
			
		}
		if(e.getSource() == buttons.removeTraj){
			
		}
		if(e.getSource() == buttons.showEdges){
			
		}
		if(e.getSource() == buttons.start){
			
		}

		if(e.getSource() == menu.load){
			//see line 960 in ScreenWindow of old sim
		}
		if(e.getSource() == menu.newGraph){
			
		}
		if(e.getSource() == menu.save){
			//see line 906 in ScreenWindow of old sim
		}
	}


}
