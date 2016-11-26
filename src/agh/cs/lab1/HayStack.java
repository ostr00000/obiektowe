package agh.cs.lab1;

public class HayStack implements IMapElement {
	Position miejsce;
	
	HayStack(Position miejsce){
		this.miejsce=miejsce;
	}
	public Position getPosition(){
		return this.miejsce;
	}
	public String toString(){
		return "s";
	}
}
