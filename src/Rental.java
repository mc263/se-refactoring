class Rental {
	private Movie movie;
	private int daysRented;

	/**
	 * 
	 * @param movie
	 *            variable of type Movie
	 * @param daysRented
	 *            count of rented days
	 */

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	int getFrequentRenterPoints() {
		return movie.getFrequentRenterPoints(daysRented);
	}

	double getCharge() {
		return movie.getCharge(daysRented);
	}
}