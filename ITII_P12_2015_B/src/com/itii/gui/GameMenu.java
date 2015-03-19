package com.itii.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.itii.data.Boat;
import com.itii.data.Boat.Boats;
import com.itii.data.boats.AircraftCarrier;
import com.itii.data.boats.Battleship;
import com.itii.data.boats.Cruiser;
import com.itii.data.boats.Destroyer;
import com.itii.data.boats.Submarine;

public class GameMenu extends JPanel implements ActionListener {

	private static final String ACTION_ROTATE_BOAT_BUTTON = "ACTION_ROTATE_BOAT_BUTTON";
	private static final String ACTION_QUIT_BUTTON = "ACTION_QUIT_BUTTON";
	private JComboBox<Boat> boatComboBox ;
	private JLabel boatAvailableLabel  = new JLabel();
	private JButton rotateBoatButton = new JButton();
	private JButton readyButton= new JButton();
	private JButton joinButton = new JButton();
	private JButton hitButton = new JButton();
	private JButton surrenderButton = new JButton();
	private JButton restartButton = new JButton();
	private JButton quitButton = new JButton();
	private ActionEvent actionEvent;
	
	public void initializejComboBox()
	{
		if(boatComboBox==null)
		{
			final Boat[] boats={
					new AircraftCarrier(),
					new Battleship(),
					new Cruiser(),
					new Submarine(),
					new Submarine(),
					new Destroyer(),
					new Destroyer()
			};
			
			boatComboBox = new JComboBox(boats);
			
			
		}
	
	}
	public void initializeName()
	{
		boatAvailableLabel.setText("Bateau Disponible");
		rotateBoatButton.setText("Rotation 90°");
		rotateBoatButton.setActionCommand(ACTION_ROTATE_BOAT_BUTTON);
		rotateBoatButton.addActionListener(this);
		readyButton.setText("Prêt");
		joinButton.setText("Joindre");
		hitButton.setText("Attaquer");
		surrenderButton.setText("Abandonner");
		restartButton.setText("Redémarrer");
		quitButton.setText("Quitter");
		quitButton.setActionCommand(ACTION_QUIT_BUTTON);
		quitButton.addActionListener(this);
	}


	public GameMenu() {
		super();
		setBackground(Color.white);
		initializejComboBox();
		initializeName();
		initialize();
		
	}

	public void initialize()
	{
		GridLayout layout = new GridLayout(9, 0);
		this.setLayout(layout);
		add(boatComboBox);
		add(boatAvailableLabel);
		add(rotateBoatButton);
		add(readyButton);
		add(joinButton);
		add(hitButton);
		add(surrenderButton);
		add(restartButton);
		add(quitButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent pactionEvent) {
		actionEvent = pactionEvent;
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				if (ACTION_ROTATE_BOAT_BUTTON.equals(actionEvent.getActionCommand())) {
					if(getBoatComboBox().getItemCount()!=0)
					{
						Boat boat_placing = (Boat) getBoatComboBox().getSelectedItem();
						boat_placing.flipOrientation();
					}
					
				}
				if (ACTION_QUIT_BUTTON.equals(actionEvent.getActionCommand())) {
					System.exit(0);
				}
			}
		});

	}
	


	public JComboBox<Boat> getBoatComboBox() {
		
		return boatComboBox;
	}


	public void setBoatComboBox(JComboBox<Boat> boatComboBox) {
		this.boatComboBox = boatComboBox;
	}


	public JLabel getBoatAvailableLabel() {
		return boatAvailableLabel;
	}

	public void setBoatAvailableLabel(JLabel boatAvailableLabel) {
		this.boatAvailableLabel = boatAvailableLabel;
	}

	public JButton getRotateBoatButton() {
		return rotateBoatButton;
	}

	public void setRotateBoatButton(JButton rotateBoatButton) {
		this.rotateBoatButton = rotateBoatButton;
	}

	public JButton getReadyButton() {
		return readyButton;
	}

	public void setReadyButton(JButton readyButton) {
		this.readyButton = readyButton;
	}

	public JButton getJoinButton() {
		return joinButton;
	}

	public void setJoinButton(JButton joinButton) {
		this.joinButton = joinButton;
	}

	public JButton getHitButton() {
		return hitButton;
	}

	public void setHitButton(JButton hitButton) {
		this.hitButton = hitButton;
	}

	public JButton getSurrenderButton() {
		return surrenderButton;
	}

	public void setSurrenderButton(JButton surrenderButton) {
		this.surrenderButton = surrenderButton;
	}

	public JButton getRestartButton() {
		return restartButton;
	}

	public void setRestartButton(JButton restartButton) {
		this.restartButton = restartButton;
	}

	public JButton getQuitButton() {
		return quitButton;
	}

	public void setQuitButton(JButton quitButton) {
		this.quitButton = quitButton;
	}



	
}
