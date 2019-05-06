import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

	Customer customer = new Customer("kai");

	@Test
	public void testAddRental() {
		Rental rental = new Rental(new Movie("beverly hills cop", 20), 2);
		customer.addRental(rental);

		Vector vector = customer.getRentals();

		Assert.assertEquals(rental, vector.get(0));
	}

	@Test
	public void negativeTestAddRental() {
		Rental rental = new Rental(new Movie("beverly hills cop", 20), 2);
		customer.addRental(rental);

		Rental rental2 = new Rental(new Movie("saw2", 20), 2);
		customer.addRental(rental2);

		Vector vector = customer.getRentals();

		Assert.assertNotEquals(rental2, vector.get(0));
	}

	@Test
	public void foo() {
		int a = 1;
		int b = 2;

		Assert.assertEquals(4, a + b);
	}

}
