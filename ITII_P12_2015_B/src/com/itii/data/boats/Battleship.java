package com.itii.data.boats;

import com.itii.data.Boat;
import com.itii.data.Boat.Boats;

public class Battleship  extends Boat
{
	@Override
	public Integer getLength() {
		return 4;
	}

	@Override
	public Boats getBoatType() {
		return Boat.Boats.BATTLESHIP;
	}
}
