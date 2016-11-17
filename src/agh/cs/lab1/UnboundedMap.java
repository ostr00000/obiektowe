package agh.cs.lab1;

import java.util.ArrayList;
import java.util.List;

public class UnboundedMap implements IWorldMap{
	HayStack [] siano;
	List<Car> cars=new ArrayList<>();
	
	UnboundedMap(HayStack [] siano){
		this.siano=siano;
	}
	public String toString(){
		int l=0,r=0,u=0,d=0;
		for(Car car:cars){
			Position p=car.getPosition();
			if(p.x<l)l=p.x;
			if(p.x>r)r=p.x;
			if(p.y>u)u=p.y;
			if(p.y<d)d=p.y;
		}
		for(HayStack sia:siano){
			Position p=sia.getPosition();
			if(p.x<l)l=p.x;
			if(p.x>r)r=p.x;
			if(p.y>u)u=p.y;
			if(p.y<d)d=p.y;
		}
		MapVisualizer wynik=new MapVisualizer();
		return wynik.dump(this, new Position(l,d), new Position(r,u));
	}
	
	@Override
	public boolean canMoveTo(Position position) {
		if(!isOccupied(position))return true;
		return false;
	}

	@Override
	public boolean add(Car car) {
		if(!isOccupied(car.getPosition()))
			return cars.add(car);
		return false;
	}

	@Override
	public void run(MoveDirection[] directions) {
		int mod = cars.size();
		for (int i = 0; i < directions.length; i++) {
			cars.get(i % mod).move(directions[i]);
		}
		
	}

	@Override
	public boolean isOccupied(Position position) {
		for(Car auto:cars){
			if(auto.getPosition().equals(position))
				return true;
		}
		for(HayStack sia:siano){
			if(sia.getPosition().equals(position))
				return true;
		}
		return false;
	}

	@Override
	public Object objectAt(Position position) {
		for(Car car:cars){
			if(car.getPosition().equals(position))
				return car;
		}
		for(HayStack sia:siano){
			if(sia.getPosition().equals(position))
				return sia;
		}
		return null;
	}

}
