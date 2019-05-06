import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

	Customer customer = new Customer("kai");

	@Test
	public void testAddRental() {
		Rental rental = new Rental(new Movie("beverly hills cop", 20), 2);
		customer.addRental(rental);

		Vector<Rental> vector = customer.getRentals();

		Assert.assertEquals(rental, vector.get(0));
	}

	@Test
	public void negativeTestAddRental() {
		Rental rental = new Rental(new Movie("beverly hills cop", 20), 2);
		customer.addRental(rental);

		Rental rental2 = new Rental(new Movie("saw2", 20), 2);
		customer.addRental(rental2);

		Vector<Rental> vector = customer.getRentals();

		Assert.assertNotEquals(rental2, vector.get(0));
	}

	@Test
	public void testGetName() {
		Assert.assertEquals("kai", customer.getName());
	}

	@Test
	public void testGetRentals() {

		Rental rental = new Rental(new Movie("beverly hills cop", 20), 2);
		customer.addRental(rental);

		Vector<Rental> vector = customer.getRentals();

		Assert.assertEquals(vector, customer.getRentals());

	}

	@Test
	public void testStatement() throws Exception {
		Movie m1 = new Movie("movie1", 1);
		Movie m2 = new Movie("movie2", 2);
		Rental r1 = new Rental(m1, 10);
		Rental r2 = new Rental(m2, 5);
		customer.addRental(r1);
		customer.addRental(r2);
		String result = customer.statement();
		Assert.assertEquals(
				"Rental Record for kai\n" + "\tTitle\t\tDays\tAmount\n" + "\tmovie1\t\t10\t30.0\n"
						+ "\tmovie2\t\t5\t4.5\n" + "Amount owed is 34.5\n" + "You earned 3 frequent renter points",
				result);
	}

}
