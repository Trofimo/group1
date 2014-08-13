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

public class SourceCounter {

	public int countText(String filePath) throws IOException {

		SourceCounter sourceCounter = new SourceCounter();
		int res = 0;

		Scanner sc = new Scanner(new File(filePath));
		String str = "";
		boolean b = false;
		while (sc.hasNextLine()) {
			str = sc.nextLine();
			
			// в начале проверяем /**/

			Pattern p = Pattern.compile("/\\*+");
			Matcher m = p.matcher(str);
			// если обнаруживаем открывающийся блок
			if (m.find()) {
				b = true;
				
			}

			if (b) {
				// 1.удаляем первую строчку с откр /* фрагмент
				str = m.replaceAll("");
				
				Pattern p1 = Pattern.compile("(^.*[.\\*]+/)");
				
				Matcher m1 = p1.matcher(str);
				// 3.проверяем есть ли закр */
				if (m1.find()) {

					// 5.если есть то удаляем только до */ включительно
					str = m1.replaceAll("");
					b = false;

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
