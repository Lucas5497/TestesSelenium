import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class TesteCadastro {
	
	private EdgeDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	String url = "https://wcaquino.me/selenium/componentes.html";
	@Before
	public void inicializar() throws InterruptedException {
		//ChromeOptions co = new ChromeOptions();
		//co.addArguments("--remote-allow-origins=*");
		//System.setProperty("webdriver.chrome.driverwhitelistedIps", "C://Users//lucas\\OneDrive//Área de Trabalho//chromedriver.exe");
		//driver = new ChromeDriver(co);
		
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.edge.driverwhitelistedIps", "C:\\Users\\Acer\\Desktop\\msedgedriver.exe");
		driver = new EdgeDriver(options);
		driver.manage().window().setSize(new Dimension(1366, 768));
		driver.get(url);
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);
		Thread.sleep(2000);
	}
	
	@After
	public void finalizar() {
		driver.quit();
	}
	
	@Test
	
	public void deveValidarCadastroComSucesso() throws InterruptedException {
		
		page.setNome("Lucas");
		page.setSobrenome("Lopes");
		page.setSexoMasculino();
		page.setComidaVegetariano();
		page.setEscolaridade("Superior");
		page.setEsporte("Futebol");
		page.setSugestoes("Aprenda java e selenium");
		Thread.sleep(1000);
		page.cadastrar();
		Thread.sleep(10000);
		
		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterNomeCadastrado().endsWith("Lucas"));
		Assert.assertTrue(page.obterSobrenomeCadastrado().endsWith("Lopes"));
		Assert.assertTrue(dsl.verRadioMarcado("elementosForm:sexo:0"));
		Assert.assertTrue(dsl.verCheckBoxMarcado("elementosForm:comidaFavorita:3"));
		
		Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastrado());
		Assert.assertEquals("Comida: Vegetariano", page.obterComidaCadastrado());
		Assert.assertEquals("Esportes: Futebol", page.obterEsporteCadastrado());
		Assert.assertEquals("Sugestoes: Aprenda java e selenium", page.obterSugestoesCadastradas());
	
	}
	
	@Test
	public void deveValidarNomeObrigatorio() {
		page.cadastrar();
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoAceitar());
	}
	
	@Test
	public void deveValidarSobrenomeObrigatorio() {
		page.setNome("Lucas");
		page.cadastrar();
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoAceitar());
	}
	
	@Test
	public void deveValidarComidaVegetariana() {
		
		page.setNome("Lucas");
		page.setSobrenome("Lopes");
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setComidaVegetariano();
		page.setEscolaridade("Superior");
		page.setEsporte("Futebol");
		page.setSugestoes("Aprenda java e selenium");
		page.cadastrar();
		
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoAceitar());
	
	}
	
	@Test
	public void deveValidarEsporteIndeciso() {
		
		page.setNome("Lucas");
		page.setSobrenome("Lopes");
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setEscolaridade("Superior");
		page.setEsporte("Futebol","O que eh esporte?");
		page.setSugestoes("Aprenda java e selenium");
		page.cadastrar();
		
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoAceitar());
	}
	
}
