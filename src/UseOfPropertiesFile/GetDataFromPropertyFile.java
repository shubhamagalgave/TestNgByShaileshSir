package UseOfPropertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		//name and loction of file
		String path ="E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\PropertyFileFolder\\FileRead.properties";

		//create an instance of fileinputstreamfile class by passing file location to its constructor 
		FileInputStream file = new FileInputStream(path);
		
		//create an instance of properties class
		Properties prop=new Properties();
		
		//with help of property class refrance call load() and pass fileinputstream ref as parameter
		prop.load(file);
		
		//in order to read property fileuse getProperty(String key) of property file 
		System.out.println("Application Url"+prop.getProperty("appUrl"));
		System.out.println("Application username"+prop.getProperty("username"));
		System.out.println("Application password"+prop.getProperty("password"));
		System.out.println("Application confirmPassword"+prop.getProperty("confirmPassword"));
		System.out.println("Application firstName"+prop.getProperty("firstName"));
		System.out.println("Application lastName"+prop.getProperty("lastName"));
		System.out.println("Application contactNumber"+prop.getProperty("contactNumber"));
		System.out.println("Application emailId"+prop.getProperty("emailId"));
	}

}
