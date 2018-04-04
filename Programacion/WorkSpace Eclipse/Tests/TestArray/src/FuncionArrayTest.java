import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FuncionArrayTest {

	@Test
	void testReves() {
		int array1 [] = new int [10];
		int array2 [];
		
		FuncionArray teodioyeray = new FuncionArray();
		
		array1 [0] = 0;
		array1 [1] = 1;
		array1 [2] = 2;
		array1 [3] = 3;
		array1 [4] = 4;
		array1 [5] = 5;
		array1 [6] = 6;
		array1 [7] = 7;
		array1 [8] = 8;
		array1 [9] = 9;
		
		array2 = teodioyeray.arrayReves(array1);
		
		assertEquals(array1, array2, "Tonto");
	}
	
	@Test
	void test() {
		FuncionArray teodioyeray = new FuncionArray();
		
		int array1 [] = {0,1,2,3,4,5,6,7,8,9};
		int array2 [] = teodioyeray.arrayReves(array1);
		
		//assertArrayEquals(array2, array1);
		assertArrayEquals(new int[] {9,8,7,6,5,4,3,2,1,0}, array2);
	}

}
