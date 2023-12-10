import static br.ce.lopes.core.DriverFactory.getDriver;
import static br.ce.lopes.core.DriverFactory.killDriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ce.lopes.core.DSL;

public class TesteDeEspera{
	
	private DSL dsl;
	
	String url = "https://wcaquino.me/selenium/componentes.html";
	
	@Before
	public void inicializa() throws InterruptedException{
		
		getDriver().get(url);
		Thread.sleep(1000);
		dsl = new DSL();
	}
	
	@After
	public void finaliza() throws InterruptedException{
		Thread.sleep(1000);
		killDriver();
	}
	
	@Test
	public void esperaFixa() throws InterruptedException {
		dsl.clicarBotao("buttonDelay");
		Thread.sleep(5000);
		dsl.escrever("novoCampo", "Deu certo?");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void esperaImplicita() throws InterruptedException {
		dsl.clicarBotao("buttonDelay");
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dsl.escrever("novoCampo", "Deu certo?");
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	
	@Test
	public void esperaExplicita() throws InterruptedException {
		
		dsl.clicarBotao("buttonDelay");
		Thread.sleep(5000);
		//WebDriverWait wait = new WebDriverWait(driver, int 30);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		dsl.escrever("novoCampo", "Deu certo?");	
	}
	
}