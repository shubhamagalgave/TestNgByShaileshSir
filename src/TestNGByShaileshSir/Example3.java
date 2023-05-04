package TestNGByShaileshSir;

import org.testng.annotations.Test;

public class Example3 {
  @Test(priority=-1)
  public void TestCase3() throws InterruptedException {
	  Thread.sleep(2000);
	  System.out.println("Hi I am Shubham -1");
  }
  
  @Test(priority=0)
  public void TestCase2() throws InterruptedException {
	  Thread.sleep(2000);
	  System.out.println("Hi I am Shubham 0");
  }
  @Test(priority=1)
  public void TestCase1() throws InterruptedException {
	  Thread.sleep(2000);
	  System.out.println("Hi I am Shubham 1");
  }

}
