import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

	Customer customer = new Customer("kai");
	Rental rental = new Rental(new Movie("beverly hills cop", 2), 2);

	@Test
	public void testAddRental() {
		customer.addRental(rental);
		Vector<Rental> vector = customer.getRentals();
		Assert.assertEquals(rental, vector.get(0));
	}

	@Test
	public void testGetName() {
		Assert.assertEquals("kai", customer.getName());
	}

	@Test
	public void testGetRentals() {
		customer.addRental(rental);
		Vector<Rental> vector = customer.getRentals();
		Assert.assertEquals(vector, customer.getRentals());
	}

	@Test
	public void testGetCustomerResultString() throws Exception {
		Movie movie1 = new Movie("movie1", 1);
		Movie movie2 = new Movie("movie2", 2);
		Rental rental1 = new Rental(movie1, 10);
		Rental rental2 = new Rental(movie2, 5);
		customer.addRental(rental1);
		customer.addRental(rental2);
		String result = customer.getCustomerResultString();
		Assert.assertEquals(
				"Rental Record for kai\n" + "\tTitle\t\tDays\tAmount\n" + "\tmovie1\t\t10\t30.0\n"
						+ "\tmovie2\t\t5\t4.5\n" + "Amount owed is 34.5\n" + "You earned 3 frequent renter points",
				result);
	}

}
