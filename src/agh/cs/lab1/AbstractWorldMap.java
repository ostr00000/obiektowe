package agh.cs.lab1;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
	List<Car> cars=new ArrayList<>();
	
	@Override
	public boolean add(Car car) {
		if(!isOccupied(car.getPosition()))
			return cars.add(car);
		return false;
	}
	
	@Override
	public void run(MoveDirection[] directions) {
		int mod = cars.size();
		if(mod==0)return;
		for (int i = 0; i < directions.length; i++) {
			cars.get(i % mod).move(directions[i]);
		}
	}
	
	protected boolean isOccupiedAbs(Position position) {
		for(Car auto:cars){
			if(auto.getPosition().equals(position))
				return true;
		}
		return false;
	}

	
	protected Object objectAtAbs(Position position) {
		for(Car car:cars){
			if(car.getPosition().equals(position))
				return car;
		}
		return null;
	}
}
