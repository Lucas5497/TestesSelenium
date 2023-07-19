import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TesteCadastro {
	
	private ChromeDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializar() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driverwhitelistedIps", "C://Users//lucas\\OneDrive//Área de Trabalho//chromedriver.exe");
		driver = new ChromeDriver(co);
		driver.get("https://wcaquino.me/selenium/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finalizar() {
		driver.quit();
	}
	
	
	@Test
	public void cadastro() {
		
		dsl.escrever("elementosForm:nome", "Lucas");
		dsl.escrever("elementosForm:sobrenome", "Lopes");
		dsl.clicarRadio("elementosForm:sexo:0");
		Assert.assertTrue(dsl.verRadioMarcado("elementosForm:sexo:0"));
		dsl.clicarCheckBox("elementosForm:comidaFavorita:0");
		dsl.clicarCheckBox("elementosForm:comidaFavorita:1");
		Assert.assertTrue(dsl.verCheckBoxMarcado("elementosForm:comidaFavorita:0"));
		Assert.assertTrue(dsl.verCheckBoxMarcado("elementosForm:comidaFavorita:1"));
		dsl.selecionarCombo("elementosForm:escolaridade","Superior");
		Assert.assertEquals("Superior", dsl.pegarValorCombo("elementosForm:escolaridade"));
		dsl.escrever("elementosForm:sugestoes", "Aprendam Java e Selenium");
		dsl.clicarBotao("elementosForm:cadastrar");
		
		//System.out.print(dsl.pegarValorDoCampo("resultado"));
		
		//Assert.assertTrue("Cadastrado!", driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		//Assert.assertTrue("Lucas", driver.findElement(By.id("descNome")).getText().endsWith("Lucas"));
	
	}

}
