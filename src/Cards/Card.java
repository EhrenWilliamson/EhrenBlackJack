package Cards;


public class Card {

		public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

		private Rank rank;
		private Suit suit;
		private int value;

		public Card(Rank r, Suit s, int value) {
			rank = r;
			suit = s;
			this.value = value;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Card [rank=");
			builder.append(rank);
			builder.append(", suit=");
			builder.append(suit);
			builder.append(", value=");
			builder.append(value);
			builder.append("]");
			return builder.toString();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((rank == null) ? 0 : rank.hashCode());
			result = prime * result + ((suit == null) ? 0 : suit.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Card other = (Card) obj;
			if (rank != other.rank)
				return false;
			if (suit != other.suit)
				return false;
			return true;

		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
}
