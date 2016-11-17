package agh.cs.lab1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Testy {

	@Test
	public void testMapDirection() {
		assertEquals(MapDirection.South,MapDirection.East.next());
		assertEquals(MapDirection.North,MapDirection.East.previous());
		assertEquals(MapDirection.North,MapDirection.West.next());
		assertEquals(MapDirection.South,MapDirection.West.previous());
		assertEquals(MapDirection.East,MapDirection.North.next());
		assertEquals(MapDirection.West,MapDirection.North.previous());
		assertEquals(MapDirection.West,MapDirection.South.next());
		assertEquals(MapDirection.East,MapDirection.South.previous());
	}
	@Test
	public void testPosition(){
		assertNotEquals(new Position(12,12),new Position(12,1212));
		assertEquals(new Position(3,4),new Position(2,3).add(new Position(1,1)));
		assertEquals(new Position(2,2).toString(),"(2,2)");
		assertTrue(new Position(3,3).smaller(new Position(4,4)));
		assertFalse(new Position(3,3).smaller(new Position(3,2)));
		assertTrue(new Position(3,3).larger(new Position(2,3)));
		assertFalse(new Position(3,3).larger(new Position(3,4)));

	}
	@Test
	public void testOptionParse(){
		MoveDirection wynik[]={MoveDirection.Forward,MoveDirection.Backward,MoveDirection.Right,MoveDirection.Left,
				MoveDirection.Right,MoveDirection.Backward,MoveDirection.Forward};
		String []test1={"f","b","r","l","r","b","f"};
		String []test2={"forward","backward","right","left","right","backward","forward"};
		String []test3={"f","r","r","l","r","b","f"};
		String []test4={"f","q","r","l","r","b","f"};
		assertTrue(Arrays.equals(OptionsParser.parse(test1),wynik));
		assertTrue(Arrays.equals(OptionsParser.parse(test2),wynik));
		assertFalse(Arrays.equals(OptionsParser.parse(test3),wynik));
		assertFalse(Arrays.equals(OptionsParser.parse(test4),wynik));
	}
	@Test
	public void testHayStack(){
		HayStack [] tabSiana={
				new HayStack(new Position(-4,-4)),
				new HayStack(new Position(7,7)),
				new HayStack(new Position(3,6)),
				new HayStack(new Position(2,0))
		};
		IWorldMap map =new UnboundedMap(tabSiana);
		map.add(new Car(map));
		assertTrue(map.objectAt(new Position(0,0)).toString().equals("N"));
		assertTrue(map.objectAt(new Position(-4,-4)).toString().equals("s"));
		assertTrue(map.objectAt(new Position(7,7)).toString().equals("s"));
		assertTrue(map.objectAt(new Position(3,6)).toString().equals("s"));
		assertTrue(map.objectAt(new Position(2,0)).toString().equals("s"));
		assertTrue(map.objectAt(new Position(2,2))==null);
		assertFalse(map.objectAt(new Position(-4,-4)).toString().equals("N"));
	}
	@Test
	public void testRectangularMap(){
		IWorldMap map=new RectangularMap(1,1);
		Car auto=new Car(map);
		map.add(auto);
		Car auto2=new Car(map,1,1);
		map.add(auto2);
		assertTrue(map.isOccupied(new Position(1,1)));
		assertTrue(map.isOccupied(new Position(0,0)));
		assertFalse(map.isOccupied(new Position(1,0)));
		assertFalse(map.isOccupied(new Position(0,1)));
		Car nibyauto=(Car)map.objectAt(new Position(0,0));
		assertTrue(nibyauto.getPosition().equals(new Position(0,0)));
	}
	@Test
	public void testUnboundedMap(){
		HayStack [] tabSiana={
				new HayStack(new Position(-4,-4)),
				new HayStack(new Position(7,7)),
				new HayStack(new Position(3,6)),
				new HayStack(new Position(2,0))
		};
		IWorldMap map=new UnboundedMap(tabSiana);
		Car auto=new Car(map);
		map.add(auto);
		Car auto2=new Car(map,1,1);
		map.add(auto2);
		assertTrue(map.isOccupied(new Position(1,1)));
		assertTrue(map.isOccupied(new Position(0,0)));
		assertFalse(map.isOccupied(new Position(1,0)));
		assertFalse(map.isOccupied(new Position(0,1)));
		Car nibyauto=(Car)map.objectAt(new Position(0,0));
		assertTrue(nibyauto.getPosition().equals(new Position(0,0)));
	}
}
