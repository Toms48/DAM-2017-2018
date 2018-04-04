import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MisArraysTest {

	@Test
	void misArraystest() {
		MisArrays misArrays = new MisArrays();
		int array1 [] = new int [10];
		
		misArrays.misArrays(array1);
	}
	
	@Test
	void getArraytest() {
		MisArrays misArrays = new MisArrays();
		int array1 [] = new int [10];
		
		misArrays.misArrays(array1);
		
		assertArrayEquals(array1, misArrays.getArray());
		assertEquals(array1, misArrays.getArray());
	}
	
	@Test
	void setArraytest() {
		MisArrays misArrays = new MisArrays();
		int array1 [] = new int [5];
		int array2 [] = new int [5];
		int array3 [] = new int [5];
		
		array1 [0] = 0;
		array1 [1] = 1;
		array1 [2] = 2;
		array1 [3] = 3;
		array1 [4] = 4;
		
		array2 [0] = 4;
		array2 [1] = 3;
		array2 [2] = 2;
		array2 [3] = 1;
		array2 [4] = 0;
		
		array3 [0] = 0;
		array3 [1] = 1;
		array3 [2] = 2;
		array3 [3] = 3;
		array3 [4] = 4;
		
		assertArrayEquals(array1, array3);
		
		misArrays.setArray(array3);
		
		assertArrayEquals(array1, array3);
	}
	
	@Test
	void eliminarYSustituirtest() {
		MisArrays misArrays = new MisArrays();
		int array1 [] = new int [5];
		
		array1 [0] = 1;
		array1 [1] = 2;
		array1 [2] = 3;
		array1 [3] = 4;
		array1 [4] = 5;
		
		misArrays.setArray(array1);
		
		misArrays.eliminarYSustituirBIEN(false);
	}

}
