package com.itii.data.boats;

import com.itii.data.Boat;
import com.itii.data.Boat.Boats;

public class Cruiser  extends Boat{
	@Override
	public Integer getLength() {
		return 3;
	}

	@Override
	public Boats getBoatType() {
		// TODO Auto-generated method stub
		return Boat.Boats.CRUISER;
	}

}
