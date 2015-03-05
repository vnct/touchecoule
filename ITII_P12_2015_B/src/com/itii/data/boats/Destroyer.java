package com.itii.data.boats;

import com.itii.data.Boat;
import com.itii.data.Boat.Boats;

public class Destroyer  extends Boat {
	
	@Override
	public Integer getLength() {
		return 2;
	}

	@Override
	public Boats getBoatType() {
		// TODO Auto-generated method stub
		return Boat.Boats.DESTROYER;
	}

}
