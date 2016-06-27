package ming.MyProject.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
	
	private final static String INCLUDE="\\{ms:include filename\\=(.*?)\\s*/}";
	
	/**
	 * decription 传入一段String，根据正则表达式取出匹配的内容
	 * @param content
	 * @param regex
	 * @return
	 */
	public static List<String> whatAreThematcher(String content,String regex){
		Pattern patternL = Pattern.compile(regex);
		Matcher matcherL = patternL.matcher(content);
		List resList = new ArrayList();
		if (matcherL.find()) {
			String includeName = matcherL.group(1);
			resList.add(includeName);
		}
		
		return resList;
	}
	
	public static String replaceFirst(String source, String regex, String newContent) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(source);
		if (matcher.find()) {
			source = matcher.replaceFirst(Matcher.quoteReplacement(newContent));//Matcher.quoteReplacement负责把/与$转换成普通字符，可以应用于replace
		}
		return source;
	}

}
