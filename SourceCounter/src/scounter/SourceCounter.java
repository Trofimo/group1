package scounter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

public class SourceCounter {

	public int countText(String filePath) throws IOException {

		SourceCounter sourceCounter = new SourceCounter();
		int res = 0;

		Scanner sc = new Scanner(new File(filePath));
		String str = "";
		boolean b = false;
		while (sc.hasNextLine()) {
			str = sc.nextLine();
			
			
			Pattern p1 = Pattern.compile("([/[\\*]+]+[A-Za-z0-9\\-_]*[[/[\\*]+]+]+)");
			Matcher m1= p1.matcher(str);
			str = m1.replaceAll("");	
			
			
			
			
			Pattern p = Pattern.compile("/\\*+");
			
			
			Matcher  m = p.matcher(str);
			
			
			
			// если обнаруживаем открывающийся блок /**/
			if (m.find()) {
				b=true;
				
				
			}	
			if(b){
			// 1.заменяем найденный фрагмент с откр /* на ""
			str = m.replaceAll("");	
			Pattern p2 = Pattern.compile("(.*[.\\*]+/)");
				
				Matcher m2 = p2.matcher(str);
				// 3.проверяем есть ли закр */
				if (m2.find()) {
					
					// 5.если есть то удаляем только до */ включительно
					str = m2.replaceAll("");
					b=false;
					
					// 6.если нет то удаляем всю строку до конца
				}else{str="";}
				
			
			}
			
				
			
			
			
			// после этого можно и // вид комментариев проверить
			p = Pattern.compile("//.+$");
			m = p.matcher(str);
			str = m.replaceAll("");

		
			
			
			// чистим всю нашу строчку от всех пробелов чтобы потом можно было
			// проверить
			// является ли она полезной*
			
			p = Pattern.compile("^\\s+");
		m = p.matcher(str);
			str = m.replaceFirst("");
			
			p = Pattern.compile("\\s+$");
			m = p.matcher(str);
			str = m.replaceAll("");
			
			
			if (!str.equals("")) {
				
				System.out.println(str);
				res++;
				System.out.println(res);
			}
		}

		return res;
	}
}






