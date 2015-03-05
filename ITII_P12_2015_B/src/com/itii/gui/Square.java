package com.itii.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import com.itii.data.Coordinates;
import com.itii.data.State.StateEnum;

public class Square extends JComponent{


	protected Coordinates coordinates;
	private StateEnum squareState;
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
		g.fillRect(coordinates.getX() * size, coordinates.getY() * size, size,
				size);
	}

	public final void setTemporaryState(final StateEnum temporarySquareState) {
		this.setSquareState(temporarySquareState);
	}

	public final void freeTemporaryState() {
		setSquareState(null);
	}
	public StateEnum getSquareState() {
		return squareState;
	}
	public void setSquareState(StateEnum squareState) {
		this.squareState = squareState;
	}
	public Boolean isFree() 
	{
		switch (getSquareState()) {
		case BOAT:
			return false;
		default:
			return true;
		}
	}

}
