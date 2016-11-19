package agh.cs.lab1;

public class RectangularMap extends AbstractWorldMap{
	public Position lewoDol = new Position(0, 0);
	public Position prawoGora;

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
	public boolean isOccupied(Position position) {
		return isOccupiedAbs(position);
	}

	@Override
	public Object objectAt(Position position) {
		return objectAtAbs(position);
	}

}
