package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseDriver {
	
	public static WebDriver driver;
	


	public void browserSetUpBeforeTest(String url) {
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.navigate().to(url);
	}
	
		
		public void browserSetUpAfterTest() {
			driver.close();
		
	}

}
