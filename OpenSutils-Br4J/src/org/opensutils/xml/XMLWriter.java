package org.opensutils.xml;

import java.util.ArrayList;

public class XMLWriter {
	
	private StringBuilder xml ;
	private String tagRaizStart ;
	private String tagRaizEnd;
	private ArrayList<String> tags;/*Tags abertas pelo m�todo open*/
	
	/**
	 * Contrutor 
	 * 
	 * Cria um xml utilizando StringBuffer.
	 */
	public XMLWriter(String tagElement){
		xml = new StringBuilder();
		String schema = "";//sem xsdl
		this.tagRaizStart = tagElement;
		tagRaizEnd  = "</"+tagRaizStart.substring(1);
		tagRaizStart = tagRaizStart.substring(0, (tagRaizStart.length()-1)) + ""+ schema + ">";
		
		tags = new ArrayList<String>(3);
		this.clearXML();
	}
	
	
	/**
	 * M�todo para adicionar tags de erro no xml. 
	 * Retorna um xml com uma mensagem de erro, o conteudo do xml � apagado e gerado apenas a tag de erro
	 * Nome da tag criada: <erro>mensagem</erro>
	 * @see addError(String mensagem)
	 * @see WSConstantes
	 * @param msgError - mensagem para colocar entre as tags de erro. 
	 */
	public String getXMLError(String msgError){
		this.clearXML();
		this.addError(msgError);
		return xml.toString()+tagRaizEnd;
	}

	/**
	 * M�todo para adicionar tags de erro no xml.
	 * Nome da tag criada: <erro>msgError</erro>
	 * @see getXMLError(String mensagem)
	 * @see WSConstantes
	 * @param msgError - mensagem para colocar entre as tags de erro. 
	 */
	public void addError(String msgError){
		xml.append("<error><![CDATA[" + msgError + "]]></error>");
	}
	
	
	/**
	 *  M�todo para adicionar informa��es no xml, os dados s�o colocados dentro das tags. 
	 * � utilizado o CCDATA para deixar no formato original os dados no xml.
	 * @param tags - Nome das tags que ser�o criadas
	 * @param dados - Dados em formato texto que ser�o colocados dentro das tags, opcional
	 * quando null � criado uma tag vazia, sem dados.
	 * @see getXML()
	 */
	public void add(String tag, String dados){
		if(dados != null){
			xml.append(tag);
			xml.append("<![CDATA["+dados+"]]>");
			xml.append("</"+tag.substring(1));	
		}else
			xml.append(tag.substring(0, tag.length()-1)+"/>");	

	}
	
	
	/**
	 *  M�todo para adicionar informa��es no xml, os dados s�o colocados dentro das tags. 
	 * � utilizado o CDATA para deixar no formato original os dados no xml.
	 * @param tags - Nome das tags que ser�o criadas
	 * @param dados - boolean, � equivalente Boolean.toString(), os dados ficam em formato texto que ser�o colocados dentro das tags e � opcional
	 * quando null � criado uma tag vazia, sem dados.
	 * @see getXML()
	 * @see addRegistro(String tag, String dados)
	 */
	public void add(String tag, boolean dados){
		this.add(tag, Boolean.toString(dados));
	}

	public void add(String tag, double dados) {
		this.add(tag, Double.toString(dados));	
	}

	
	/**
	 *  M�todo para adicionar informa��es no xml, os dados s�o colocados dentro das tags. 
	 * 
	 * @param tags - Nome das tags que ser�o criadas
	 * @param dados - Dados em formato numerico que ser�o colocados dentro das tags.
	 * @see getXML()
	 */
	public void add(String tag, long dados){
			xml.append(tag);
			xml.append(dados);
			xml.append("</"+tag.substring(1));	
	}
	
	
	/**
	 * Fecha o xml aberto e retorna o xml de acordo com suas informa��es.
	 * 
	 * @return String - XML contendo informa��es.
	 */
	public String getXML(){
		return xml.toString()+tagRaizEnd;
	}
	
	
	/**
	 * Abre uma nova tag no xml, est� tag deve ser fechada pelo m�todo closeTag().
	 * @param tag - Tag que ser� aberta no xml.
	 * @see ActionXMLResponse.closeTag(String tag)
	 */
	public void openTag(String tag){
		tags.add(tag);
		xml.append(tag);
	}
	
	
	/**
	 * Fecha as ultimas tag que foram abertas pelo m�todo openTag(). 
	 * @param tag - Tag que ser� aberta no xml.
	 * @see ActionXMLResponse.openTag(String tag)
	 */
	public void closeTag(){
		if(tags.size() > 0){
			xml.append("</"+tags.get(tags.size()-1).substring(1));
			tags.remove(tags.size()-1);
		}
	}
	
	
	/**
	 * Limpa as informa��es dentro do xml e cria um novo sem informa��es.
	 */
	public void clearXML(){
		this.tags.clear();
		xml.delete(0, xml.length());//Limpando todo o StringBuffer
		xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		xml.append(tagRaizStart);		
	}
	
	
	public String toString(){
		return this.getXML();
	}

}
