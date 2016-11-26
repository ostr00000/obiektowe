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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}//(0,31),(1,0)
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Position))
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
