BufferedFileReader

Está classe implementa a interface org.opensutils.io.FileReader e oferece métodos para facilitar a leitura de arquivos no formato texto, utilizando um Buffer para aumentar a performaçe da leitura.
Adicionado na versão 0.2

## Detalhes ##

Os métodos disponíveis nesta classe são:

<ul>
<li>clean()</li>
<li>close()</li>
<li>getCountReadLine()</li>
<li>nextLine()</li>
<li>open()</li>
<li>readAll()</li>
<li>setFile(File)</li>
<li>setFile(String)</li>
</ul>

### Exemplo de uso ###
```
try{
	 org.opensutils.io.FileReader reader = new org.opensutils.io.BufferedFileReader(new File("c:\\arquivo.txt"));
	 reader.open();
	 System.out.println(reader.nextLine());
	 System.out.println(reader.nextLine());
	 System.out.println(reader.nextLine());
	 System.out.println("Linhas lidas no arquivo :"+reader.getCountReadLine());//Print 3
	 reader.close();
	 reader.clean();
	}catch(IOException ioE){
		ioE.printStackTrace();
	}
```

**Informações dos métodos:**

<ul>
<li>
<h3>clean</h3>
<i>public void clean();</i>

Este método libera os recursos utilizado para ler um arquivo.<br>
É necessario chamar o método close() antes de invocar este método, para evitar que o arquivo fique aberto no disco.<br>
<br>
</li>
<li>
<h3>close</h3>
<i>public void close() throws IOException;</i>

Este método finaliza e libera o arquivo do uso para a leitura<br>
</li>

<li>
<h3>getCountReadLine</h3>
<i>public int getCountReadLine();</i>

Este método retorna a contagem de linhas que foram lidas do arquivo.<br>
<br>
</li>

<li>
<h3>nextLine</h3>
<i>public String nextLine() throws IOException;</i>

Faz a leitura de uma linha do arquivo e avança para a proxima linha. Retorna null quando não existir mais linhas.<br>
Necessario existir um arquivo setado e deve ser usado depois de invocar o método open()<br>
<br>
</li>

<li>
<h3>open</h3>
<i>public void open() throws FileNotFoundException ;</i>

Abre o arquivo para leitura.<br>
<br>
</li>

<li>
<h3>readAll</h3>
<i>public StringBuilder readAll() throws IOException;</i>

Faz a leitura total de um arquivo, é necessario que o método open() seja executado antes deste método.<br>
<br>
</li>

<li>
<h3>setFile</h3>
<i>public void setFile(File file);</i>
<i>public void setFile(String fileName);</i>

Seta um arquivo, aquele que será lido por esta classe.<br>
<br>
</li>


</ul>