IOUtils

As funcionalidades desta classe servem para facilitar o uso e manuseio de funcionalidades de E/S.
Adicionado na versão 0.2

## Detalhes ##

As constantes disponíveis nesta classe são:
<ul>
<li>DIR_SEPARATOR : String contendo o separador de diretórios atual utilizado pelo S.O no momento da execução</li>
<li>DIR_SEPARATOR_UNIX : String contendo o separador de diretórios utilizado pelo Sistema Operacional UNIX</li>
<li>DIR_SEPARATOR_WINDOWS : String contendo o separador de diretórios utilizado pelo Sistema Operacional WINDOWS</li>
<li>LINE_SEPARATOR : String contendo os caracteres de quebra de linha atual utilizado pelo S.O no momento da execução</li>
<li>LINE_SEPARATOR_UNIX : String contendo os caracteres de quebra de linha utilizado pelo Sistema Operacional UNIX</li>
<li>LINE_SEPARATOR_WINDOWS : String contendo os caracteres de quebra de linha utilizado pelo Sistema Operacional WINDOWS</li>
</ul>

Os métodos disponíveis nesta classe são:

<ul>
<li>closeIgnore(Closeable)</li>
<li>closeIgnore(Socket)</li>
<li>copy(InputStream, OutputStream, int)</li>
<li>copy(Reader, Writer, int)</li>
<li>getExtension(String)</li>
<li>getNameFile(String)</li>
<li>removeExtension(String)</li>
<li>toString(InputStream, int)</li>
<li>toString(Reader, int)</li>
</ul>

**Informações dos métodos:**

<ul>
<li>
<h3>closeIgnore</h3>
<i>public static void closeIgnore(java.io.Closeable c)</i>
<i>public static void closeIgnore(java.net.Socket s)</i>

Esta classe invoca o método close de uma implementação de Closeable, e ignora possíveis exceções que possam ocorrer.<br>
Exemplo:<br>
<pre><code>	java.io.InputStream myInputStrean = getInputStream();<br>
	org.opensutils.io.IOUtils.close(myInputStrean);//no exceptions for closing<br>
<br>
</code></pre>

</li>
<li>
<h3>copy</h3>
<i>public static long copy(java.io.InputStream inputStream, java.io.OutputStream outputStream,int bufferSize) throws java.io.IOException</i>

Este método copia os dados de um InputStream em um OutputStream utilizando um tamanho definido de buffer, padrão = 1024<br>
<br>
</li>

<li>
<h3>copy</h3>
<i>public static long copy(	java.io.Reader input, java.io.Writer output,int bufferSize) throws java.io.IOException</i>

Este método copia os dados de um Reader em um Writer utilizando um tamanho definido de buffer, padrão = 1024<br>
</li>

<li>
<h3>getExtension</h3>
<i>public static String getExtension(final String filename)</i>

Este método obtém a extensão de uma String contendo o nome de arquivo.<br>
Exemplo:<br>
<pre><code>	String extension = org.opensutils.io.IOUtils.getExtension("c:\\my\\dir\\extensions\\file1.jpeg");<br>
	extension.equals("jpeg")); //is true<br>
</code></pre>
</li>

<li>
<h3>getNameFile</h3>
<i>public static String getNameFile(final String path)</i>

Este método obtém um nome de arquivo a partir de uma String.<br>
Exemplo:<br>
<pre><code>	String name = org.opensutils.io.IOUtils.getNameFile("/opt/jboss/server/default/conf/jboss-log4j");<br>
	name.equals("jboss-log4j")); //is true<br>
</code></pre>
</li>

<li>
<h3>removeExtension</h3>
<i>public static String removeExtension(final String filename)</i>

Este método remove a extensão de um nome de arquivo.<br>
Exemplo:<br>
<pre><code>	String extension = org.opensutils.io.IOUtils.removeExtension("h:\\file.rtf");<br>
	extension.equals("h:\\file"); //is true<br>
</code></pre>
</li>

<li>
<h3>toString</h3>
<i>public static String toString(	java.io.InputStream InputStream,int bufferSize) java.io.throws IOException</i>
<i>public static String toString(	java.io.Reader input,int bufferSize) throws java.io.IOException</i>

Este método obtém os dados de um InputStream e retorna em uma String.<br>
</li>

</ul>