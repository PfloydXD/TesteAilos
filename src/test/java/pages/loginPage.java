package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	private WebDriver driver;
	
	@FindBy(how = How.ID, using = "user-name")
	private WebElement usuario;
	
	@FindBy(how = How.ID, using = "password")
	private WebElement senha;
	
	@FindBy(how = How.ID, using = "login-button")
	private WebElement loginBtn;
	
	
	public loginPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;	
	}
	
	public void inserirUsuario(String usuario) {
		this.usuario.sendKeys(usuario);
		System.out.print("Informando usuario \n");
	}
	
	public void inserirSenha(String senha) {
		this.senha.sendKeys(senha);
		System.out.print("Informando senha \n");
	}
	
	public void clicarLogin() {
		loginBtn.click();
		System.out.print("Clicando no botão de login \n");
	}
	
	public void validarMenssagemErro() {
		Assert.assertEquals(driver.findElement(By.xpath("//h3[text() = 'Epic sadface: Sorry, this user has been locked out.']")), 
				driver.findElement(By.xpath("//h3[text() = 'Epic sadface: Sorry, this user has been locked out.']")));
		System.out.print("Validando a mensagem de erro \n");
	}
}
