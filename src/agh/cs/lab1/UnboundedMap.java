package agh.cs.lab1;

import java.util.Map;

public class UnboundedMap extends AbstractWorldMap{
	
	UnboundedMap(HayStack [] siano){
		for(HayStack s:siano){
			elements.put(s.getPosition(), s);
		}
	}
	public String toString(){
		int l=0,r=0,u=0,d=0;
		for(Map.Entry<Position, IMapElement> entry : elements.entrySet()){
			Position p=entry.getValue().getPosition();
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
}
