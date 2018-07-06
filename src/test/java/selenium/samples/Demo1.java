package selenium.samples;

import org.t360.controller.Controller;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo1 extends Controller{

	@BeforeMethod
	public void Start()
	{
		System.out.println("started");
		initialize();
	}
	@Test
	public void test1(){
		driver.get("");
	}
	
}
