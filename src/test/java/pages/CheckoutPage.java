package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	private WebDriver driver;
	
	@FindBy(how = How.ID, using = "first-name")
	private WebElement fname;
	
	@FindBy(how = How.ID, using = "last-name")
	private WebElement lname;
	
	@FindBy(how = How.ID, using = "postal-code")
	private WebElement postalCode;
	
	@FindBy(how = How.ID, using = "continue")
	private WebElement continuar;
	
	@FindBy(how = How.ID, using = "finish")
	private WebElement finish;
	
	public CheckoutPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;	
	}
	
	public void preencherFirstName(String fname) {
		this.fname.sendKeys(fname);
		System.out.print("Informando First Name \n");
	}
	
	public void preencherLastName(String lname) {
		this.lname.sendKeys(lname);
		System.out.print("Informando Last Name \n");
	}
	
	public void preencherPostalCode(String postalCode) {
		this.postalCode.sendKeys(postalCode);
		System.out.print("Informando Postal Code \n");
	}
	
	public void clicarContinuar() {
		continuar.click();
		System.out.print("Clicando em Continue \n");
	}
	
	public void clicarFinalizar() {
		finish.click();
		System.out.print("Clicando em Finish \n");
	}
	
	public void validarMenssagemCompra() {
		Assert.assertEquals(driver.findElement(By.xpath("//h2[text() = 'THANK YOU FOR YOUR ORDER']")), 
				driver.findElement(By.xpath("//h2[text() = 'THANK YOU FOR YOUR ORDER']")));
		System.out.print("Validando a mensagem de compra \n");
	}
	
	public void validarValorTotalPago() {
		Assert.assertEquals(driver.findElement(By.xpath("//div[text() = '140.34']")), 
				driver.findElement(By.xpath("//div[text() = '140.34']")));
		System.out.print("Validando total da compra \n");
	}
}
