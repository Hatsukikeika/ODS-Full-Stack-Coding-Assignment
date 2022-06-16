package fsassignment.util;

import java.util.*;

/**
 * @author Yi
 *
 */
public class AutoComplete {
	
	private static HashMap<String, Locker> repo = new HashMap<>();
	
	public AutoComplete() {}
	
	/**
	 * Regist a locker into global scope
	 * 
	 * @param catagory catagory the group that matcher/dictionary belongs to.
	 * @param locker a matcher/dictionary
	 */
	public static void register(String catagory, Locker locker) {
		repo.putIfAbsent(catagory, locker);
	}
	
	/**
	 * return a registed locker.
	 * 
	 * @param catagory catagory the group that matcher/dictionary belongs to.
	 */
	public static void remove(String catagory) {
		repo.remove(catagory);
	}
	
	/**
	 * store objects into a target locker
	 * 
	 * @param <T> A type that target locker should able to handle
	 * @param catagory catagory the group that matcher/dictionary belongs to.
	 * @param item objects that needs to be searched later.
	 */
	public static <T> void tryLoad(String catagory, T... item) {
		if(!repo.containsKey(catagory));
		repo.get(catagory).addItem(item);
	}
	
	/**
	 * look up all possible/similar objects based on the input.
	 * 
	 * @param <T> A type that target locker should able to handle
	 * @param catagory catagory the group that matcher/dictionary belongs to.
	 * @param prefix Basic info that locates the BFS enterance point.
	 * @param limit how many result can be found.
	 * @return a list of result
	 */
	public static <T> List<T> lookup(String catagory, T prefix, int limit){
		if(!repo.containsKey(catagory)) return new ArrayList<>();
		return repo.get(catagory).fuzzySearch(prefix, limit);
	}
}
