package com.itii.data.boats;

import com.itii.data.Boat;

public class AircraftCarrier extends Boat{

	@Override
	public Integer getLength() {
		return 5;
	}

	@Override
	public Boats getBoatType() {
		// TODO Auto-generated method stub
		return Boat.Boats.AIRCRAFT_CARRIER;
	}



}
