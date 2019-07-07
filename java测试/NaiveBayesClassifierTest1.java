package net.mooctest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;
import java.util.SortedSet;

import org.junit.Test;
import org.junit.runner.RunWith;

public class NaiveBayesClassifierTest{

	 @Test
	  public void test0() {
	      NaiveBayesClassifier<Object, Object> c = new NaiveBayesClassifier<Object, Object>();
	      
		  c.decrementCategory(true);
	      
	      Collection features=new ArrayList();
	      features.add(1);
	      features.add(0);
	      assertEquals(0,c.getCategoriesTotal());
	      assertEquals(0,c.categoryCount(true));
	      
	      assertEquals(0,c.classifyDetailed(features).size());
	      assertEquals(null,c.classify(features));
	  }
	 
	  @Test(timeout=3000)
	  public void test1() {
	      NaiveBayesClassifier<Object, Object> c = new NaiveBayesClassifier<Object, Object>();
	 
	      Collection featureSet=new ArrayList();
	      featureSet.add(1);
	      featureSet.add(0);
	      c.learn(new Classification(featureSet,true));
	      featureSet.clear();
	      
	      featureSet.add(1);
	      featureSet.add(0);
	      c.learn(new Classification(featureSet,false));
	      
	      assertEquals(2,c.getCategoriesTotal());
	      assertEquals(1,c.categoryCount(true));
	      assertEquals(1,c.categoryCount(false));
	      assertEquals(1,c.featureCount(1, true));
	      assertEquals(1,c.featureCount(0, true));
	      assertEquals(1,c.featureCount(1, false));
	      assertEquals(1,c.featureCount(0, false));
	      
	      assertEquals(0,c.featureCount(2, true));
	      
	      Set<Object> fs=c.getFeatures();
	      assertTrue(fs.contains(1));
	      assertTrue(fs.contains(0));
	      assertEquals(2,fs.size());
	      
	      
	      Collection features=new ArrayList();
	      features.add(1);
	      features.add(0);

	      
	      assertEquals(true,c.classify(features).getCategory());
	      assertEquals(0.347,c.classify(features).getProbability(),0.001);
	      assertEquals("[Classification [category=false, probability=0.3472222, featureset=[1, 0]], Classification [category=true, probability=0.3472222, featureset=[1, 0]]]",
	    		  c.classifyDetailed(features).toString());
	  }
	  
	  @Test
	  public void test2() {
	      NaiveBayesClassifier<Object, Object> c = new NaiveBayesClassifier<Object, Object>();
	 
	      Collection featureSet=new ArrayList();
	      featureSet.add(1);
	      featureSet.add(0);
	      c.learn(true,featureSet);
	      featureSet.clear();
	      	     	      
	      Collection features=new ArrayList();
	      features.add(1);
	      features.add(0);
	      assertEquals(true,c.classify(features).getCategory());
	      assertEquals(0.5625,c.classify(features).getProbability(),0.001);
	  }
	  
	  @Test
	  public void test3() {
		  NaiveBayesClassifier<Object, Object> c = new NaiveBayesClassifier<Object, Object>();
		  assertEquals(1000,c.getMemoryCapacity());
		  int capicity=20;
		  c.setMemoryCapacity(capicity);
		  assertEquals(20,c.getMemoryCapacity());
		  for(int i=0;i<capicity;i++) {
			  Collection featureSet=new ArrayList();
			  featureSet.add(i%5);
			  c.learn(i/10==0,featureSet);
		  }
		  for(int i=0;i<5;i++) {
			  assertEquals(2,c.featureCount(i, true));
			  assertEquals(2,c.featureCount(i, false));
		  }
		  for(int i=0;i<10;i++) {
			  Collection featureSet=new ArrayList();
			  featureSet.add(i%5);
			  c.learn(false,featureSet);
		  }
		  
		  for(int i=0;i<5;i++) {
			  assertEquals(4,c.featureCount(i, false));
		  }
		  
		  c.decrementCategory(true);
	      c.decrementFeature(0, true);
	      c.decrementFeature(10, false);
	      
		  for(int i=0;i<5;i++) {
			  assertEquals(4,c.featureCount(i, false));
		  }
		  
		  for(int i=0;i<20;i++) {
			  assertEquals(4-i/5,c.featureCount(i%5, false));
			  c.decrementFeature(i%5,false);
			  c.decrementCategory(false);
			  assertEquals(3-i/5,c.featureCount(i%5, false));
			  assertEquals(19-i,c.categoryCount(false));
			  assertEquals(19-i,c.getCategoriesTotal());
			  assertEquals(1-i/19,c.getCategories().size());
			  assertEquals(5-(i/15)*(i%14),c.getFeatures().size());
		  }
	  }
	  
	  @Test
	  public void test4() {
		  NaiveBayesClassifier<Object, Object> c = new NaiveBayesClassifier<Object, Object>();
		  int capicity=10;
		  c.setMemoryCapacity(capicity);
		  assertEquals(10,c.getMemoryCapacity());
		  for(int i=0;i<capicity;i++) {
			  Collection featureSet=new ArrayList();
			  featureSet.add(i);
			  c.learn(true,featureSet);
		  }
		  assertEquals("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]",c.getFeatures().toString());
		  c.setMemoryCapacity(5);
		  assertEquals("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]",c.getFeatures().toString());
		  for(int i=0;i<capicity;i++) {
			  Collection featureSet=new ArrayList();
			  featureSet.add(i+10);
			  c.learn(true,featureSet);
		  }
		  assertEquals("[19, 18, 17, 16, 15, 4, 3, 2, 1, 0]",c.getFeatures().toString());
	  }
	  
	  @Test
	  public void testAll() {
	      NaiveBayesClassifier<Object, Object> c = new NaiveBayesClassifier<Object, Object>();
	 
	      Collection featureSet=new ArrayList();
	      featureSet.add(1);
	      featureSet.add(0);
	      c.learn(new Classification(featureSet,false));
	      featureSet.clear();
	      
	      featureSet.add(1);
	      featureSet.add(-1);
	      c.learn(new Classification(featureSet,false));
	      featureSet.clear();
	      
	      featureSet.add(1);
	      featureSet.add(-1);
	      c.learn(new Classification(featureSet,true));
	      featureSet.clear();
	      
	      featureSet.add(1);
	      featureSet.add(0);
	      c.learn(new Classification(featureSet,true));
	      featureSet.clear();
	      
	      featureSet.add(1);
	      featureSet.add(0);
	      c.learn(new Classification(featureSet,false));
	      featureSet.clear();
	      
	      featureSet.add(2);
	      featureSet.add(0);
	      c.learn(new Classification(featureSet,false));
	      featureSet.clear();
	      
	      featureSet.add(2);
	      featureSet.add(-1);
	      c.learn(new Classification(featureSet,false));
	      featureSet.clear();
	      
	      featureSet.add(2);
	      featureSet.add(-1);
	      c.learn(new Classification(featureSet,true));
	      featureSet.clear();
	      
	      featureSet.add(2);
	      featureSet.add(-2);
	      c.learn(new Classification(featureSet,true));
	      featureSet.clear();
	      
	      featureSet.add(2);
	      featureSet.add(-2);
	      c.learn(new Classification(featureSet,true));
	      featureSet.clear();
	      
	      featureSet.add(3);
	      featureSet.add(-2);
	      c.learn(new Classification(featureSet,true));
	      featureSet.clear();
	      
	      featureSet.add(3);
	      featureSet.add(-1);
	      c.learn(new Classification(featureSet,true));
	      featureSet.clear();
	      
	      featureSet.add(3);
	      featureSet.add(-2);
	      c.learn(new Classification(featureSet,true));
	      featureSet.clear();
	      
	      featureSet.add(3);
	      featureSet.add(-1);
	      c.learn(new Classification(featureSet,true));
	      featureSet.clear();
	      
	      featureSet.add(3);
	      featureSet.add(-2);
	      c.learn(new Classification(featureSet,false));
	      featureSet.clear();
	      
	      assertEquals(0.444,c.featureProbability(-1,true),0.001);
	      assertEquals(0.111,c.featureProbability(0,true),0.001);
	      assertEquals(0.222,c.featureProbability(1,true),0.001);
	      assertEquals(0.333,c.featureProbability(2,true),0.001);
	      assertEquals(0.444,c.featureProbability(3,true),0.001);
	      assertEquals(0.333,c.featureProbability(-1,false),0.001);
	      assertEquals(0.5,c.featureProbability(0,false),0.001);
	      assertEquals(0.5,c.featureProbability(1,false),0.001);
	      assertEquals(0.333,c.featureProbability(2,false),0.001);
	      assertEquals(0.167,c.featureProbability(3,false),0.001);
	      assertEquals(0,c.featureProbability(4, false),0.001);
	      assertEquals(0,c.featureProbability(true, 4),0.001);
	      
	      assertEquals(0.452,c.featureWeighedAverage(-1, true),0.001);
	      assertEquals(0.189,c.featureWeighedAverage(0, true),0.001);
	      assertEquals(0.268,c.featureWeighedAverage(1, true),0.001);
	      assertEquals(0.361,c.featureWeighedAverage(2, true),0.001);
	      assertEquals(0.454,c.featureWeighedAverage(3, true),0.001);
	      assertEquals(0.357,c.featureWeighedAverage(-1, false),0.001);
	      assertEquals(0.5,c.featureWeighedAverage(0, false),0.001);
	      assertEquals(0.5,c.featureWeighedAverage(1, false),0.001);
	      assertEquals(0.361,c.featureWeighedAverage(2, false),0.001);
	      assertEquals(0.222,c.featureWeighedAverage(3, false),0.001);
	      assertEquals(0.5,c.featureWeighedAverage(4, false),0.001);
	      assertEquals(0.5,c.featureWeighedAverage(true,4),0.001);
	      
	      IFeatureProbability caculator=new IFeatureProbability(){
			public float featureProbability(Object feature, Object category) {
				return 0.1f;
			}
	      };
	      assertEquals(0.157,c.featureWeighedAverage(-1, true, caculator),0.001);
	      assertEquals(0.167,c.featureWeighedAverage(1, false, caculator),0.001);
	      assertEquals(0.5,c.featureWeighedAverage(4, true, caculator),0.001);
	      assertEquals(0.5,c.featureWeighedAverage(true, 4, caculator),0.001);
	      
	      assertEquals(0.2,c.featureWeighedAverage(-1, true, caculator,2.0f),0.001);
	      assertEquals(0.214,c.featureWeighedAverage(1, false, caculator,2.0f),0.001);
	      assertEquals(0.5,c.featureWeighedAverage(4, true, caculator,2.0f),0.001);
	      assertEquals(0.5,c.featureWeighedAverage(true, 4, caculator,2.0f),0.001);
	      

	      

	      
	      Collection features=new ArrayList();
	      features.add(2);
	      features.add(0);
	      assertEquals(false,c.classify(features).getCategory());
	      assertEquals(0.072,c.classify(features).getProbability(),0.001);
	      assertEquals("Classification [category=false, probability=0.072222225, featureset=[2, 0]]",c.classify(features).toString());
	      
	      SortedSet<Classification<Integer,Boolean>> probabilites = (SortedSet<Classification<Integer, Boolean>>) c.classifyDetailed(features);
	     
	      Classification first=probabilites.first();
	      Classification last=probabilites.last();
	      assertEquals(true,first.getCategory());
	      assertEquals(0.041,first.getProbability(),0.001);
	      assertEquals(features,first.getFeatureset());
	      assertEquals(false,last.getCategory());
	      assertEquals(0.072,last.getProbability(),0.001);
	      assertEquals(features,last.getFeatureset());
	  }
}