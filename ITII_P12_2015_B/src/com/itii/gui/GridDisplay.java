package com.itii.gui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class GridDisplay extends JPanel implements MouseListener,
		MouseMotionListener {

	private Integer gridSize;
	private Boolean player;
	private Square[][] squares;

	public GridDisplay(Integer gridSize, Boolean player) {
		super();
		this.gridSize = gridSize;
		this.player = player;
		this.squares = new Square[gridSize + 1][gridSize + 1];
	}



	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		// Display the grid itself. 
		final int squareEdgeSize= Math.min( ( getWidth() / (getSquares().length + 1) ) , ( getHeight() / (getSquares()[0].length + 1 ) ));
		for (int y = 0; y < getSquares().length; y++) {
			for (int x = 0; x < getSquares()[y].length; x++) {
				getSquares()[y][x].paintSquare(g, squareEdgeSize);
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

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
