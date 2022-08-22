package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CarrinhoPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.loginPage;
import utils.Driver;

public class TestAIStep {
	
	private WebDriver driver;
	
	@Given("Acesso ao link de teste")
	public void acesso_ao_link_de_teste() {
		Driver wdriver = new Driver();
		driver = wdriver.Webdriver();
		System.out.print("Iniciando driver \n");
	}
	
	@When("informo login e senha")
	public void informo_login_senha() throws InterruptedException {
		loginPage loginpage = new loginPage(driver);
		loginpage.inserirUsuario("locked_out_user");
		loginpage.inserirSenha("secret_sauce");
		loginpage.clicarLogin();
	}
	
	@Then("valido a menssagem de erro")
	public void valido_menssagem_erro() throws InterruptedException, IOException {
		loginPage loginpage = new loginPage(driver);
		loginpage.validarMenssagemErro();
		
		File printFinal = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);     //Executa um print no final da execução
		FileUtils.copyFile(printFinal, new File("target/validacao.png"));
		driver.quit();
	}
	
	@And("realizo login")
	public void realizo_login() throws InterruptedException {
		loginPage loginpage = new loginPage(driver);
		loginpage.inserirUsuario("standard_user");
		loginpage.inserirSenha("secret_sauce");
		loginpage.clicarLogin();
	}
	
	@And("adiciono produtos ao carrinho")
	public void adiciono_produtos_ao_carrinho() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.clicarBackpack();
		homePage.clicarBikeLight();
		homePage.clicarJacket();
	}
	
	@When("acesso o carrinho")
	public void acesso_carrinho() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		CarrinhoPage carrinhoPage = new CarrinhoPage(driver);
		homePage.clicarCarrinho();
		carrinhoPage.clicarCheckout();
	}
	
	@And("preencho os campos necessarios")
	public void preencho_campos_necessarios() throws InterruptedException {
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.preencherFirstName("Jorge");
		checkoutPage.preencherLastName("Ben");
		checkoutPage.preencherPostalCode("00000000");
		checkoutPage.clicarContinuar();
	}
	
	@Then("valido a compra realizada com sucesso")
	public void valido_compra_realizada_com_sucesso() throws InterruptedException, IOException {
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.clicarFinalizar();
		checkoutPage.validarMenssagemCompra();
		
		File printFinal = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);     //Executa um print no final da execução
		FileUtils.copyFile(printFinal, new File("target/validacao.png"));
		driver.quit();
	}
	
	@And("adiciono todos os produtos ao carrinho")
	public void adiciono_todos_produtos_ao_carrinho() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.clicarBackpack();
		homePage.clicarBikeLight();
		homePage.clicarJacket();
		homePage.clicarOnesie();
		homePage.clicarTShirt();
		homePage.clicarRedShirt();
	}
	
	@Then("valido valor total a ser pago")
	public void valido_valor_total_pago() throws InterruptedException, IOException {
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.validarValorTotalPago();
		
		File printFinal = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);     //Executa um print no final da execução
		FileUtils.copyFile(printFinal, new File("target/validacao.png"));
		driver.quit();
	}
}
