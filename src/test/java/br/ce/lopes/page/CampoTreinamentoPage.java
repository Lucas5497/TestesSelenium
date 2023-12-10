package br.ce.lopes.page;
import br.ce.lopes.core.DSL;

public class CampoTreinamentoPage {

	private DSL dsl;
			
			
	public CampoTreinamentoPage() {
		dsl = new DSL();
		
	}
	
	
	String nomeElement = "elementosForm:nome";
	
	
	public void setNome(String nome) {
		dsl.escrever(nomeElement, nome);
	}
	
	public void setSobrenome(String sobrenome) {
		dsl.escrever("elementosForm:sobrenome", sobrenome);
	}
	
	public void setSexoMasculino() {
		dsl.clicarRadio("elementosForm:sexo:0");
	}
	
	public void setSexoFeminino() {
		dsl.clicarRadio("elementosForm:sexo:1");
	}
	
	public void setComidaCarne() {
		dsl.clicarCheckBox("elementosForm:comidaFavorita:0");
	}
	
	public void setComidaFrango() {
		dsl.clicarCheckBox("elementosForm:comidaFavorita:1");
	}
	
	public void setComidaPizza() {
		dsl.clicarCheckBox("elementosForm:comidaFavorita:2");
	}
	
	public void setComidaVegetariano() {
		dsl.clicarCheckBox("elementosForm:comidaFavorita:3");
	}
	
	public void setEscolaridade(String escolaridade) {
		dsl.selecionarCombo("elementosForm:escolaridade", escolaridade);
	}
	
	public void setEsporte(String... esportes) {
		for(String esporte: esportes)
			dsl.selecionarCombo("elementosForm:esportes", esporte);
	}
	
	public void setSugestoes(String sugestoes) {
		dsl.escrever("elementosForm:sugestoes", sugestoes);
	}
	
	public void cadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}
	
	public String obterResultadoCadastro() {
		return dsl.pegarTexto("resultado");
	}
	
	public String obterNomeCadastrado() {
		return dsl.pegarTexto("descNome");
	}
	
	public String obterSobrenomeCadastrado() {
		return dsl.pegarTexto("descSobrenome");
	}
	
	public String obterSexoCadastrado() {
		return dsl.pegarTexto("descSexo");
	}
	
	public String obterComidaCadastrado() {
		return dsl.pegarTexto("descComida");
	}
	
	public String obterEscolaridadeCadastrado() {
		return dsl.pegarTexto("descEscolaridade");
	}
	
	public String obterEsporteCadastrado() {
		return dsl.pegarTexto("descEsportes");
	}
	
	public String obterSugestoesCadastradas() {
		return dsl.pegarTexto("descSugestoes");
	}
	
}
