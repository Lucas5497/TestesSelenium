import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;




public class TesteCampoTreinamento {
	
	private ChromeDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driverwhitelistedIps", "C://Users//lucas\\OneDrive//Área de Trabalho//chromedriver.exe");
		driver = new ChromeDriver(co);
		driver.get("https://wcaquino.me/selenium/componentes.html");
		dsl = new DSL(driver);
	}

	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void testeTextField() {
		//driver.wait(1000);
		dsl.escrever("elementosForm:nome", "teste de escrita");	
		//driver.findElement(By.id("elementosForm:nome")).sendKeys("teste de escrita");
		//verifica se o que foi escrito está correto
		Assert.assertEquals("teste de escrita", dsl.pegarValorDoCampo("elementosForm:nome"));
	}

	@Test
	public void interagirComTextArea() {
		//procura o elemento através do id, class, name xpath etc. Escreve um texto no elemento
		dsl.escrever("elementosForm:sugestoes", "testes\n\nselenium\n\nultimalinha\n\n\nops tem mais uma rsrs");
	}
	
	@Test
	public void interagirComRadioButton() {
		//interagindo com o radio button
		dsl.clicarRadio("elementosForm:sexo:0");
		//verificando se o botão está selecionado verifica se o resultado é true
		Assert.assertTrue(dsl.verRadioMarcado("elementosForm:sexo:0"));
	}
	
	@Test
	public void interagirComCheckBox() {
		//interagindo com o checkBox
		dsl.clicarCheckBox("elementosForm:comidaFavorita:0");
		//verificando se o botão está selecionado verifica se o resultado é true
		Assert.assertTrue(dsl.verCheckBoxMarcado("elementosForm:comidaFavorita:0"));
	}
	
	@Test
	public void interagirComCombo() {
		
		dsl.selecionarCombo("elementosForm:escolaridade", "Mestrado");
		Assert.assertEquals("Mestrado", dsl.obterValorCombo("elementosForm:escolaridade"));
	}
	
	@Test
	public void verificarValoresDoCombo() {
		//interagindo com a lista | Inicializando a instãncia do webelement 
		WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade"));
		//interagindo com o combo
		Select combo = new Select(elemento);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());	
		boolean encontrou = false;
		for(WebElement option: options){
			if(option.getText().equals("Doutorado")){
				encontrou = true;
				break;
			} 
		}
		Assert.assertTrue(encontrou);
	}
	
	@Test
	public void verificarValoresDoComboMultiplo() {
		
		dsl.selecionarCombo("elementosForm:esportes","Natacao");
		dsl.selecionarCombo("elementosForm:esportes","Futebol");
		dsl.selecionarCombo("elementosForm:esportes","Corrida");
		
		WebElement elemento = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(elemento);
		 
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());	
		
		combo.deselectByVisibleText("Corrida");
		
		List<WebElement> allSelectedOptions2 = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions2.size());
	}
	
	@Test 
	public void interagirComBotao() {
		
		dsl.clicarBotao("buttonSimple");
	}
	
	@Test 
	public void interagirComLink() {	
		
		dsl.clicarLink("Voltar");
		Assert.assertEquals("Voltou!", dsl.pegarTexto(By.id("resultado")));
	}
	
	@Test 
	public void buscarTextosNaPagina() {
		System.out.print(dsl.pegarTexto(By.tagName("Body")));
		Assert.assertEquals("Campo de Treinamento",
				dsl.pegarTexto(By.tagName("h3")));
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", 
				dsl.pegarTexto(By.className("facilAchar")));
		
	}
	
	@Test
	public void interagirComAlert() {	
		driver.findElement(By.id("Alert")).click();
		Alert alert = driver.switchTo().alert();
		
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples",texto);
		alert.accept();
	}
	
	@Test
	public void interagirComAlertSimples() {
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples",texto);
		alert.accept();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	}
	
	@Test
	public void interagirAlertConfirm() {
		driver.findElement(By.id("confirm")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.accept();
		
		Assert.assertEquals("Confirmado", alerta.getText()); 
		alerta.accept();
	}

	public void interagirAlertPrompt() {
		
		driver.findElement(By.id("prompt")).click();
		
		Alert alertaPrompt = driver.switchTo().alert();
		
		Assert.assertEquals("Digite um numero", alertaPrompt.getText());
		
		alertaPrompt.sendKeys("12");
		
		alertaPrompt.accept();
		
		Assert.assertEquals("Era 10? ", alertaPrompt.getText());
		
		alertaPrompt.accept();
		
		Assert.assertEquals(":D", alertaPrompt.getText());
		
		alertaPrompt.accept();
	}
	
	@Test
	public void interagirComFrame() {
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!",msg);
		alert.accept();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
		
	}
	@Test 
	public void interagirComJanela() {
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("Vai dar certo");
		driver.close();
		driver.switchTo().window("");
		
	}
	@Test
	public void interagirComJanelaSemNome() {
		String atualPopUp = driver.getWindowHandle();
		driver.findElement(By.id("buttonPopUpHard")).click();
		
		String novoPopUp = driver.getWindowHandle();
		//System.out.print(driver.getWindowHandle());
		//System.out.print(driver.getWindowHandles());
		driver.switchTo().window(novoPopUp);
		driver.findElement(By.tagName("textarea")).sendKeys("escrevendo em outra janela");
		driver.switchTo().window(atualPopUp);
		driver.findElement(By.tagName("textarea")).sendKeys("escrevendo em outra janela");
	}
}	
