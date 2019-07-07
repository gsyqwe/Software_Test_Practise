package net.mooctest;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryHeapTest {
	
	private BinaryHeap b = new BinaryHeap();
	private BinaryHeap b1 = new BinaryHeap(0);

	@Test
	public void test() {
		assertEquals(b.isEmpty(),true);
		assertEquals(true,b.isEmpty());
		assertEquals(false,b.isFull());
		assertEquals(b.isFull(),false);
	}
	
	@Test
	public void test1(){
		assertEquals(b1.isEmpty(),true);
		assertEquals(true,b1.isEmpty());
		assertEquals(true,b1.isFull());
		assertEquals(b1.isFull(),true);
	}
	
	@Test(expected=Overflow.class)
	public void test2() throws Overflow{
		b1.insert(0);
	}
	
	@Test
	public void test3() throws Overflow{
		b.insert(0);
	}
	
	@Test
	public void test4() {
		assertEquals(true,b1.wellFormed());
	}
	
	@Test
	public void test5(){
		BinaryHeap b2=new BinaryHeap(-1);
		assertEquals(false,b2.wellFormed());
	}
	
	@Test
	public void test6(){
		assertEquals(-1,b1.deleteMin());
	}
	
	@Test
	public void test7(){
		try {
			b.insert(1);
			b.insert(2);
		} catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1,b.deleteMin());
	}
	
	@Test
	public void test8(){
		try {
			b.insert(1);
		} catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(false,b.isEmpty());
		b.makeEmpty();
		assertEquals(true,b.isEmpty());
	}
	
	@Test
	public void test9(){
		try {
			b.insert(1);
		} catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1,b.findMin());
	}
	
	@Test
	public void test10(){
		assertEquals(-1,b1.findMin());
	}
	
	@Test
	public void test11(){
		try {
			b.insert(1);
			b.insert(0);
		} catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(0,b.findMin());
	}
	
	@Test
	public void test12(){
		try {
			b.insert(0);
			b.insert(1);
		} catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(0,b.findMin());
		assertEquals(0,b.deleteMin());
	}
	
	@Test
	public void test13(){
		try {
			b.insert(1);
			b.insert(0);
		} catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(0,b.deleteMin());
	}
	
	@Test
	public void test14(){
		try {
			b.insert(0);
			b.insert(1);
		} catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(0,b.deleteMin());
	}
	
	@Test
	public void test15(){
		b1.buildHeap();
	}
	
	@Test
	public void test16(){
		b.buildHeap();
	}
	
	@Test
	public void test17(){
		try {
			b.insert(0);
		} catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.buildHeap();
	}
	
	@Test
	public void test18(){
		try{
			b.insert(0);
			b.insert(1);
		}catch (Overflow e){
			e.printStackTrace();
		}
		b.buildHeap();
	}
	
	@Test
	public void test19(){
		try{
			b.insert(0);
			b.insert(1);
			b.insert(2);
		}catch (Overflow e){
			e.printStackTrace();
		}
		b.buildHeap();
	}
	
	@Test
	public void test20(){
		BinaryHeap b3=new BinaryHeap(-1);
		assertEquals(true,b3.isEmpty());
		assertEquals(false,b3.isFull());
	}
	
	@Test
	public void test21(){
		BinaryHeap b3=new BinaryHeap(0);
		try {
			b3.insert(0);
		} catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true,b3.isEmpty());
		assertEquals(true,b3.wellFormed());
	}
	
	@Test
	public void test22(){
		BinaryHeap b3=new BinaryHeap(1);
		try {
			b3.insert(0);
		} catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(false,b3.isEmpty());
		assertEquals(true,b3.wellFormed());
	}
	
	@Test
	public void test23(){
		BinaryHeap b3=new BinaryHeap(1);
		try {
			b3.insert(0);
		} catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(false,b3.isEmpty());
		assertEquals(true,b3.isFull());
	}
	
	@Test
	public void test24(){
		BinaryHeap b4=new BinaryHeap(2);
		try {
			b4.insert(0);
			assertEquals(false,b4.isFull());
			b4.insert(1);
		} catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(false,b4.isEmpty());
		assertEquals(true,b4.isFull());
	}
	
	@Test
	public void test25(){
		BinaryHeap b5=new BinaryHeap(3);
		try {
			b5.insert(2);
			b5.insert(3);
			b5.insert(4);
		} catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true,b5.wellFormed());
	}
	
	@Test
	public void test26(){
		BinaryHeap b5=new BinaryHeap(4);
		try {
			b5.insert(2);
			b5.insert(3);
			b5.insert(4);
			b5.insert(0);
		} catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true,b5.wellFormed());
	}
	
	@Test
	public void test27(){
		BinaryHeap b5=new BinaryHeap(6);
		try {
			b5.insert(6);
			b5.insert(5);
			b5.insert(4);
			b5.insert(3);
			b5.insert(2);
			b5.insert(1);
		} catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true,b5.wellFormed());
	}
	
	@Test
	public void test28(){
		BinaryHeap b5=new BinaryHeap(6);
		try {
			b5.insert(6);
			b5.insert(5);
			b5.insert(4);
			b5.insert(3);
			b5.insert(2);
			b5.insert(1);
		} catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1,b5.deleteMin());
		assertEquals(true,b5.wellFormed());
	}
	
	@Test
	public void test29(){
		BinaryHeap b5=new BinaryHeap(6);
		try {
			b5.insert(100);
			b5.insert(1);
			b5.insert(1);
			b5.insert(2);
			b5.insert(2);
			b5.insert(2);
		} catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1,b5.deleteMin());
		b5.buildHeap();
		b5.makeEmpty();
		assertEquals(false,b5.isFull());
		assertEquals(true,b5.isEmpty());
		assertEquals(true,b5.wellFormed());
		try{
			b5.insert(100000);
			b5.insert(1000);
		}catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true,b5.wellFormed());
	}
	
	@Test
	public void test30(){
		BinaryHeap b5=new BinaryHeap(6);
		try {
			b5.insert(100);
			b5.insert(1);
			b5.insert(1);
			b5.insert(2);
			b5.insert(2);
			b5.insert(2);
		} catch (Overflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1,b5.deleteMin());
		assertEquals(1,b5.deleteMin());
		assertEquals(1,b5.deleteMin());
		assertEquals(2,b5.deleteMin());
	}
	
}
