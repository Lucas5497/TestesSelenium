package br.ce.lopes.core;
import static br.ce.lopes.core.DriverFactory.getDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	
	/*****  Área e campos de texto ****/
	public void escrever(By by, String texto) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}
	
	public void escrever(String id_campo, String texto) {
		
		getDriver().findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public String pegarValorDoCampo(String id_campo) {
		
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
	
	/****** Radio e Check ******/
	public void clicarRadio(String id) {
		
		getDriver().findElement(By.id(id)).click();	
	}
	
	public boolean verRadioMarcado (String id) {
		
		return getDriver().findElement(By.id(id)).isSelected();	
	}
	
	public void clicarCheckBox(String id) {
		
		getDriver().findElement(By.id(id)).click();	
	}
	 
	public boolean verCheckBoxMarcado(String id) {
		
		return getDriver().findElement(By.id(id)).isSelected();	
	}
	
	/****** Combo ******/
	public void selecionarCombo(String id, String valor) {
		
		WebElement elemento = getDriver().findElement(By.id(id)); 
		Select combo = new Select(elemento);
		combo.selectByVisibleText(valor);
	}
	
	public void deselecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}
	
	public String pegarValorCombo(String id) {
		
		WebElement elemento = getDriver().findElement(By.id(id));
		Select combo = new Select(elemento);
		return combo.getFirstSelectedOption().getText() ;
	}
	
	/****** Botões ******/
	
	public void clicarBotao(String id) {
		
		getDriver().findElement(By.id(id)).click();
	}
	
	
	public String obterValueElemento(String id){
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}
	
	/****** Link ******/
	
	
	public void clicarLink(String id) {
		
		getDriver().findElement(By.linkText(id)).click();
	}
	
	/****** Texto *****/
	
	
	public String pegarTexto(By by) {
		
		return getDriver().findElement(by).getText();
	}
	
	
	public String pegarTexto(String id) {
		return pegarTexto(By.id(id));
	}
	
	
	/****** Alerts ******/
	
	public String alertaObterTexto() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
	}
	
	public String alertaObterTextoAceitar() {
		
		Alert alert = getDriver().switchTo().alert();
		String texto = alert.getText();
		alert.accept();
		return texto;
	}
	
	public String alertaObterTextoNegar() {
		
		Alert alert = getDriver().switchTo().alert();
		String texto = alert.getText();
		alert.dismiss();
		return texto;
	}

	/***** Frames e Janelas *******/
	
	public void entrarFrame(String id_frame) {
		
		getDriver().switchTo().frame(id_frame);
	}
	
	public void sairFrame() {
		
		getDriver().switchTo().defaultContent();
	}
	
	public void trocarJanela(String id) {
		getDriver().switchTo().window(id);
	}
	/************ JS 
	 * @return ************/
	
	public Object executarJavaScript(String cmd, Object...param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(cmd, param);
		
	}
}
