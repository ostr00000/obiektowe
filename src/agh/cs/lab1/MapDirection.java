package agh.cs.lab1;

public enum MapDirection {
	North, East, South, West;

	public MapDirection next() {
		return MapDirection.values()[(this.ordinal() + 1) % 4];
	}

	public MapDirection previous() {
		return MapDirection.values()[(this.ordinal() + 3) % 4];
	}

	public String toString() {
		switch (this) {
		case North:
			return "Pó³noc";
		case South:
			return "Po³udnie";
		case East:
			return "Wschód";
		case West:
			return "Zachód";
		default:
			return "zly kierunek";
		}
	}
}