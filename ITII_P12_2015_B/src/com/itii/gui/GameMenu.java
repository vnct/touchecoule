package com.itii.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.itii.data.Boat;
import com.itii.data.Boat.Boats;
import com.itii.data.boats.AircraftCarrier;
import com.itii.data.boats.Battleship;
import com.itii.data.boats.Cruiser;
import com.itii.data.boats.Destroyer;
import com.itii.data.boats.Submarine;

public class GameMenu extends JPanel implements ActionListener {

	private JComboBox<Boat> boatComboBox ;
	private JLabel boatAvailableLabel  = new JLabel();
	private JButton rotateBoatButton = new JButton();
	private JButton readyButton= new JButton();
	private JButton joinButton = new JButton();
	private JButton hitButton = new JButton();
	private JButton surrenderButton = new JButton();
	private JButton restartButton = new JButton();
	private JButton quitButton = new JButton();
	
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
	

	public GameMenu() {
		super();
		setBackground(Color.black);
		initializejComboBox();
		initialize();
		
	}

	public void initialize()
	{
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
