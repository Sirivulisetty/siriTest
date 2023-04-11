package PageClasses;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WriteintoExcel;




public class pageClass_Homepage {
	
	
    WebDriver driver;
    
    WriteintoExcel w;

	
	@FindBy(xpath="//button[text()='✕']")
	public WebElement closeButton;
	
	
	@FindBy(xpath="//div[@class='xtXmba']")
	List<WebElement> mainMenu;
	
	@FindBy(xpath="//div[text()='Apple iPads']")
	WebElement smartWatch;
	
	@FindBy(xpath="//div[@class='_13oc-S']//div[@class='col col-7-12']//div[@class='_4rR01T']")
	List<WebElement> productName;
 	
	@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")
	List<WebElement> price;
	
	public pageClass_Homepage(WebDriver driver)

	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean clickOnCloseButton() {
		
		if(closeButton.isDisplayed()) {
			
			closeButton.click();
		}
		
		return true;
		
		
	}
	
	public ArrayList<String> validateMainMenu(){
		
		ArrayList<String> list=new ArrayList<String>();
		
		Iterator<WebElement> itr=mainMenu.iterator();
		
		while(itr.hasNext()) {
			
			WebElement w=itr.next();
			
			list.add(w.getText());
		}
		
		return list;
	

		
		
	}
	
	public boolean clickOnContainers() throws InterruptedException {
		
		
		
		WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(2000));
		
		wt.until(ExpectedConditions.elementToBeClickable(smartWatch));
		if(smartWatch.isDisplayed()) {
			smartWatch.click();
			return true;
		}
		
		else
			return false;
		
	}
	
	public boolean selectRatings(String str) throws InterruptedException {
		
		String xrpath="//div[text()="+"'"+str+"'"+"]";
		
     WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(2000));
		
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(xrpath)));
		
		WebElement ratings=driver.findElement(By.xpath(xrpath));
		
		ratings.click();
        
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(xrpath)));
	
		
        if(ratings.isEnabled()) {
        	return true;
        	
	}
        else
        	
        	return false;
	}
	
	public void validateProductDetails() throws Exception {
		
		w=new WriteintoExcel();
      
        driver.navigate().refresh();
        
       for(int i=0;i<productName.size();i++){
    	   
    	   WebElement wt=productName.get(i);
    	   
        	
        String name=wt.getText();
        
        String priceinfo=price.get(i).getText();
        	
        w.writeProductDetails(i+1,1, name);
        
        w.writeProductDetails(i+1, 2, priceinfo);
        	 }
        	
       
        	
        }
        
	
	
	
}