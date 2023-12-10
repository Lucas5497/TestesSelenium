import static br.ce.lopes.core.DriverFactory.getDriver;
import static br.ce.lopes.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.lopes.core.DSL;


public class TesteCadastro {
	
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	String url = "https://wcaquino.me/selenium/componentes.html";
	@Before
	public void inicializar() throws InterruptedException {
		//ChromeOptions co = new ChromeOptions();
		//co.addArguments("--remote-allow-origins=*");
		//System.setProperty("webdriver.chrome.driverwhitelistedIps", "C://Users//lucas\\OneDrive//Área de Trabalho//chromedriver.exe");
		//driver = new ChromeDriver(co);
		
		getDriver().get(url);
		dsl = new DSL();
		page = new CampoTreinamentoPage();
		Thread.sleep(2000);
	}
	
	@After
	public void finalizar() {
		killDriver();
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
