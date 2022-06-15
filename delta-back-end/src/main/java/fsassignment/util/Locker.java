package fsassignment.util;

import java.util.List;

public abstract interface Locker<T> {

	public void addItem(T... item);
	
	public List<T> fuzzySearch(T item, int limit);
	
	public Locker<T> locate(T item);

}
