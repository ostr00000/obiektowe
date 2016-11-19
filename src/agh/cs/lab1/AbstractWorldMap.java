package agh.cs.lab1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap {
	Map<Position, Car> cars = new HashMap<>();

	@Override
	public void add(Car car) {
		if (!isOccupied(car.getPosition()))
			cars.put(car.getPosition(), car);
		else
			throw new IllegalArgumentException("pole " + car.getPosition() + " jest juz zajete");
	}

	@Override
	public void run(MoveDirection[] directions) {
		if (cars.isEmpty())
			return;
		int len = directions.length;
		for (int i = 0; i < len;) {
			Map<Position, Car> newCars = new HashMap<>();
			List<Position> toDelete = new LinkedList<>();
			for (Car car : cars.values()) {
				toDelete.add(car.getPosition());
				car.move(directions[i++]);
				newCars.put(car.getPosition(), car);
				if (i >= len)
					break;
			}
			for (Position p : toDelete) {
				cars.remove(p);
			}
			cars.putAll(newCars);
			//// cars.get(i % mod).move(directions[i]);
		}
	}

	protected boolean isOccupiedAbs(Position position) {
		return cars.containsKey(position);
	}

	protected Object objectAtAbs(Position position) {
		return cars.get(position);
	}
}
