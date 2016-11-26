package agh.cs.lab1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeListener {
	protected Map<Position, IMapElement> elements = new HashMap<>();
	private List<Car> cars=new ArrayList<>();
	
	@Override
	public void positionChanged(Position oldPos, Position newPos) {
		IMapElement auto = elements.remove(oldPos);
		elements.put(newPos, auto);
	}

	@Override
	public void add(Car car) {
		if (isOccupied(car.getPosition()))
			throw new IllegalArgumentException("pole " + car.getPosition() + " jest juz zajete");
		elements.put(car.getPosition(), car);
		cars.add(car);
		car.addListener(this);

	}

	@Override
	public void run(MoveDirection[] directions) {
		if (elements.isEmpty())
			return;
		for (int i = 0, len = directions.length; i < len;) {
			for(Car auto:cars){
				auto.move(directions[i++]);
				if (i >= len)
					break;
			}
		}
	}

	public boolean isOccupied(Position position) {
		return elements.containsKey(position);
	}

	public Object objectAt(Position position) {
		return elements.get(position);
	}
}
