package fr.paf.dev;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author paf
 *
 */
public class NimGame {

	private int nbNim;
//	private static final Logger LOG = Logger.getLogger(NimGame.class.getName());

	public static void main(String[] args) {
//		LOG.debug("hello");
		new NimGame(10).start("Toto");
	}

	NimGame(int nbNim) {
		this.nbNim = nbNim;
	}

	private void computerTurn() {
//		LOG.debug("Computer turn");
		System.out.println("Computer turn");

		Random random = new Random();
		int numberChose = random.nextInt(2) + 1;
//		LOG.debug("Computer chose" + numberChose);
		System.out.println("Computer chose :" + numberChose);
		this.nbNim -= numberChose;

	}

	@SuppressWarnings("resource")
	private void userTurn() {
//		LOG.debug("User turn");
		System.out.println("Your turn");
		int numberChose = -1;
		Scanner scanner = new Scanner(System.in);
		while (numberChose < 1 || numberChose > 2) {
//			LOG.debug("Please choose a number ( 1 or 2 )");

			numberChose = scanner.nextInt();
//			LOG.error(e);
		}
//		LOG.debug("You chose" + numberChose);
		this.nbNim -= numberChose;

	}

	private String start(String UserName) {

		String winnerName = UserName;
		boolean isUserTurn = false;
		System.out.println("Starting game");

		while (nbNim > 0) {
			isUserTurn = !isUserTurn;

			System.out.println("Nb : " + this.nbNim);

			if (isUserTurn)
				userTurn();
			else
				computerTurn();

		}
		if (isUserTurn) {
			winnerName = "Computer";
		}

		System.out.println("and the winner is " + winnerName);
		return winnerName;

	}
}
