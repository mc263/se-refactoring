
import java.util.Enumeration;
import java.util.Vector;

class Customer { // represents customer of the store

	private String name;
	private Vector<Rental> rentals = new Vector<Rental>();

	/**
	 * 
	 * @param name
	 *            name of customer
	 * @param rentals
	 *            vector of all rentals from customer
	 */

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.addElement(rental);
	}

	public String getName() {
		return name;
	}

	public Vector<Rental> getRentals() {
		return rentals;
	}

	/**
	 * 
	 * @return Returns String of rental information for customer (includes: customer
	 *         name; title, rented days and amount of the movie; total charge and
	 *         total frequent renter points)
	 */
	public String getCustomerResultString() {
		Enumeration<Rental> enum_rentals = rentals.elements();

		// Result string with name of customer
		String result = "Rental Record for " + this.getName() + "\n";
		result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

		while (enum_rentals.hasMoreElements()) {
			Rental each = enum_rentals.nextElement();
			// add corresponding values for movies of this rental (title, days and amount)
			result += "\t" + each.getMovie().getTitle() + "\t" + "\t" + each.getDaysRented() + "\t"
					+ String.valueOf(each.getCharge()) + "\n";
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
		return result;
	}

	public String getCustomerResultHtml() {
		Enumeration<Rental> enum_rentals = this.rentals.elements();
		// Result string with name of customer
		String result = "<H1>Rentals for <EM>" + getName() + "</EM></H!><P>\n";
		while (enum_rentals.hasMoreElements()) {
			Rental each = enum_rentals.nextElement();
			// add movies with title and amount
			result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
		}
		// add paragraph with total charge and earned points
		result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
		result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints())
				+ "</EM> frequent renter points<P>";
		return result;
	}

	private int getTotalFrequentRenterPoints() {
		int result = 0;
		Enumeration<Rental> rentals = this.rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();
			result += each.getFrequentRenterPoints();
		}
		return result;
	}

	private double getTotalCharge() {
		double result = 0;
		Enumeration<Rental> rentals = this.rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}

}
