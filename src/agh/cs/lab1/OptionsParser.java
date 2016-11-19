package agh.cs.lab1;

public class OptionsParser {
	public static MoveDirection[] parse(String[] args) {
		MoveDirection[] tab = new MoveDirection[args.length];
		// int bledne = 0;
		for (int i = 0; i < args.length; i++) {
			switch (args[i]) {
			case "f":
			case "forward":
				tab[i] = MoveDirection.Forward;
				break;
			case "b":
			case "backward":
				tab[i] = MoveDirection.Backward;
				break;
			case "r":
			case "right":
				tab[i] = MoveDirection.Right;
				break;
			case "l":
			case "left":
				tab[i] = MoveDirection.Left;
				break;
			default:
				throw new IllegalArgumentException("\"" + args[i] + "\"" + " jest niepoprawnym argumentem");
				// tab[i] = null;
				// bledne++;
			}
		}

		/*
		 * if (bledne != 0) { MoveDirection[] ntab = new
		 * MoveDirection[args.length - bledne]; for (int i = 0, index = 0; i <
		 * args.length; i++) { if (tab[i] != null) ntab[index++] = tab[i]; }
		 * return ntab; } else
		 */
		return tab;

	}
}
