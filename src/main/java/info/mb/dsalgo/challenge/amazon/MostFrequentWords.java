package info.mb.dsalgo.challenge.amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MostFrequentWords {
	
	public static int highestFrequency = 0;

	public static void main(String... s) {
		String text = "I am a good boy and I am loving it";
		List<String> wordsToExclude = new ArrayList<>();
		wordsToExclude.add("am");
		wordsToExclude.add("I");

		new MostFrequentWords().retrieveMostFrequentlyUsedWords(text, wordsToExclude);
	}

	List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude) {
		List<String> frequentWords;

		// Splitting words by Separator
		String[] words = literatureText.split(" ");

		// Generating a word frequency map
		Map<String, Integer> wordMap = getWordMap(words, wordsToExclude);

		// System.out.println(wordMap);

		// Sorting Entries by Value using a custom comparator
		TreeMap<String, Integer> sortedWordMap = new TreeMap<String, Integer>(new MyComparator(wordMap));
		sortedWordMap.putAll(wordMap);

		// System.out.println(sortedWordMap);

		// Segregating the words with the highest frequency in a List
		frequentWords = new ArrayList<>();
		//int highestFrequency = sortedWordMap.firstEntry().getValue();
		for (Map.Entry<String, Integer> entry : sortedWordMap.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			if (value == highestFrequency) {
				frequentWords.add(key);
			} else {
				break;
			}
		}

		System.out.println(frequentWords);

		return frequentWords;
	}

	private Map<String, Integer> getWordMap(String[] words, List<String> wordsToExclude) {
		Map<String, Integer> wordMap = new HashMap<>();
		for (String word : words) {
			if (!wordsToExclude.contains(word)) {
				wordMap.put(word, null == wordMap.get(word) ? 1 : wordMap.get(word) + 1);
			}
		}
		return wordMap;
	}

}

/**
 * Comparator class for comparing entries by Value.
 * 
 * @author mukulbansal
 *
 */
class MyComparator implements Comparator<String> {

	Map<String, Integer> hashMap = new HashMap<>();

	public MyComparator(Map<String, Integer> map) {
		hashMap.putAll(map);
	}

	@Override
	public int compare(String s1, String s2) {
		if (hashMap.get(s1) >= hashMap.get(s2)) {
			if(MostFrequentWords.highestFrequency < hashMap.get(s1)) {
				MostFrequentWords.highestFrequency = hashMap.get(s1);
			}
			return -1;
		} else {
			if(MostFrequentWords.highestFrequency < hashMap.get(s2)) {
				MostFrequentWords.highestFrequency = hashMap.get(s2);
			}
			return 1;
		}
	}
}
