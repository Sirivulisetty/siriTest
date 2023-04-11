package Tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageClasses.pageClass_Homepage;
import utilities.baseDriver;





public class validateProducts {
	
	
	public baseDriver b;
	
	pageClass_Homepage p;
	
	@BeforeTest
	
	public void beforeTest() {
		
		//driver=new ChromeDriver();
		
		b=new baseDriver();
		
		b.browserSetUpBeforeTest("https://www.flipkart.com/");
		
		
	}
	
	@Test
	
	public void test() throws Exception {
		
		p=new pageClass_Homepage(baseDriver.driver);
	
		
		Assert.assertTrue(p.clickOnCloseButton(),"Unable to click on closebutton");
		
		ArrayList<String> ActualMainMenu=p.validateMainMenu();
		
		String[] str= {"Grocery","Mobiles","Fashion","Electronics","Home","Appliances","Travel","Top Offers","Beauty" , "Toys & More" , "Two Wheelers"};
		
		;
		ArrayList<String>  ExcpectdMainMenu=new ArrayList<String>(Arrays.asList("Grocery","Mobiles","Fashion","Electronics","Home","Appliances","Travel","Top Offers","Beauty,"+" " +"Toys & More" , "Two Wheelers"));
		//ExcpectdMainMenu= 
		
		System.out.println(str.length);
		
		System.out.println(ActualMainMenu);	
		System.out.println(ExcpectdMainMenu);	
		
		Assert.assertEquals(ActualMainMenu, ExcpectdMainMenu,"MainMenu doesn't match");
		
		
		Assert.assertEquals(p.clickOnContainers(), true,"Containers product doesn't exist");
		
		Assert.assertEquals((p.selectRatings("4★ & above")),true,"Rating is not selected");
		
		
		p.validateProductDetails();
	
	}
	
	

}
