package net.mooctest;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;

import org.junit.Test;

public class BinaryHeapTest {

	@Test
	public void test11() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap(5);
		binaryHeap.insert(1);
		binaryHeap.insert(2);
		binaryHeap.insert(3);
		binaryHeap.insert(4);
		assertEquals(1,binaryHeap.findMin());
	}
	
	@Test
	public void test12() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.insert(1);
		binaryHeap.insert(2);
		binaryHeap.insert(3);
		binaryHeap.insert(4);
		binaryHeap.insert(5);
		binaryHeap.insert(6);
		assertEquals(1,binaryHeap.findMin());
	}
	
	@Test
	public void test13() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.insert(6);
		binaryHeap.insert(2);
		binaryHeap.insert(9);
		binaryHeap.insert(4);
		assertEquals(2,binaryHeap.findMin());
	}
	
	@Test
	public void test14() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.insert(7);
		binaryHeap.insert(6);
		binaryHeap.insert(5);
		binaryHeap.insert(4);
		binaryHeap.insert(3);
		binaryHeap.insert(2);
		binaryHeap.insert(1);
		binaryHeap.insert(0);
		assertEquals(0,binaryHeap.findMin());
	}
	
	@Test
	public void test15() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.insert(7);
		assertEquals(7,binaryHeap.findMin());
	}
	
	@Test(expected = Overflow.class)
	public void test16() throws Overflow{
		BinaryHeap binaryHeap = new BinaryHeap(1);
		binaryHeap.insert(7);
		binaryHeap.insert(8);
	}
	
	@Test
	public void test17() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap(-1);
		assertEquals(true,binaryHeap.isEmpty());
	}
	
	@Test
	public void test18() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap(-1);
		assertEquals(false,binaryHeap.isFull());
	}
	
	@Test(expected = NegativeArraySizeException.class)
	public void test19(){
		BinaryHeap binaryHeap = new BinaryHeap(-2);
	}
	
	@Test
	public void test21() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap(5);
		binaryHeap.insert(1);
		binaryHeap.insert(2);
		binaryHeap.insert(3);
		binaryHeap.insert(4);
		binaryHeap.deleteMin();
		assertEquals(2,binaryHeap.findMin());
	}
	
	@Test
	public void test22() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.insert(1);
		binaryHeap.insert(2);
		binaryHeap.insert(3);
		binaryHeap.insert(4);
		binaryHeap.insert(5);
		binaryHeap.insert(6);
		binaryHeap.deleteMin();
		assertEquals(2,binaryHeap.findMin());
	}
	
	@Test
	public void test23() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.insert(6);
		binaryHeap.insert(2);
		binaryHeap.insert(9);
		binaryHeap.insert(4);
		binaryHeap.deleteMin();
		assertEquals(4,binaryHeap.findMin());
	}
	
	@Test
	public void test24() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.insert(7);
		binaryHeap.insert(6);
		binaryHeap.insert(5);
		binaryHeap.insert(4);
		binaryHeap.insert(3);
		binaryHeap.insert(2);
		binaryHeap.insert(1);
		binaryHeap.insert(0);
		binaryHeap.deleteMin();
		assertEquals(1,binaryHeap.findMin());
	}
	@Test
	public void test25() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.insert(7);
		binaryHeap.deleteMin();
		assertEquals(-1,binaryHeap.findMin());
	}
	
	
	@Test
	public void test31() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap(4);
		binaryHeap.insert(6);
		binaryHeap.insert(7);
		binaryHeap.insert(9);
		binaryHeap.insert(4);
		assertEquals(true,binaryHeap.isFull());
	}
	
	@Test
	public void test32() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap(4);
		binaryHeap.insert(6);
		binaryHeap.insert(7);
		binaryHeap.insert(9);
		assertEquals(false,binaryHeap.isFull());
	}
	
	@Test
	public void test33() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.insert(6);
		binaryHeap.insert(7);
		binaryHeap.insert(9);
		assertEquals(false,binaryHeap.isFull());
	}
	
	@Test
	public void test41() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap(4);
		binaryHeap.insert(1);
		binaryHeap.insert(2);
		binaryHeap.insert(3);
		binaryHeap.makeEmpty();
		assertEquals(true,binaryHeap.isEmpty());
	}
	
	@Test
	public void test42() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap(4);
		assertEquals(true,binaryHeap.isEmpty());
	}
	
	@Test
	public void test43() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap(4);
		binaryHeap.insert(1);
		binaryHeap.insert(2);
		binaryHeap.insert(3);
		assertEquals(false,binaryHeap.isEmpty());
	}
	
	@Test
	public void test51() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap(4);
		binaryHeap.insert(6);
		binaryHeap.insert(7);
		binaryHeap.insert(9);
		binaryHeap.insert(4);
		assertEquals(4,binaryHeap.deleteMin());
	}
	
	@Test
	public void test52() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap(4);
		binaryHeap.insert(1);
		binaryHeap.insert(2);
		binaryHeap.insert(3);
		binaryHeap.insert(4);
		assertEquals(1,binaryHeap.deleteMin());
	}
	
	@Test
	public void test53() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.insert(1000);
		binaryHeap.insert(200);
		binaryHeap.insert(30);
		binaryHeap.insert(4);
		assertEquals(4,binaryHeap.deleteMin());
	}
	
	@Test
	public void test54() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap();
		assertEquals(-1,binaryHeap.deleteMin());
	}
	
	@Test
	public void test61() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap(5);
		binaryHeap.insert(1);
		binaryHeap.insert(2);
		binaryHeap.insert(3);
		binaryHeap.insert(4);
		binaryHeap.buildHeap();
		assertEquals(true,binaryHeap.wellFormed());
	}
	
	@Test
	public void test62() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.insert(1);
		binaryHeap.insert(2);
		binaryHeap.insert(3);
		binaryHeap.insert(4);
		binaryHeap.insert(5);
		binaryHeap.insert(6);
		binaryHeap.buildHeap();
		assertEquals(true,binaryHeap.wellFormed());
	}
	
	@Test
	public void test63() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.insert(-6);
		binaryHeap.insert(2);
		binaryHeap.insert(-9);
		binaryHeap.insert(4);
		binaryHeap.buildHeap();
		assertEquals(true,binaryHeap.wellFormed());
	}
	
	@Test
	public void test64() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.insert(7);
		binaryHeap.insert(6);
		binaryHeap.insert(5);
		binaryHeap.insert(4);
		binaryHeap.insert(3);
		binaryHeap.insert(2);
		binaryHeap.insert(1);
		binaryHeap.insert(0);
		binaryHeap.buildHeap();
		assertEquals(true,binaryHeap.wellFormed());
	}
	
	@Test
	public void test65() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.insert(7);
		binaryHeap.buildHeap();
		assertEquals(true,binaryHeap.wellFormed());
	}
	
	@Test
	public void test66() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap(-1);
		assertEquals(false,binaryHeap.wellFormed());
	}
	
	@Test(expected = OutOfMemoryError.class)
	public void test67() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap(Integer.MAX_VALUE/2-1);
	}
    
	@Test
	public void test_m26() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap(0);
		assertEquals(true,binaryHeap.wellFormed());
	}
	
	@Test
	public void test_m38() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.insert(1);
		binaryHeap.insert(1);
		binaryHeap.insert(1);
		binaryHeap.insert(1);
		assertEquals(true,binaryHeap.wellFormed());
	}
	
	@Test
	public void test_m51() throws Overflow {
		BinaryHeap binaryHeap = new BinaryHeap(2);
		binaryHeap.insert(1);
		binaryHeap.insert(2);
		assertEquals(true,binaryHeap.wellFormed());
	}
	
	@Test
	public void test_reflect1() throws Overflow, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		BinaryHeap c1=BinaryHeap.class.newInstance();//创建对象后应赋值给另一个对象 
	    Field [] fields=BinaryHeap.class.getDeclaredFields();
	    fields[2].setAccessible(true);
	    //System.out.println(fields[2].getName());
	    fields[2].set(c1, null);//第一个参数为:被创建的对象，二：要修改的值
	    //System.out.println(fields[0].get(c1));
		assertEquals(false,c1.wellFormed());
	}
	
	@Test
	public void test_reflect2() throws Overflow, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		BinaryHeap c1=BinaryHeap.class.newInstance();//创建对象后应赋值给另一个对象 
	    Field [] fields=BinaryHeap.class.getDeclaredFields();
	    fields[1].setAccessible(true);
	    fields[1].set(c1, -1);
		assertEquals(false,c1.wellFormed());
	}
	
	@Test
	public void test_reflect3() throws Overflow, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		BinaryHeap c1=BinaryHeap.class.newInstance();//创建对象后应赋值给另一个对象 
	    Field [] fields=BinaryHeap.class.getDeclaredFields();
	    fields[1].setAccessible(true);
	    fields[1].set(c1, 3);
	    fields[2].setAccessible(true);
	    int[] array = {0,10,4,5};
	    fields[2].set(c1, array);//第一个参数为:被创建的对象，二：要修改的值
		assertEquals(false,c1.wellFormed());
	}
	
	@Test
	public void test_reflect4() throws Overflow, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		BinaryHeap c1=BinaryHeap.class.newInstance();//创建对象后应赋值给另一个对象 
	    Field [] fields=BinaryHeap.class.getDeclaredFields();
	    fields[1].setAccessible(true);
	    fields[1].set(c1, 3);
	    fields[2].setAccessible(true);
	    int[] array = {0,10,11,5};
	    fields[2].set(c1, array);//第一个参数为:被创建的对象，二：要修改的值
		assertEquals(false,c1.wellFormed());
	}
	
	@Test
	public void test_reflect5() throws Overflow, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		BinaryHeap c1=BinaryHeap.class.newInstance();//创建对象后应赋值给另一个对象 
	    Field [] fields=BinaryHeap.class.getDeclaredFields();
	    fields[1].setAccessible(true);
	    fields[1].set(c1, 3);
	    fields[2].setAccessible(true);
	    int[] array = {0,10,11,5,1,2,0};
	    fields[2].set(c1, array);//第一个参数为:被创建的对象，二：要修改的值
	    c1.buildHeap();
		assertEquals(true,c1.wellFormed());
	}
	
	@Test
	public void test_m8() throws Overflow{
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.insert(-1);
		assertEquals(-1,binaryHeap.findMin());
	}
	// m33 ?
	@Test
	public void test_m37() throws Overflow, ClassNotFoundException, InstantiationException, IllegalAccessException {
		BinaryHeap c1=BinaryHeap.class.newInstance();//创建对象后应赋值给另一个对象 
	    Field [] fields=BinaryHeap.class.getDeclaredFields();
	    fields[1].setAccessible(true);
	    fields[1].set(c1, 4);
	    fields[2].setAccessible(true);
	    int[] array = {0,1,2,3,0};
	    fields[2].set(c1, array);//第一个参数为:被创建的对象，二：要修改的值
		assertEquals(false,c1.wellFormed());
	}
	
	@Test
	public void test_m69() throws Overflow, ClassNotFoundException, InstantiationException, IllegalAccessException {
		BinaryHeap c1=BinaryHeap.class.newInstance();//创建对象后应赋值给另一个对象 
	    Field [] fields=BinaryHeap.class.getDeclaredFields();
	    fields[1].setAccessible(true);
	    fields[1].set(c1, 4);
	    fields[2].setAccessible(true);
	    int[] array = {5,1,2,3,0};
	    fields[2].set(c1, array);//第一个参数为:被创建的对象，二：要修改的值
	    c1.buildHeap();
		assertEquals(0,c1.findMin());
	}
	
	@Test
	public void test_m83() throws Overflow, ClassNotFoundException, InstantiationException, IllegalAccessException {
		BinaryHeap c1=BinaryHeap.class.newInstance();//创建对象后应赋值给另一个对象 
	    Field [] fields=BinaryHeap.class.getDeclaredFields();
	    fields[1].setAccessible(true);
	    fields[1].set(c1, 2);
	    fields[2].setAccessible(true);
	    int[] array = {0,1,0};
	    fields[2].set(c1, array);//第一个参数为:被创建的对象，二：要修改的值
	    c1.buildHeap();
		assertEquals(true,c1.wellFormed());
	}
	
	@Test(timeout = 4000)
	public void test_m87() throws Overflow, ClassNotFoundException, InstantiationException, IllegalAccessException {
		BinaryHeap c1=BinaryHeap.class.newInstance();//创建对象后应赋值给另一个对象 
	    Field [] fields=BinaryHeap.class.getDeclaredFields();
	    fields[1].setAccessible(true);
	    fields[1].set(c1, 4);
	    fields[2].setAccessible(true);
	    int[] array = {0,1,2,3,4};
	    fields[2].set(c1, array);//第一个参数为:被创建的对象，二：要修改的值
	    c1.buildHeap();
		assertEquals(true,c1.wellFormed());
	}
	//m_90 ?
	@Test
	public void test_m90() throws Overflow, ClassNotFoundException, InstantiationException, IllegalAccessException {
		BinaryHeap c1=BinaryHeap.class.newInstance();//创建对象后应赋值给另一个对象 
	    Field [] fields=BinaryHeap.class.getDeclaredFields();
	    fields[1].setAccessible(true);
	    fields[1].set(c1, 3);
	    fields[2].setAccessible(true);
	    int[] array = {0,4,3,2};
	    fields[2].set(c1, array);//第一个参数为:被创建的对象，二：要修改的值
	    c1.buildHeap();
		assertEquals(2,c1.findMin());
	}
	//m_96 ?
}

