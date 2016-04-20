ReflectField

Esta classe permite obter ou setar valores atraves do java reflection em Fields (Campos) de uma classe de maneira simplificada.
Adicionado na versão 0.2

## Detalhes ##

Os métodos disponíveis nesta classe são:

<ul>
<li>getValue(Object, Field, Converter)</li>
<li>getValue(Object, String, Converter)</li>
<li>setValue(Object, Field, Object)</li>
<li>setValue(Object, String, Object)</li>
</ul>

**Informações dos métodos:**

<ul>
<li>
<h3>getValue</h3>
<i>public static Object getValue(Object parentField, String fieldName, org.opensutils.converter.Converter converter)</i>
<i>public static Object getValue(Object parentField, java.lang.reflect.Field field, org.opensutils.converter.Converter converter)</i>

Este metodo permite obter um valor de um atributo(Field), seja ele private, public, protected, default, o acesso ao campo é modificado por um momento caso o mesmo não for 'public', para obter o valor do campo.<br>
O Converter do OpenSutils é opcional e é utilizado para converter o resultado se necessario.<br>
<br>
Exemplo:<br>
<pre><code>public class TesteReflectField{<br>
<br>
	static class Car{<br>
		private String model = "ford";<br>
		private int number = 222 ;<br>
		public Engine engine = new Engine();<br>
	}<br>
<br>
	static  class Engine {<br>
		private Long hp = 220L;<br>
		public String name = "V6" ;<br>
	}<br>
<br>
<br>
	public static void main(String[] args){<br>
		TesteReflectField.Car c = new TesteReflectField.Car();<br>
		<br>
		Object obj = org.opensutils.reflect.ReflectField.getValue( c ,"engine.hp", null);<br>
		<br>
		System.out.println(obj.equals(220L));// ira imprimir true no console<br>
<br>
		obj = org.opensutils.reflect.ReflectField.getValue( c ,"model", null);<br>
		System.out.println(obj); // imprimira 'ford' no console<br>
<br>
	}<br>
}<br>
</code></pre>

</li>
<li>
<h3>setValue</h3>
<i>public static boolean setValue(Object parentField, String fieldName, Object value)</i>
<i>public static boolean setValue(Object parentField, java.lang.reflect.Field field, Object value)</i>

Este metodo permite setar um valor de um campo (Field), seja ele private, public, protected, default, o acesso ao campo é modificado por um momento caso o mesmo não for 'public', para setar o valor do campo.<br>
<pre><code>public class TesteSetReflectField{<br>
<br>
	static class Car{<br>
		private String model = "ford";<br>
		private int number = 222 ;<br>
		public Engine engine = new Engine();<br>
	}<br>
<br>
	static  class Engine {<br>
		private Long hp = 220L;<br>
		public String name = "V6" ;<br>
	}<br>
<br>
<br>
	public static void main(String[] args){<br>
		TesteSetReflectField.Car c = new TesteSetReflectField.Car();<br>
<br>
		org.opensutils.reflect.ReflectField.setValue( c ,"model", "ranger");//setando o valor do atributo 'model' de "ford" para "ranger"<br>
<br>
org.opensutils.reflect.ReflectField.setValue( c ,"engine.hp", 240L);//setando o valor do atributo 'hp' da classe Engine de 220 para 240.<br>
<br>
<br>
	}<br>
}<br>
</code></pre>
</li>


</ul>