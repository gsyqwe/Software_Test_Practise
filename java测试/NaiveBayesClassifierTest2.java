package net.mooctest;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Queue;

import org.junit.Test;

public class NaiveBayesClassifierTest{

    NaiveBayesClassifier<Object, Object> naiveBayesClassifier = new NaiveBayesClassifier<Object, Object>();
    
    /**
     * 对父类Classifier的测试
     */
    @Test(timeout = 4000)
    public void getFeaturesTest_1() {
        NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
        assertEquals(0, bayes.getFeatures().size());
    }
    
    @Test(timeout = 4000)
    public void getCategoriesTest_1(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
        assertEquals(0, bayes.getCategories().size());
    }
    
    @Test(timeout = 4000)
    public void getCategoriesTotalTest_1(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
        assertEquals(0, bayes.getCategoriesTotal());
    }
    
    @Test(timeout = 4000)
    public void getMemoryCapacityTest_1(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
        assertEquals(1000, bayes.getMemoryCapacity());
    }
    
    @Test(timeout = 4000)
    public void setMemoryCapacityTest_1(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.setMemoryCapacity(1000);
        assertEquals(1000, bayes.getMemoryCapacity());
    }
    
    @Test(timeout = 4000)
    public void setMemoryCapacityTest_2(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.setMemoryCapacity(999);
        assertEquals(999, bayes.getMemoryCapacity());
    }
    
    @Test(timeout = 4000)
    public void setMemoryCapacityTest_3(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.setMemoryCapacity(1001);
        assertEquals(1001, bayes.getMemoryCapacity());
    }
    
    @Test(timeout = 4000)
    public void incrementFeatureTest_1(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementFeature(new Integer(1), new Integer(1));
    	assertEquals(1, bayes.getFeatures().size());
    }
    
    @Test(timeout = 4000)
    public void incrementFeatureTest_2(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementFeature(new Integer(1), new Integer(1));
    	bayes.incrementFeature(new Integer(1), new Integer(2));
    	assertEquals(1, bayes.getFeatures().size());
    }
    
    @Test(timeout = 4000)
    public void incrementFeatureTest_3(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementFeature(new Integer(1), new Integer(1));
    	bayes.incrementFeature(new Integer(1), new Integer(2));
    	bayes.incrementFeature(new Integer(2), new Integer(3));
    	bayes.incrementFeature(new Integer(2), new Integer(1));
    	bayes.incrementFeature(new Integer(1), new Integer(1));
    	assertEquals(2, bayes.getFeatures().size());
    }
   
    @Test(timeout = 4000)
    public void incrementCategoriesTest_1(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	assertEquals(1, bayes.getCategories().size());
    }
    
    @Test(timeout = 4000)
    public void incrementCategoriesTest_2(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	bayes.incrementCategory(2);
    	bayes.incrementCategory(1);
    	assertEquals(2, bayes.getCategories().size());
    	assertEquals(3, bayes.getCategoriesTotal());
    }
    
    @Test(timeout = 4000)
    public void decrementFeatureTest_1(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.decrementFeature(1, 1);
    	assertEquals(0, bayes.featureCount(1, 1));
    	assertEquals(0, bayes.getFeatures().size());
    }
    
    @Test(timeout = 4000)
    public void decrementFeatureTest_2(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementFeature(1, 1);
    	bayes.decrementFeature(1, 1);
    	assertEquals(0, bayes.featureCount(1, 1));
    	assertEquals(0, bayes.getFeatures().size());
    }
    
    @Test(timeout = 4000)
    public void decrementFeatureTest_3(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	bayes.incrementFeature(2, 1);
    	bayes.decrementFeature(1, 1);
    	assertEquals(0, bayes.featureCount(1, 1));
    	assertEquals(1, bayes.getFeatures().size());
    }
    
    @Test(timeout = 4000)
    public void decrementFeatureTest_4(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	bayes.incrementFeature(1, 1);
    	bayes.decrementFeature(1, 1);
    	assertEquals(0, bayes.featureCount(1, 1));
    	assertEquals(0, bayes.getFeatures().size());
    }

    @Test(timeout = 4000)
    public void decrementFeatureTest_5(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	bayes.incrementFeature(1, 1);
    	bayes.incrementFeature(2, 1);
    	bayes.decrementFeature(1, 1);
    	assertEquals(0, bayes.featureCount(1, 1));
    	assertEquals(1, bayes.getFeatures().size());
    }
    
    @Test(timeout = 4000)
    public void decrementFeatureTest_6(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	bayes.incrementFeature(1, 1);
    	bayes.incrementFeature(1, 1);
    	bayes.decrementFeature(1, 1);
    	assertEquals(1, bayes.featureCount(1, 1));
    	assertEquals(1, bayes.getFeatures().size());
    }
    
    @Test(timeout = 4000)
    public void decrementFeatureTest_7(){			//变异47
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	bayes.incrementFeature(1, 1);
    	bayes.incrementFeature(1, 1);
    	bayes.decrementFeature(1, 1);
    	bayes.decrementFeature(1, 1);
    	assertEquals(0, bayes.featureCount(1, 1));
    	assertEquals(0, bayes.getFeatures().size());
    }
    
    @Test(timeout = 4000)
    public void decrementCategoryTest_1(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.decrementCategory(1);
    	assertEquals(0, bayes.getCategoriesTotal());
    }
    
    @Test(timeout = 4000)
    public void decrementCategoryTest_2(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	bayes.incrementCategory(2);
    	bayes.decrementCategory(1);
    	assertEquals(1, bayes.getCategoriesTotal());
    	assertEquals(1, bayes.getCategories().size());
    }
    
    @Test(timeout = 4000)
    public void decrementCategoryTest_3(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	bayes.incrementCategory(2);
    	bayes.incrementCategory(1);
    	bayes.decrementCategory(1);
    	assertEquals(2, bayes.getCategoriesTotal());
    	assertEquals(2, bayes.getCategories().size());
    }
    
    @Test(timeout = 4000)
    public void decrementCategoryTest_4(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	bayes.incrementCategory(2);
    	bayes.incrementCategory(1);
    	bayes.decrementCategory(2);
    	assertEquals(2, bayes.getCategoriesTotal());
    	assertEquals(1, bayes.getCategories().size());
    }
    
    @Test(timeout = 4000)
    public void categoryTest_1(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	assertEquals(0, bayes.categoryCount(1));
    }
    
    @Test(timeout = 4000)
    public void categoryTest_2(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	assertEquals(1, bayes.categoryCount(1));
    }
    
    @Test(timeout = 4000)
    public void categoryTest_3(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	bayes.incrementCategory(1);
    	assertEquals(2, bayes.categoryCount(1));
    }
    
    @Test(timeout = 4000)
    public void featureProbabilityTest_1(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	assertEquals(0.0f, bayes.featureProbability(1, 1), 0.00001);
    }
    
    @Test(timeout = 4000)
    public void featureProbabilityTest_2(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	bayes.incrementFeature(1, 1);
    	assertEquals(1.0f, bayes.featureProbability(1, 1), 0.00001);
    }
    
    @Test(timeout = 4000)
    public void featureProbabilityTest_3(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	bayes.incrementFeature(1, 1);
    	bayes.incrementFeature(2, 1);
    	assertEquals(1.0f, bayes.featureProbability(1, 1), 0.00001);
    }
    
    @Test
    public void featureProbabilityTest_4(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	bayes.incrementFeature(1, 1);
    	bayes.incrementFeature(2, 1);
    	bayes.incrementFeature(1, 1);
    	assertEquals(2.0f, bayes.featureProbability(1, 1), 0.00001);
    }
    
    @Test
    public void featureProbabilityTest_5(){		//变异71
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	bayes.incrementCategory(1);
    	bayes.incrementFeature(1, 1);
    	bayes.incrementFeature(2, 1);
    	bayes.incrementFeature(1, 1);
    	assertEquals(1.0f, bayes.featureProbability(1, 1), 0.00001);
    }
    
    @Test(timeout = 4000)
    public void featureWeighedAverageTest_1_1(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	assertEquals(0.5f, bayes.featureWeighedAverage(1, 1), 0.00001);
    }
    
    @Test(timeout = 4000)
    public void featureWeighedAverageTest_1_2(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	bayes.incrementFeature(1, 1);
    	assertEquals(0.75f, bayes.featureWeighedAverage(1, 1), 0.00001);
    }
    
    @Test(timeout = 4000)
    public void featureWeighedAverageTest_1_3(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	bayes.incrementFeature(1, 1);
    	bayes.incrementFeature(1, 1);
    	assertEquals(1.5f, bayes.featureWeighedAverage(1, 1), 0.00001);
    }
    
    @Test(timeout = 4000)
    public void featureWeighedAverageTest_2_1(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	NaiveBayesClassifier<Object, Object> calculator = new NaiveBayesClassifier<Object, Object>();
    	assertEquals(0.5f, bayes.featureWeighedAverage(1, 1, calculator), 0.00001);
    }
    
    @Test(timeout = 4000)
    public void featureWeighedAverageTest_2_2(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	NaiveBayesClassifier<Object, Object> calculator = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	bayes.incrementFeature(1, 1);
    	assertEquals(0.25f, bayes.featureWeighedAverage(1, 1, calculator), 0.00001);
    }
    
    @Test(timeout = 4000)
    public void featureWeighedAverageTest_2_3(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	NaiveBayesClassifier<Object, Object> calculator = new NaiveBayesClassifier<Object, Object>();
    	bayes.incrementCategory(1);
    	bayes.incrementFeature(1, 1);
    	calculator.incrementCategory(1);
    	calculator.incrementFeature(1, 1);
    	assertEquals(0.75f, bayes.featureWeighedAverage(1, 1, calculator), 0.00001);
    }
    
    @Test(timeout = 4000)
    public void featureWeighedAverageTest_3_1(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	NaiveBayesClassifier<Object, Object> calculator = new NaiveBayesClassifier<Object, Object>();
    	assertEquals(0.5f, bayes.featureWeighedAverage(1, 1, calculator, 1.0f), 0.00001);
    }
    
    @Test(timeout = 4000)
    public void learnTest_1_1(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	HashSet<Object> featureset = new HashSet<Object>();
    	featureset.add(1);
    	featureset.add(2);
    	Classification<Object, Object> clas = new Classification<Object, Object>(featureset, 1);
    	bayes.learn(clas);
    	assertEquals(1, bayes.getCategories().size());
    	assertEquals(1, bayes.getCategoriesTotal());
    }
    
    @Test(timeout = 4000)
    public void learnTest_1_2(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	bayes.setMemoryCapacity(1);
    	//第一次learn
    	HashSet<Object> featureset = new HashSet<Object>();
    	featureset.add(1);
    	featureset.add(2);
    	featureset.add(3);
    	Classification<Object, Object> clas = new Classification<Object, Object>(featureset, 1);
    	bayes.learn(clas);
    	
    	//第二次learn,导致超过memorySize
    	HashSet<Object> featureset2 = new HashSet<Object>();
    	featureset2.add(4);
    	Classification<Object, Object> clas2 = new Classification<Object, Object>(featureset2, 2);
    	bayes.learn(clas2);

    	assertEquals(1, bayes.getCategories().size());
    	assertEquals(1, bayes.getCategoriesTotal());
    	assertEquals(0, bayes.categoryCount(1));
    	assertEquals(1, bayes.getFeatures().size());
    	assertEquals(1, bayes.featureCount(4, 2));
    }
    
    @Test(timeout = 4000)
    public void learnTest_2_1(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	HashSet<Object> featureset = new HashSet<Object>();
    	featureset.add(1);
    	featureset.add(2);
    	bayes.learn(1, featureset);
    	assertEquals(1, bayes.getCategories().size());
    	assertEquals(1, bayes.getCategoriesTotal());
    }
    
    /**
     * 对Classification类剩余方法的测试
     */
    @Test(timeout = 4000)
    public void getProbabilityTest_1(){
    	HashSet<Object> featureset = new HashSet<Object>();
    	featureset.add(1);
    	featureset.add(2);
    	Classification<Object, Object> clas = new Classification<Object, Object>(featureset, 1);
    	assertEquals(1.0f, clas.getProbability(), 0.00001);
    }
    
    @Test(timeout = 4000)
    public void getProbabilityTest_2(){
    	HashSet<Object> featureset = new HashSet<Object>();
    	featureset.add(1);
    	featureset.add(2);
    	Classification<Object, Object> clas = new Classification<Object, Object>(featureset, 1, 0.8f);
    	assertEquals(0.8f, clas.getProbability(), 0.00001);
    }
    
    @Test(timeout = 4000)
    public void toStringTest_1(){
    	HashSet<Object> featureset = new HashSet<Object>();
    	Classification<Object, Object> clas = new Classification<Object, Object>(featureset, 1);
    	assertEquals("Classification [category=1, probability=1.0, featureset=[]]", clas.toString());
    }
    
    @Test(timeout = 4000)
    public void toStringTest_2(){
    	HashSet<Object> featureset = new HashSet<Object>();
    	featureset.add(1);
    	featureset.add(2);
    	Classification<Object, Object> clas = new Classification<Object, Object>(featureset, 1);
    	assertEquals("Classification [category=1, probability=1.0, featureset=[1, 2]]", clas.toString());
    }
    
    /**
     * 对NaiveBayesClassifier方法的测试
     */
    @Test(timeout = 4000)
    public void classifyTest_1(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	assertEquals(null, bayes.classify(null));
    }
    
    @Test(timeout = 4000)
    public void classifyTest_2(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	HashSet<Object> featureset = new HashSet<Object>();
    	featureset.add(1);
    	featureset.add(2);
    	assertEquals(null, bayes.classify(featureset));
    }
    
    @Test(timeout = 4000)
    public void classifyTest_3(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	HashSet<Object> featureset1 = new HashSet<Object>();
    	featureset1.add(1);
    	featureset1.add(2);
    	featureset1.add(3);
    	bayes.learn(1, featureset1);
    	
    	HashSet<Object> featureset2 = new HashSet<Object>();

    	assertEquals("Classification [category=1, probability=1.0, featureset=[]]", bayes.classify(featureset2).toString());
    }
    
    @Test(timeout = 4000)
    public void classifyTest_4(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	HashSet<Object> featureset1 = new HashSet<Object>();
    	featureset1.add(1);
    	featureset1.add(4);
    	featureset1.add(3);
    	bayes.learn(1, featureset1);
    	
    	HashSet<Object> featureset2 = new HashSet<Object>();
    	featureset2.add(1);
    	featureset2.add(1);

    	assertEquals("Classification [category=1, probability=0.75, featureset=[1]]", bayes.classify(featureset2).toString());
    }
    
    @Test(timeout = 4000)
    public void classifyTest_5(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	HashSet<Object> featureset1 = new HashSet<Object>();
    	featureset1.add(1);
    	featureset1.add(4);
    	featureset1.add(3);
    	bayes.learn(1, featureset1);
    	HashSet<Object> featureset2 = new HashSet<Object>();
    	featureset2.add(1);
    	featureset2.add(4);
    	featureset2.add(3);
    	bayes.learn(2, featureset1);
    	
    	HashSet<Object> featureset3 = new HashSet<Object>();
    	featureset3.add(1);
    	featureset3.add(1);

    	assertEquals("Classification [category=2, probability=0.41666666, featureset=[1]]", bayes.classify(featureset3).toString());
    }
    
    @Test(timeout = 4000)
    public void classifyTest_6(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	HashSet<Object> featureset1 = new HashSet<Object>();
    	featureset1.add(1);
    	featureset1.add(4);
    	Classification<Object, Object> clas1 = new Classification<Object, Object>(featureset1, 1, 1.0f);
    	bayes.learn(clas1);
    	HashSet<Object> featureset2 = new HashSet<Object>();
    	featureset2.add(1);
    	featureset2.add(4);
    	featureset2.add(3);
    	Classification<Object, Object> clas2 = new Classification<Object, Object>(featureset2, 2, 1.0f);
    	bayes.learn(clas2);
    	
    	HashSet<Object> featureset3 = new HashSet<Object>();
    	featureset3.add(3);
    	
    	assertEquals("Classification [category=2, probability=0.375, featureset=[3]]", bayes.classify(featureset3).toString());
    }
    
    @Test(timeout = 4000)
    public void classifyTest_7(){		//变异13
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	HashSet<Object> featureset1 = new HashSet<Object>();
    	featureset1.add(1);
    	featureset1.add(4);
    	featureset1.add(3);
    	Classification<Object, Object> clas1 = new Classification<Object, Object>(featureset1, 1);
    	bayes.learn(clas1);
    	HashSet<Object> featureset2 = new HashSet<Object>();
    	featureset2.add(1);
    	featureset2.add(4);
    	Classification<Object, Object> clas2 = new Classification<Object, Object>(featureset2, 2);
    	bayes.learn(clas2);
    	
    	HashSet<Object> featureset3 = new HashSet<Object>();
    	featureset3.add(1);
    	
    	assertEquals("Classification [category=2, probability=0.41666666, featureset=[1]]", bayes.classify(featureset3).toString());
    }
    
    @Test(timeout = 4000)
    public void classifyTest_8(){		//变异17
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	HashSet<Object> featureset1 = new HashSet<Object>();
    	featureset1.add(1);
    	featureset1.add(4);
    	featureset1.add(3);
    	Classification<Object, Object> clas1 = new Classification<Object, Object>(featureset1, 1);
    	bayes.learn(clas1);
    	HashSet<Object> featureset2 = new HashSet<Object>();
    	featureset2.add(1);
    	featureset2.add(4);
    	Classification<Object, Object> clas2 = new Classification<Object, Object>(featureset2, 2);
    	bayes.learn(clas2);
    	
    	HashSet<Object> featureset3 = new HashSet<Object>();
    	
    	assertEquals("Classification [category=2, probability=0.5, featureset=[]]", bayes.classify(featureset3).toString());
    }
    
    @Test(timeout = 4000)
    public void classifyDetailedTest_1(){
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
    	assertEquals("[]", bayes.classifyDetailed(null).toString());
    }
    
    @Test(timeout = 4000)
    public void setMemoryCapacityTest_2_1() throws Exception{		//变异15
    	Class<Classifier> class1 = Classifier.class;
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
//    	Class<NaiveBayesClassifier<Object, Object>> class1 = (Class<NaiveBayesClassifier<Object, Object>>) bayes.getClass();
    	Field memoryQueue = class1.getDeclaredField("memoryQueue");
    	memoryQueue.setAccessible(true);
    	bayes.setMemoryCapacity(3);
    	
    	HashSet<Object> featureset1 = new HashSet<Object>();
    	featureset1.add(1);
    	featureset1.add(4);
    	featureset1.add(3);
    	bayes.learn(1, featureset1);
    	HashSet<Object> featureset2 = new HashSet<Object>();
    	featureset2.add(1);
    	featureset2.add(4);
    	featureset2.add(3);
    	bayes.learn(2, featureset1);
    	
    	Queue<Object> queue = (Queue)memoryQueue.get(bayes);
    	assertEquals(2, queue.size());
    	bayes.setMemoryCapacity(2);
    	queue = (Queue)memoryQueue.get(bayes);
    	assertEquals(1, queue.size());
    }
    
    @Test(timeout = 4000)
    public void setMemoryCapacityTest_2_2() throws Exception{		//变异17
    	Class<Classifier> class1 = Classifier.class;
    	NaiveBayesClassifier<Object, Object> bayes = new NaiveBayesClassifier<Object, Object>();
//    	Class<NaiveBayesClassifier<Object, Object>> class1 = (Class<NaiveBayesClassifier<Object, Object>>) bayes.getClass();
    	Field memoryQueue = class1.getDeclaredField("memoryQueue");
    	memoryQueue.setAccessible(true);
    	bayes.setMemoryCapacity(2);
    	
    	HashSet<Object> featureset1 = new HashSet<Object>();
    	featureset1.add(1);
    	featureset1.add(4);
    	featureset1.add(3);
    	bayes.learn(1, featureset1);
    	HashSet<Object> featureset2 = new HashSet<Object>();
    	featureset2.add(1);
    	featureset2.add(4);
    	featureset2.add(3);
    	bayes.learn(2, featureset1);
    	
    	Queue<Object> queue = (Queue)memoryQueue.get(bayes);
    	assertEquals(2, queue.size());
    	bayes.setMemoryCapacity(3);
    	queue = (Queue)memoryQueue.get(bayes);
    	assertEquals(2, queue.size());
    }
}
