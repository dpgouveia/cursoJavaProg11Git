package s16.ChessSystem.Application;

import java.util.Scanner;

import s16.ChessSystem.BoardGame.Position;

public class Program {

	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		
		Position pos = new Position(3, 5);
		System.out.println(pos);
		
		input.close();
		
	}
	
}
