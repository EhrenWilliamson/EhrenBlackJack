package Cards;

import java.util.*;

public class Game {
	public void start() {
		Game game = new Game();
		Dealer dealer = new Dealer();
		dealer.getGameDeck();
		System.out.println("The dealer is shuffling the deck");
		dealer.shuffle();
		System.out.println("The dealer is drawing cards from the deck");

		dealer.draw();
		dealer.draw();
		dealer.draw();
		dealer.draw();

		Player player = new Player();
		player.getPlayerHand().addCard(dealer.draw());
		dealer.getDealerHand().addCard(dealer.draw());
		for (Card c : dealer.getDealerHand().getHand()) {
			System.out.println("The Dealer is showing a " + c);
			System.out.println();
		}
		player.getPlayerHand().addCard(dealer.draw());
		dealer.getDealerHand().addCard(dealer.draw());

		for (Card c : player.getPlayerHand().getHand()) {
			System.out.println("You have" + c);
		}

		if (game.blackJackCheck(player, dealer, game) == false) {
			game.hit_Or_Stay(player, dealer, game);
			/// checks for blackjack

			if (game.totalOfPlayerHand(player) <= 21) {

				game.dealerTurn(dealer, game); // Dealer's turen
			}

			if (game.totalOfPlayerHand(player) <= 21 && game.totalOfDealerHand(dealer) <= 21) {
				if (game.totalOfPlayerHand(player) > game.totalOfDealerHand(dealer)) {
					System.out.println("Player wins");
				} else if (game.totalOfPlayerHand(player) == game.totalOfDealerHand(dealer)) {
					System.out.println("Sorry, it's a tie ");
				} else {
					System.out.println("Dealer Wins");
				}
			}
		}
	}

	public void hit_Or_Stay(Player player, Dealer dealer, Game game) {
		Scanner input = new Scanner(System.in);
		System.out.println("Would you like to hit or stay? Please type hit or stay");
		String answer = input.next();
		while (answer.equals("hit")) {
			player.getPlayerHand().addCard(dealer.draw());
			for (Card c : player.getPlayerHand().getHand()) {
				System.out.println("The player hand is " + c);

			}
			System.out.println("You have a total of");
			System.out.println(game.totalOfPlayerHand(player));
			if (game.totalOfPlayerHand(player) == 21) {
				System.out.println("Good luck");
				break;
			}
			if (game.bustCheck(player, game) == true) {
				break;
			}
			System.out.println("Would you like to hit or stay? Please type hit or stay");
			answer = input.next();
		}

		if (answer.equals("stay")) {
			System.out.println("Good luck");

		}
	}

	public int totalOfPlayerHand(Player p) {
		int total = 0;
		for (Card c : p.getPlayerHand().getHand()) {
			total = total + c.getValue();
//			if (c.getRank().equals("ACE")  && total > 21) {
//				total = total - 10;
//			}
//		}
		for (Card d : p.getPlayerHand().getHand()) 
			if (d.getRank().ordinal() == Rank.ACE.ordinal()  && total > 21) {
				total = total - 10;
			}
		
	}
		return total;
	}

	public int totalOfDealerHand(Dealer dealer) {
		int total = 0;
		for (Card c : dealer.getDealerHand().getHand()) {
			total = total + c.getValue();
		}
		for (Card d : dealer.getDealerHand().getHand()) 
			if (d.getRank().ordinal() == Rank.ACE.ordinal()  && total > 21) {
				total = total - 10;
			}
		

		return total;
	}

	public boolean blackJackCheck(Player player, Dealer dealer, Game game) {
		
		totalOfPlayerHand(player);
		totalOfDealerHand(dealer);
		if (totalOfPlayerHand(player) == 21) {
			System.out.println("Player has blackjack, You win.");
			return true;
		} else if (totalOfDealerHand(dealer) == 21) {
			System.out.println("Dealer has blackjack, You lose.");
			return true;
		} else {
			System.out.println("You have a total of");
			System.out.println(game.totalOfPlayerHand(player));
		}
		return false;
	}

	public boolean bustCheck(Player player, Game game) {
		if (totalOfPlayerHand(player) > 21) {
			System.out.println("You have busted and lose");
			return true;
		}
		return false;
	}

	public void dealerTurn(Dealer dealer, Game game) {
		for (Card c : dealer.getDealerHand().getHand()) {
			System.out.println("The Dealer has " + c);
		}
		while (totalOfDealerHand(dealer) < 17) {
			System.out.println("The dealer will draw a card");
			dealer.getDealerHand().addCard(dealer.draw());
			for (Card c : dealer.getDealerHand().getHand()) {
				System.out.println("The Dealer has " + c);
				// System.out.println(game.totalOfDealerHand(dealer));
			}
			System.out.println("The dealer has a total of " + game.totalOfDealerHand(dealer));

		}
		if (totalOfDealerHand(dealer) > 21) {
			System.out.println("Dealer has busted, You Win");
		}
	}
}