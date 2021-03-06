package com.itii.gui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
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
	private Integer squareEdgeSize = 0;
	private final Square[][] squares;

	public GridDisplay(Integer gridSize, Boolean player) {
		super();
		this.gridSize = gridSize;
		this.player = player;
		this.squares = new Square[gridSize + 1][gridSize + 1];
		initializeGrid();
		if (player)
			setGridDisplayEnabled(true);

	}

	public void initializeGrid() {
		for (int y = 0; y < getSquares().length; y++) {
			for (int x = 0; x < getSquares()[y].length; x++) {
				if (y == 0) {
					getSquares()[y][x] = new SurroundingSquare(new Coordinates(
							y, x));
				} else if (x == 0) {
					getSquares()[y][x] = new SurroundingSquare(new Coordinates(
							y, x));
				} else {
					getSquares()[y][x] = new Square(new Coordinates(y, x));
				}

			}
		}
	}

	public void freeAllTemporarySquareState() {
		for (int y = 1; y < getSquares().length; y++) {
			for (int x = 1; x < getSquares()[y].length; x++) {

				getSquares()[y][x].freeTemporaryState();
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// Display the grid itself.
		squareEdgeSize = Math.min((getWidth() / (getSquares().length + 1)),
				(getHeight() / (getSquares()[0].length + 1)));

		for (int y = 0; y < getSquares().length; y++) {
			for (int x = 0; x < getSquares()[y].length; x++) {
				getSquares()[y][x].paintSquare(g, squareEdgeSize);// ici on g�re
																	// la taille
																	// des cases
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent mouseEvent) {
		GridDisplay gridDisplay = (GridDisplay) mouseEvent.getSource();
		try{
			Boat boatBeingAdded = (Boat) MainWindow.getInstance().getDesk()
					.getGameMenu().getBoatComboBox().getSelectedItem();

			Square squareDisplayingBoat = (Square) (gridDisplay
					.getComponentAt(mouseEvent.getPoint()));
			// System.out.println(MainWindow.getInstance().getDesk().getGameMenu().getBoatComboBox().getSelectedItem());
			updateSquareDependingOnBoatSelected(squareDisplayingBoat,
					boatBeingAdded, State.StateEnum.PLACING_BOAT, true);
		}
		catch(Exception e)
		{
			
		}
		
		
		repaint();

	}
	/**
	 * Fonction qui permet pour une case donn�e de regarder autour et de d�terminer si on peut ou non placer le bateau en fonction si les cases sont vides ou remplies. 
	 * 
	 * @param squareDisplayingBoat : Square o� se trouve l'emplacement de la souris. Endroit o� nous souhaitons placer notre Bateau
	 * @param boatBeingAdded : Type de notre Bateau, on va surtout s'interesser � la taille
	 * @param state : Etat si nous voulons juste faire l'action de d�placer le bateau ou le placer. 
	 * @param isTemporary : Si temporaire on ne sauvegarde pas l'�tat. 
	 * @return Retourne si nous avons r�ussi ou non � placer un bateau
	 */
	private boolean updateSquareDependingOnBoatSelected(
			final Square squareDisplayingBoat, final Boat boatBeingAdded,
			final StateEnum state, final boolean isTemporary) {

		ArrayList<Square> listOfSquareToUpdate = new ArrayList<Square>();
		Boolean isFreeSquare = true;
		Boolean boatPlaced = false;

		final int boatSize = boatBeingAdded.getLength();
		final int boatCenter = boatBeingAdded.getCenter();
		freeAllTemporarySquareState();
		switch (boatBeingAdded.getBoatOrientation()) {
		case VERTICAL:
			final int numberOfSquaresOnX = squares[0].length;
			
			final int currentXPosition = squareDisplayingBoat.getPositionX();
		
			
			final int boatRightEdgePosition = currentXPosition
					+ (boatSize - boatCenter);
			final int boatLeftEdgePosition = currentXPosition - boatCenter;
			
			int startingXPosition = boatLeftEdgePosition;
			if (boatRightEdgePosition >= numberOfSquaresOnX
					|| boatLeftEdgePosition < 1) { // As the boat is crossing
													// the
													// limit of the grid we
													// shift it
													// inside the grid
				startingXPosition = boatRightEdgePosition >= numberOfSquaresOnX ? (numberOfSquaresOnX - boatSize)
						: 1;
			}
			for (int x = 0; x < boatSize; x++) {
				final Square squareForTmpBoatPlacing = getSquares()[squareDisplayingBoat
						.getPositionY()][startingXPosition + x];
				// System.out.println(squareForTmpBoatPlacing.getPositionX());
				// System.out.println(squareForTmpBoatPlacing.getPositionY());
				// System.out.println(squareForTmpBoatPlacing.isFree());

				if (!squareForTmpBoatPlacing.isFree()) {
					isFreeSquare = false;
				}
				listOfSquareToUpdate.add(squareForTmpBoatPlacing);
			}
			break;

		case HORIZONTAL:
			final int numberOfSquaresOnY = squares.length;
			
			final int currentYPosition = squareDisplayingBoat.getPositionY();
		
			final int boatUpEdgePosition = currentYPosition
					+ (boatSize - boatCenter);
			final int boatBottomEdgePosition = currentYPosition - boatCenter;
			
			int startingYPosition = boatBottomEdgePosition;
			if (boatUpEdgePosition >= numberOfSquaresOnY
					|| boatBottomEdgePosition < 1) { // As the boat is crossing
													// the
													// limit of the grid we
													// shift it
													// inside the grid
				startingYPosition = boatUpEdgePosition >= numberOfSquaresOnY ? (numberOfSquaresOnY - boatSize)
						: 1;
			}
			for (int x = 0; x < boatSize; x++) {
				final Square squareForTmpBoatPlacing = getSquares()[startingYPosition + x]
						[squareDisplayingBoat.getPositionX()];
				
				if (!squareForTmpBoatPlacing.isFree()) {
					isFreeSquare = false;
				}
				listOfSquareToUpdate.add(squareForTmpBoatPlacing);
			}

		}

		// Verify if the boat could be added to the current position.
		// It must not have any boat already on this square

	
		StateEnum state1 = isFreeSquare ? state : State.StateEnum.FORBIDDEN;
	

		for (Square square : listOfSquareToUpdate) {
			if (isTemporary) {

				square.setTemporaryState(state1);
			} else if (!isTemporary && isFreeSquare) {
				
				square.setSquareState(state1);
				Boat.setPlaceGrid(true);
				boatPlaced = true;
			}
		}

		return boatPlaced;
	}

	@Override
	public Component getComponentAt(final int x, final int y) {
		// int xLocation = (int) (((float) x / gridSize) *
		// getSquares()[0].length);
		// int yLocation = (int) (((float) y / gridSize) * getSquares().length);

		int xLocation = (int) ((float) x / squareEdgeSize);
		int yLocation = (int) ((float) y / squareEdgeSize);

		xLocation = Math.min(xLocation, getSquares()[0].length - 1);
		yLocation = Math.min(yLocation, getSquares().length - 1);
		return getSquares()[yLocation][xLocation];
		// return squares[yLocation][xLocation];
	}

	public void setGridDisplayEnabled(Boolean enable) {
		if (enable) {
			addMouseMotionListener(this);
			addMouseListener(this);
		} else {
			removeMouseListener(this);
			removeMouseMotionListener(this);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

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
		try{
			GridDisplay gridDisplay = (GridDisplay) e.getSource();
			Boat boatBeingAdded = (Boat) MainWindow.getInstance().getDesk()
					.getGameMenu().getBoatComboBox().getSelectedItem();

			Square squareDisplayingBoat = (Square) (gridDisplay.getComponentAt(e
					.getPoint()));

			Boolean boatplaced = updateSquareDependingOnBoatSelected(squareDisplayingBoat,
					boatBeingAdded, State.StateEnum.BOAT, false);
			if(boatplaced)
			{
				Integer positionselected = MainWindow.getInstance().getDesk().getGameMenu().getBoatComboBox().getSelectedIndex();
				MainWindow.getInstance().getDesk().getGameMenu().getBoatComboBox().removeItemAt(positionselected);
				
			}
		}
		catch(Exception exception)
		{
			
		}
		
		repaint();

	}

	public Square[][] getSquares() {
		return squares;
	}

}
