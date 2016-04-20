BufferedFileReaderConverter

Esta classe implementa a interface org.opensutils.io.FileReaderConverter e extende a classe BufferedFileReader, para oferecer métodos para converter a leitura de arquivos  texto para Objetos Java atraves de Reflection.
Esta classe utiliza um Buffer para armazenar as informações lidas de um arquivo.
Adicionado na versão 0.2

## Detalhes ##

Os métodos disponíveis nesta classe são:

<ul>
<li>clean()</li>
<li>close()</li>
<li>getCountReadLine()</li>
<li>nextLineInObject()</li>
<li>nextLine()</li>
<li>open()</li>
<li>readAll()</li>
<li>setFile(File)</li>
<li>setFile(String)</li>
<li>getLineConverter()</li>
<li>setLineConverter(LineConverter)</li>

</ul>

### Exemplo de uso ###
```

	try{
		List<org.opensutils.converter.layout.Layout> layout = new ArrayList<org.opensutils.converter.layout.Layout>(3);
		layout.add( new Layout(0,1,"1", MyObjectReader.class));//Definindo a linha que começa com "1" para ser convertivo para o objeto MyObjectReader.class
		layout.get(0).getFields().add(new FieldLayout(1,13,"name",ConverterUtils.buildConvertString()));//Definindo os campos que devem ser preenchidos no objeto MyObjectReader.class
		layout.get(0).getFields().add(new FieldLayout(13,21,"id",ConverterUtils.buildConvertLong()));
		
		layout.add( new Layout(0,1,"2", MyObjectReader.class));//Definindo a linha que começa com "2" para ser convertivo para o objeto MyObjectDetail.class
		layout.get(0).getFields().add(new FieldLayout(1,13,"name",ConverterUtils.buildConvertString()));//Definindo os campos que devem ser preenchidos no objeto MyObjectDetail
		layout.get(0).getFields().add(new FieldLayout(13,23,"data",ConverterUtils.buildConvertDate(new SimpleDateFormat("dd/MM/yyyy"))));
		layout.get(0).getFields().add(new FieldLayout(false,27,38,"numberInteger",ConverterUtils.buildConvertInteger()));
	
		layout.add( new Layout(0,1,"9", MyObjectReader.class));//Definindo a linha que começa com "9" para ser convertivo para o objeto MyObjectTrailler.class
		layout.get(0).getFields().add(new FieldLayout(1,13,"name",ConverterUtils.buildConvertString()));//Definindo os campos que devem ser preenchidos no objeto MyObjectTrailler.class
		layout.get(0).getFields().add(new FieldLayout(13,21,"id",ConverterUtils.buildConvertLong()));
		
		org.opensutils.io.FileReader reader = new org.opensutils.io.BufferedFileReaderConverter( new C3POLineConverter(layout) );
	
		 reader.open();
		 //O Converter 'C3POLineConverter' ira converter uma linha String do arquivo em um Objeto.
		 System.out.println(reader.nextLineInObject() instanceof MyObjectReader); // true
		 System.out.println(reader.nextLineInObject()  instanceof MyObjectDetail); // true
		 System.out.println(reader.nextLineInObject()  instanceof MyObjectDetail); // true
		 System.out.println(reader.nextLineInObject() instanceof MyObjectTrailler); // true
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
<h3>nextLineInObject</h3>
<i>public Object nextLineInObject()</i>

Lê a proxima linha do arquivo convertendo a linha para um Objecto Java.<br>
<br>
</li>

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

<li>
<h3>getLineConverter</h3>
<i>public LineConverter getLineConverter()</i>

Obtem o Layout que sera utilizado para converter uma linha de texto para um Objeto<br>
<br>
</li>

<li>
<h3>setLineConverter</h3>
<i>public void setLineConverter(LineConverter)</i>

Seta o Layout que sera utilizado para converter uma linha de texto para um Objeto<br>
<br>
</li>

</ul>