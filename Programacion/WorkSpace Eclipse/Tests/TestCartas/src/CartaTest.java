import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CartaTest {

	@Test
	void testGetPalo() {
		Carta carta1 = new Carta(1, 12);
		
		assertEquals(1, carta1.getPalo(), "Mal, como todo lo que haces en la vida");
	}

	@Test
	void testGetNumero() {
		Carta carta1 = new Carta(1, 12);
		
		assertEquals(12, carta1.getNumero(), "Mal, como todo lo que haces en la vida");
	}

}
