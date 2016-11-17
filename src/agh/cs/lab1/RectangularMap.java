package agh.cs.lab1;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
	public Position lewoDol = new Position(0, 0);
	public Position prawoGora;
	List<Car> cars = new ArrayList<>();

	public RectangularMap(int width, int height) {
		prawoGora = new Position(width, height);
	}
	
	
	@Override
	public boolean canMoveTo(Position position) {
		if (position.larger(lewoDol) && position.smaller(prawoGora))
			if (!isOccupied(position))
				return true;
		return false;
	}

	public String toString(){
		MapVisualizer wynik=new MapVisualizer();
		return wynik.dump(this,lewoDol,prawoGora);
	}
	@Override
	public boolean add(Car car) {
		if (!isOccupied(car.getPosition())){
			
			return cars.add(car);
		}
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

	@Override
	public boolean isOccupied(Position position) {
		for (Car car : cars) {
			if (car.getPosition().equals(position)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object objectAt(Position position) {
		for (Car car : cars) {
			if (car.getPosition().equals(position)) {
				return car;
			}
		}
		return null;
	}

}
