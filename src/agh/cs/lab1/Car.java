package agh.cs.lab1;

public class Car {
	private IWorldMap map;
	private Position pozycja = new Position(0, 0);
	private MapDirection kierunek = MapDirection.North;

	Car(IWorldMap map) {
		this.map = map;
	}

	Car(IWorldMap map, int x, int y) {
		this.map = map;
		Position poz = new Position(x, y);
		if (!map.isOccupied(poz))
			pozycja = poz;
	}

	public String toString() {
		switch (kierunek) {
		case East:
			return "E";
		case North:
			return "N";
		case South:
			return "S";
		default:
			return "W";

		}

	}

	public void move(MoveDirection direction) {
		switch (direction) {
		case Left:
			kierunek = kierunek.previous();
			break;
		case Right:
			kierunek = kierunek.next();
			break;
		case Forward:
			poruszSie(1);
			break;
		case Backward:
			poruszSie(-1);
			break;
		default:
			break;
		}
	}

	private void poruszSie(int a) {
		Position nowa;
		switch (kierunek) {
		case North:
			nowa = pozycja.add(new Position(0, a));
			break;
		case East:
			nowa = pozycja.add(new Position(a, 0));
			break;
		case South:
			nowa = pozycja.add(new Position(0, -a));
			break;
		case West:
		default:
			nowa = pozycja.add(new Position(-a, 0));
			break;
		}
		if (map.canMoveTo(nowa)) {
			this.pozycja = nowa;
		}
	}

	Position getPosition() {
		return this.pozycja;
	}
}
