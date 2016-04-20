BufferedFileWriter

Esta classe implementa a interface org.opensutils.io.FileWriter e oferece métodos para facilitar a escrita de informações em arquivos no formato texto.
Esta classe utiliza um Buffer para aumentar a performance de gravação.
Adicionado na versão 0.2

## Detalhes ##

Os métodos disponíveis nesta classe são:

<ul>
<li>breakLine()</li>
<li>clean()</li>
<li>close()</li>
<li>flush()</li>
<li>getFile()</li>
<li>isFlushAll()</li>
<li>isOpen()</li>
<li>open()</li>
<li>setFile(File)</li>
<li>setFile(String)</li>
<li>setFlushAll(boolean)</li>
<li>write(String)</li>
<li>writeLine(String)</li>
</ul>

## EXEMPLO ##
```
	try{
		 org.opensutils.io.FileWriter writer = new org.opensutils.io.BufferedFileWriter(new File("c:\\arquivo.txt"));
		 writer.open();//INICIA O PROCESSO DE GRAVAÇÃO
		 writer.writeLine("teste 1");//GRAVA O TEXTO 'teste 1' no arquivo
		 writer.writeLine("teste 2");//GRAVA O TEXTO 'teste 2' no arquivo
		 writer.writeLine("teste 3");//GRAVA O TEXTO 'teste 3' no arquivo
		 writer.flush();//FORÇA A GRAVAÇÃO
		 writer.close();//FINALIZA
	}catch(IOException ioE){
		ioE.printStackTrace();
	}
```

**Informações dos métodos:**

<ul>

<li>
<h3>write</h3>
<i>public void write(String data) throws IOException;</i>

Este método grava no arquivo um texto, aquele recebido no parâmetro 1 no método ('data')<br>
<br>
</li>

<li>
<h3>writeLine</h3>
<i>public void writeLine(String data) throws IOException;</i>

Este método grava no arquivo um texto, aquele recebido no parâmetro 1 no método ('data')<br>
e após gravar, adiciona uma quebra de linha.<br>
<br>
<br>
</li>

<li>
<h3>breakLine</h3>
<i>public void breakLine() throws IOException;</i>

Este método adiciona uma quebra de linha no arquivo.<br>
</li>

<li>
<h3>clean</h3>
<i>public void clean();</i>

Este método libera os recursos utilizados para gravar informações em um arquivo.<br>
É necessário chamar o método close() antes de invocar este método, para evitar que o arquivo fique aberto no disco.<br>
<br>
</li>

<li>
<h3>close</h3>
<i>public void close() throws IOException;</i>

Este método finaliza e libera o arquivo do uso para gravação<br>
</li>

<li>
<h3>flush</h3>
<i>public void flush() throws IOException;</i>

Este método força a liberação de memória e gravação das informações em um arquivo.<br>
</li>

<li>
<h3>setFlushAll</h3>
<i>public void setFlushAll(boolean flushAll) throws IOException;</i>

Seta o tipo de flush a ser utilizado, se true após uma chamada do método writer ó método flush() é invocado automaticamente.<br>
false para não chamar o método flush() após o writer.<br>
</li>


<li>
<h3>open</h3>
<i>public void open() throws FileNotFoundException ;</i>

Abre o arquivo para gravação.<br>
<br>
</li>

<li>
<h3>setFile</h3>
<i>public void setFile(File file);</i>
<i>public void setFile(String fileName);</i>

Seta um arquivo, aquele que será utilizado para gravar as informações recebidas pelo método writer.<br>
<br>
</li>


</ul>