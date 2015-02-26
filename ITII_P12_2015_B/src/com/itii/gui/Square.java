package com.itii.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import com.itii.data.Coordinates;

public class Square extends JComponent{


	private Coordinates coordinates;
	public Square(Coordinates coor) {
		super();
		coordinates = coor;
	}
	public void paintSquare(Graphics g,Integer size)
	{
		g.fillRect(coordinates.getX(), coordinates.getY(), size, size);
		g.setColor(Color.BLUE);
		
	}
}
