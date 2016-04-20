# HexaDecimalUtils #

Está classe oferece métodos estáticos para converter valores em HexaDecimal

## Detalhes ##

Os métodos disponíveis nesta classe são:

<ul>
<li>toByte(String)</li>
<li>toByteArray(String)</li>
<li>toString(byte)</li>
<li>toString(byte<a href='.md'>.md</a>)</li>
</ul>

**Informações dos métodos:**

<ul>
<li>
<h3>toByte</h3>
<i>public static final byte toByte(final String strHexa);</i>

<i>public static final byte<a href='.md'>.md</a> toByteArray(final String strHexa);</i>

Este método converte uma String hexadecimal em um vetor de bytes(String)<br>
Exemplo:<br>
<pre><code>		byte[] bytes = HexaDecimalUtils.toByteArray("47656E65726174657320612068657861646563696D616C20537472696E67");<br>
		String resp = new String(bytes);<br>
		//resp equals to: "Generates a hexadecimal String"<br>
</code></pre>

</li>
<li>
<h3>toString</h3>
<i>public static final String toString(final byte bits);</i>

<i>public static final String toString(final byte<a href='.md'>.md</a> bytes);</i>

Este método converte um vetor de bytes(String) em uma String HexaDecimal<br>
descompactados;<br>
Exemplo:<br>
<pre><code>		String resp = HexaDecimalUtils.toString("Generates a hexadecimal String".getBytes());<br>
<br>
		//resp equals to: "47656E65726174657320612068657861646563696D616C20537472696E67"<br>
		<br>
</code></pre>
</li>

</ul>