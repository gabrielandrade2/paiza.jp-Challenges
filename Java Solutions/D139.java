// D139:少ない方の勝ち
// The smaller one wins
// Authon: Gabriel Andrade

import java.util.Scanner;

public class D139 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int participants = Integer.valueOf(s.nextLine());
		String choices = s.nextLine().replace(" ", "").substring(0, participants);
		s.close();
		
		int gCount = (int) choices.chars().parallel().filter(ch -> ch == 'G').count();
		int pCount = (int) choices.chars().parallel().filter(ch -> ch == 'P').count();
		
		if(gCount > pCount)
			System.out.println("P");
		else if(gCount < pCount)
			System.out.println("G");
		else 
			System.out.println("Draw");
	}

}
