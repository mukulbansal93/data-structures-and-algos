package info.mb.dsalgo.algorithm;

import java.util.concurrent.locks.Lock;

/**
 * 
 * @author mukulbansal
 *
 */
public class LRUCacheDemo {

	public static void main(String... s) {
		LRUCache cache = LRUCache.initializeCache(3);
		for (int i = 0; i < 6; i++) {
			System.out.println("Adding data " + i);
			cache.add(i + "", i + "");
			cache.print();
		}
		
	}

}
