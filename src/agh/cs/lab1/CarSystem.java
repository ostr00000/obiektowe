package agh.cs.lab1;

import java.util.Random;

public class CarSystem {
	public static void main(String[] args) {
		try {
			MoveDirection[] directions = OptionsParser.parse(args);
			Random rand = new Random();
			HayStack tabSiana[] = new HayStack[10];
			for (int i = 0; i < 10; i++) {
				tabSiana[i] = new HayStack(new Position(rand.nextInt(10), rand.nextInt(10)));
			}

			//IWorldMap map = new RectangularMap(10, 5);
			IWorldMap map = new UnboundedMap(tabSiana);
			map.add(new Car(map));
			map.add(new Car(map, 1, 0));
			map.run(directions);
			for (String s : args)
				System.out.print(s + " ");
			System.out.println();
			System.out.println(map);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex);
		}
	}
}
