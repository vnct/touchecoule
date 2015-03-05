package com.itii.data;

public abstract class Boat {

	public static Integer nbCase;
	protected static Boolean placeGrid = false;

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
}
