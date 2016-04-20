# ZipUtils #

Está classe abstrata oferece métodos estáticos para comprimir e descomprimir arquivos no formato zip.

## Detalhes ##

Os métodos disponíveis nesta classe são:

<ul>
<li>compress(String, String, String)</li>
<li>compress(String<a href='.md'>.md</a>, String)</li>
<li>compress(String<a href='.md'>.md</a>, String<a href='.md'>.md</a>, String)</li>
<li>decompresses(File, File)</li>
</ul>

**Informações dos métodos:**

<ul>
<li>
<h3>compress</h3>
<i>public static File compress(String, String, String);</i>

<i>public static File compress(String<a href='.md'>.md</a>, String);</i>

<i>public static File compress(String<a href='.md'>.md</a>, String<a href='.md'>.md</a>, String);</i>

Este método comprimi os arquivos encontrados e retorna um unico arquivo compactado no formato zip;<br>
Exemplo:<br>
<pre><code>	String[] arr = {"c:\\felipe.priuli\\arquivoTeste1.txt","c:\\felipe.priuli\\arquivoTeste2.txt"};<br>
	String[] arrNomes = {"ARQUIVO1.txt","ARQUIVO2.txt"};<br>
	<br>
	File file = ZipUtils.compress(arr,arrNomes, "c:\\felipe.priuli\\ARQUIVOS.zip");<br>
</code></pre>

</li>
<li>
<h3>decompresses</h3>
<i>public static String decompresses(File, File);</i>

Este método descompacta todos os arquivos dentro de um arquivo compactado no formato zip e retorna os arquivos<br>
descompactados;<br>
Exemplo:<br>
<pre><code>	File[] files = ZipUtils.decompresses(	new File("c:\\felipe.priuli\\ARQUIVOS.zip"),<br>
						new File("c:\\felipe.priuli\\ARQUIVOS\\")<br>
					   );<br>
</code></pre>
</li>

</ul>