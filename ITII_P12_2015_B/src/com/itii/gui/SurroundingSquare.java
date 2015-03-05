package com.itii.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.itii.data.Coordinates;

public class SurroundingSquare extends Square{

	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SurroundingSquare(Coordinates coor) {
		super(coor);
		if(coor.getX()==0&&coor.getY()!=0)
		{
			setName(String.valueOf(1 + coor.getY()-1));
		
		}
		else if(coor.getY()==0&&coor.getX()!=0)
		{
			setName(String.valueOf(Character.toChars(65 + coor.getX()-1)));
			
		}
		else
		{
			setName("");
		}
		
		// TODO Auto-generated constructor stub
	}
	public void paintSquare(Graphics g,Integer size)
	{
		Color color = Color.green;
		g.setColor(color);
		g.fillRect(coordinates.getX()*size, coordinates.getY()*size, size, size);
		color = Color.black;
		g.setColor(color);
		g.drawString(getName(), coordinates.getX()*size+20, coordinates.getY()*size+20);
	}


}
