package com.itii.gui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.EventObject;

import javax.swing.JPanel;

import com.itii.data.Boat;
import com.itii.data.Coordinates;
import com.itii.data.State;
import com.itii.data.State.StateEnum;

public class GridDisplay extends JPanel implements MouseListener,
		MouseMotionListener {

	private Integer gridSize;
	private Boolean player;
	private final Square[][] squares;


	public GridDisplay(Integer gridSize, Boolean player) {
		super();
		this.gridSize = gridSize;
		this.player = player;
		this.squares = new Square[gridSize + 1][gridSize + 1];
		initializeGrid();
		
	}

	public void initializeGrid()
	{
		for (int y = 0; y < getSquares().length; y++) {
			for (int x = 0; x < getSquares()[y].length; x++) {
				if(y==0)
				{
					getSquares()[y][x]=new SurroundingSquare(new Coordinates(y, x));
				}
				else if(x==0)
				{
					getSquares()[y][x]=new SurroundingSquare(new Coordinates(y, x));
				}
				else
				{
					getSquares()[y][x]=new Square(new Coordinates(y, x));
				}
				
			}
		}
	}

	public void freeAllTemporarySquareState() 
	{
		for (int y = 1; y < getSquares().length; y++) {
			for (int x = 1; x < getSquares()[y].length; x++) {
				
				//getSquares()[y][x]
			}
		}
	}
	public void freeTemporaryState()
	{
		
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// Display the grid itself. 
		final int squareEdgeSize= Math.min( ( getWidth() / (getSquares().length + 1) ) , ( getHeight() / (getSquares()[0].length + 1 ) ));
		for (int y = 0; y < getSquares().length; y++) {
			for (int x = 0; x < getSquares()[y].length; x++) {
				
				getSquares()[y][x].paintSquare(g, squareEdgeSize);// ici on gère la taille des cases
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent mouseEvent) {
		GridDisplay gridDisplay= (GridDisplay) mouseEvent.getSource();
		Boat boatBeingAdded= (Boat) MainWindow.getInstance().getDesk().getGameMenu().getBoatComboBox().getSelectedItem();
		Square squareDisplayingBoat= (Square)(gridDisplay.getComponentAt( mouseEvent.getPoint() ));
		updateSquareDependingOnBoatSelected( squareDisplayingBoat, boatBeingAdded, State.StateEnum.PLACING_BOAT, true );
		repaint();

	}

	private void updateSquareDependingOnBoatSelected(
			Square squareDisplayingBoat, Boat boatBeingAdded,
			StateEnum placingBoat, boolean b) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Component getComponentAt ( final int x, final int y )
	{  
		int xLocation=  (int) ( ( (float)x / gridSize ) * getSquares()[0].length );   
		int yLocation=  (int) ( ( (float)y / gridSize ) * getSquares().length );         
		xLocation =  Math.min( xLocation, getSquares()[0].length - 1 );   
		yLocation =  Math.min( yLocation, getSquares().length - 1 );  
	    return squares[yLocation][xLocation];
	   }


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public Square[][] getSquares() {
		return squares;
	}


}
