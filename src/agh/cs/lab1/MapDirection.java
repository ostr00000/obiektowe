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
			return "P�noc";
		case South:
			return "Po�udnie";
		case East:
			return "Wsch�d";
		case West:
			return "Zach�d";
		default:
			return "zly kierunek";
		}
	}
}