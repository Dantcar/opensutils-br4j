# StringUtils #

Está classe abstrata oferece métodos estáticos para utilização com a classe
java.lang.String do Java6+ afim de porporcionar funcionalidades para facilitar o
manuseio de textos.

## Detalhes ##

Os métodos disponíveis nesta classe são:

<ul>
<li>abbreviateName(String, int)</li>
<li>capitalize(String)</li>
<li>capitalizeAll(String)</li>
<li>ignoreEmpty(String)</li>
<li>leftPad(String, int, String)</li>
<li>parseNameFile(String)</li>
<li>remove(String, char...)</li>
<li>removeAccentuation(String)</li>
<li>removeSymbols(String)</li>
<li>rightPad(String, int, String)</li>
<li>truncateAndRightPad</li>
<li>truncateAndLeftPad</li>
<li>isNullOrEmpty</li>
<li>nullToEmpty</li>

</ul>


<ul>
<li>
<h3>abbreviateName</h3>
<i>public static String abbreviateName(String, int);</i>

Este método abrevia um nome completo diminuindo-o até a posição informada no segundo parâmetro deste método. A abreviação apenas é realizada no nome do meio(sobrenome) e apenas se o nome for maior que o tamanho definido.<br>
Exemplo:<br>
<pre><code>	String resp = StringUtils.abbreviateName("BARTOLOMEU SILVADOS SANTOS DIAS", 30);<br>
	//resp equals to: "BARTOLOMEU S. S. DIAS<br>
</code></pre>
</li>
<li>
<h3>capitalize</h3>
<i>public static String capitalize(final String value);</i>

Este método transforma a primeira letra, da primeira palavra do parâmetro, em maiúscula mantendo as<br>
<br>
outras letras como estão.<br>
</li>
<li>
<h3>capitalizeAll</h3>
<i>public static String capitalizeAll(final String value);</i>

Este método transforma todas as primeiras letras, de cada palavra, em maiúscula mantendo as outras letras como estão.<br>
</li>
<li>
<h3>ignoreEmpty</h3>
<i>public static String ignoreEmpty(final String value);</i>

Este metodo ignora valores vazios retornando null para estes casos.<br>
Exemplo:<br>
<pre><code>	StringUtils.ignoreEmpty("  ") == null //is true<br>
</code></pre>
</li>
<li>
<h3>leftPad</h3>
<i>public static String leftPad(String value, int size,String pad);</i>

Este método adiciona um texto(@param pad) do lado esquerdo do primeiro parâmetro (@param value) até preencher o tamanho(@param size)<br>
Exemplo:<br>
<pre><code>	String value = "2333";<br>
	String resp = StringUtils.leftPad(value,5,"R");<br>
	//resp equals to: "R2333"<br>
	<br>
	resp = StringUtils.leftPad(value,8," ");<br>
	//resp equals to: "    2333"<br>
</code></pre>
</li>
<li>
<h3>parseNameFile</h3>
<i>public static String parseNameFile(final String path);</i>

Este método obtém o nome de um arquivo a partir de um caminho completo de um arquivo(@param path)<br>
Exemplo:<br>
<pre><code>String result = StringUtils.parseNameFile("c:\\test\\file\\file1.txt"); <br>
//result equals to: "file1.txt"<br>
</code></pre>
</li>
<li>
<h3>remove</h3>
<i>public static String remove(final String value,char... charSymbols);</i>

Este método remove todos os caracteres do parâmetro 'value' que forem igual as caracteres do parametro 'charSymbols'<br>
</li>
<li>
<h3>removeAccentuation</h3>
<i>public static String removeAccentuation(final String value);</i>

Este método remove todas as acentuações das letras que tem acentuação.<br>
Exemplo:<br>
<pre><code>	String str = "SÃO PRAÇA JOSÉ É DAS";<br>
	//str equalst to : "SAO PRACA JOSE E DAS"<br>
</code></pre>
</li>
<li>
<h3>removeSymbols</h3>
<i>public static String removeSymbols(final String value);</i>

Este método remove todos os caracteres de símbolos, aqueles que não são numero e letras, a virgula(',') e ponto('.') são mantidos.<br>
</li>
<li>
<h3>rightPad</h3>
<i>public static String rightPad(	String value,int tamanho,String pad);</i>

Este metodo adiciona um texto(@param pad) do lado direito do primeiro parâmetro (@param value) até preencher o tamanho(@param size)<br>
Exemplo:<br>
<pre><code>	String value = "2525225252";<br>
	String resp = StringUtils.rightPad(value,14,"0");<br>
	//resp equals to: "25252252520000"<br>
</code></pre>
</li>
<li>
<h3>truncateAndRightPad</h3>
<i>public static String truncateAndRightPad(	String value,int maxLength, String pad);</i>

ADDICIONADO NA VERSÃO 0.2<br>
Este método formata uma String, truncando caso o 'value' for maior que o tamanho (@param maxLength) ou tambem adiciona (@param pad) do lado direito do primeiro parâmetro (@param value) até preencher o tamanho(@param maxLength)<br>
Exemplo:<br>
<pre><code>String value = StringUtils.truncateAndRightPad("VALOR", 12, "X"  );<br>
//value será igual a "VALORXXXXXXX" como que o tamanho é menor que 12 sera adicionado o caracter 'X' até preencher com 12 posições.<br>
<br>
<br>
value = StringUtils.truncateAndRightPad("   123456789", 5, " "  );<br>
//value será igual a "12345" , como o tamanho é maior que 5 o value será truncado até 5 posições<br>
</code></pre>
</li>
<li>
<h3>truncateAndLeftPad</h3>
<i>public static String truncateAndLeftPad(	String value,int maxLength, String pad);</i>

ADDICIONADO NA VERSÃO 0.2<br>
Este método formata uma String, truncando caso o 'value' for maior que o tamanho (@param maxLength) ou tambem adiciona (@param pad) do lado esquerdo do primeiro parâmetro (@param value) até preencher o tamanho(@param maxLength)<br>
Exemplo:<br>
<pre><code>String value = StringUtils.truncateAndLeftPad("VALOR", 12, "X"  );<br>
//value será igual a "XXXXXXXVALOR" como que o tamanho é menor que 12 sera adicionado o caracter 'X' até preencher com 12 posições do lado esquerdo.<br>
<br>
<br>
value =  StringUtils.truncateAndLeftPad("123456789", 20, "0"  );<br>
//value será igual a "00000000000123456789" <br>
</code></pre>
</li>
<li>
<h3>nullToEmpty</h3>
<i>public static String nullToEmpty(final String value)</i>
<i>public static String nullToEmpty(final String value, boolean trim)</i>

Este método quando receber um valor null ele retorna uma String vazia.<br>
</li>
<li>
<h3>isNullOrEmpty</h3>
<i>public static boolean isNullOrEmpty(final String value)</i>

Este método verifica se um texto é vazio ou nulo. Caso for retorna verdadeiro.<br>
</li>

</ul>