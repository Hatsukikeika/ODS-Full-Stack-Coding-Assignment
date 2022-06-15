package fsassignment.util;

import java.util.*;

public class AutoComplete {
	
	private static HashMap<String, Locker> repo = new HashMap<>();
	
	public AutoComplete() {
		
	}
	
	public static void register(String catagory, Locker locker) {
		repo.putIfAbsent(catagory, locker);
	}
	
	public static void remove(String catagory) {
		repo.remove(catagory);
	}
	
	public static <T> void tryLoad(String catagory, T... item) {
		if(!repo.containsKey(catagory));
		repo.get(catagory).addItem(item);
	}
	
	public static <T> List<T> lookup(String catagory, T prefix, int limit){
		if(!repo.containsKey(catagory)) return new ArrayList<>();
		return repo.get(catagory).fuzzySearch(prefix, limit);
	}
}
