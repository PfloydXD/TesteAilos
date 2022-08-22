package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private WebDriver driver;
	
	@FindBy(how = How.ID, using = "add-to-cart-sauce-labs-backpack")
	private WebElement backpack;
	
	@FindBy(how = How.ID, using = "add-to-cart-sauce-labs-bike-light")
	private WebElement bikelight;

	@FindBy(how = How.ID, using = "add-to-cart-sauce-labs-bolt-t-shirt")
	private WebElement tshirt;
	
	@FindBy(how = How.ID, using = "add-to-cart-sauce-labs-fleece-jacket")
	private WebElement jacket;
	
	@FindBy(how = How.ID, using = "add-to-cart-sauce-labs-onesie")
	private WebElement onesie;
	
	@FindBy(how = How.ID, using = "add-to-cart-test.allthethings()-t-shirt-(red)")
	private WebElement redShirt;
	
	@FindBy(how = How.ID, using = "shopping_cart_container")
	private WebElement carrinho;
	
	public HomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;	
	}
	
	public void clicarBackpack() {
		backpack.click();
		System.out.print("Clicando em Backpack ADD TO CART \n");
	}
	
	public void clicarBikeLight() {
		bikelight.click();
		System.out.print("Clicando em Bikelight ADD TO CART \n");
	}
	
	public void clicarTShirt() {
		tshirt.click();
		System.out.print("Clicando em t-shirt ADD TO CART \n");
	}
	
	public void clicarJacket() {
		jacket.click();
		System.out.print("Clicando em Jacket ADD TO CART \n");
	}
	
	public void clicarOnesie() {
		onesie.click();
		System.out.print("Clicando em Onesie ADD TO CART \n");
	}
	
	public void clicarRedShirt() {
		redShirt.click();
		System.out.print("Clicando em red Shirt ADD TO CART \n");
	}
	
	public void clicarCarrinho() {
		carrinho.click();
		System.out.print("Clicando no icone do carrinho \n");
	}
}
