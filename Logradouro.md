# Logradouro #

Está classe oferece métodos estáticos para manipular informações de logradouro, endereço.

## Detalhes ##

Os métodos disponíveis nesta classe são:

<ul>
<li>parseXmlTipoLogradouro(InputStream)</li>
<li>parseTipoLogradouro(String)</li>
<li>parseTipoLogradouro(String, List<b><TipoLogradouro</b>>)</li>
<li>removeTipoLogradouro(String)</li>
<li>removeTipoLogradouro(String, List<b><TipoLogradouro</b>>)</li>
<li>clean()</li>
</ul>

**Informações dos métodos:**

<ul>
<li>
<h3>parseTipoLogradouro</h3>
<i>public static List<b><TipoLogradouro</b>> parseXmlTipoLogradouro(InputStream in);</i>


Este método parsea as regras dos tipos de logradouros e retorna em uma lista de objetos de TipoLogradouro<br>
Exemplo:<br>
<pre><code>		<br>
	InputStream in = Logradouro.class.getResourceAsStream(FILE_NAME_CONF_TIPOS_LOGRADOUROS);<br>
	List*&lt;TipoLogradouro*&gt; tipoLogradouroList = Logradouro.parseXmlTipoLogradouro(in);<br>
	<br>
</code></pre>

</li>
<li>
<h3>parseTipoLogradouro</h3>
<i>public static String<a href='.md'>.md</a> parseTipoLogradouro(final String streetName,final List<b><TipoLogradouro</b>> tipoLogradouroList);</i>
<i>public String<a href='.md'>.md</a> parseTipoLogradouro(final String streetName);</i>

Este método parseia o tipo de logradouro de um endereço unificando o tipo de logradouro.<br>
Exemplo:<br>
<pre><code>	Logradouro logradouro = new Logradouro();<br>
	String[] resp = logradouro.parseTipoLogradouro("AV   SERGIO LANDULFO FURTADO                                                    ");<br>
	//resp[0] equals to: "AVENIDA"<br>
	//resp[1] equals to: "SERGIO LANDULFO FURTADO"<br>
	<br>
	resp = logradouro.parseTipoLogradouro("TV   VIEIRA");<br>
	//resp[0] equals to: "TRAVESSA"<br>
	//resp[1] equals to: "VIEIRA"<br>
</code></pre>

</li>
<li>
<h3>removeTipoLogradouro</h3>
<i>public String removeTipoLogradouro(final String streetName );</i>
<i>public String removeTipoLogradouro(final String streetName, List<b><TipoLogradouro</b>> list );</i>

Este método remove os tipos de logradouro de um endereço.<br>
Exemplo:<br>
<pre><code>Logradouro logradouro = new Logradouro();<br>
<br>
resp = logradouro.removeTipoLogradouro("R. Espártaco");<br>
//resp equals to: "Espártaco";<br>
<br>
resp = logradouro.removeTipoLogradouro("          AV SERGIO LANDULFO FURTADO   ");<br>
//resp equals to: "SERGIO LANDULFO FURTADO"<br>
<br>
</code></pre>
</li>
<li>
<h3>clean</h3>
<i>public void clean();</i>

Este método remove todas as instancias que a classe Logradouro está utilizando.<br>
Logradouro logradouro = new Logradouro();<br>
<br>
resp = logradouro.removeTipoLogradouro("R. Espártaco");<br>
//resp equals to: "Espártaco";<br>
<br>
resp = logradouro.removeTipoLogradouro("          AV SERGIO LANDULFO FURTADO   ");<br>
//resp equals to: "SERGIO LANDULFO FURTADO"<br>
<br>
}}}<br>
</li><br>
</ul></code></pre>