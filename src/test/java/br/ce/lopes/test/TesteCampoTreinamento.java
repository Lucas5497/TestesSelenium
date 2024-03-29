package br.ce.lopes.test;
import static br.ce.lopes.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.ce.lopes.core.BaseTest;
import br.ce.lopes.core.DSL;

public class TesteCampoTreinamento extends BaseTest{
	
	private DSL dsl;
	
	String url = "https://wcaquino.me/selenium/componentes.html";
	@Before
	public void inicializa() throws InterruptedException {
		getDriver().get(url);
		Thread.sleep(2000);
		dsl = new DSL();
	}

	@Test
	public void testetTextField() {
		
		dsl.escrever("elementosForm:nome", "teste de escrita");	
		Assert.assertEquals("teste de escrita", dsl.pegarValorDoCampo("elementosForm:nome"));
	}

	@Test
	public void interagirComTextArea() {
		
		dsl.escrever("elementosForm:sugestoes", "testes\n\nselenium\n\nultimalinha\n\n\nops tem mais uma rsrs");
	}
	
	@Test
	public void interagirComRadioButton() {
		
		dsl.clicarRadio("elementosForm:sexo:0");
		Assert.assertTrue(dsl.verRadioMarcado("elementosForm:sexo:0"));
	}
	
	@Test
	public void interagirComCheckBox() {
		
		dsl.clicarCheckBox("elementosForm:comidaFavorita:0");
		Assert.assertTrue(dsl.verCheckBoxMarcado("elementosForm:comidaFavorita:0"));
	}
	
	@Test
	public void interagirComCombo() {
		
		dsl.selecionarCombo("elementosForm:escolaridade", "Mestrado");
		Assert.assertEquals("Mestrado", dsl.pegarValorCombo("elementosForm:escolaridade"));
	}
	
	@Test
	public void verificarValoresDoCombo() {
		 
		WebElement elemento = getDriver().findElement(By.id("elementosForm:escolaridade"));
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
		WebElement elemento = getDriver().findElement(By.id("elementosForm:esportes"));
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
	public void interagirComFrame() {
		
		dsl.entrarFrame("frame1");
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertaObterTextoAceitar(); 
		Assert.assertEquals("Frame OK!",msg);
		dsl.sairFrame();
		dsl.escrever("elementosForm:nome", msg);
	}
	
	@Test 
	public void interagirComJanela() {
		getDriver().findElement(By.id("buttonPopUpEasy")).click();
		getDriver().switchTo().window("Popup");
		getDriver().findElement(By.tagName("textarea")).sendKeys("Vai dar certo");
		getDriver().close();
		getDriver().switchTo().window("");
		
	}
	
	@Test
	public void interagirComJanelaSemNome() {
		String atualPopUp = getDriver().getWindowHandle();
		getDriver().findElement(By.id("buttonPopUpHard")).click();
		
		String novoPopUp = getDriver().getWindowHandle();
		//System.out.print(getDriver().getWindowHandle());
		//System.out.print(getDriver().getWindowHandles());
		getDriver().switchTo().window(novoPopUp);
		getDriver().findElement(By.tagName("textarea")).sendKeys("escrevendo em outra janela");
		getDriver().switchTo().window(atualPopUp);
		getDriver().findElement(By.tagName("textarea")).sendKeys("escrevendo em outra janela");
	}
	
	/*@Test
	public void testJavaStcript() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("alert('Testando JavaScript via Selenium')");
		Thread.sleep(1000);
	}*/
}	
