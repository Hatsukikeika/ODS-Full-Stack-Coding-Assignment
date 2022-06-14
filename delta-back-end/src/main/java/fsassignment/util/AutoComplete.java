package fsassignment.util;

import java.util.*;

public class AutoComplete {
	
	private static HashMap<String, StringLocker> repo = new HashMap<>();
	
	public AutoComplete() {
		
	}
	
	public static void register(String catagory) {
		repo.putIfAbsent(catagory, new StringLocker());
	}
	
	public static void remove(String catagory) {
		repo.remove(catagory);
	}
	
	public static void tryLoad(String catagory, String word) {
		if(!repo.containsKey(catagory));
		repo.get(catagory).addWord(word);
	}
	
	public static List<String> lookup(String catagory, String prefix, int limit){
		return repo.getOrDefault(catagory, new StringLocker()).fuzzySearch(prefix, limit);
	}
}
