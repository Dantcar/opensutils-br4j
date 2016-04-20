# JSMin #

Está classe oferece funcionalidades para diminuir arquivos de JavaScript, minimizando o seu tamanho sem perder sua funcionalidade.
Está classe implementa a interface Minimizer, e foi modificada do original JSMin

## Detalhes ##

Os métodos disponíveis nesta classe são:

<ul>
<li>jsmin()</li>
<li>compress(File, File)</li>
<li>compress(InputStream, OutputStream)</li>
</ul>

**Informações dos métodos:**

<ul>
<li>
<h3>jsmin</h3>
<i>public void jsmin();</i>

Este método comprimi o codigo fonte de um JavaScript diminuindo o seu tamanho sem perder a sua funcionalidade.<br>
Exemplo:<br>
<pre><code>	JSMin jsmin = new JSMin(new FileInputStream("c:\\teste\\meuJs.js"), System.out);<br>
	jsmin.jsmin();<br>
	<br>
</code></pre>

</li>
<li>
<h3>compress</h3>
<i>public void compress(File in, File out);</i>

<i>public void compress(InputStream in, OutputStream out);</i>

Este método comprimi o codigo fonte de um JavaScript diminuindo o seu tamanho sem perder a sua funcionalidade.<br>
Exemplo:<br>
<pre><code>	Minimizer minimizer = new JSMin();<br>
	minimizer.compress(new File("c:\\teste\\meuJs.js"), new File("c:\\teste\\meuJs.min.js"));<br>
	<br>
</code></pre>
</li>

</ul>