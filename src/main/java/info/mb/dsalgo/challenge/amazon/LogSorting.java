package info.mb.dsalgo.challenge.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LogSorting {

	public static List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");

	public static void main(String... s) {
		int logFileSize = 5;
		List<String> logLines = new ArrayList<>();
		logLines.add("mi2 jog mid pet");
		logLines.add("wz3 34 54 398");
		logLines.add("a1 alps cow bar");
		logLines.add("x4 45 21 7");

		new LogSorting().reorderLines(logFileSize, logLines);
	}

	public List<String> reorderLines(int logFileSize, List<String> logLines) {

		// Generating a map
		Map<String, String> wordMap = getWordMap(logLines);
		System.out.println(wordMap);
		Map<String, String> numMap = getNumMap(logLines);
		System.out.println(numMap);

		// Sorting Entries by Value using a custom comparator
		TreeMap<String, String> sortedWordMap = new TreeMap<String, String>(new MyWordComparator(wordMap));
		sortedWordMap.putAll(wordMap);
		System.out.println(sortedWordMap);
		
		List<String> retVal = getListFromMap(sortedWordMap);
		retVal.addAll(getListFromMap(numMap));
		System.out.println(retVal);
		
		return retVal;
	}
	
	private List<String> getListFromMap(Map<String,String> map){
		List<String> retVal = new LinkedList<>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			retVal.add(key+" "+value);
		}
		return retVal;
	}

	private Map<String, String> getWordMap(List<String> logLines) {
		Map<String, String> wordMap = new HashMap<>();
		for (String line : logLines) {
			String[] key = line.split(" ", 2);
			if (!numbers.contains(key[1].substring(0, 1))) {
				wordMap.put(key[0], key[1]);
			}
		}
		return wordMap;
	}

	private Map<String, String> getNumMap(List<String> logLines) {
		Map<String, String> wordMap = new LinkedHashMap<>();
		for (String line : logLines) {
			String[] key = line.split(" ", 2);
			if (numbers.contains(key[1].substring(0, 1))) {
				wordMap.put(key[0], key[1]);
			}
		}
		return wordMap;
	}
}

class MyWordComparator implements Comparator<String> {

	Map<String, String> hashMap = new HashMap<>();

	public MyWordComparator(Map<String, String> map) {
		hashMap.putAll(map);
	}

	@Override
	public int compare(String s1, String s2) {
		if (hashMap.get(s1).compareTo(hashMap.get(s2)) >= 1) {
			return 1;
		} else if (hashMap.get(s1).compareTo(hashMap.get(s2)) <= 0) {
			return -1;
		} else {
			int maxLoop = 0;
			int retVal;
			if (s1.length() >= s2.length()) {
				maxLoop = s2.length();
				retVal = 1;
			} else {
				maxLoop = s1.length();
				retVal = -1;
			}

			for (int i = 0; i < maxLoop; i++) {
				byte bs1 = (byte) s1.charAt(i);
				byte bs2 = (byte) s2.charAt(i);

				if (bs1 > bs2) {
					return 1;
				} else if (bs1 < bs2) {
					return -1;
				}
			}
			
			return retVal;
			
		}
	}
}
