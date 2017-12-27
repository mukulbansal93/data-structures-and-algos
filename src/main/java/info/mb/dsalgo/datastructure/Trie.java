package info.mb.dsalgo.datastructure;

import java.util.ArrayList;
import java.util.List;

import info.mb.dsalgo.util.Constants;
import info.mb.dsalgo.util.Utility;

public class Trie {

	public static TrieNode root;

	public static class TrieNode {
		public TrieNode children[];
		public boolean isEndOfWord;

		public TrieNode() {
			this.children = new TrieNode[Constants.ALPHABET_SIZE];
			this.isEndOfWord = false;
		}
	}

	/**
	 * Inserts a word into the Trie.
	 * 
	 * @param word
	 */
	public static void insert(String word) {
		TrieNode head = root;
		char[] chars = word.toCharArray();
		for (char c : chars) {
			int charPosition = Utility.getCharPositionInAlphabets(c);
			charPosition = charPosition - 1;
			if (head.children[charPosition] != null) {
				head = head.children[charPosition];
			} else {
				head.children[charPosition] = new TrieNode();
				head = head.children[charPosition];
			}
		}
		head.isEndOfWord = true;
	}

	/**
	 * Checks if the given word exits in the Trie.
	 * 
	 * @param word
	 * @return
	 */
	public static boolean exists(String word) {
		boolean exists = false;
		TrieNode head = root;
		char[] chars = word.toCharArray();
		for (char c : chars) {
			int charPosition = Utility.getCharPositionInAlphabets(c);
			charPosition = charPosition - 1;
			if (head.children[charPosition] != null) {
				head = head.children[charPosition];
			} else {
				return false;
			}
		}
		if (head.isEndOfWord == true) {
			exists = true;
		}
		return exists;
	}

	/**
	 * Returns the list of all words in the Trie with given prefix.
	 * 
	 * @param prefix
	 * @return
	 */
	public static List<String> autoCompleteSuggestions(String prefix) {
		List<String> suggestions = new ArrayList<String>();
		TrieNode head = root;
		char[] chars = prefix.toCharArray();
		for (char c : chars) {
			int charPosition = Utility.getCharPositionInAlphabets(c);
			charPosition = charPosition - 1;
			if (head.children[charPosition] != null) {
				head = head.children[charPosition];
			} else {
				return suggestions;
			}
		}

		suggestions = retrieveAll(head);

		for (int i = 0; i < suggestions.size(); i++) {
			String newWord = prefix + suggestions.get(i);
			suggestions.remove(i);
			suggestions.add(i, newWord);
		}

		return suggestions;
	}

	/**
	 * Retrieve all values in the Trie.
	 * 
	 * @param root
	 * @return
	 */
	public static List<String> retrieveAll(TrieNode root) {
		List<String> words = new ArrayList<String>();
		words = retrieve(root, "", words);
		return words;
	}

	private static List<String> retrieve(TrieNode root, String currentWord, List<String> words) {
		boolean flag = false;
		for (int i = 0; i < 26; i++) {
			if (root.children[i] != null) {
				retrieve(root.children[i], currentWord + Utility.getCharFromPositionInAlphabets(i + 1), words);
			}
			if (root.isEndOfWord && !flag) {
				flag = true;
				words.add(currentWord);
			}
		}
		return words;
	}

	/**
	 * Deletes the word from the Trie.
	 * 
	 * @param word
	 */
	public static void delete(String word) {
		if (word.length() > 0) {
			deleteKey(root, word);
		}
	}

	public static boolean deleteKey(TrieNode root, String word) {
		boolean isDeletable;

		if (word.length() == 1) {
			isDeletable = false;
			int count = 0;
			for (int i = 0; i < 26; i++) {
				if (root.children[i] != null) {
					count++;
				}
			}
			if (count >= 1) {
				isDeletable = false;
				root.children[Utility.getCharPositionInAlphabets(word.charAt(0)) - 1].isEndOfWord = false;
			} else {
				isDeletable = true;
			}
			return isDeletable;
		}

		TrieNode current = root;
		TrieNode next = current.children[Utility.getCharPositionInAlphabets(word.charAt(0)) - 1];

		// Recursion
		isDeletable = deleteKey(next, word.substring(1));

		if (isDeletable) {
			int count = 0;
			for (int i = 0; i < 26; i++) {
				if (next.children[i] != null) {
					count++;
				}
			}
			if (count > 1) {
				current.isEndOfWord = false;
				isDeletable = false;
			}
		}

		return isDeletable;
	}

	public static void main(String... s) {
		root = new TrieNode();

		// INSERTION
		String keys[] = { "mukul", "bansal", "and", "amazing", "absolute", "data", "algorithm", "structures", "algo" };
		for (int i = 0; i < keys.length; i++) {
			System.out.println("Inserting into Trie- " + keys[i]);
			insert(keys[i]);
		}

		// SEARCHING
		System.out.print("Does the word 'algorithm' exists in trie- ");
		System.out.println(exists("algorithm"));

		// RETRIEVE ALL
		System.out.println("All values in trie- ");
		System.out.println(retrieveAll(root));

		// AUTO COMPLETE
		System.out.println("Autocomplete suggestions for- 'a'");
		System.out.println(autoCompleteSuggestions("a"));

		// DELETION
		System.out.println("Deleting the word 'algorithm' from trie...");
		delete("algorithm");
		System.out.println(retrieveAll(root));
		System.out.print("Does the word 'algorithm' exists in trie- ");
		System.out.println(exists("algorithm"));
	}

}
