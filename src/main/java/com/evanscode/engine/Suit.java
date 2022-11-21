//Package
package com.evanscode.engine;

//ENUM for a Card SUIT
//4 Distinct Suits
public enum Suit {
	Hearts {
		@Override
		public String getSuit() {
			return "Hearts";
		}

		@Override
		public boolean isRed() {
			return true;
		}

		@Override
		public boolean isBlack() {
			return false;
		}
	},
	Spades {
		@Override
		public String getSuit() {
			return "Spades";
		}

		@Override
		public boolean isRed() {
			return false;
		}

		@Override
		public boolean isBlack() {
			return true;
		}
	},
	Diamonds {
		@Override
		public String getSuit() {
			return "Diamonds";
		}

		@Override
		public boolean isRed() {
			return true;
		}

		@Override
		public boolean isBlack() {
			return false;
		}
	},
	Clubs {
		@Override
		public String getSuit() {
			return "Clubs";
		}

		@Override
		public boolean isRed() {
			return false;
		}

		@Override
		public boolean isBlack() {
			return true;
		}
	};

	//Abstract methods
	public abstract String getSuit();

	public abstract boolean isRed();

	public abstract boolean isBlack();
}