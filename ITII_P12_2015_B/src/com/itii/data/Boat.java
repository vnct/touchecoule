package com.itii.data;

import com.itii.data.State.BoatOrientation;

public abstract class Boat {

	public static Integer nbCase;
	protected static Boolean placeGrid = false;
	protected BoatOrientation boatOrientation = BoatOrientation.VERTICAL;
	
	public static Boolean getPlaceGrid() {
		return placeGrid;
	}
	public static void setPlaceGrid(Boolean placeGrid) {
		Boat.placeGrid = placeGrid;
	}
	public enum Boats {     
		  AIRCRAFT_CARRIER,   
		  BATTLESHIP,    
		  SUBMARINE,   
		  CRUISER,    
		  DESTROYER;
	};
	public abstract Integer getLength();
	public abstract Boats getBoatType();
	@Override
	public String toString() {
		
		return getBoatType().name() + " [" +getLength() +"]";
	}
	public Integer getCenter()
	{
		return getLength()/2;
	}
	public BoatOrientation getBoatOrientation() {
		return boatOrientation;
	}
	public void setBoatOrientation(BoatOrientation boatOrientation) {
		this.boatOrientation = boatOrientation;
	}
	public final void flipOrientation()
	{
		setBoatOrientation(getBoatOrientation() == BoatOrientation.HORIZONTAL 
				? BoatOrientation.VERTICAL
				: BoatOrientation.HORIZONTAL
				);
		
	}

	
}
