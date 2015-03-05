package com.itii.data.boats;

import com.itii.data.Boat;
import com.itii.data.Boat.Boats;

public class Battleship  extends Boat
{
	@Override
	public Integer getSize() {
		return 4;
	}

	@Override
	public Boats getBoatType() {
		// TODO Auto-generated method stub
		return Boat.Boats.BATTLESHIP;
	}
}
