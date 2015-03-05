package com.itii.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.Thread.State;

import javax.swing.JComponent;

import com.itii.data.Coordinates;
import com.itii.data.State.StateEnum;

public class Square extends JComponent{


	protected Coordinates coordinates;
	private StateEnum squareState =StateEnum.EMPTY;
	private StateEnum squaretemporaryState ;
	public Square(Coordinates coor) {
		super();
	
		coordinates = coor;
	
	}
	public void paintSquare(Graphics g,Integer size)
	{
	
		switch (getSquareState()) {
		case EMPTY:
			g.setColor(Color.BLUE);
			g.fillRect(coordinates.getX() * size, coordinates.getY() * size, size,size);
			break;
		case BOAT:
			g.setColor(Color.BLACK);
			g.fillRect(coordinates.getX() * size, coordinates.getY() * size, size,size);
			break;
		case PLACING_BOAT:
			g.setColor(Color.YELLOW);
			g.fillRect(coordinates.getX() * size, coordinates.getY() * size, size,size);
			break;
		default:
			break;
		}
		
	}

	public final void setTemporaryState(final StateEnum temporarySquareState) {
		this.setSquaretemporaryState(temporarySquareState);
	}

	public final void freeTemporaryState() {
		setSquaretemporaryState(null);
	}
	public StateEnum getSquareState() {
		return squaretemporaryState != null   
				? squaretemporaryState    
				: squareState; 
	}

	public Boolean isFree() 
	{
		boolean isFree=false;
		switch (getSquareState()) {
		case BOAT:
			return false;
		case EMPTY:
			return true;
		case PLACING_BOAT:
			return true;
		default:
			return false;
		}
	}
	public StateEnum getSquaretemporaryState() {
		return squaretemporaryState;
	}
	public void setSquaretemporaryState(StateEnum squaretemporaryState) {
		this.squaretemporaryState = squaretemporaryState;
	}

}
