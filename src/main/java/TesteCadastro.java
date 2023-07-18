	import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driverwhitelistedIps", "C://Users//lucas\\OneDrive//Área de Trabalho//chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(co);
		driver.get("https://wcaquino.me/selenium/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	
	@Test
	public void cadastro() {
		
		dsl.escrever("elementosForm:nome", "Lucas");
		dsl.escrever("elementosForm:nome", "Lopes");
		
		dsl.clicarRadio("elementosForm:sexo:0");
		Assert.assertTrue(dsl.verRadioMarcado("elementosForm:sexo:0"));
		
		dsl.clicarCheckBox("elementosForm:comidaFavorita:0");
		dsl.clicarCheckBox("elementosForm:comidaFavorita:1");
		
		Assert.assertTrue(dsl.verCheckBoxMarcado("elementosForm:comidaFavorita:0"));
		Assert.assertTrue(dsl.verCheckBoxMarcado("elementosForm:comidaFavorita:1"));
		
		dsl.selecionarCombo("elementosForm:escolaridade","superior");
		Assert.assertEquals("superior", dsl.pegarValorCombo("elementosForm:escolaridade"));
		
		
		dsl.escrever("elementosForm:sugestoes", "Aprendam Java e Selenium");
		dsl.clicarBotao("elementosForm:cadastrar");
		
		System.out.print(dsl.pegarTexto(By.id("resultado")));
		
		
		Assert.assertTrue("Cadastrado!", driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue("Lucas", driver.findElement(By.id("descNome")).getText().endsWith("Lucas"));
		
		//Assert.assertEquals("Lopes", driver.findElement(By.id("descSobrenome")).getText());
		
		//Assert.assertEquals("Masculino", driver.findElement(By.id("descSexo")).getText());
		//Assert.assertEquals("Masculino", driver.findElement(By.id("descComida")).getText());
		//Assert.assertEquals("Masculino", driver.findElement(By.id("descEscolaridade")).getText());
		//Assert.assertEquals("Masculino", driver.findElement(By.id("descEsportes")).getText());
		
		//Assert.assertEquals("Aprendam Java e Selenium", driver.findElement(By.id("descSugestoes")).getText());
		
		
		
		driver.quit();
		
		
	}

}
