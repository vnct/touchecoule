package com.itii.gui;

import javax.swing.JFrame;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 7440673678966475194L;

	private static MainWindow instance;
	
	public static MainWindow getInstance()
	{
		if(instance==null)
		{
	
				instance=new MainWindow();
			
					
		}
		return instance;
	}
	private MainWindow()
	{
		initialize();
	}
	private void initialize()
	{
		this.setSize(300, 300);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
		repaint();
	}
}
