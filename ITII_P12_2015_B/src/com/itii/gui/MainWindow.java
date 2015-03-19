package com.itii.gui;


import javax.swing.JFrame;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 7440673678966475194L;

	private static MainWindow instance;
	private Desk desk;
	
	public static MainWindow getInstance()
	{
		if(instance==null)
		{
			
	            synchronized(MainWindow.class) {
	              if (instance == null) {
	                instance = new MainWindow();
	              }
	            }
	       
	  
			
					
		}
		return instance;
	}
	private MainWindow()
	{
		initialize();
	}
	private void initialize()
	{
		this.setSize(1300, 600);
		this.setResizable(false);
		this.setVisible(true);
		this.getContentPane().add( getDesk() );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
		repaint();
	}
	public Desk getDesk()
	{
		if(desk==null)
		{
			desk = new Desk(new GridDisplay(10, true), new GridDisplay(10, false));
		}
		return desk;
	}
}
