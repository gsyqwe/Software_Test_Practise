package net.mooctest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;

public class NaiveBayesClassifierTest{

	
	//测试learn，待分类只有一个元素
	//包含incrementFeature，incrementCategory，
	//不包含decrementFeature，decrementCategory，
	//不含重复特征
	//结果得到最大可能分类
	@Test(timeout = 4000)
	public void test1_1() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
		//a1,a2,a3,a4
		Collection<Integer> features = new ArrayList<Integer>();
		features.add(0);
		
		Collection<Integer> features1 = new ArrayList<Integer>();
		for(int i=0;i<4;i++){
			features1.add(i);
		}
		naiveBayesClassifier.learn("category1", features1);
		
		//a1,a2,a3,a4
		Collection<Integer> features2 = new ArrayList<Integer>();
		for(int i=1;i<5;i++){
			features2.add(i);
		}
		naiveBayesClassifier.learn("category2", features2);
		
		assertEquals("category1",naiveBayesClassifier.classify(features).getCategory());
	}
	
	//测试learn，待分类只有一个元素
	//包含incrementFeature，incrementCategory，
	//设置内存为1，包含decrementFeature，decrementCategory，
	//不含重复特征
	//结果得到最大可能分类
	@Test(timeout = 4000)
	public void test1_2() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
		naiveBayesClassifier.setMemoryCapacity(1);
		
		//a1,a2,a3,a4
		Collection<Integer> features = new ArrayList<Integer>();
		features.add(0);
				
		Collection<Integer> features1 = new ArrayList<Integer>();
		for(int i=0;i<4;i++){
			features1.add(i);
		}
		naiveBayesClassifier.learn("category1", features1);
				
		//a1,a2,a3,a4
		Collection<Integer> features2 = new ArrayList<Integer>();
		for(int i=1;i<5;i++){
			features2.add(i);
		}
		naiveBayesClassifier.learn("category2", features2);
				
		assertEquals("category2",naiveBayesClassifier.classify(features).getCategory());
	}
	
	//测试learn，待分类只有一个元素
	//包含incrementFeature，incrementCategory，
	//设置内存为1，包含decrementFeature，decrementCategory
	//结果得到最大可能Classification
	@Test(timeout = 4000)
	public void test1_3() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
		naiveBayesClassifier.setMemoryCapacity(1);
			
		//a1,a2,a3,a4
		Collection<Integer> features = new ArrayList<Integer>();
		features.add(0);
					
		Collection<Integer> features1 = new ArrayList<Integer>();
		for(int i=0;i<4;i++){
			features1.add(i);
		}
		naiveBayesClassifier.learn("category1", features1);
					
		//a1,a2,a3,a4
		Collection<Integer> features2 = new ArrayList<Integer>();
		for(int i=1;i<5;i++){
			features2.add(i);
		}
		naiveBayesClassifier.learn("category2", features2);
			
		Collection<Classification<Integer,String>> c = naiveBayesClassifier.classifyDetailed(features);
		assertEquals(1,c.size());
	}
	
	//测试learn，待分类有多个元素
	//包含incrementFeature，incrementCategory，
	//含重复特征的分类，含无特征的分类
	//结果得到最大可能分类
	@Test(timeout = 4000)
	public void test1_4() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
			
		//a1,a2,a3,a4,a5,a6
		Collection<Integer> features = new ArrayList<Integer>();
		features.add(0);
		features.add(1);
		features.add(2);
					
		Collection<Integer> features1 = new ArrayList<Integer>();
		for(int i=0;i<6;i++){
			features1.add(i%3);
		}
		naiveBayesClassifier.learn("category1", features1);
					
		//a1,a2,a3,a4,a5,a6,a7,a8
		Collection<Integer> features2 = new ArrayList<Integer>();
		for(int i=0;i<8;i++){
			features2.add(i%6);
		}
		naiveBayesClassifier.learn("category2", features2);
		
		naiveBayesClassifier.learn("category3", new ArrayList<>());
					
		assertEquals("category1",naiveBayesClassifier.classify(features).getCategory());
	}
	
	//测试learn，待分类有多个元素
	//包含incrementFeature，incrementCategory，
	//含重复分类
	//结果得到最大可能分类
	@Test(timeout = 4000)
	public void test1_5() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
				
		//a1,a2,a3,a4,a5,a6
		Collection<Integer> features = new ArrayList<Integer>();
		features.add(0);
		features.add(1);
		features.add(2);
						
		Collection<Integer> features1 = new ArrayList<Integer>();
		for(int i=0;i<6;i++){
			features1.add(i%3);
		}
		naiveBayesClassifier.learn("category1", features1);
						
		//a1,a2,a3,a4,a5,a6,a7,a8
		Collection<Integer> features2 = new ArrayList<Integer>();
		for(int i=0;i<16;i++){
			features2.add(i%16);
		}
		naiveBayesClassifier.learn("category2", features2);
			
		Collection<Integer> features3 = new ArrayList<Integer>();
		for(int i=0;i<6;i++){
			features3.add(i%4);
		}
		features3.add(4);
		naiveBayesClassifier.learn("category1", features3);
						
		assertEquals("category1",naiveBayesClassifier.classify(features).getCategory());
	}
	

	//测试learn，待分类只有一个元素
	//包含incrementFeature，incrementCategory，
	//不包含decrementFeature，decrementCategory，
	//不含重复特征，且分类的特征也不重复
	//结果得到最大可能分类
	@Test(timeout = 4000)
	public void test1_6() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
		//a1,a2,a3,a4
		Collection<Integer> features = new ArrayList<Integer>();
		features.add(0);
		features.add(1);
			
		Collection<Integer> features1 = new ArrayList<Integer>();
		for(int i=0;i<4;i++){
			features1.add(i);
		}
		naiveBayesClassifier.learn("category1", features1);
			
		//a1,a2,a3,a4
		Collection<Integer> features2 = new ArrayList<Integer>();
		for(int i=4;i<8;i++){
			features2.add(i);
		}
		naiveBayesClassifier.learn("category2", features2);
			
		assertEquals("category1",naiveBayesClassifier.classify(features).getCategory());
	}
	
	//测试learn，待分类只有一个元素
	//包含incrementFeature，incrementCategory，
	//设置内存为1，包含decrementFeature，decrementCategory
	//结果得到最大可能Classification
	@Test(timeout = 4000)
	public void test1_7() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
		naiveBayesClassifier.setMemoryCapacity(1);
				
		//a1,a2,a3,a4
		Collection<Integer> features = new ArrayList<Integer>();
		features.add(0);
						
		Collection<Integer> features1 = new ArrayList<Integer>();
		for(int i=0;i<4;i++){
			features1.add(i);
		}
		naiveBayesClassifier.learn("category1", features1);

		Collection<Integer> features3 = new ArrayList<Integer>();
		for(int i=0;i<4;i++){
			features3.add(i);
		}
		naiveBayesClassifier.learn("category1", features3);
		
		//a1,a2,a3,a4
		Collection<Integer> features2 = new ArrayList<Integer>();
		for(int i=1;i<5;i++){
			features2.add(i);
		}
		naiveBayesClassifier.learn("category2", features2);
		
				
		Collection<Classification<Integer,String>> c = naiveBayesClassifier.classifyDetailed(features);
		assertEquals(1,c.size());
	}
	
	
	//category = null
	@Test(timeout = 4000)
	public void test1_8() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
		naiveBayesClassifier.learn("category1", new ArrayList<>());
		naiveBayesClassifier.decrementCategory("category2");
		assertEquals("category1",naiveBayesClassifier.classify(new ArrayList<>()).getCategory());
	}
	
	@Test(expected = NullPointerException.class)
	public void test1_9() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
		naiveBayesClassifier.classify(new ArrayList<>()).getCategory();
	}
	
	//测试capacity
	@Test(timeout = 4000)
	public void test2_1() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
		naiveBayesClassifier.setMemoryCapacity(1);
		assertEquals(1,naiveBayesClassifier.getMemoryCapacity());
	}
	
	//测试capacity
	@Test(timeout = 4000)
	public void test2_2() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
		assertEquals(1000,naiveBayesClassifier.getMemoryCapacity());
	}	
	
	//测试capacity
	@Test(timeout = 4000)
	public void test2_3() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
		naiveBayesClassifier.setMemoryCapacity(10000);
		assertEquals(10000,naiveBayesClassifier.getMemoryCapacity());
	}
	
	//测试capacity
	@Test(timeout = 4000)
	public void test2_4() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
		//a1,a2,a3,a4,a5,a6
		Collection<Integer> features = new ArrayList<Integer>();
		features.add(0);
		features.add(1);
		features.add(2);
							
		Collection<Integer> features1 = new ArrayList<Integer>();
		for(int i=0;i<6;i++){
			features1.add(i%3);
		}
		naiveBayesClassifier.learn("category1", features1);
							
		//a1,a2,a3,a4,a5,a6,a7,a8
		Collection<Integer> features2 = new ArrayList<Integer>();
		for(int i=0;i<8;i++){
			features2.add(i%6);
		}
		naiveBayesClassifier.learn("category2", features2);
				
		naiveBayesClassifier.learn("category3", new ArrayList<>());
		Classification c = naiveBayesClassifier.classify(features);
		naiveBayesClassifier.setMemoryCapacity(1);
		assertEquals("category1",c.getCategory());
	}
	
	//测试capacity
	@Test(timeout = 4000)
	public void test2_5() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
		naiveBayesClassifier.setMemoryCapacity(3);
		//a1,a2,a3,a4,a5,a6
		Collection<Integer> features = new ArrayList<Integer>();
		features.add(0);
		features.add(1);
		features.add(2);
								
		Collection<Integer> features1 = new ArrayList<Integer>();
		for(int i=0;i<6;i++){
			features1.add(i%3);
		}
		naiveBayesClassifier.learn("category1", features1);
		
		//a1,a2,a3,a4,a5,a6,a7,a8
		Collection<Integer> features2 = new ArrayList<Integer>();
		for(int i=0;i<8;i++){
			features2.add(i%6);
		}
		
		naiveBayesClassifier.learn("category2", features2);
					
		naiveBayesClassifier.learn("category3", new ArrayList<>());
		naiveBayesClassifier.setMemoryCapacity(1);
		naiveBayesClassifier.learn("category4",features1);
		Classification c = naiveBayesClassifier.classify(features);
		assertEquals("category4",c.getCategory());
		}
	
	//得到所有特征集合
	@Test(timeout = 4000)
	public void test3_1() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
					
		Collection<Integer> features1 = new ArrayList<Integer>();
		for(int i=0;i<6;i++){
			features1.add(i%3);
		}
		naiveBayesClassifier.learn("category1", features1);
					
		//a1,a2,a3,a4,a5,a6,a7,a8
		Collection<Integer> features2 = new ArrayList<Integer>();
		for(int i=0;i<8;i++){
			features2.add(i%6);
		}
		naiveBayesClassifier.learn("category2", features2);
		
		naiveBayesClassifier.learn("category3", new ArrayList<>());
		
		Set<Integer> s = naiveBayesClassifier.getFeatures();
		assertEquals(6,s.size());
	}
	
	//得到所有类别集合
	@Test(timeout = 4000)
	public void test4_1() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
						
		Collection<Integer> features1 = new ArrayList<Integer>();
		for(int i=0;i<6;i++){
			features1.add(i%3);
		}
		naiveBayesClassifier.learn("category1", features1);
						
		//a1,a2,a3,a4,a5,a6,a7,a8
		Collection<Integer> features2 = new ArrayList<Integer>();
		for(int i=0;i<8;i++){
			features2.add(i%6);
		}
		naiveBayesClassifier.learn("category2", features2);
			
		naiveBayesClassifier.learn("category3", new ArrayList<>());
			
		Set<String> s = naiveBayesClassifier.getCategories();
		assertEquals(3,s.size());
	}
	
	//得到所有类别集合，有重复
	@Test(timeout = 4000)
	public void test4_2() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
						
		Collection<Integer> features1 = new ArrayList<Integer>();
		for(int i=0;i<6;i++){
			features1.add(i%3);
		}
		naiveBayesClassifier.learn("category1", features1);
						
		//a1,a2,a3,a4,a5,a6,a7,a8
		Collection<Integer> features2 = new ArrayList<Integer>();
		for(int i=0;i<8;i++){
			features2.add(i%6);
		}
		naiveBayesClassifier.learn("category2", features2);
			
		naiveBayesClassifier.learn("category1", new ArrayList<>());
			
		Set<String> s = naiveBayesClassifier.getCategories();
		assertEquals(2,s.size());
	}
	
	//得到所有类型的统计和
	@Test(timeout = 4000)
	public void test5_1() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
						
		Collection<Integer> features1 = new ArrayList<Integer>();
		for(int i=0;i<6;i++){
			features1.add(i%3);
		}
		naiveBayesClassifier.learn("category1", features1);
						
		//a1,a2,a3,a4,a5,a6,a7,a8
		Collection<Integer> features2 = new ArrayList<Integer>();
		for(int i=0;i<8;i++){
			features2.add(i%6);
		}
		naiveBayesClassifier.learn("category2", features2);
			
		naiveBayesClassifier.learn("category3", new ArrayList<>());
			
		assertEquals(3,naiveBayesClassifier.getCategoriesTotal());
	}
	
	@Test(timeout = 4000)
	public void test5_2() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
						
		Collection<Integer> features1 = new ArrayList<Integer>();
		for(int i=0;i<6;i++){
			features1.add(i%3);
		}
		naiveBayesClassifier.learn("category1", features1);
						
		//a1,a2,a3,a4,a5,a6,a7,a8
		Collection<Integer> features2 = new ArrayList<Integer>();
		for(int i=0;i<8;i++){
			features2.add(i%6);
		}
		naiveBayesClassifier.learn("category2", features2);
			
		naiveBayesClassifier.learn("category1", new ArrayList<>());
			
		assertEquals(3,naiveBayesClassifier.getCategoriesTotal());
	}
  
	@Test
	public void test6_1(){
		Collection<Integer> features1 = new ArrayList<Integer>();
		for(int i=0;i<6;i++){
			features1.add(i%3);
		}
		Classification c = new Classification(features1,"category1");
		assertEquals("Classification [category=category1, probability=1.0, featureset="+features1+"]",c.toString());
	}
	
	@Test
	public void test6_2(){
		Classification c = new Classification(null,null);
		assertEquals("Classification [category=null, probability=1.0, featureset=null]",c.toString());
	}
	
	@Test(timeout = 4000)
	public void m_33_35_43_45_47() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
		naiveBayesClassifier.setMemoryCapacity(2);
		
		Collection<Integer> features = new ArrayList<Integer>();
		features.add(2);
		
		Collection<Integer> features1 = new ArrayList<Integer>();
		features1.add(0);
		
		Collection<Integer> features2 = new ArrayList<Integer>();
		features2.add(2);
		
		Collection<Integer> features3 = new ArrayList<Integer>();
		features3.add(2);
		features3.add(3);
		
		Collection<Integer> features4 = new ArrayList<Integer>();
		features4.add(3);
		
		naiveBayesClassifier.learn("category1", features1);
		naiveBayesClassifier.learn("category2", features2);
		naiveBayesClassifier.learn("category3", features3);
		naiveBayesClassifier.learn("category4", features4);
		
		
		assertEquals("0.75",""+naiveBayesClassifier.featureWeighedAverage(2, "category3"));
	}
	
	@Test(timeout = 4000)
	public void m_37_41() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
		naiveBayesClassifier.setMemoryCapacity(1);
		
		Collection<Integer> features1 = new ArrayList<Integer>();
		features1.add(1);
		features1.add(1);
		features1.add(1);
		naiveBayesClassifier.learn("category1", features1);
		naiveBayesClassifier.decrementFeature(1,"category1");
		
		assertEquals("2",""+naiveBayesClassifier.featureCount(1, "category1"));
	}
	
	@Test(timeout = 4000)
	public void m_39() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
		naiveBayesClassifier.setMemoryCapacity(1);
		
		Collection<Integer> features1 = new ArrayList<Integer>();
		features1.add(2);
		features1.add(1);
		features1.add(1);
		features1.add(1);
		naiveBayesClassifier.learn("category1", features1);
		naiveBayesClassifier.decrementFeature(2,"category1");
		
		assertEquals("3",""+naiveBayesClassifier.featureCount(1, "category1"));
	}
	
	@Test(timeout = 4000)
	public void m_57() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
		naiveBayesClassifier.setMemoryCapacity(1);
		
		Collection<Integer> features1 = new ArrayList<Integer>();
		features1.add(2);
		features1.add(1);
		features1.add(1);
		features1.add(1);
		naiveBayesClassifier.learn("category1", features1);
		
		assertEquals("0",""+naiveBayesClassifier.featureCount(3, "category1"));
	}
	
	@Test(timeout = 4000)
	public void m_67() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
		naiveBayesClassifier.setMemoryCapacity(1);
		
		Collection<Integer> features1 = new ArrayList<Integer>();
		features1.add(2);
		features1.add(1);
		features1.add(1);
		features1.add(1);
		naiveBayesClassifier.learn("category1", features1);
		
		assertEquals("0.0",""+naiveBayesClassifier.featureProbability(1,"category2"));
	}
	
	@Test(timeout = 4000)
	public void m_71() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
		
		Collection<Integer> features1 = new ArrayList<Integer>();
		features1.add(2);
		features1.add(1);
		features1.add(1);
		features1.add(1);
		naiveBayesClassifier.learn("category1", features1);
		naiveBayesClassifier.learn("category1", new ArrayList<>());
		
		assertEquals("1.5",""+naiveBayesClassifier.featureProbability(1,"category1"));
	}
	// m 75 ?
	@Test(timeout = 4000)
	public void m_77_83_89_104() {
		NaiveBayesClassifier<Integer, String> naiveBayesClassifier = new NaiveBayesClassifier<Integer, String>();
		
		Collection<Integer> features1 = new ArrayList<Integer>();
		features1.add(2);
		features1.add(1);
		features1.add(1);
		features1.add(1);
		naiveBayesClassifier.learn("category1", features1);
		naiveBayesClassifier.learn("category1", new ArrayList<>());
		assertEquals("1.3823528",""+naiveBayesClassifier.featureWeighedAverage(1,"category1",naiveBayesClassifier,0.4f));
	}
	
	//featureWeighedAverage
	
	
}
