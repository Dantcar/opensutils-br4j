RomanNumber

Está classe oferece métodos para converter numeros inteiros em numeros romanos.
Adicionado na versão 0.2

## Detalhes ##

Os métodos disponíveis nesta classe são:

<ul>
<li>format(int)</li>
<li>parse(String)</li>
<li>isValid(String)</li>
</ul>

**Informações dos métodos:**

<ul>
<li>
<h3>format</h3>
<i>public static String format(final int</i>decimal);<br>
<br>
Este método formata um numero inteiro na base decimal para uma String representando o valor em numero romano.<br>
Exemplo:<br>
<pre><code>	RomanNumber.format(18).equals("XVIII")//is true<br>
<br>
</code></pre>

</li>
<li>
<h3>parse</h3>
<i>public static int parse(String romanNumber);</i>

Este método converte um numero romano em um numero inteiro.<br>
Exemplo:<br>
<pre><code>	RomanNumber.parse("LIV")== 54//is true<br>
<br>
</code></pre>
</li>

<li>
<h3>isValid</h3>
<i>public static boolean isValid(final String romanNumber);</i>

Este método verifica se uma String está no formato de numero romano.<br>
Exemplo:<br>
<pre><code>	 RomanNumber.isValid("XIV") //is true<br>
	 RomanNumber.isValid("x") //is faLse<br>
<br>
</code></pre>
</li>

</ul>