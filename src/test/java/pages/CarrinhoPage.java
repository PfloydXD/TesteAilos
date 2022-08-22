package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CarrinhoPage {
	
	private WebDriver driver;
	
	@FindBy(how = How.ID, using = "checkout")
	private WebElement checkout;
	
	public CarrinhoPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;	
	}
	
	public void clicarCheckout() {
		checkout.click();
		System.out.print("Clicando em Checkout \n");
	}
}
