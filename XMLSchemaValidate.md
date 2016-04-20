# XMLSchemaValidate #

Está classe oferece métodos para facilitar a verificação de arquivos xml para saber se o arquivo xml esta valido de acordo com um arquivo Schema XSD

## Detalhes ##

Os métodos disponíveis nesta classe são:

<ul>
<li>validateXML(File, String)</li>
<li>validateXML(InputStream, String)</li>
<li>validateXML(String, String)</li>
</ul>

**Informações dos métodos:**

<ul>
<li>
<h3>buildXMLWriter</h3>
<i>public static XMLWriter buildXMLWriter(String tagElement);</i>

Este método cria uma instancia de uma classe para facilitar a construção de um arquivo xml<br>
<br>
</li>
<li>
<h3>validateXML</h3>
<i>public static Document validateXML(File xmlFile, String urlSchema );</i>
<i>public static Document validateXML(InputStream inputStream, String urlSchema );</i>
<i>public static Document validateXML(String xmlSource, String urlSchema);</i>

Este método verifica se um xml está valido, esta seguindo todas as regras, de um XSD Schema, caso não seja valida lança uma exception chamada XMLException,<br>
se não existir erros retorna um org.w3c.dom.Document<br>
<br>
<pre><code>try {<br>
	StringBuffer xml = new StringBuffer();<br>
	xml.append("&lt;?xml version=\"1.0\" encoding=\"UTF-8\" ?&gt;");<br>
	xml.append("&lt;resultSet xmlns=\"file:///c:/OpenSutilsBr4J\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"file:///c:/OpenSutilsBr4J schemaValidatorTest.xsd\"&gt; ");<br>
	xml.append("&lt;detail&gt;"+System.getProperty("line.separator"));<br>
	xml.append("&lt;ddd&gt;11&lt;/ddd&gt;"+System.getProperty("line.separator"));<br>
	xml.append("&lt;phone&gt;31565700&lt;/phone&gt;"+System.getProperty("line.separator"));<br>
	xml.append("&lt;person&gt;Felipe&lt;/person&gt;"+System.getProperty("line.separator"));<br>
	xml.append("&lt;number&gt;0&lt;/number&gt;"+System.getProperty("line.separator"));				<br>
	xml.append("&lt;code&gt;SP&lt;/code&gt;"+System.getProperty("line.separator"));			<br>
	xml.append("&lt;/detail&gt;"+System.getProperty("line.separator"));<br>
	xml.append("&lt;/resultSet&gt;"+System.getProperty("line.separator"));<br>
<br>
	new XMLSchemaValidate().validateXML(xml.toString(),"file:///c:/OpenSutilsBr4J/schemaValidatorTest.xsd");<br>
} catch (XMLException e) {<br>
	for(XMLElementError error : e.getListErro())<br>
		System.out.println("Line: "+error.getRow() + " Columns: "+error.getColumn() +" Error:" +error.getError());<br>
}<br>
</code></pre>
Arquivo XSD Schema(c:/OpenSutilsBr4J/schemaValidatorTest.xsd) :<br>
<pre><code>&lt;?xml version="1.0" encoding="UTF-8"?&gt;<br>
&lt;xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" targetNamespace="file:///c:/OpenSutilsBr4J" xmlns="file:///c:/OpenSutilsBr4J" elementFormDefault="qualified"&gt;<br>
	&lt;xs:annotation&gt;<br>
		&lt;xs:documentation&gt;schemaValidatorTest.xsd	0.1	08/01/2011&lt;/xs:documentation&gt;<br>
	&lt;/xs:annotation&gt;<br>
	&lt;xs:simpleType name="dddType"&gt;<br>
		&lt;xs:restriction base="xs:string"&gt;<br>
			&lt;xs:pattern value="([0-9]{3}|[0-9]{2}|[0-9]{1})" /&gt;<br>
		&lt;/xs:restriction&gt;<br>
	&lt;/xs:simpleType&gt;<br>
	&lt;xs:simpleType name="phoneType"&gt;<br>
		&lt;xs:restriction base="xs:string"&gt;<br>
			&lt;xs:pattern value="([0-9]{8}|[0-9]{7})" /&gt;<br>
		&lt;/xs:restriction&gt;<br>
	&lt;/xs:simpleType&gt;<br>
	&lt;xs:simpleType name = "numberType"&gt;<br>
		&lt;xs:restriction base="xs:integer"&gt;<br>
			 &lt;xs:minInclusive value="0"/&gt;<br>
		&lt;/xs:restriction&gt;<br>
	&lt;/xs:simpleType&gt;<br>
	&lt;xs:simpleType name="codeType"&gt;<br>
		&lt;xs:restriction base="xs:string"&gt;<br>
			&lt;xs:maxLength value="2" /&gt;<br>
		&lt;/xs:restriction&gt;<br>
	&lt;/xs:simpleType&gt;	<br>
	&lt;xs:complexType name="detailType"&gt;<br>
		&lt;xs:sequence&gt;<br>
			&lt;xs:element name="ddd" type="dddType"/&gt;<br>
			&lt;xs:element name="phone" type="phoneType"/&gt;<br>
			&lt;xs:element name="person" type="xs:string"/&gt;<br>
			&lt;xs:element name="number" type="numberType"/&gt;<br>
			&lt;xs:element name="code" type="codeType"/&gt;<br>
		&lt;/xs:sequence&gt;<br>
	&lt;/xs:complexType&gt;<br>
	&lt;xs:complexType name="resultSetType"&gt;<br>
		&lt;xs:choice&gt;<br>
			&lt;xs:element name="detail" type="detailType" minOccurs="0" maxOccurs="unbounded" /&gt;<br>
		&lt;/xs:choice&gt;<br>
	&lt;/xs:complexType&gt;<br>
	&lt;xs:element name="resultSet" type="resultSetType" /&gt;<br>
&lt;/xs:schema&gt;<br>
</code></pre>
</li>

</ul>