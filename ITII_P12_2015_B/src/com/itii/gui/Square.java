package com.itii.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import com.itii.data.Coordinates;

public class Square extends JComponent{


	protected Coordinates coordinates;
	public Square(Coordinates coor) {
		super();
		coordinates = coor;
	}
	public void paintSquare(Graphics g,Integer size)
	{
		Color color;
		if(coordinates.getX()==coordinates.getY())
		{
			color = Color.BLUE;
		}
		else
		{
			color = Color.RED;
		}
		g.setColor(color);
		g.fillRect(coordinates.getX()*size, coordinates.getY()*size, size, size);
	}
}
