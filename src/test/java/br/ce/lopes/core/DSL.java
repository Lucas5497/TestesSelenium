package br.ce.lopes.core;
import static br.ce.lopes.core.DriverFactory.getDriver;

import java.util.List;

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
	
/************** Tabela *********************/
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
		//procurar coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		//encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		//procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		//clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		celula.findElement(By.xpath(".//input")).click();
		
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}
}
