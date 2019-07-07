package net.mooctest;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.Random;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;
import org.junit.validator.PublicClassValidator;


public class BinaryHeapTest {

	
	@Test
	public void test() {
		BinaryHeap binaryheap=new BinaryHeap();
		assertEquals(-1,binaryheap.findMin());
	}

	
	@Test
	public void test2() throws Overflow{
		BinaryHeap binaryheap=new BinaryHeap(20);	
        binaryheap.insert(3);
        binaryheap.insert(5);
        binaryheap.insert(1);
        binaryheap.insert(2);
        binaryheap.insert(6);
        assertEquals(1,binaryheap.findMin());
	}
	
	@Test
	public void test2_2() throws Overflow{
		BinaryHeap binaryheap=new BinaryHeap(20);	
        binaryheap.insert(3);
        binaryheap.insert(5);
        binaryheap.insert(7);
        binaryheap.insert(1);
        binaryheap.insert(2);
        binaryheap.insert(6);
        assertEquals(1,binaryheap.findMin());
	}
	
    @Rule
    public ExpectedException thrown=ExpectedException.none();
    
  
    @Test()
	public void test3() throws Overflow{
		thrown.expect(Overflow.class);
		BinaryHeap binaryheap=new BinaryHeap(2);
		binaryheap.insert(1);
		binaryheap.insert(1);
		binaryheap.insert(1);

	}

	
	@Test
	public void test4(){
		BinaryHeap binaryheap=new BinaryHeap(2);
		try {
			binaryheap.insert(1);
		} catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    @Test 
    public void test5_1() throws Overflow{
        BinaryHeap binaryheap=new BinaryHeap();
        binaryheap.makeEmpty();
        boolean result=binaryheap.wellFormed();
        assertEquals(true,result);
    }
    

    
    @Test
    public void test5_7() throws Overflow{
        BinaryHeap binaryheap=new BinaryHeap(2);
        binaryheap.insert(1);
        assertEquals(true,binaryheap.wellFormed());
    }
    
    @Test
    public void test5_8() throws Overflow{
    	BinaryHeap binaryHeap=new BinaryHeap(5);
    	binaryHeap.insert(3);
    	binaryHeap.insert(1);
    	binaryHeap.insert(2);
    	
    	boolean result=binaryHeap.wellFormed();
    	assertEquals(true, result);
    }
    
    @Test
    public void test6_1(){
        BinaryHeap binaryheap=new BinaryHeap(2);
        assertEquals(-1,binaryheap.deleteMin());

    }
    
    @Test 
    public void test6_2() throws Overflow{
        BinaryHeap binaryheap=new BinaryHeap(2);
        binaryheap.insert(1);
        int result=binaryheap.deleteMin();
        assertEquals(1,result);
    }
    
    @Test
    public void test7(){
        BinaryHeap binaryheap=new BinaryHeap(2);
        assertEquals(true,binaryheap.isEmpty());
    }
    
    
    @Test
    public void test8() throws Overflow{
        BinaryHeap binaryheap=new BinaryHeap(2);
        binaryheap.insert(1);
        binaryheap.insert(2);
        assertEquals(true,binaryheap.isFull());
    }
    
    @Test
    public void test9() throws Overflow{
    	BinaryHeap binaryHeap=new BinaryHeap(3);
    	binaryHeap.insert(1);
    	binaryHeap.insert(3);
    	binaryHeap.insert(2);
    	binaryHeap.makeEmpty();
    	binaryHeap.insert(5);
    	binaryHeap.insert(3);
    	binaryHeap.buildHeap();
    	
    }
    
    @Test
    public void test10() throws Overflow{
    	BinaryHeap binaryHeap=new BinaryHeap(100);
    	binaryHeap.insert(1);
		binaryHeap.insert(5);
		binaryHeap.insert(2);
		binaryHeap.insert(10);



    	binaryHeap.deleteMin();

    	
    	assertEquals(2, binaryHeap.findMin());
    	
    }
    
    
    @Test
    public void test11() throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException{
    	BinaryHeap binaryHeap=new BinaryHeap();
    	Class class1=binaryHeap.getClass();
    	Field f=class1.getDeclaredField("array");
    	f.setAccessible(true);
    	f.set(binaryHeap, null);
    	assertEquals(false,binaryHeap.wellFormed());

    }
    
    @Test
    public void test12() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
    	BinaryHeap binaryHeap=new BinaryHeap();
    	Class class1=binaryHeap.getClass();
    	Field f2=class1.getDeclaredField("currentSize");
    	f2.setAccessible(true);
    	f2.set(binaryHeap,-1);
    	assertEquals(false, binaryHeap.wellFormed());
    }
    
    @Test
    public void test13() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
    	BinaryHeap binaryHeap=new BinaryHeap();
    	Class class1=binaryHeap.getClass();
    	Field f2=class1.getDeclaredField("currentSize");
    	f2.setAccessible(true);
    	f2.set(binaryHeap,101);
    	assertEquals(false, binaryHeap.wellFormed());
    }
    
    @Test
    public void test14() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, Overflow{
    	BinaryHeap binaryHeap=new BinaryHeap(2);
    	Class class1=binaryHeap.getClass();
    	Field f2=class1.getDeclaredField("array");
    	f2.setAccessible(true);
    	int[] array2=new int[]{2,0,0};
    	f2.set(binaryHeap,array2);
    	binaryHeap.insert(1);
    	assertEquals(1, binaryHeap.findMin());
    }
    
    @Test
    public void test15() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
    	BinaryHeap binaryHeap=new BinaryHeap(2);
    	Class class1=binaryHeap.getClass();
    	Field f2=class1.getDeclaredField("array");
    	Field f3=class1.getDeclaredField("currentSize");

    	int[] array2=new int[]{0,10,2};
    	f2.setAccessible(true);
    	f3.setAccessible(true);
    	f2.set(binaryHeap,array2);
    	f3.set(binaryHeap, 2);
    	assertEquals(false, binaryHeap.wellFormed());
    }
    
    @Test
    public void test16() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
    	BinaryHeap binaryHeap=new BinaryHeap(3);
    	Class class1=binaryHeap.getClass();
    	Field f2=class1.getDeclaredField("array");
    	Field f3=class1.getDeclaredField("currentSize");

    	int[] array2=new int[]{0,10,11,2};
    	f2.setAccessible(true);
    	f3.setAccessible(true);
    	f2.set(binaryHeap,array2);
    	f3.set(binaryHeap, 3);
    	assertEquals(false, binaryHeap.wellFormed());

    }
    
    @Test
    public void test17() throws Overflow{
    	BinaryHeap binaryHeap=new BinaryHeap(3);
    	binaryHeap.insert(1);
    	binaryHeap.insert(1);
    	binaryHeap.insert(1);
    	
    	assertEquals(true, binaryHeap.wellFormed());
    }
    
    @Test
    public void test18() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
    	BinaryHeap binaryHeap=new BinaryHeap(3);
    	Class class1=binaryHeap.getClass();
    	Field f2=class1.getDeclaredField("array");
    	Field f3=class1.getDeclaredField("currentSize");

    	int[] array2=new int[]{0,10,11,2};
    	f2.setAccessible(true);
    	f3.setAccessible(true);
    	f2.set(binaryHeap,array2);
    	f3.set(binaryHeap, 2);
    	assertEquals(true, binaryHeap.wellFormed());

    }
    
    @Test(timeout=4000)
    public void test19() throws Overflow{
    	BinaryHeap binaryHeap=new BinaryHeap(3);
    	binaryHeap.insert(1);
    	binaryHeap.insert(2);
    	binaryHeap.insert(3);
    	binaryHeap.deleteMin();
    	assertEquals(2, binaryHeap.findMin());
    }
    
    @Test(timeout=4000)
    public void test20() throws Overflow{
    	BinaryHeap binaryHeap=new BinaryHeap(2);
    	binaryHeap.insert(-2);
    	binaryHeap.insert(-1);
    	binaryHeap.buildHeap();
    	assertEquals(-2, binaryHeap.findMin());
    }
    
    @Test(timeout=4000)
    public void test21() throws Overflow{
    	BinaryHeap binaryHeap=new BinaryHeap(1);
    	binaryHeap.insert(-1);
    	binaryHeap.buildHeap();
    	assertEquals(-1, binaryHeap.findMin());
    }
    
    @Test(timeout=4000)
    public void test22() throws Overflow, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
    	BinaryHeap binaryHeap=new BinaryHeap(3);
    	Class c=binaryHeap.getClass();
    	Field f=c.getDeclaredField("array");
    	Field f2=c.getDeclaredField("currentSize");
    	int[] array2=new int[]{0,3,2,1};
    	f.setAccessible(true);
    	f.set(binaryHeap,array2);
    	f2.setAccessible(true);
    	f2.set(binaryHeap, 3);
    	binaryHeap.buildHeap();
    	assertEquals(1, binaryHeap.findMin());
    	
    	
    }
    
    @Test(timeout=4000)
    public void test23() throws Overflow, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
    	BinaryHeap binaryHeap=new BinaryHeap(2);
    	Class c=binaryHeap.getClass();
    	Field f=c.getDeclaredField("array");
    	Field f2=c.getDeclaredField("currentSize");
    	int[] array2=new int[]{0,2,1};
    	f.setAccessible(true);
    	f.set(binaryHeap,array2);
    	f2.setAccessible(true);
    	f2.set(binaryHeap, 2);
    	binaryHeap.buildHeap();
    	assertEquals(1, binaryHeap.findMin());
    	
    }
    
    
    @Test(timeout=4000)
    public void test24() throws Overflow, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
    	BinaryHeap binaryHeap=new BinaryHeap(3);
    	Class c=binaryHeap.getClass();
    	Field f=c.getDeclaredField("array");
    	Field f2=c.getDeclaredField("currentSize");
    	int[] array2=new int[]{0,4,3,2};
    	f.setAccessible(true);
    	f.set(binaryHeap,array2);
    	f2.setAccessible(true);
    	f2.set(binaryHeap, 3);
    	binaryHeap.buildHeap();
    	assertEquals(2, binaryHeap.findMin());
    	
    }
    
    @Test(timeout=4000)
    public void test25() throws Overflow, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
    	BinaryHeap binaryHeap=new BinaryHeap(3);
    	binaryHeap.insert(1);
    	binaryHeap.insert(2);
    	binaryHeap.buildHeap();
    	assertEquals(1, binaryHeap.findMin());
    	
    }
    
    @Test(timeout=4000)
    public void test26() throws Overflow, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
    	BinaryHeap binaryHeap=new BinaryHeap(10);
    	binaryHeap.insert(1);
    	binaryHeap.insert(2);
    	
    	assertEquals(true, binaryHeap.wellFormed());
    	
    }
    
    @Test(timeout=4000)
    public void test27() throws Overflow, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
    	BinaryHeap binaryHeap=new BinaryHeap(10);
    	binaryHeap.insert(1);
    	binaryHeap.insert(2);
    	binaryHeap.insert(3);

    	assertEquals(true, binaryHeap.wellFormed());
    	
    }
    
}
