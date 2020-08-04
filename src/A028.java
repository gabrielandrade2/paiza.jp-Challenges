// A028:武器の強化
// Weapon enhancement
// Author: Gabriel Andrade

import java.util.Scanner;

public class A028 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double strengh = s.nextInt();
		double upgradePoints = s.nextInt();
		s.close();
		while(upgradePoints > 0){
			// Search for best upgrade path
			int pointsToUse;
			for(pointsToUse = 1; pointsToUse <= upgradePoints; pointsToUse++){
				if(strengh < upgrade(strengh, pointsToUse))
					break;
			}
			// Execute upgrade
			strengh = upgrade(strengh, pointsToUse);
			upgradePoints -= pointsToUse;
		}
		System.out.println(String.format("%.0f", strengh));
	}

	public static double upgrade(double initialStrengh, double upgradePoints){
		return Math.floor(initialStrengh * (100 + upgradePoints) / 100);
	}
}
