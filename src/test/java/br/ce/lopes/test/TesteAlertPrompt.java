package br.ce.lopes.test;
import static br.ce.lopes.core.DriverFactory.getDriver;
import static br.ce.lopes.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import br.ce.lopes.core.DSL;

public class TesteAlertPrompt {
	//private EdgeDriver driver;
	private DSL dsl;
	
	String url = "https://wcaquino.me/selenium/componentes.html";
	
	@Before
	public void inicializa() throws InterruptedException{
		
		//EdgeOptions options = new EdgeOptions();
		//options.addArguments("--remote-allow-origins=*");
		//DriverFactory.getDriver().get(System.setProperty("webgetDriver().edge.driverwhitelistedIps", "C:\\Users\\Acer\\Desktop\\msedgegetDriver().exe"));
		//driver = new EdgeDriver(options);
		//getDriver().manage().window().setSize(new Dimension(1366, 768));
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
	public void interagirComAlert() {	
		
		getDriver().findElement(By.id("Alert")).click();
		Alert alert = getDriver().switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples",texto);
		alert.accept();		
	}
	
	@Test
	public void interagirComAlertSimples() {
		
		getDriver().findElement(By.id("alert")).click();
		Alert alert = getDriver().switchTo().alert();		
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples",texto);
		alert.accept();
		getDriver().findElement(By.id("elementosForm:nome")).sendKeys(texto);
	}
	
	@Test
	public void interagirAlertConfirm() {
	
		getDriver().findElement(By.id("confirm")).click();
		Alert alerta = getDriver().switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.accept();
		Assert.assertEquals("Confirmado", alerta.getText()); 
		alerta.accept();
	}

	@Test
	public void interagirAlertPrompt() {
		
		getDriver().findElement(By.id("prompt")).click();	
		Alert alertaPrompt = getDriver().switchTo().alert();
		Assert.assertEquals("Digite um numero", alertaPrompt.getText());
		alertaPrompt.sendKeys("10");
		alertaPrompt.accept();
		Assert.assertEquals("Era 10? ", alertaPrompt.getText());
		alertaPrompt.accept();
		Assert.assertEquals(":D", alertaPrompt.getText());
		alertaPrompt.accept();
	}
}
