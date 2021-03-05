package birthdayProblem;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BirthdayProblem {

	private static DecimalFormat df = new DecimalFormat("#.##");

	public static void main(String[] args) {

			double sameBirthday = 0;

			int match = 100000;

			while (match > 0) {

				List<Integer> birthdayList = new ArrayList<>();
			
				for (int i = 0; i < 23; i++) {
					Random birthday = new Random();
					birthdayList.add(birthday.nextInt(366));
				
				}
				
				Set<Integer> birthdaySet = new HashSet<Integer>(birthdayList);
				
				if (birthdaySet.size() < birthdayList.size()) {
					sameBirthday ++;
				} 
				
				match --;
			}
			
			double result = sameBirthday/100000;
			
			System.out.println("The percentage of at least two people sharing the same birthday among 23 people is: " + df.format(result * 100) + "%");
		
	}

}
