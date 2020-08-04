// C055:ログのフィルター
// Log filter
// Author: Gabriel Andrade

import java.util.Scanner;
import java.util.StringJoiner;

public class C055 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfStrings = Integer.valueOf(s.nextLine());
		String importantString = s.nextLine();
		
		// Split input log
		StringJoiner joiner = new StringJoiner("\n");
		joiner.setEmptyValue("None");
		
		// Iterate over strings and remove unnecessary stuff
		for(int count = 0; count < numberOfStrings; count++){
			String logLine = s.nextLine();
			if(logLine.contains(importantString)){
				joiner.add(logLine);
			}
		}
		s.close();
		System.out.println(joiner.toString());
	}

}
