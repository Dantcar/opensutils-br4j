# ZipFileCreator #

Está classe oferece métodos para comprimir arquivos no formato zip.

## Detalhes ##

Os métodos disponíveis nesta classe são:

<ul>
<li>addFile(FileInputStream, String)</li>
<li>close()</li>
<li>compress()</li>
<li>addDirectory(File dir) - <i>(ADICIONADO NA VERSÃO 0.2)</i></li>
</ul>

## Exemplo de uso ##
```

	ZipFileCreator zip = new ZipFileCreator();
	
	zip.addDirectory(new File("C:\\teste"));//adicionando o diretorio para dentro do zip.
	
	zip.addFile(new FileInputStream(new File("c:\\meuArquivo.txt")),"MeuArquivo.txt");//Adicionando um arquivo e alterando o nome no zip
	
	zip.compress();
	zip.close();

```


**Informações dos métodos:**
<ul>
<li>
<h3>addFile</h3>
<i>public void addFile(FileInputStream in, String fileName);</i>

Este método adiciona um arquivo para ser compactado dentro do zip.<br>
Exemplo:<br>
<pre><code>	FileInputStream in = this.getFileInput();<br>
	ZipFileCreator zip = new ZipFileCreator();<br>
	zip.addFile(in,"MeuArquivo.txt");<br>
	zip.compress();<br>
	zip.close();<br>
<br>
</code></pre>

</li>

<li>
<h3>addDirectory</h3>
<i>public void addDirectory(File dir) throws IOException</i>
Este método adiciona um diretorio e todos os diretorios dentro do diretorio para ser compactado dentro do zip<br>
Exemplo:<br>
<pre><code>	ZipFileCreator zip = new ZipFileCreator("C:\\dirZip.zip");<br>
	zip.addDirectory(new File("C:\\teste"));//adicionando o diretorio para dentro do zip.<br>
	zip.compress();//compactando<br>
	zip.close();//encerrando compactação.<br>
<br>
</code></pre>
</li>
<li>
<h3>compress</h3>
<i>public File compress();</i>

Este método compacta todos os arquivos que foram adicionado na classe.<br>
</li>
<li>
<h3>close</h3>
<i>public void close();</i>

Este método finaliza todos os arquivos manipulados pela classe.<br>
</li>


</ul>