package net.mooctest;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BinaryHeapTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test(timeout = 4000)
	public void newTest_1() {
		BinaryHeap heap = new BinaryHeap();
		assertEquals(true, heap.isEmpty());
	}
	
	@Test(timeout = 4000)
	public void newTest_2() {
		BinaryHeap heap = new BinaryHeap(10);
		assertEquals(true, heap.isEmpty());
	}
	
	@Test(timeout = 4000)
	public void insertTest_1() throws Overflow {
		BinaryHeap heap = new BinaryHeap(3);
		heap.insert(3);
		heap.insert(1);
		heap.insert(2);
		assertEquals(false, heap.isEmpty());
		assertEquals(1, heap.findMin());
	}
	
	@Test(timeout = 4000)
	public void insertTest_2() throws Overflow {
		BinaryHeap heap = new BinaryHeap(3);
		thrown.expect(Overflow.class);
		heap.insert(3);
		heap.insert(1);
		heap.insert(2);
		heap.insert(0);
		assertEquals(false, heap.isEmpty());
		assertEquals(0, heap.findMin());
	}
	
	@Test(timeout = 4000)
	public void insertTest_3() throws Overflow {		//变异7
		BinaryHeap heap = new BinaryHeap();
		heap.insert(-1);
		assertEquals(-1, heap.findMin());
	}
	
	@Test(timeout = 4000)
	public void findMinTest_1 (){
		BinaryHeap heap = new BinaryHeap();
		assertEquals(-1, heap.findMin());
	}
	
	@Test(timeout = 4000)
	public void wellFormedTest_1(){
		BinaryHeap heap = new BinaryHeap();
		assertEquals(true, heap.wellFormed());
	}
	
	@Test(timeout = 4000)
	public void wellFormedTest_2() throws Overflow{
		BinaryHeap heap = new BinaryHeap(3);
		heap.insert(3);
		heap.insert(1);
		assertEquals(true, heap.wellFormed());
	}
	
	@Test(timeout = 4000)
	public void wellFormedTest_3() throws Overflow{
		BinaryHeap heap = new BinaryHeap(3);
		heap.insert(3);
		heap.insert(1);
		heap.insert(2);
		assertEquals(true, heap.wellFormed());
	}
	
	@Test(timeout = 4000)
	public void deleteMinTest_1() throws Overflow{
		BinaryHeap heap = new BinaryHeap();
		assertEquals(-1, heap.deleteMin());
	}
	
	@Test(timeout = 4000)
	public void deleteMinTest_2() throws Overflow{
		BinaryHeap heap = new BinaryHeap();
		heap.insert(4);
		heap.insert(2);
		heap.insert(3);
		heap.insert(1);
		assertEquals(1, heap.deleteMin());
	}
	
	@Test(timeout = 4000)
	public void deleteMinTest_3() throws Overflow{
		BinaryHeap heap = new BinaryHeap(5);
		heap.insert(1);
		heap.insert(2);
		heap.insert(4);
		heap.insert(3);
		heap.insert(5);
		assertEquals(1, heap.deleteMin());
	}
	
	@Test(timeout = 4000)
	public void buildHeapTest_1() throws Overflow{
		BinaryHeap heap = new BinaryHeap();
		heap.insert(4);
		heap.insert(2);
		heap.insert(3);
		heap.insert(1);
		heap.insert(6);
		heap.insert(0);
		heap.insert(3);
		heap.buildHeap();
		assertEquals(0, heap.findMin());
	}
	
	@Test(timeout = 4000)
	public void buildHeapTest_2() throws Overflow {
		BinaryHeap heap = new BinaryHeap();
		heap.insert(4);
		heap.insert(2);
		heap.insert(3);
		heap.insert(1);
		heap.buildHeap();
		assertEquals(1, heap.findMin());
	}
	
	@Test(timeout = 4000)
	public void buildHeapTest_3() throws Overflow{
		BinaryHeap heap = new BinaryHeap();
		heap.buildHeap();
		assertEquals(-1, heap.findMin());
	}
	
	@Test(timeout = 4000)
	public void buildHeapTest_4() throws Overflow{
		BinaryHeap heap = new BinaryHeap();
		heap.insert(2);
		heap.buildHeap();
		assertEquals(2, heap.findMin());
	}
	
	@Test(timeout = 4000)
	public void makeEmptyTest_1() throws Overflow {
		BinaryHeap heap = new BinaryHeap();
		heap.insert(1);
		heap.makeEmpty();
		assertEquals(true, heap.isEmpty());
	}
	
	/**
	 * 反射解决wellFormed
	 * @throws SecurityException 
	 * @throws Exception 
	 */
	@Test(timeout = 4000)
	public void wellFormedTest_2_1() throws Exception{		//array == null
		Class<BinaryHeap> class1 = BinaryHeap.class;
		BinaryHeap heap = new BinaryHeap();
		Field field = class1.getDeclaredField("array");
		field.setAccessible(true);
		field.set(heap, null);
		assertEquals(false, heap.wellFormed());
	}
	
	@Test(timeout = 4000)
	public void wellFormedTest_2_2() throws Exception{		//currentSize < 0
		Class<BinaryHeap> class1 = BinaryHeap.class;
		BinaryHeap heap = new BinaryHeap();
		Field field = class1.getDeclaredField("currentSize");
		field.setAccessible(true);
		field.set(heap, -1);
		assertEquals(false, heap.wellFormed());
	}
	
	@Test(timeout = 4000)
	public void wellFormedTest_2_3() throws Exception{		// currentSize>=array.length
		Class<BinaryHeap> class1 = BinaryHeap.class;
		BinaryHeap heap = new BinaryHeap(4);
		Field field = class1.getDeclaredField("currentSize");
		field.setAccessible(true);
		field.set(heap, 5);
		assertEquals(false, heap.wellFormed());
	}

	@Test(timeout = 4000)
	public void wellFormedTest_2_4() throws Exception{		//i*2 <= currentSize && array[i]>array[2*i]
		Class<BinaryHeap> class1 = BinaryHeap.class;
		BinaryHeap heap = new BinaryHeap();
		Field array = class1.getDeclaredField("array");
		array.setAccessible(true);
		array.set(heap, new int[]{0, 5, 4, 3, 2, 1});
		Field currentSize = class1.getDeclaredField("currentSize");
		currentSize.setAccessible(true);
		currentSize.set(heap, 5);
		
		assertEquals(false, heap.wellFormed());
	}
	
	@Test(timeout = 4000)
	public void wellFormedTest_2_5() throws Exception{		//i*2 + 1<= currentSize && array[i]>array[2*i+1]
		Class<BinaryHeap> class1 = BinaryHeap.class;
		BinaryHeap heap = new BinaryHeap();
		Field array = class1.getDeclaredField("array");
		array.setAccessible(true);
		array.set(heap, new int[]{0, 4, 5, 3});
		Field currentSize = class1.getDeclaredField("currentSize");
		currentSize.setAccessible(true);
		currentSize.set(heap, 3);
		
		assertEquals(false, heap.wellFormed());
	}
	
	@Test(timeout = 4000)
	public void wellFormedTest_2_6() throws Exception{		//i*2 <= currentSize && array[i]>array[2*i]
		Class<BinaryHeap> class1 = BinaryHeap.class;
		BinaryHeap heap = new BinaryHeap();
		Field array = class1.getDeclaredField("array");
		array.setAccessible(true);
		array.set(heap, new int[]{0, 5, 4});
		Field currentSize = class1.getDeclaredField("currentSize");
		currentSize.setAccessible(true);
		currentSize.set(heap, 2);
		
		assertEquals(false, heap.wellFormed());
	}
	
	@Test(timeout = 4000)
	public void wellFormedTest_2_7() throws Exception{		//i*2 <= currentSize && array[i]>array[2*i]
		Class<BinaryHeap> class1 = BinaryHeap.class;
		BinaryHeap heap = new BinaryHeap();
		Field array = class1.getDeclaredField("array");
		array.setAccessible(true);
		array.set(heap, new int[]{0, 1, 1});
		Field currentSize = class1.getDeclaredField("currentSize");
		currentSize.setAccessible(true);
		currentSize.set(heap, 2);
		
		assertEquals(true, heap.wellFormed());
	}
	
	@Test(timeout = 4000)
	public void wellFormedTest_2_8() throws Exception{		//i*2 <= currentSize && array[i]>array[2*i]
		Class<BinaryHeap> class1 = BinaryHeap.class;
		BinaryHeap heap = new BinaryHeap();
		Field array = class1.getDeclaredField("array");
		array.setAccessible(true);
		array.set(heap, new int[]{0, 1, 1, 1});
		Field currentSize = class1.getDeclaredField("currentSize");
		currentSize.setAccessible(true);
		currentSize.set(heap, 3);
		
		assertEquals(true, heap.wellFormed());
	}
	
	@Test
	public void wellFormedTest_2_9() throws Exception{		//变异40
		Class<BinaryHeap> class1 = BinaryHeap.class;
		BinaryHeap heap = new BinaryHeap();
		Field array = class1.getDeclaredField("array");
		array.setAccessible(true);
		array.set(heap, new int[]{0, -2, -4});
		Field currentSize = class1.getDeclaredField("currentSize");
		currentSize.setAccessible(true);
		currentSize.set(heap, 1);
		
		assertEquals(true, heap.wellFormed());
	}
	
	@Test
	public void wellFormedTest_2_10() throws Exception{		//变异50
		Class<BinaryHeap> class1 = BinaryHeap.class;
		BinaryHeap heap = new BinaryHeap();
		Field array = class1.getDeclaredField("array");
		array.setAccessible(true);
		array.set(heap, new int[]{0, -1, -2, -2, -2});
		Field currentSize = class1.getDeclaredField("currentSize");
		currentSize.setAccessible(true);
		currentSize.set(heap, 1);
		
		assertEquals(true, heap.wellFormed());
	}
	
	@Test(timeout = 4000)
	public void deleteMinTest_4() throws Overflow{
		BinaryHeap heap = new BinaryHeap();
		heap.insert(2);
		heap.insert(3);
		heap.insert(1);
		heap.insert(4);
		heap.insert(6);
		heap.insert(5);
		assertEquals(1, heap.deleteMin());
		assertEquals(2, heap.deleteMin());
		assertEquals(3, heap.deleteMin());
	}
	
	@Test(timeout = 4000)
	public void buildHeapTest_2_1() throws Exception{		//buildHeap 变异
		Class<BinaryHeap> class1 = BinaryHeap.class;
		BinaryHeap heap = new BinaryHeap();
		Field array = class1.getDeclaredField("array");
		array.setAccessible(true);
		array.set(heap, new int[]{-2, 3, -1, 1, 5});
		Field currentSize = class1.getDeclaredField("currentSize");
		currentSize.setAccessible(true);
		currentSize.set(heap, 4);
		heap.buildHeap();
		assertEquals(-1, heap.findMin());
	}
	
	@Test(timeout = 4000)
	public void buildHeapTest_2_2() throws Exception{		//buildHeap 变异
		Class<BinaryHeap> class1 = BinaryHeap.class;
		BinaryHeap heap = new BinaryHeap();
		Field array = class1.getDeclaredField("array");
		array.setAccessible(true);
		array.set(heap, new int[]{-2, -1, 3, 5, 1});
		Field currentSize = class1.getDeclaredField("currentSize");
		currentSize.setAccessible(true);
		currentSize.set(heap, 4);
		heap.buildHeap();
		assertEquals(-1, heap.findMin());
	}
}
