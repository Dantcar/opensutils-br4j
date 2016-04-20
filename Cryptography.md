# Cryptography #

Está classe abstrata oferece métodos estáticos para criptografar valores utilizando Sha1 e Md5.

## Detalhes ##

Os métodos disponíveis nesta classe são:

<ul>
<li>toMD5(String)</li>
<li>toSHA1(String)</li>
</ul>

**Informações dos métodos:**

<ul>
<li>
<h3>toMD5</h3>
<i>public static String toMD5(String value);</i>

Este método criptograva uma String no algoraitmo de MD5<br>
Exemplo:<br>
<pre><code>	String senha = "senha";<br>
	Cryptography.toMD5(senha);<br>
</code></pre>

</li>

<li>
<h3>toSHA1</h3>
<i>public static String toSHA1(String value);</i>

Este método criptograva uma String no algoraitmo de SHA-1<br>
Exemplo:<br>
<pre><code>	String senha = "senha";<br>
	Cryptography.toSHA1(senha);<br>
</code></pre>
</li>

</ul>