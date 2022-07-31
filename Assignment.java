package javaprograms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Assignment {
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://sanbox.undostres.com.mx/");
		Thread.sleep(3000);
		driver.findElement(By
				.xpath("//body/div[3]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/input[1]"))
		.sendKeys("8465433546");
		driver.findElement(By.xpath("//input[@suggest='mobile-operator']")).click();
		Thread.sleep(500);
		int count1 = driver.findElements(By.xpath("//div[@class='suggestion suggestion-ul-container']//ul/li")).size();
		for (int i = 1; i <= count1; i++) {
			WebElement ele = driver
					.findElement(By.xpath("//div[@class='suggestion suggestion-ul-container']//ul/li[" + i + "]"));
			if ("Telcel".equalsIgnoreCase(ele.getText())) {
				ele.click();
				break;
			}
			System.out.println(ele.getText());
		}
		int count2 = driver
				.findElements(By.xpath("//li[@data-cat='Recarga Saldo']//div[@class='main-info data-value'][1]"))
				.size();
		for (int i = 1; i <= count2; i++) {
			WebElement ele1 = driver.findElement(
					By.xpath("//li[@data-cat='Recarga Saldo'][" + i + "]//div[@class='main-info data-value']"));
			if ("$10".equalsIgnoreCase(ele1.getText())) {
				ele1.click();
				break;
			}
		}
		driver.findElement(
				By.xpath("//div[@to-do='mobile']//button[@class='button buttonRecharge']")).click();


		String  expected = "https://sanbox.undostres.com.mx/payment.php";
		String  actual= driver.getCurrentUrl();

		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println("user is able to reach payment screen");
		}
		else
		{
			System.out.println("user is Not able to reach payment screen");
		}
		driver.findElement(By.xpath("//span[@id='cardGly']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@for='radio-c']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='cardnumberunique']")).sendKeys("4111111111111111");
		driver.findElement(By.xpath("//input[@placeholder='Mes']")).sendKeys("11");
		driver.findElement(By.xpath("//input[@placeholder='Año']")).sendKeys("25");
		driver.findElement(By.xpath("//input[@placeholder='CVV']")).sendKeys("111");
		driver.findElement(By.xpath("//input[@name='txtEmail'][@class='form-control email preventChromeAutofill']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//div[@id='new-card-button-desktop']//div[@class='col']")).click();
		driver.findElement(By.xpath("//input[@id='usrname']")).sendKeys("automationexcersise@test.com");
		driver.findElement(By.xpath("//input[@id='psw']")).sendKeys("123456");
		
	//As we cannot automate CAPTCH by using selenium, so i did my best to accomplish th assignment
	//  kindly go through my script and review it
		
		
		/*  WebElement frameElement = driver.findElement(By.xpath("//form[@id='loginForm']//iframe"));

		  driver.switchTo().frame(frameElement);
		  driver.findElement(By.xpath("//button[contains(text(),'Acceso')]")).click();
		  String  expected1 = "https://sanbox.undostres.com.mx/confirmation/success";
			String actual1= driver.getCurrentUrl();

			  if(actual.equalsIgnoreCase(expected))
			  {
				  System.out.println("Recharge is successful");
			  }
			  else
			  {
				  System.out.println("Recharge is Not successful");
			  }*/
	}




}






