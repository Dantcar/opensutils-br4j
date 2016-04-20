# DateFormat #

Está classe abstrata oferece métodos estáticos para utilização com a classe
java.util.Date e java.util.Calendar do Java6+ afim de proporcionar funcionalidades para facilitar o
manuseio de datas no java.

## Detalhes ##

Os métodos disponíveis nesta classe são:

<ul>
<li>differenceInDays</li>
<li>trunc</li>
<li>format</li>
<li>formatTime</li>
<li>parse</li>
<li>parseBr</li>
</ul>

**Informações dos metodos:**

<ul>
<li>
<h3>differenceInDays</h3>
<i>differenceInDays(Calendar, Calendar);</i>

Este método calcula a diferença em dias de duas datas.<br>
</li>
<li>
<h3>format</h3>
<i>public static String format(final Calendar calendar,String delimiter,short FORMAT);</i>
<i>public static String format(Date date, String delimiter, short FORMAT);</i>

Estes métodos convertem um objeto Date ou Calendar em String, formatando a data de acordo com o parâmetro FORMAT. O parâmetro Format pode ser obtido pelas constantes presentes na classe DateFormat são eles:<br>
<blockquote>DateFormat.DDMMYYYY,	 DateFormat.DDMMYYYY_HHMISS,	 DateFormat.YYYYMMDD_HHMISS,<br>
DateFormat.MMYYYY,	 DateFormat.YYYYMMDDTHHMISS<br>
Exemplo:<br>
<pre><code>Calendar calendar = Calendar.getInstance();<br>
	 calendar.set(2004, 4-1, 16, 11, 25, 15);<br>
String result = DateFormat.format(calendar, "/", DateFormat.DDMMYYYY_HHMISS);<br>
//result equals to: "16/04/2004 11:25:15"<br>
</code></pre>
</li>
<li>
<h3>formatTime</h3>
<i>public static String formatTime(final Calendar calendar);</i>
<i>public static String formatTime(final long milisseconds);</i></blockquote>

Estes métodos convertem um calendar ou milisseconds em String, formatando apenas o tempo,(hora,minuto,segundo)<br>
</li>
<li>
<h3>parse</h3>
<i>public static Calendar parse(String data);</i>

Este método converte um texto(String) no formato de data americana em um objeto Calendar.<br>
Formatos aceitos: 	YYYY-MM-DD,			YYYY-MM-DD HH24:MI:SS,<br>
<blockquote>YYYY-MM-DD HH24:MI:SS.ML, 	YY-MM-DD,<br>
YY-MM-DD HH24:MI:SS<br>
Exemplo:<br>
<pre><code>Calendar calendar = DateFormat.parse("2008-04-16 10:15:25");<br>
System.out.println(calendar);<br>
/*Console is print: java.util.GregorianCalendar[time=?,areFieldsSet=false,areAllFieldsSet=true,lenient=true,<br>
zone=sun.util.calendar.ZoneInfo[id="GMT-03:00",offset=-10800000,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],<br>
firstDayOfWeek=2,minimalDaysInFirstWeek=1,ERA=1,YEAR=2008,MONTH=3,WEEK_OF_YEAR=47,<br>
WEEK_OF_MONTH=3,DAY_OF_MONTH=16,DAY_OF_YEAR=323,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=3,<br>
AM_PM=1,HOUR=4,HOUR_OF_DAY=10,MINUTE=15,SECOND=25,MILLISECOND=734,ZONE_OFFSET=-10800000,<br>
DST_OFFSET=0]*/<br>
</code></pre>
</li>
<li>
<h3>parseBr</h3>
<i>public static Calendar parseBr(String data);</i></blockquote>

Este método converte um texto(String) no formato de data brasileira em um objeto Calendar.<br>
Formatos aceitos: 	DD-MM-YYYY,			DD-MM-YYYY HH24:MI:SS,<br>
<blockquote>DD-MM-YY, 			DD-MM-YY HH24:MI:SS</blockquote>

Exemplo:Calendar calendar = DateFormat.parseBr("16-04-2008 10:15:25");<br>
System.out.println(calendar);<br>
/*Console is print: java.util.GregorianCalendar[time=?,areFieldsSet=false,areAllFieldsSet=true,lenient=true,<br>
zone=sun.util.calendar.ZoneInfo[id="GMT-03:00",offset=-10800000,dstSavings=0,useDaylight=false,transitions=0,<br>
lastRule=null],firstDayOfWeek=2,minimalDaysInFirstWeek=1,ERA=1,YEAR=2008,MONTH=3,<br>
WEEK_OF_YEAR=47,WEEK_OF_MONTH=3,DAY_OF_MONTH=16,DAY_OF_YEAR=323,DAY_OF_WEEK=6,<br>
DAY_OF_WEEK_IN_MONTH=3,AM_PM=1,HOUR=5,HOUR_OF_DAY=10,MINUTE=15,SECOND=25,<br>
MILLISECOND=828,ZONE_OFFSET=-10800000,DST_OFFSET=0]<br>
}}}*/<br>
</li><br>
<br>
<li><br>
===trunc===<br>
_public static Date trunc(Date date);_<br>
<br>
Este método trunca os campos de uma data, deixando apenas o dia, mes e ano removendo os segundos,minutos, horas e milisegundos<br>
<br>
Exemplo:<br>
{{{<br>
		<br>
	Date resp = DateFormat.trunc( new Date() );<br>
	System.out.println(resp);<br>
	//No console printa a data sem as horas,minutos,segundo e milisegundos<br>
	//Wed Feb 09 00:00:00 GMT-03:00 2011<br>
<br>
}}}<br>
</li><br>
<br>
</ul></code></pre>