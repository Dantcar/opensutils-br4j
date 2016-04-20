# ReflectUtils #

Está classe oferece métodos estáticos para manipular objetos atraves de java Reflection.

## Detalhes ##

Os métodos disponíveis nesta classe são:

<ul>
<li>clone(Class<b><T</b>>, T)</li>
<li>generateNameGetClass(Class)</li>
<li>generateNameGetMethod(Field)</li>
<li>generateNameGetMethod(String)</li>
<li>generateNameSetMethod(Field)</li>
<li>generateNameSetMethod(String)</li>
<li>getValuesInCollection(Collection, String) //adicionado na versão 0.2</li>
<li>getIdsFieldInCollection(Collection)</li>
<li>isWrapperPrimitive(Object)</li>
<li>toString(Object, boolean)</li>
<li>toString(Object, boolean, boolean)</li>
</ul>

**Informações dos métodos:**

<ul>
<li>
<h3>clone</h3>
<i>public static <b><T</b>> T clone(Class<b><T</b>> entityClass,final T obj) ;</i>


Este método cria uma nova instancia de uma classe copiando todas as informações de uma classe para outra utilizando<br>
reflection. É necessario que exista um contrutor default.<br>
Exemplo:<br>
<pre><code>		<br>
	MockClass mockClass = this.getMyClass();<br>
		<br>
	MockClass result = ReflectUtils.clone(MockClass.class, mockClass);<br>
	<br>
	//result == mockClass is false<br>
	//(result 'value fields' equals to: 'mockClass value fields') -&gt; is true<br>
	<br>
</code></pre>

</li>
<li>
<h3>generateNameGet<b></h3>
<i>public static String generateNameGetClass(Class c);</i>
<i>public static String generateNameGetMethod(Field field);</i>
<i>public static String generateNameGetMethod(String fieldName);</i></b>

Este método obtem o nome da classe/campo.<br>
Exemplo:<br>
<pre><code>	ReflectUtils.generateNameGetClass(MockClass.class)<br>
	.equals("mockClass")//is true<br>
</code></pre>

</li>
<li>
<h3>generateNameSet<b></h3>
<i>public static String generateNameSetMethod(Field field);</i>
<i>public static String generateNameSetMethod(String fieldName);</i></b>

Este método obtem o nome do método set de um campo.<br>
Exemplo:<br>
<pre><code>	Field field = mockClass.getClass().getField("numberFloat");<br>
	String result = ReflectUtils.generateNameSetMethod( field);<br>
	result.equals("setNumberFloat"));//is true<br>
</code></pre>

</li>

<li>
<h3>getIdsFieldInCollection</h3>
<i>public static List<b><Object</b>> getIdsFieldInCollection(Collection collection);</i>

Este método obtem todos os valores dos campos que tem o nome de ID/id nos objetos da collection.<br>
Exemplo:<br>
<pre><code>	<br>
<br>
	List*&lt;MockClass*&gt; list = new ArrayList*&lt;MockClass*&gt;();<br>
	list.add( new MockClass(1L));//passando id no contrutor da classe<br>
	list.add( new MockClass(2L));//passando id no contrutor da classe<br>
	list.add( new MockClass(3L));//passando id no contrutor da classe<br>
	list.add( new MockClass(4L));//passando id no contrutor da classe<br>
<br>
	List*&lt;Object*&gt; resultList = ReflectUtils.getIdsFieldInCollection(list);<br>
<br>
	//((Long) resultList.get(0)) == 1L ) is true<br>
	//((Long) resultList.get(1)) == 2L ) is true<br>
	//((Long) resultList.get(2)) == 3L ) is true<br>
	//((Long) resultList.get(3)) == 4L ) is true<br>
<br>
</code></pre>
</li>

<li>
<h3>getValuesInCollection</h3>
<i>public static List</i>

<Object>

 getValuesInCollection(Collection collection, String fieldName);<br>
<br>
Este método obtem todos os valores dos campos que tiverem o nome que você quizer.<br>
Exemplo:<br>
<pre><code><br>
import java.util.ArrayList;<br>
import java.util.List;<br>
<br>
public class ReflectUtilsTeste{<br>
	public static void main(String... args){<br>
		List&lt;Project&gt; list = new ArrayList&lt;Project&gt;();<br>
		list.add( new Project("Open"));<br>
		list.add( new Project("Sutils"));<br>
		list.add( new Project("-Br"));<br>
		list.add( new Project("4J"));<br>
<br>
		List&lt;Object&gt; resultList = ReflectUtils.getValuesInCollection(list,"name");<br>
<br>
		System.out.print((String) resultList.get(0));<br>
		System.out.print((String) resultList.get(1));<br>
		System.out.print((String) resultList.get(2));<br>
		System.out.print((String) resultList.get(3));<br>
		//Irá imprimir: OpenSutils-Br4J<br>
	}<br>
<br>
}<br>
<br>
class Project{<br>
	private String name;<br>
	public Project(String name){<br>
		this.name = name;<br>
	}<br>
}<br>
	<br>
</code></pre>

<br>
<br>
Unknown end tag for </li><br>
<br>
<br>
<br>
<li>
<h3>isWrapperPrimitive</h3>
<i>public static boolean isWrapperPrimitive(Object obj);</i>

Este método verifica se um objeto é do tipo primitivo.<br>
Exemplo:<br>
<pre><code>	<br>
<br>
	ReflectUtils.isWrapperPrimitive(new Long(1))		// result is true<br>
	ReflectUtils.isWrapperPrimitive(new Integer(1))		// result is true<br>
	ReflectUtils.isWrapperPrimitive(new Boolean(false))	// result is true<br>
	ReflectUtils.isWrapperPrimitive(new Short((short)1))	// result is true<br>
	ReflectUtils.isWrapperPrimitive(new Double(100.5))	// result is true<br>
	ReflectUtils.isWrapperPrimitive(new BigDecimal(1))	// result is true<br>
	ReflectUtils.isWrapperPrimitive(new String("teste") 	// result is true<br>
	ReflectUtils.isWrapperPrimitive(new Float(1.2))		// result is true<br>
<br>
</code></pre>
</li>
<li>
<h3>toString</h3>
<i>public static String toString(final Object obj, boolean recursive);</i>
<i>public static String toString(final Object obj, boolean recursive, boolean ignoreCollection);</i>

Este método obtem em uma String todos os campos visiveis de um objeto.<br>
Exemplo:<br>
<pre><code><br>
	MockClass mockClass = this.getMyClass();	<br>
	String resp = ReflectUtils.toString(mockClass, true);<br>
	//resp.equals("MockClass [id=789456123, name=MockClass JUnit Test, nameNull=null, value=22225, numberShort=1, numberInteger=74411, numberFloat=2.0, boo=true, mockClass=MockClass [id=0, name=null, nameNull=it a value, not null., value=null, numberShort=0, numberInteger=null, numberFloat=null, boo=false, mockClass=null, fieldNotGetMethod=null], fieldNotGetMethod=teste]"));<br>
</code></pre>
</li>

<br>
<br>
Unknown end tag for </ul><br>
<br>
