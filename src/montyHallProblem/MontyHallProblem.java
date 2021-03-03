package montyHallProblem;

import java.text.DecimalFormat;
import java.util.Random;

public class MontyHallProblem {
	
	private static DecimalFormat df = new DecimalFormat("#.##");
	
	public static void main(String[] args) {
		
		double stayWithDoor = 0;
		double switchDoor = 0;
		
		Random random = new Random();
		
		int round = 100000;
		while(round > 0) {
			
			int[] doors = {0, 0, 0};
			doors[random.nextInt(3)] = 1;

			int chosenDoor = random.nextInt(3);
			int doorOpenedByHost = random.nextInt(3);
		
			while( doorOpenedByHost == chosenDoor || doors[doorOpenedByHost] == 1) {
				doorOpenedByHost = random.nextInt(3);
			}
			
			stayWithDoor += doors[chosenDoor];
			switchDoor +=doors[3 - doorOpenedByHost - chosenDoor];

			round--;
		}
	
		System.out.println("Win rate by staying with the chosen door: " + df.format((stayWithDoor/100000) * 100).concat("%"));
		System.out.println("Win rate by switching doors: " + df.format((switchDoor/100000) * 100).concat("%"));
	}

}
