package agh.cs.lab1;

public class Position {
	final public int x;
	final public int y;

	Position(int a, int b) {
		this.x = a;
		this.y = b;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}


	public boolean smaller(Position oth) {
		return this.x <= oth.x && this.y <= oth.y;
	}

	public boolean larger(Position oth) {
		return this.x >= oth.x && this.y >= oth.y;
	}

	public Position add(Position oth) {
		return new Position(this.x + oth.x, this.y + oth.y);
	}

	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(other instanceof Position))
			return false;
		Position that = (Position) other;
		if (that.x == this.x && that.y == this.y) {
			return true;
		} else
			return false;
	}
}
