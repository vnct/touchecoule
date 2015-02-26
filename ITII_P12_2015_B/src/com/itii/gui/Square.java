package com.itii.gui;

import javax.swing.JComponent;

import com.itii.data.Coordinates;

public class Square extends JComponent{


	private GridDisplay gridDisplay;
	private Coordinates coordinates;
	public Square(Coordinates coor) {
		super();
		coordinates = coor;
	}
	
}
