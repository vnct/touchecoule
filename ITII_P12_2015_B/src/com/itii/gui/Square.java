package com.itii.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.Thread.State;

import javax.swing.JComponent;

import com.itii.data.Coordinates;
import com.itii.data.State.StateEnum;

public class Square extends JComponent{


	protected Coordinates coordinates;
	private Integer X;
	private Integer Y;
	private StateEnum squareState =StateEnum.EMPTY;

	private StateEnum squaretemporaryState ;
	public Square(Coordinates coor) {
		super();
	
		coordinates = coor;
		setPositionX(coordinates.getX());
		setPositionY(coordinates.getY());
	
	}
	public void setSquareState(StateEnum squareState) {
		this.squareState = squareState;
	}
	public void paintSquare(Graphics g,Integer size)
	{
	
		switch (getSquareState()) {
		case EMPTY:
			g.setColor(Color.BLUE);
			g.fillRect(coordinates.getX() * size, coordinates.getY() * size, size,size);

			//System.out.println("EMPTY");
			break;
		case BOAT:
			g.setColor(Color.BLACK);
			g.fillRect(coordinates.getX() * size, coordinates.getY() * size, size,size);
			//System.out.println("BOAT");
			
			break;
		case PLACING_BOAT:
			g.setColor(Color.YELLOW);
			g.fillRect(coordinates.getX() * size, coordinates.getY() * size, size,size);
		//	System.out.println("PLACING_BOAT");
			break;
		default:
			g.setColor(Color.RED);
			g.fillRect(coordinates.getX() * size, coordinates.getY() * size, size,size);
			
			break;
		}
		g.setColor(Color.WHITE);
		g.drawRect(coordinates.getX() * size, coordinates.getY() * size, size, size);
		
	}

	public final void setTemporaryState(final StateEnum temporarySquareState) {
		//System.out.println("changement temporary " + temporarySquareState);
		this.setSquaretemporaryState(temporarySquareState);
	}

	public final void freeTemporaryState() {
		setSquaretemporaryState(null);
	}
	 /**
	  * Fonction qui permet de récuperer l'état de la case. 
	  * @return StateEnum, état de la case (Vide, présence Bateau, etc..)
 	  */
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
			isFree= false;
			break;
		case EMPTY:
			isFree= true;
			break;
		case PLACING_BOAT:
			isFree = true;
			break;
		default:
			isFree =  false;
			break;
		}
		//System.out.println(isFree);
		return isFree;
	}
	public StateEnum getSquaretemporaryState() {
		return squaretemporaryState;
	}
	public void setSquaretemporaryState(StateEnum squaretemporaryState) {
		this.squaretemporaryState = squaretemporaryState;
	}
	public Integer getPositionX() {
		return X;
	}
	public void setPositionX(Integer x) {
		X = x;
	}
	public Integer getPositionY() {
		return Y;
	}
	public void setPositionY(Integer y) {
		Y = y;
	}

}
