import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static ArrayList<Integer> playerpositions=new ArrayList<>();
	static ArrayList<Integer> cpupositions=new ArrayList<>();

	public static void main(String[] args) {
		char[][] gameboard={
				{' ','|',' ','|',' '},
		{'-','+','-','+','-'},
		{' ','|',' ','|',' '},
		{'-','+','-','+','-'},
		{' ','|',' ','|',' '}};
		System.out.println("Welcome to Tic Tac Toe!");
		System.out.println();
		printgameboard(gameboard);
		
		Scanner scn=new Scanner(System.in);
		
		while(true) {
			
			
			System.out.println("Enter position to insert: ");
			int pos=scn.nextInt();
			while(playerpositions.contains(pos) || cpupositions.contains(pos)) {
				System.out.println("Enter valid position to insert: ");
				pos=scn.nextInt();
			}
			
			placepiece(gameboard,pos,"player");
			
			Random rand=new Random();
			int cpupos=rand.nextInt(9)+1;
			while(playerpositions.contains(cpupos) || cpupositions.contains(cpupos)) {
				cpupos=rand.nextInt(9)+1;
			}
			
			placepiece(gameboard,cpupos,"cpu");
			printgameboard(gameboard);
			
			String result = checkwinner();
			System.out.println(result);
			
		}
		
		
		
	}
	
	public static void printgameboard(char[][] game) {
		for(char[] row:game) {
			for(char ch:row) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}
	
	public static void placepiece(char[][] gameboard, int pos, String user) {
		char symbol=' ';
		if(user.equals("player")) {
			symbol='X';
			playerpositions.add(pos);
		}
		else {
			symbol='O';
			cpupositions.add(pos);
		}
		switch(pos) {
				case 1:
					gameboard[0][0]=symbol;
					break;
				case 2:
					gameboard[0][2]=symbol;
					break;
				case 3:
					gameboard[0][4]=symbol;
					break;
				case 4:
					gameboard[2][0]=symbol;
					break;
				case 5:
					gameboard[2][2]=symbol;
					break;
				case 6:
					gameboard[2][4]=symbol;
					break;
				case 7:
					gameboard[4][0]=symbol;
					break;
				case 8:
					gameboard[4][2]=symbol;
					break;
				case 9:
					gameboard[4][4]=symbol;
					break;
				default:
					break;
		}
		
		
	}
	
	public static String checkwinner() {
		List toprow=Arrays.asList(1,2,3);
		List midrow=Arrays.asList(4,5,6);
		List lastrow=Arrays.asList(7,8,9);
		List fcol=Arrays.asList(1,4,7);
		List midcol=Arrays.asList(2,5,8);
		List lastcol=Arrays.asList(3,6,9);
		List diag1=Arrays.asList(1,5,9);
		List diag2=Arrays.asList(3,5,7);
		
		List<List> winningcondition=new ArrayList<List>();
		winningcondition.add(toprow);
		winningcondition.add(midrow);
		winningcondition.add(lastrow);
		winningcondition.add(fcol);
		winningcondition.add(midcol);
		winningcondition.add(midcol);
		winningcondition.add(lastcol);
		winningcondition.add(diag1);
		winningcondition.add(diag2);
		
		for(List l:winningcondition) {
			if(playerpositions.containsAll(l)) {
				return "Congratulations you won!";
			}
			else if(cpupositions.containsAll(l)) {
				return "OOPS CPU won";
			}
			else if(playerpositions.size()+cpupositions.size()==9) {
				return "Match drawn";
			}
				
			
		}
		
		return "";
	}

}
