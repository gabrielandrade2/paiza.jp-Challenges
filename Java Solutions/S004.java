// S004:積まれた文字
// Stacked characters
// Author: Gabriel Andrade

import java.util.Scanner;

public class S004 {
	
	static int value = Integer.MAX_VALUE;

	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String A = s.nextLine();
		String B = s.nextLine();
		String S = s.nextLine();
		s.close();
		
		checkNode(new String(), 0, A, B, S);

		System.out.println(value);
		
	}
	public static void checkNode(String path, int total, String A, String B, String S){
		if(total >= value)
			return;
		// Accept (all S chars read)
		if(S.length() == 0){
			value = total;
		} else{
			
			int indexA = A.indexOf(S.charAt(0));
			int indexB = B.indexOf(S.charAt(0));
			// Check A
			if(indexA >= 0){
				checkNode(path+"A", total + indexA + 1, A.substring(indexA + 1), B, S.substring(1));
			}
			
			// Check B
			if(indexB >= 0){ 
				checkNode(path+"B", total + indexB + 1, A, B.substring(indexB + 1), S.substring(1));
			}
		}
	}
}
