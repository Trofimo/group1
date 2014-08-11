package scounter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
http://kulibaba.net/programming/java/strings
	http://www.helloworld.ru/texts/comp/lang/java/java/09.htm
		http://habrahabr.ru/post/127307/
			http://www.vova-prog.narod.ru/articles/regular_expressions/regular_expressions_examples.html#spaces
				http://www.quizful.net/post/Java-RegExp
					http://www.shtogrin.com/library/web/pcre/doc/pcre/
						http://www.exlab.net/files/tools/sheets/regexp/regexp.pdf
*/
public class SourceCounter {
	
	public String getContent(String 
			filePath) throws IOException{
	FileInputStream input;
	
		input = new FileInputStream(filePath);
	

	byte[] fileData = new byte[input.available()];

	input.read(fileData);
	input.close();

	return new String(fileData, "UTF-8");
	}
	
	public static void main(String[] args) throws IOException {
		SourceCounter sc=new SourceCounter();
		String str=sc.getContent("D:\\testContent.txt");
		System.out.println(str);
		
	 
		
		Pattern p = Pattern.compile("/\\*[^\\*]*[^/]*/|\\/\\/[^\\n]*");
		Matcher m = p.matcher(str);
		str = m.replaceAll("");	
		System.out.println(str);
	 
		//'\t'| ' '| '\n'| '\r'
	}
}
