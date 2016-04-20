# FTPApacheCommonsNetImpl #

Está classe implementa a interface FTP do OpenSutils e oferece métodos para facilitar a copia de arquivos
para um servidor ftp atraves das bibliotecas da Apache Commons Net.

Está classe precisa da lib: commons-net-1.4.1.jar ou superior para funcionar e pode ser obtida em
http://commons.apache.org/net/download_net.cgi

## Detalhes ##

Os métodos disponíveis nesta classe são:

<ul>
<li>copyFileToHost(File, String)</li>
<li>copyFileToHost(File, String, String)</li>
<li>copyFileToHost(InputStream, String, String)</li>
<li>copyFileToHost(String, String)</li>
<li>createDirectory(String)</li>
<li>deleteDirectory(String)</li>
<li>deleteFile(String, String)</li>
<li>getAttemptsCount()</li>
<li>getFile(String)</li>
<li>getFile(String, String)</li>
<li>getFileType()</li>
<li>listFilesFromHost(String)</li>
<li>setAttemptsCount(int)</li>
<li>setFileType(FILE_TYPE)</li>
</ul>

**Informações dos métodos:**

<ul>
<li>
<h3>copyFileToHost</h3>
<i>public boolean copyFileToHost(File file,String dirHost);</i>
<i>public boolean copyFileToHost(	String pathFile,String dirHost);</i>
<i>public boolean copyFileToHost(	File file, String fileName, String dirHost);</i>
<i>public boolean copyFileToHost(InputStream inputStream, String fileName, String dirHost);</i>

Este método copia arquivos para um servidor ftp.<br>
<br>
</li>
<li>
<h3>createDirectory</h3>
<i>public boolean createDirectory(String newDir);</i>

Este método cria uma pasta no servidor ftp conectado<br>
</li>
<li>
<h3>deleteDirectory</h3>
<i>public boolean deleteDirectory(String dir);</i>

Este método excluir uma pasta no servidor ftp conectado<br>
</li>
<li>
<h3>deleteFile</h3>
<i>public boolean deleteFile(String dirHost, String fileName );</i>

Este método excluir um arquivo no servidor ftp conectado<br>
</li>
<li>
<h3>getAttemptsCount</h3>
<i>public int getAttemptsCount();</i>

Este método obtém a quantidade máxima de tentativas caso haja algum problema com a comunicação com o<br>
servidor ftp<br>
</li>
<li>
<h3>getFile</h3>
<i>public File getFile(String fileName);</i>
<i>public File getFile(String dirHost,String fileName);</i>

Este método obtem um arquivo do servidor ftp conectado.<br>
</li>
<li>
<h3>getFileType</h3>
<i>public FILE_TYPE getFileType();</i>

Este método obtém o tipo binário que será utilizado para copiar e obter arquivos do servidor ftp.<br>
@see	FTP.FILE_TYPE.BINARY<br>
@see 	FTP.FILE_TYPE.ASCII<br>
</li>
<li>
<h3>listFilesFromHost</h3>
<i>public String<a href='.md'>.md</a> listFilesFromHost(String dirHost);</i>

Este método obtém todos os nomes dos arquivos, que estão em uma pasta do servidor ftp concitado.<br>
<br>
</li>
<li>
<h3>setAttemptsCount</h3>
<i>public void setAttemptsCount(int attemptsCount);</i>

Este método seta a quantidade máxima de tentativas para quando ocorrer erros de comunicação com o<br>
servidor ftp conectado.<br>
<br>
</li>
<li>
<h3>setFileType</h3>
<i>public void setFileType(FILE_TYPE fileType);</i>

Este método seta o tipo binário que será utilizado para copiar e obter arquivos do servidor ftp.<br>
@see	FTP.FILE_TYPE.BINARY<br>
@see 	FTP.FILE_TYPE.ASCII<br>
</li>

</ul>