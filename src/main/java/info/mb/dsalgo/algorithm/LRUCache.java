package info.mb.dsalgo.algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * LRU cache implementation using a DLL queue and HashMap.
 * 
 * @author mukulbansal
 *
 */
public class LRUCache {

	private int cacheCapacity = 0;
	private volatile AtomicInteger currentCacheSize = new AtomicInteger(0);
	private Map<String, DLL.DLLNode> lruCache = null;
	private DLL dll = null;

	public LRUCache(int cacheSize) {
		lruCache = new HashMap<>();
		cacheCapacity = cacheSize;
		dll = new DLL();
	}

	public static LRUCache initializeCache(int cacheSize) {
		return new LRUCache(cacheSize);
	}

	public void add(String key, String value) {
		if (currentCacheSize.get() == cacheCapacity) {
			lruCache.remove(dll.rear.key);
			dll.removeFromRear();
			DLL.DLLNode newDllNode = dll.addAtFront(key, value);
			lruCache.put(key, newDllNode);
		} else {
			DLL.DLLNode newDllNode = dll.addAtFront(key, value);
			lruCache.put(key, newDllNode);
			currentCacheSize.incrementAndGet();
		}
	}

	public void remove(String key) {
		dll.removeFromRear();
		lruCache.remove(key);
		currentCacheSize.decrementAndGet();
	}

	public String get(String key) {
		return lruCache.get(key).value;
	}

	public void print() {
		System.out.println("Printing all key-value pairs in the cache- ");
		Iterator<Map.Entry<String, LRUCache.DLL.DLLNode>> it = lruCache.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, LRUCache.DLL.DLLNode> pair = (Map.Entry<String, LRUCache.DLL.DLLNode>) it.next();
			System.out.println(pair.getKey() + " -> " + pair.getValue().value);
		}
	}

	private class DLL {
		DLLNode front = null;
		DLLNode rear = null;

		public DLLNode addAtFront(String key, String value) {
			DLLNode newDLLNode = new DLLNode(key, value);
			if (null == front && null == rear) {
				front = newDLLNode;
				rear = newDLLNode;
			} else {
				DLLNode backupFront = front;
				front = newDLLNode;
				backupFront.previous = newDLLNode;
				front.next = backupFront;
			}
			return newDLLNode;
		}

		public void removeFromRear() {
			if (null != front && null != rear) {
				rear = rear.previous;
				rear.next = null;
			}
		}

		private class DLLNode {
			DLLNode next = null;
			String key = null;
			String value = null;
			DLLNode previous = null;

			DLLNode(String key, String value) {
				this.key = key;
				this.value = value;
			}

		}
	}

}
