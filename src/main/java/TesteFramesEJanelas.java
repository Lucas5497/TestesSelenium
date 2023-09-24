import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class TesteFramesEJanelas {
	
	private EdgeDriver driver;
	private DSL dsl;

	@Before
	public void inicializa(){
		
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.edge.driverwhitelistedIps", "C:\\Users\\lucas\\OneDrive\\Área de Trabalho\\msedgedriver.exe");
		driver = new EdgeDriver(options);
		
		driver.get("https://wcaquino.me/selenium/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza(){
		driver.quit();
	}

	@Test
	public void deveInteragirComFrames(){
		dsl.entrarFrame("frame1");
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertaObterTextoAceitar();
		Assert.assertEquals("Frame OK!", msg);

		dsl.sairFrame();
		dsl.escrever("elementosForm:nome", msg);
	}
	
	@Test
	public void deveInteragirComJanelas(){
		dsl.clicarBotao("buttonPopUpEasy");
		dsl.trocarJanela("Popup");
		dsl.escrever(By.tagName("textarea"), "Deu certo?");
		driver.close();
		dsl.trocarJanela("");
		dsl.escrever(By.tagName("textarea"), "e agora?");
	}
	
	@Test
	public void deveInteragirComJanelasSemTitulo(){
		dsl.clicarBotao("buttonPopUpHard");
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		dsl.trocarJanela((String) driver.getWindowHandles().toArray()[1]);
		dsl.escrever(By.tagName("textarea"), "Deu certo?");
		dsl.trocarJanela((String) driver.getWindowHandles().toArray()[0]);
		dsl.escrever(By.tagName("textarea"), "e agora?");
	}
}
