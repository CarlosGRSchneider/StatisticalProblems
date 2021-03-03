package bertrandBoxParadox;

import java.text.DecimalFormat;
import java.util.Random;

public class BertrandBoxParadox {

	private static DecimalFormat df = new DecimalFormat("#.##");

	public static void main(String[] args) {

		double probabilityGold = 0;
		double probabilitySilver = 0;

		Random random = new Random();

		String[][] boxesOfCoins = { { "S", "G" }, { "S", "S" }, { "G", "G" } };

		int matches = 100000;
		while (matches > 0) {

			int drawBox = random.nextInt(3);
			int drawCoin = random.nextInt(2);
			String coinDrawn = boxesOfCoins[drawBox][drawCoin];

			while (coinDrawn.equals("S")) {
				drawBox = random.nextInt(3);
				drawCoin = random.nextInt(2);
				coinDrawn = boxesOfCoins[drawBox][drawCoin];
			}

			if (drawCoin == 1) {
				String secondCoin = boxesOfCoins[drawBox][0];
				if (secondCoin.equals("G")) {
					probabilityGold++;
				} else {
					probabilitySilver++;
				}
			} else {
				String secondCoin = boxesOfCoins[drawBox][1];
				if (secondCoin.equals("G")) {
					probabilityGold++;
				} else {
					probabilitySilver++;
				}
			}

			matches--;
		}

		System.out.println("The probability of finding a gold coin is " + df.format((probabilityGold / 100000) * 100).concat("%"));
		System.out.println("The probability of finding a silver coin is " + df.format((probabilitySilver / 100000) * 100).concat("%"));
	}

}
