Ehren's Read Me


This is a basic game of blackjack. The dealer always treats An Ace as an 11 unless he goes over 21.
The player will use the Ace as an 11 unless he/she goes over 21.

There are 9 classes
Player
Dealer
Hand
Card
Deck 
Rank
suit
Game
Blackjack

Rank is an enum which has every rank of cards.
Suit is an enum which has every suit of cards.
Card has a rank, suit, and value.
Deck has a List of 52 cards with every suit, rank, and value represented as a deck of cards.
Hand has a List of cards but is empty.
Player has a hand of cards which is empty at start.
Dealer has a hand, the dealer can draw cards and shuffle the deck.
Game has all of the game logic. It allows the Ace to be a 1 or 11, it allows the player to hit or stay. It has a bust checker to see if the player lost. 
BlackJack is where main is and starts a new game.
