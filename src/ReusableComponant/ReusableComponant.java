package ReusableComponant;

import java.io.IOException;

public class ReusableComponant extends BaseClass {

	public static void main(String[] args) throws IOException, InterruptedException {
		ReusableComponant rc=new ReusableComponant();
		rc.logIn();
		rc.testInheritance();
	}
	public void testInheritance() throws IOException, InterruptedException
	{
		//logIn();
		System.out.println("Test Inheritance");
	}

	

}
