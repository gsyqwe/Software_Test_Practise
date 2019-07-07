package net.mooctest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.lang.annotation.Annotation;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.stmt.SwitchEntryStmt;
import com.github.javaparser.ast.stmt.SwitchStmt;
import com.github.javaparser.ast.type.ArrayType;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.PrimitiveType;
import com.github.javaparser.ast.type.Type;

public class NaiveBayesClassifierTest{
  
  @Test(timeout = 4000)
  public <T> void testf(){
	  Collection c = new ArrayList();
	  c.add("1");
	  c.add("2");
	  Collection c3=new ArrayList();
	  c3.add("2");
	  Collection<T> c2=new ArrayList();
	  c2.add((T) c3);
	  Classification c1 =new Classification(c2, c);
	  c1.toString();
	  NaiveBayesClassifier<Object, Object> naiveBayesClassifier = new NaiveBayesClassifier<Object, Object>();
	  naiveBayesClassifier.classifyDetailed(c);
	  assertEquals(null,naiveBayesClassifier.classify(c));
  }
  
  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ConstructorDeclaration constructorDeclaration0 = new ConstructorDeclaration("a");
      Classification<Object, ConstructorDeclaration> classification0 = new Classification<Object, ConstructorDeclaration>((Collection<Object>) null, constructorDeclaration0, 0.0F);
      float float0 = classification0.getProbability();
      assertEquals(0.0F, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      PriorityQueue<Object> priorityQueue0 = new PriorityQueue<Object>();
      Classification<Object, Object> classification0 = new Classification<Object, Object>(priorityQueue0, priorityQueue0, (-0.55683595F));
      float float0 = classification0.getProbability();
      assertEquals((-0.55683595F), float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Classification<SwitchStmt, Locale.LanguageRange> classification0 = new Classification<SwitchStmt, Locale.LanguageRange>((Collection<SwitchStmt>) null, (Locale.LanguageRange) null);
      classification0.getFeatureset();
      assertEquals(1.0F, classification0.getProbability(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      PriorityQueue<Object> priorityQueue0 = new PriorityQueue<Object>();
      Classification<Object, ConstructorDeclaration> classification0 = new Classification<Object, ConstructorDeclaration>(priorityQueue0, (ConstructorDeclaration) null, 0.0F);
      classification0.getCategory();
      assertEquals(0.0F, classification0.getProbability(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      TreeSet<ConstructorDeclaration> treeSet0 = new TreeSet<ConstructorDeclaration>();
      SwitchStmt switchStmt0 = new SwitchStmt();
      Classification<ConstructorDeclaration, Object> classification0 = new Classification<ConstructorDeclaration, Object>(treeSet0, switchStmt0);
      float float0 = classification0.getProbability();
      assertEquals(1.0F, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      LinkedList<Object> linkedList0 = new LinkedList<Object>();
      Classification<Object, String> classification0 = new Classification<Object, String>(linkedList0, "", 0.0F);
      classification0.getCategory();
      assertEquals(0.0F, classification0.getProbability(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      LinkedList<Object> linkedList0 = new LinkedList<Object>();
      Classification<Object, String> classification0 = new Classification<Object, String>(linkedList0, "", 0.0F);
      String string0 = classification0.toString();
      assertEquals("Classification [category=, probability=0.0, featureset=[]]", string0);
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      LinkedList<Object> linkedList0 = new LinkedList<Object>();
      Classification<Object, String> classification0 = new Classification<Object, String>(linkedList0, "", 0.0F);
      classification0.getFeatureset();
      assertEquals(0.0F, classification0.getProbability(), 0.01F);
  }
  
  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      NaiveBayesClassifier<MethodDeclaration, Object> naiveBayesClassifier0 = new NaiveBayesClassifier<MethodDeclaration, Object>();
      ArrayType.Origin arrayType_Origin0 = ArrayType.Origin.NAME;
      PriorityQueue<MethodDeclaration> priorityQueue0 = new PriorityQueue<MethodDeclaration>();
      Classification<MethodDeclaration, Object> classification0 = new Classification<MethodDeclaration, Object>(priorityQueue0, naiveBayesClassifier0);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
      naiveBayesClassifier0.setMemoryCapacity(1);
      naiveBayesClassifier0.learn(classification0);
      naiveBayesClassifier0.learn((Object) arrayType_Origin0, (Collection<MethodDeclaration>) priorityQueue0);
      assertEquals(1, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      NaiveBayesClassifier<Properties, Properties> naiveBayesClassifier0 = new NaiveBayesClassifier<Properties, Properties>();
      Properties properties0 = new Properties();
      ArrayList<Properties> arrayList0 = new ArrayList<Properties>();
      naiveBayesClassifier0.learn(properties0, (Collection<Properties>) arrayList0);
      HashSet<Properties> hashSet0 = new HashSet<Properties>();
      Vector<Properties> vector0 = new Vector<Properties>();
      vector0.add(properties0);
      naiveBayesClassifier0.learn(properties0, (Collection<Properties>) vector0);
      hashSet0.add(properties0);
      naiveBayesClassifier0.classifyDetailed(hashSet0);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      NaiveBayesClassifier<Integer, Integer> naiveBayesClassifier0 = new NaiveBayesClassifier<Integer, Integer>();
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
      
      naiveBayesClassifier0.setMemoryCapacity(1001);
      assertEquals(1001, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      NaiveBayesClassifier<String, Hashtable<Object, Properties>> naiveBayesClassifier0 = new NaiveBayesClassifier<String, Hashtable<Object, Properties>>();
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
      
      naiveBayesClassifier0.setMemoryCapacity(0);
      int int0 = naiveBayesClassifier0.getMemoryCapacity();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      NaiveBayesClassifier<Object, String> naiveBayesClassifier0 = new NaiveBayesClassifier<Object, String>();
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
      
      naiveBayesClassifier0.setMemoryCapacity((-1));
      int int0 = naiveBayesClassifier0.getMemoryCapacity();
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      NaiveBayesClassifier<ArrayType.Origin, ArrayType.Origin> naiveBayesClassifier0 = new NaiveBayesClassifier<ArrayType.Origin, ArrayType.Origin>();
      int int0 = naiveBayesClassifier0.getCategoriesTotal();
      assertEquals(0, int0);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      NaiveBayesClassifier<Properties, ArrayType.Origin> naiveBayesClassifier0 = new NaiveBayesClassifier<Properties, ArrayType.Origin>();
      ArrayType.Origin arrayType_Origin0 = ArrayType.Origin.NAME;
      naiveBayesClassifier0.incrementCategory(arrayType_Origin0);
      int int0 = naiveBayesClassifier0.getCategoriesTotal();
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      NaiveBayesClassifier<ArrayType.Origin, Properties> naiveBayesClassifier0 = new NaiveBayesClassifier<ArrayType.Origin, Properties>();
      ArrayType.Origin arrayType_Origin0 = ArrayType.Origin.NAME;
      Properties properties0 = new Properties();
      float float0 = naiveBayesClassifier0.featureWeighedAverage(arrayType_Origin0, properties0, (IFeatureProbability<ArrayType.Origin, Properties>) naiveBayesClassifier0, 0.8960381F, 0.8960381F);
      assertEquals(0.8960381F, float0, 0.01F);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      NaiveBayesClassifier<Properties, ArrayType.Origin> naiveBayesClassifier0 = new NaiveBayesClassifier<Properties, ArrayType.Origin>();
      Properties properties0 = new Properties();
      ArrayType.Origin arrayType_Origin0 = ArrayType.Origin.NAME;
      float float0 = naiveBayesClassifier0.featureWeighedAverage(properties0, arrayType_Origin0, (IFeatureProbability<Properties, ArrayType.Origin>) naiveBayesClassifier0, (-0.8053941F), (-0.8053941F));
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
      assertEquals((-0.8053942F), float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      NaiveBayesClassifier<Object, MethodDeclaration> naiveBayesClassifier0 = new NaiveBayesClassifier<Object, MethodDeclaration>();
      NaiveBayesClassifier<Object, String> naiveBayesClassifier1 = new NaiveBayesClassifier<Object, String>();
      float float0 = naiveBayesClassifier1.featureWeighedAverage((Object) naiveBayesClassifier0, "", (IFeatureProbability<Object, String>) naiveBayesClassifier1, (-0.5009795F));
      assertEquals(0.5F, float0, 0.01F);
      assertEquals(1000, naiveBayesClassifier1.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      NaiveBayesClassifier<ArrayType.Origin, Object> naiveBayesClassifier0 = new NaiveBayesClassifier<ArrayType.Origin, Object>();
      ArrayType.Origin arrayType_Origin0 = ArrayType.Origin.TYPE;
      float float0 = naiveBayesClassifier0.featureWeighedAverage(arrayType_Origin0, (Object) arrayType_Origin0);
      assertEquals(0.5F, float0, 0.01F);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      ArrayDeque<ArrayType.Origin> arrayDeque0 = new ArrayDeque<ArrayType.Origin>();
      NaiveBayesClassifier<ArrayType.Origin, Properties> naiveBayesClassifier0 = new NaiveBayesClassifier<ArrayType.Origin, Properties>();
      naiveBayesClassifier0.classify(arrayDeque0);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      NaiveBayesClassifier<ArrayType.Origin, Integer> naiveBayesClassifier0 = new NaiveBayesClassifier<ArrayType.Origin, Integer>();
      Set<Integer> set0 = naiveBayesClassifier0.getCategories();
      NaiveBayesClassifier<Integer, Hashtable<ArrayType.Origin, Object>> naiveBayesClassifier1 = new NaiveBayesClassifier<Integer, Hashtable<ArrayType.Origin, Object>>();
      Hashtable<ArrayType.Origin, Object> hashtable0 = new Hashtable<ArrayType.Origin, Object>();
      Classification<Integer, Hashtable<ArrayType.Origin, Object>> classification0 = new Classification<Integer, Hashtable<ArrayType.Origin, Object>>(set0, hashtable0);
      naiveBayesClassifier1.learn(classification0);
      int int0 = naiveBayesClassifier1.categoryCount(hashtable0);
      assertEquals(1, int0);
      assertEquals(1000, naiveBayesClassifier1.getMemoryCapacity());
  }


  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      NaiveBayesClassifier<String, Properties> naiveBayesClassifier0 = new NaiveBayesClassifier<String, Properties>();
      Properties properties0 = new Properties();
      // Undeclared exception!
      try { 
        naiveBayesClassifier0.incrementFeature((String) null, properties0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      NaiveBayesClassifier<String, Object> naiveBayesClassifier0 = new NaiveBayesClassifier<String, Object>();
      // Undeclared exception!
      try { 
        naiveBayesClassifier0.incrementCategory((Object) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      NaiveBayesClassifier<MethodDeclaration, Hashtable<Object, Object>> naiveBayesClassifier0 = new NaiveBayesClassifier<MethodDeclaration, Hashtable<Object, Object>>();
      Properties properties0 = new Properties();
      // Undeclared exception!
      try { 
        naiveBayesClassifier0.featureWeighedAverage((MethodDeclaration) null, (Hashtable<Object, Object>) properties0, (IFeatureProbability<MethodDeclaration, Hashtable<Object, Object>>) naiveBayesClassifier0, 0.0F, 0.0F);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      NaiveBayesClassifier<String, Hashtable<String, Object>> naiveBayesClassifier0 = new NaiveBayesClassifier<String, Hashtable<String, Object>>();
      // Undeclared exception!
      try { 
        naiveBayesClassifier0.featureWeighedAverage("", (Hashtable<String, Object>) null, (IFeatureProbability<String, Hashtable<String, Object>>) naiveBayesClassifier0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      NaiveBayesClassifier<Integer, Integer> naiveBayesClassifier0 = new NaiveBayesClassifier<Integer, Integer>();
      // Undeclared exception!
      try { 
        naiveBayesClassifier0.featureProbability((Integer) null, (Integer) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      NaiveBayesClassifier<String, Properties> naiveBayesClassifier0 = new NaiveBayesClassifier<String, Properties>();
      Properties properties0 = new Properties();
      naiveBayesClassifier0.incrementFeature("", properties0);
      // Undeclared exception!
      try { 
        naiveBayesClassifier0.featureCount((String) null, properties0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      NaiveBayesClassifier<Properties, Properties> naiveBayesClassifier0 = new NaiveBayesClassifier<Properties, Properties>();
      // Undeclared exception!
      try { 
        naiveBayesClassifier0.decrementFeature((Properties) null, (Properties) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      NaiveBayesClassifier<Optional<Annotation>, ClassOrInterfaceType> naiveBayesClassifier0 = new NaiveBayesClassifier<Optional<Annotation>, ClassOrInterfaceType>();
      // Undeclared exception!
      try { 
        naiveBayesClassifier0.decrementCategory((ClassOrInterfaceType) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      TokenRange tokenRange0 = TokenRange.INVALID;
      NaiveBayesClassifier<MarkerAnnotationExpr, SwitchEntryStmt> naiveBayesClassifier0 = new NaiveBayesClassifier<MarkerAnnotationExpr, SwitchEntryStmt>();
      BlockStmt blockStmt0 = new BlockStmt();
      NodeList<Statement> nodeList0 = blockStmt0.getStatements();
      NodeList<Statement> nodeList1 = nodeList0.addFirst(blockStmt0);
      SwitchEntryStmt switchEntryStmt0 = new SwitchEntryStmt(tokenRange0, (Expression) null, nodeList1);
      // Undeclared exception!
      try { 
        naiveBayesClassifier0.categoryCount(switchEntryStmt0);
        fail("Expecting exception: StackOverflowError");
      
      } catch(StackOverflowError e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      NaiveBayesClassifier<Properties, MethodDeclaration> naiveBayesClassifier0 = new NaiveBayesClassifier<Properties, MethodDeclaration>();
      // Undeclared exception!
      try { 
        naiveBayesClassifier0.categoryCount((MethodDeclaration) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      NaiveBayesClassifier<Properties, Properties> naiveBayesClassifier0 = new NaiveBayesClassifier<Properties, Properties>();
      Properties properties0 = new Properties();
      naiveBayesClassifier0.incrementFeature(properties0, properties0);
      float float0 = naiveBayesClassifier0.featureWeighedAverage(properties0, properties0, (IFeatureProbability<Properties, Properties>) naiveBayesClassifier0, 0.0F, 0.0F);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
      assertEquals(0.0F, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      NaiveBayesClassifier<Object, Hashtable<String, Object>> naiveBayesClassifier0 = new NaiveBayesClassifier<Object, Hashtable<String, Object>>();
      ArrayType.Origin arrayType_Origin0 = ArrayType.Origin.NAME;
      Hashtable<String, Object> hashtable0 = new Hashtable<String, Object>();
      float float0 = naiveBayesClassifier0.featureWeighedAverage((Object) arrayType_Origin0, hashtable0, (IFeatureProbability<Object, Hashtable<String, Object>>) null, 0.0F, 0.0F);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
      assertEquals(Float.NaN, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      NaiveBayesClassifier<ArrayType.Origin, Hashtable<Properties, Integer>> naiveBayesClassifier0 = new NaiveBayesClassifier<ArrayType.Origin, Hashtable<Properties, Integer>>();
      ArrayType.Origin arrayType_Origin0 = ArrayType.Origin.TYPE;
      Hashtable<Properties, Integer> hashtable0 = new Hashtable<Properties, Integer>();
      LinkedList<ArrayType.Origin> linkedList0 = new LinkedList<ArrayType.Origin>();
      naiveBayesClassifier0.learn(hashtable0, (Collection<ArrayType.Origin>) linkedList0);
      float float0 = naiveBayesClassifier0.featureProbability(arrayType_Origin0, hashtable0);
      assertEquals(0.0F, float0, 0.01F);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      NaiveBayesClassifier<MethodDeclaration, Object> naiveBayesClassifier0 = new NaiveBayesClassifier<MethodDeclaration, Object>();
      MethodDeclaration methodDeclaration0 = new MethodDeclaration();
      float float0 = naiveBayesClassifier0.featureProbability(methodDeclaration0, methodDeclaration0);
      assertEquals(0.0F, float0, 0.01F);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      NaiveBayesClassifier<String, Classification<ArrayType.ArrayBracketPair, String>> naiveBayesClassifier0 = new NaiveBayesClassifier<String, Classification<ArrayType.ArrayBracketPair, String>>();
      LinkedHashSet<ArrayType.ArrayBracketPair> linkedHashSet0 = new LinkedHashSet<ArrayType.ArrayBracketPair>();
      Classification<ArrayType.ArrayBracketPair, String> classification0 = new Classification<ArrayType.ArrayBracketPair, String>(linkedHashSet0, "");
      int int0 = naiveBayesClassifier0.categoryCount(classification0);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      NaiveBayesClassifier<ArrayType.Origin, ArrayType.Origin> naiveBayesClassifier0 = new NaiveBayesClassifier<ArrayType.Origin, ArrayType.Origin>();
      ArrayType.Origin arrayType_Origin0 = ArrayType.Origin.TYPE;
      naiveBayesClassifier0.incrementFeature(arrayType_Origin0, arrayType_Origin0);
      int int0 = naiveBayesClassifier0.featureCount(arrayType_Origin0, arrayType_Origin0);
      assertEquals(1, int0);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      NaiveBayesClassifier<Properties, Properties> naiveBayesClassifier0 = new NaiveBayesClassifier<Properties, Properties>();
      Properties properties0 = new Properties();
      naiveBayesClassifier0.incrementCategory(properties0);
      naiveBayesClassifier0.decrementCategory(properties0);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      NaiveBayesClassifier<Properties, Properties> naiveBayesClassifier0 = new NaiveBayesClassifier<Properties, Properties>();
      Properties properties0 = new Properties();
      Vector<Properties> vector0 = new Vector<Properties>();
      vector0.add(properties0);
      vector0.add(properties0);
      naiveBayesClassifier0.learn(properties0, (Collection<Properties>) vector0);
      naiveBayesClassifier0.decrementFeature(properties0, properties0);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      NaiveBayesClassifier<ArrayType.Origin, ArrayType.Origin> naiveBayesClassifier0 = new NaiveBayesClassifier<ArrayType.Origin, ArrayType.Origin>();
      ArrayType.Origin arrayType_Origin0 = ArrayType.Origin.TYPE;
      naiveBayesClassifier0.incrementFeature(arrayType_Origin0, arrayType_Origin0);
      naiveBayesClassifier0.decrementFeature(arrayType_Origin0, arrayType_Origin0);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      NaiveBayesClassifier<Object, Properties> naiveBayesClassifier0 = new NaiveBayesClassifier<Object, Properties>();
      Properties properties0 = new Properties();
      TreeSet<Object> treeSet0 = new TreeSet<Object>();
      Classification<Object, Properties> classification0 = new Classification<Object, Properties>(treeSet0, properties0);
      naiveBayesClassifier0.learn(classification0);
      naiveBayesClassifier0.incrementCategory(properties0);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      NaiveBayesClassifier<Properties, Properties> naiveBayesClassifier0 = new NaiveBayesClassifier<Properties, Properties>();
      Properties properties0 = new Properties();
      Vector<Properties> vector0 = new Vector<Properties>();
      vector0.add(properties0);
      naiveBayesClassifier0.learn(properties0, (Collection<Properties>) vector0);
      naiveBayesClassifier0.incrementFeature(properties0, properties0);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      NaiveBayesClassifier<Annotation, Integer> naiveBayesClassifier0 = new NaiveBayesClassifier<Annotation, Integer>();
      naiveBayesClassifier0.reset();
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      NaiveBayesClassifier<Integer, Classification<Integer, Integer>> naiveBayesClassifier0 = new NaiveBayesClassifier<Integer, Classification<Integer, Integer>>();
      NaiveBayesClassifier<Object, Properties> naiveBayesClassifier1 = new NaiveBayesClassifier<Object, Properties>();
      Properties properties0 = new Properties();
      TreeSet<Object> treeSet0 = new TreeSet<Object>();
      treeSet0.add("");
      Classification<Object, Properties> classification0 = new Classification<Object, Properties>(treeSet0, properties0);
      naiveBayesClassifier1.learn(classification0);
      float float0 = naiveBayesClassifier1.featureWeighedAverage((Object) naiveBayesClassifier0, properties0, (IFeatureProbability<Object, Properties>) naiveBayesClassifier1);
      assertEquals(1000, naiveBayesClassifier1.getMemoryCapacity());
      assertEquals(0.5F, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      ArrayType.Origin arrayType_Origin0 = ArrayType.Origin.NAME;
      NaiveBayesClassifier<ArrayType.Origin, ArrayType.Origin> naiveBayesClassifier0 = new NaiveBayesClassifier<ArrayType.Origin, ArrayType.Origin>();
      int int0 = naiveBayesClassifier0.featureCount(arrayType_Origin0, arrayType_Origin0);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      NaiveBayesClassifier<Properties, Properties> naiveBayesClassifier0 = new NaiveBayesClassifier<Properties, Properties>();
      HashSet<Properties> hashSet0 = new HashSet<Properties>();
      Properties properties0 = new Properties();
      Vector<Properties> vector0 = new Vector<Properties>();
      vector0.add(properties0);
      naiveBayesClassifier0.learn(properties0, (Collection<Properties>) vector0);
      hashSet0.add(properties0);
      naiveBayesClassifier0.classifyDetailed(hashSet0);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      MethodDeclaration methodDeclaration0 = new MethodDeclaration();
      NaiveBayesClassifier<Object, MethodDeclaration> naiveBayesClassifier0 = new NaiveBayesClassifier<Object, MethodDeclaration>();
      naiveBayesClassifier0.decrementCategory(methodDeclaration0);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      NaiveBayesClassifier<MethodDeclaration, Object> naiveBayesClassifier0 = new NaiveBayesClassifier<MethodDeclaration, Object>();
      PriorityQueue<MethodDeclaration> priorityQueue0 = new PriorityQueue<MethodDeclaration>();
      MethodDeclaration methodDeclaration0 = new MethodDeclaration();
      priorityQueue0.add(methodDeclaration0);
      Classification<MethodDeclaration, Object> classification0 = new Classification<MethodDeclaration, Object>(priorityQueue0, naiveBayesClassifier0, 0.0F);
      naiveBayesClassifier0.learn(classification0);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
      
      naiveBayesClassifier0.setMemoryCapacity(0);
      naiveBayesClassifier0.learn(classification0);
      assertEquals(0, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test44()  throws Throwable  {
      NaiveBayesClassifier<ArrayType.Origin, ArrayType.Origin> naiveBayesClassifier0 = new NaiveBayesClassifier<ArrayType.Origin, ArrayType.Origin>();
      ArrayType.Origin arrayType_Origin0 = ArrayType.Origin.TYPE;
      naiveBayesClassifier0.incrementFeature(arrayType_Origin0, arrayType_Origin0);
      ArrayType.Origin arrayType_Origin1 = ArrayType.Origin.NAME;
      naiveBayesClassifier0.decrementFeature(arrayType_Origin1, arrayType_Origin0);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      NaiveBayesClassifier<Hashtable<Properties, Integer>, String> naiveBayesClassifier0 = new NaiveBayesClassifier<Hashtable<Properties, Integer>, String>();
      Hashtable<Properties, Integer> hashtable0 = new Hashtable<Properties, Integer>();
      naiveBayesClassifier0.decrementFeature(hashtable0, "");
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      NaiveBayesClassifier<MethodDeclaration, Object> naiveBayesClassifier0 = new NaiveBayesClassifier<MethodDeclaration, Object>();
      PriorityQueue<MethodDeclaration> priorityQueue0 = new PriorityQueue<MethodDeclaration>();
      MethodDeclaration methodDeclaration0 = new MethodDeclaration();
      priorityQueue0.add(methodDeclaration0);
      Classification<MethodDeclaration, Object> classification0 = new Classification<MethodDeclaration, Object>(priorityQueue0, naiveBayesClassifier0, 0.0F);
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
      
      naiveBayesClassifier0.setMemoryCapacity(0);
      naiveBayesClassifier0.learn(classification0);
      assertEquals(0, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test47()  throws Throwable  {
      NaiveBayesClassifier<String, Hashtable<Object, Properties>> naiveBayesClassifier0 = new NaiveBayesClassifier<String, Hashtable<Object, Properties>>();
      int int0 = naiveBayesClassifier0.getMemoryCapacity();
      assertEquals(1000, int0);
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      NaiveBayesClassifier<Properties, Properties> naiveBayesClassifier0 = new NaiveBayesClassifier<Properties, Properties>();
      naiveBayesClassifier0.getFeatures();
      assertEquals(1000, naiveBayesClassifier0.getMemoryCapacity());
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      NaiveBayesClassifier<ArrayType.Origin, Properties> naiveBayesClassifier0 = new NaiveBayesClassifier<ArrayType.Origin, Properties>();
      ArrayType.Origin arrayType_Origin0 = ArrayType.Origin.NAME;
      // Undeclared exception!
      try { 
        naiveBayesClassifier0.featureWeighedAverage(arrayType_Origin0, (Properties) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      NaiveBayesClassifier<Object, String> naiveBayesClassifier0 = new NaiveBayesClassifier<Object, String>();
      Properties properties0 = new Properties();
      // Undeclared exception!
      try { 
        naiveBayesClassifier0.featureWeighedAverage((Object) properties0, (String) null, (IFeatureProbability<Object, String>) naiveBayesClassifier0, 0.0F);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }
  
  @Test(timeout = 4000)
  public void test013()  throws Throwable  {
      NaiveBayesClassifier<Locale.FilteringMode, String> naiveBayesClassifier0 = new NaiveBayesClassifier<Locale.FilteringMode, String>();
      Locale.FilteringMode locale_FilteringMode0 = Locale.FilteringMode.IGNORE_EXTENDED_RANGES;
      float float0 = naiveBayesClassifier0.featureProbability(locale_FilteringMode0, "");
      assertEquals(0.0F, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test113()  throws Throwable  {
      NaiveBayesClassifier<Object, ConstructorDeclaration> naiveBayesClassifier0 = new NaiveBayesClassifier<Object, ConstructorDeclaration>();
      // Undeclared exception!
      try { 
        naiveBayesClassifier0.featureProbability("", (ConstructorDeclaration) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }
  
  @Test(timeout = 4000)
  public void testa0()  throws Throwable  {
      NaiveBayesClassifier<Object, PrimitiveType.Primitive> naiveBayesClassifier0 = new NaiveBayesClassifier<Object, PrimitiveType.Primitive>();
      PrimitiveType.Primitive primitiveType_Primitive0 = PrimitiveType.Primitive.SHORT;
      naiveBayesClassifier0.incrementCategory(primitiveType_Primitive0);
      naiveBayesClassifier0.incrementCategory(primitiveType_Primitive0);
      TreeSet<Object> treeSet0 = new TreeSet<Object>();
      PrimitiveType.Primitive primitiveType_Primitive1 = PrimitiveType.Primitive.DOUBLE;
      naiveBayesClassifier0.incrementCategory(primitiveType_Primitive1);
      Classification<Object, PrimitiveType.Primitive> classification0 = naiveBayesClassifier0.classify(treeSet0);
      assertEquals(0.6666667F, classification0.getProbability(), 0.01F);
      assertNotNull(classification0);
  }

  @Test(timeout = 4000)
  public void testa1()  throws Throwable  {
      NaiveBayesClassifier<String, String> naiveBayesClassifier0 = new NaiveBayesClassifier<String, String>();
      ArrayDeque<String> arrayDeque0 = new ArrayDeque<String>();
      arrayDeque0.addLast("");
      naiveBayesClassifier0.learn("", (Collection<String>) arrayDeque0);
      Classification<String, String> classification0 = naiveBayesClassifier0.classify(arrayDeque0);
      assertNotNull(classification0);
      assertEquals(0.75F, classification0.getProbability(), 0.01F);
  }

  @Test(timeout = 4000)
  public void testa2()  throws Throwable  {
      NaiveBayesClassifier<Type, Object> naiveBayesClassifier0 = new NaiveBayesClassifier<Type, Object>();
      LinkedList<Type> linkedList0 = new LinkedList<Type>();
      PrimitiveType primitiveType0 = PrimitiveType.shortType();
      naiveBayesClassifier0.learn((Object) linkedList0, (Collection<Type>) linkedList0);
      linkedList0.add((Type) primitiveType0);
      Classification<Type, Object> classification0 = naiveBayesClassifier0.classify(linkedList0);
      assertEquals(0.0F, classification0.getProbability(), 0.01F);
      assertNotNull(classification0);
  }

  @Test(timeout = 4000)
  public void testa3()  throws Throwable  {
      ArrayList<String> arrayList0 = new ArrayList<String>();
      NaiveBayesClassifier<String, Locale> naiveBayesClassifier0 = new NaiveBayesClassifier<String, Locale>();
      Classification<String, Locale> classification0 = naiveBayesClassifier0.classify(arrayList0);
      assertNull(classification0);
  }

  @Test(timeout = 4000)
  public void testa4()  throws Throwable  {
      NaiveBayesClassifier<Object, PrimitiveType.Primitive> naiveBayesClassifier0 = new NaiveBayesClassifier<Object, PrimitiveType.Primitive>();
      PrimitiveType.Primitive primitiveType_Primitive0 = PrimitiveType.Primitive.LONG;
      naiveBayesClassifier0.incrementCategory(primitiveType_Primitive0);
      TreeSet<Object> treeSet0 = new TreeSet<Object>();
      PrimitiveType.Primitive primitiveType_Primitive1 = PrimitiveType.Primitive.BOOLEAN;
      naiveBayesClassifier0.incrementCategory(primitiveType_Primitive1);
      Classification<Object, PrimitiveType.Primitive> classification0 = naiveBayesClassifier0.classify(treeSet0);
      assertEquals(0.5F, classification0.getProbability(), 0.01F);
      assertNotNull(classification0);
  }

  @Test(timeout = 4000)
  public void testa5()  throws Throwable  {
      NaiveBayesClassifier<Object, PrimitiveType.Primitive> naiveBayesClassifier0 = new NaiveBayesClassifier<Object, PrimitiveType.Primitive>();
      PrimitiveType.Primitive primitiveType_Primitive0 = PrimitiveType.Primitive.SHORT;
      naiveBayesClassifier0.incrementCategory(primitiveType_Primitive0);
      TreeSet<Object> treeSet0 = new TreeSet<Object>();
      PrimitiveType.Primitive primitiveType_Primitive1 = PrimitiveType.Primitive.DOUBLE;
      naiveBayesClassifier0.learn(primitiveType_Primitive1, (Collection<Object>) treeSet0);
      naiveBayesClassifier0.incrementCategory(primitiveType_Primitive1);
      Classification<Object, PrimitiveType.Primitive> classification0 = naiveBayesClassifier0.classify(treeSet0);
      assertNotNull(classification0);
      assertEquals(0.6666667F, classification0.getProbability(), 0.01F);
  }

  @Test(timeout = 4000)
  public void testa7()  throws Throwable  {
      NaiveBayesClassifier<PrimitiveType.Primitive, String> naiveBayesClassifier0 = new NaiveBayesClassifier<PrimitiveType.Primitive, String>();
      Collection<Classification<PrimitiveType.Primitive, String>> collection0 = naiveBayesClassifier0.classifyDetailed((Collection<PrimitiveType.Primitive>) null);
      assertNotNull(collection0);
  }

  
}
