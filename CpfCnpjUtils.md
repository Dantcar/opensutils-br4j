# CpfCnpjUtils #

Está classe abstrata oferece métodos estáticos para validação, formatação de Cpf e Cnpj
afim de proporcionar funcionalidades para facilitar tais validações.

## Detalhes ##

Os métodos disponíveis nesta classe são:

<ul>
<li>cnpjToString(long)</li>
<li>cnpjToString(String)</li>
<li>cpfCnpjToString(long)</li>
<li>cpfCnpjToString(String)</li>
<li>cpfToString(long)</li>
<li>cpfToString(String)</li>
<li>formatCnpj(long)</li>
<li>formatCnpj(String)</li>
<li>formatCpf(long)</li>
<li>formatCpf(String)</li>
<li>formatCpfOrCnpj(long)</li>
<li>isValidCnpj(long)</li>
<li>isValidCnpj(String)</li>
<li>isValidCpf(long)</li>
<li>isValidCpf(String)</li>
<li>isValidCpfOrCnpj(long)</li>
<li>isValidCpfOrCnpj(String)</li>
</ul>

**Informações dos métodos:**

<ul>
<li>
<h3>cnpjToString</h3>
<i>public static String cnpjToString(final long cnpj);</i>
<i>public static String cnpjToString(final String cnpj);</i>

Este método converte um numero de cnpj em texto sem formatação;<br>
Este método não faz verificação da validação do cpf.<br>
Exemplo:<br>
<pre><code>	String resp = CpfCnpjUtils.cnpjToString(245526522L);<br>
	resp.equals("00000245526522") // is true<br>
</code></pre>

</li>
<li>
<h3>cpfCnpjToString</h3>
<i>public static String cpfCnpjToString(final long cpfCnpj);</i>
<i>public static String cpfCnpjToString(final String cpfCnpj);</i>

Este método converte um numero de cpf ou cnpj em texto sem formatação;<br>
Este método faz uma verificação na validação do parm1 para identificar o tipo de formatação.<br>
Exemplo:<br>
<pre><code>	String resp = CpfCnpjUtils.cpfCnpjToString(689165234L);//is valid cpf<br>
	resp.equals("00689165234") // is true<br>
</code></pre>
</li>
<li>
<h3>cpfToString</h3>
<i>public static String cpfToString(final long cpfCnpj);</i>
<i>public static String cpfToString(final String cpf);</i>

Este método converte um numero de cpf em texto sem formatação;<br>
Este método não faz verificação da validação do cpf.<br>
Exemplo:<br>
<pre><code>		resp = CpfCnpjUtils.cpfToString("554444");<br>
		resp.equals("00000554444") //is true<br>
</code></pre>
</li>
<li>
<h3>formatCnpj</h3>
<i>public static String formatCnpj(final long cnpj);</i>
<i>public static String formatCnpj(final String cnpj);</i>

Este método converte um numero, ou string no formato de cnpj valido.<br>
Este método não faz verificação da validação do cpf.<br>
Exemplo:<br>
<pre><code>	String resp = CpfCnpjUtils.formatCnpj("00245526522");<br>
	//resp equals to: "00.000.245/5265-22<br>
<br>
</code></pre>
</li>
<li>
<h3>formatCpf</h3>
<i>public static String formatCpf(final long cpf);</i>
<i>public static String formatCpf(final String cpf);</i>

Este método converte um numero, ou string no formato de cpf valido.<br>
Este método não faz verificação da validação do cpf.<br>
Exemplo:<br>
<pre><code>	resp = CpfCnpjUtils.formatCpf("124244");<br>
	////resp equals to: "000.001.242-44"<br>
<br>
</code></pre>
</li>
<li>
<h3>formatCpfOrCnpj</h3>
<i>public static String formatCpfOrCnpj(final long cpfCnpj);</i>

Este método converte um long no formato de um cpf ou cnpj.<br>
O parâmetro deve ser um cpf ou cnpj valido para identificação do mesmo na formatação, este<br>
método faz uma verificação da validação de um cpf para identificar a sua formatação.<br>
Exemplo:<br>
<pre><code>	resp = CpfCnpjUtils.formatCpf("124244");<br>
	////resp equals to: "000.001.242-44"<br>
<br>
</code></pre>
</li>
<li>
<h3>isValidCnpj</h3>
<i>public static boolean isValidCnpj(long cnpj);</i>
<i>public static boolean isValidCnpj(final String cnpj);</i>

Este método verifica se um cnpj é valido de acordo com o algoritmo de validação de cnpj.<br>
Exemplo:<br>
<pre><code>	boolean resp = CpfCnpjUtils.isValidCnpj("04312419000130");//CNPJ valido<br>
	//resp equals to: true<br>
	<br>
	resp = CpfCnpjUtils.isValidCnpj("043blabla131");//CNPJ invalido<br>
	//resp equals to: false<br>
<br>
</code></pre>
</li>
<li>
<h3>isValidCpf</h3>
<i>public static boolean isValidCpf(final long cpf);</i>
<i>public static boolean isValidCpf(final String cpf);</i>

Este método verifica se um cpf(@param1) é valido de acordo com o algoritmo de validação de cpf.<br>
Exemplo:<br>
<pre><code>	resp = CpfCnpjUtils.isValidCpf("33596438950");//Cpf valido<br>
	//resp equals to: true<br>
	<br>
	resp = CpfCnpjUtils.isValidCpf("33596438951");//Cpf invalido<br>
	//resp equals to: false<br>
<br>
</code></pre>
</li>
<li>
<h3>isValidCpfOrCnpj</h3>
<i>public static boolean isValidCpfOrCnpj(final long cpfCnpj);</i>
<i>public static boolean isValidCpfOrCnpj(final String cpfCnpj);</i>

Este método verifica se um long ou String é um cpf ou cnpj valido de acordo com o algoritmo de<br>
validação de cpf ou cnpj.<br>
Exemplo:<br>
<pre><code>	resp = CpfCnpjUtils.isValidCpfOrCnpj("33596438950");//Cpf valido<br>
	//resp equals to: true (is valid cpf)<br>
	<br>
	resp = CpfCnpjUtils.isValidCpfOrCnpj("04312419000130");//CNPJ valido<br>
	//resp equals to: true (is valid cnpj)<br>
	<br>
	resp = CpfCnpjUtils.isValidCpfOrCnpj("04312419000131");//CNPJ invalido<br>
	//resp equals to: false (not cpf and not cpnj valid)<br>
</code></pre>
</li>



</ul>