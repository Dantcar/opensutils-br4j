BufferedFileWriterConverter

Esta classe implementa a interface org.opensutils.io.FileWriter e org.opensutils.io.FileWriterConverter e oferece métodos para facilitar a escrita de objetos java em arquivos no formato texto.
Esta classe utiliza um Buffer para aumentar a performance de gravação e e filha de BufferedFileWriter.
Adicionado na versão 0.2

## Detalhes ##

Os métodos disponíveis nesta classe são:

<ul>
<li>getLineConverter()</li>
<li>setLineConverter(LineConverter)</li>
<li>writer(Object)</li>
<li>writer(String<a href='.md'>.md</a>)</li>
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

## Usando o BufferedFileWriterConverter ##
```
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.opensutils.converter.C3POLineConverter;
import org.opensutils.converter.ConverterUtils;
import org.opensutils.converter.layout.FieldLayout;
import org.opensutils.converter.layout.Layout;
import org.opensutils.converter.layout.FieldLayout.TypePad;

public class BufferedFileWriterConvertIntegrationTest {

	public static void main(String[] args) {
		try{
			C3POLineConverter c = new C3POLineConverter(buildLayout());	
			FileWriterConverter writer = new org.opensutils.io.BufferedFileWriterConverter(new File("c:\\testObjectWriter.txt"), c);
			writer.open();
			
			writeHeader(writer);//00IHEADERheaderHEADEROTHERXXXXX
			
			writeDetail(writer);//1NOME_CLIENTE00001255VALUE000400050001.414/12/2010
	
			writer.flush();
			writer.close();
			
		}catch(Exception ioE){
			System.out.println(ioE.getMessage());
			ioE.printStackTrace();
		}
	}
	
	private static void writeDetail(FileWriterConverter writer) throws IOException {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2010, (12-1), 14, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		DetailMock m = new DetailMock(1255L,"NOME_CLIENTE",(short)1.4,(int)40005,"VALUE",calendar.getTime());
		
		writer.writer(m);
	}
	
	private static void writeHeader(FileWriterConverter writer) throws IOException {
		
		HeaderMock header = new HeaderMock("       HEADERheaderHEADER   "," OTHER ");
		writer.writer(header);
	}

	private static List<Layout> buildLayout() {
		List<Layout> layout = new ArrayList<Layout>(8);
		layout.add( new Layout(0,1,"1", DetailMock.class));//Initial 1 use this layout
		layout.get(0).getFields().add(new FieldLayout(1,13,"name"," ",ConverterUtils.buildConvertString()));
		layout.get(0).getFields().add(new FieldLayout(13,21,"id","0",ConverterUtils.buildConvertLong()));
		layout.get(0).getFields().add(new FieldLayout(21,26,"nameNull"," ",ConverterUtils.buildConvertString()));
		layout.get(0).getFields().add(new FieldLayout(34,40,"numberShort","0",ConverterUtils.buildConvertShort()));
		layout.get(0).getFields().add(new FieldLayout(21,26,"fieldNotGetMethod"," ",ConverterUtils.buildConvertString()));
		layout.get(0).getFields().add(new FieldLayout(26,34,"numberInteger","0", ConverterUtils.buildConvertInteger()));
		layout.get(0).getFields().add(new FieldLayout(40,50,"data"," ",ConverterUtils.buildConvertDate(new SimpleDateFormat("dd/MM/yyyy"))));
		
		layout.add( new Layout(0,2,"00",HeaderMock.class));//Initial 0 use this layout
		layout.get(1).getFields().add(new FieldLayout(2,21,"name","I",TypePad.LEFT_PAD,ConverterUtils.buildConvertString()));
		layout.get(1).getFields().add(new FieldLayout(21,31,"other","X",TypePad.RIGHT_PAD,ConverterUtils.buildConvertString()));
		
		return layout;
	}

}
@SuppressWarnings("unused")
class HeaderMock{
	private String name;
	private String other;
	
	public HeaderMock(String name, String other) {
		super();
		this.name = name;
		this.other = other;
	}
}
@SuppressWarnings("unused")
class DetailMock{
	private long id;
	private String name;
	private String nameNull = null;
	private short numberShort;
	private Integer numberInteger;
	public String fieldNotGetMethod;
	public Date data;
	
	public DetailMock(long id, String name,short numberShort,
			Integer numberInteger, String fieldNotGetMethod, Date data) {
		super();
		this.id = id;
		this.name = name;
		this.numberShort = numberShort;
		this.numberInteger = numberInteger;
		this.fieldNotGetMethod = fieldNotGetMethod;
		this.data = data;
	}
}
```

**Informações dos métodos:**

<ul>

<li>
<h3>write</h3>
public void writer(String<a href='.md'>.md</a> array) throws IOException, ConverterException</li>

Este método grava no arquivo um texto convertendo o vetor em uma linha de texto, utiliza um layout(LineConverter.java) para fazer esta conversao.<br>
<br>
<br>
<br>
Unknown end tag for </li><br>
<br>
<br>
<br>
<li>
<h3>write</h3>
<i>public void writer(Object object) throws IOException, ConverterException;</i>

Este método grava no arquivo um texto, convertendo um objeto em uma linha de texto, utiliza um layout(LineConverter.java) para fazer esta conversao.<br>
<br>
</li>


<li>
<h3>write</h3>
<i>public void writer(Object object) throws IOException, ConverterException;</i>

Este método grava no arquivo um texto, convertendo um objeto em uma linha de texto, utiliza um layout(LineConverter.java) para fazer esta conversao.<br>
<br>
</li>

<li>
<h3>setLineConverter</h3>
<i>public void setLineConverter(LineConverter converter);</i>

Este método seta o layout que irá converter os objetos java em linha de texto no arquivo<br>
<br>
</li>



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