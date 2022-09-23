package GroupingByShaileshSir;

import org.testng.annotations.Test;

public class Grouping {
  @Test(groups="Regression")
  public void TestCase1() {
	  System.out.println("I am in Test Case 1");
  }
  @Test(groups="Smoke")
  public void TestCase2() {
	  System.out.println("I am in Test Case 2");
  }
  @Test(groups="Regression")
  public void TestCase3() {
	  System.out.println("I am in Test Case 3");
  }
  @Test(groups="Smoke")
  public void TestCase4() {
	  System.out.println("I am in Test Case 4");
  }
  @Test(groups="Smoke")
  public void TestCase5() {
	  System.out.println("I am in Test Case 5");
  }
  @Test(groups="Regression")
  public void TestCase6() {
	  System.out.println("I am in Test Case 6");
  } 
}
//72 video is important all advance testNG concepts are covered