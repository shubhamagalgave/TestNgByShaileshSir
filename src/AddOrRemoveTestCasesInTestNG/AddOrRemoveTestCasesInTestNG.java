package AddOrRemoveTestCasesInTestNG;

import org.testng.annotations.Test;

public class AddOrRemoveTestCasesInTestNG {
  @Test(enabled=true)
  public void TC1() {
	  System.out.println("I am in TestCase1");
  }
  @Test(enabled=false)
  public void TC2() {
	  System.out.println("I am in TestCase2");
  }
  
	@Test
	public void addDepartmentTestCase() 
	{
		System.out.println("Im in add department test case");
	}
	
	@Test
	public void addEmployeeTestCase() 
	{
		System.out.println("Im in add employee test case");
	}
  
  
  
}
