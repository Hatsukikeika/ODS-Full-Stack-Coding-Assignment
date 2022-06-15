package fsassignment.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StationLocker implements Locker<String>{
	
	HashMap<Character, StationLocker> next = new HashMap<>();
	boolean validEnd;
	String code;
	String fullname;
	
	public StationLocker() {}
	
	public void addItem(String... word) {
		if(word[0] == null) return;
		StationLocker itr = this;
		
		for(char c : word[0].toCharArray()) {
			itr.next.putIfAbsent(c, new StationLocker());
			itr = itr.next.get(c);
		}
		
		itr.validEnd = true;
		if(word[0] != null) itr.code = word[0];
		if(word[1] != null) itr.fullname = word[1];
	}
	
	public List<String> fuzzySearch(String prefix, int limit) {
		HashSet<String> result = new HashSet<>(limit);
		
		StationLocker itr = this.locate(prefix);
		
		Queue<StationLocker> hold = new LinkedList<>();
		
		if(itr != null) hold.add(itr);
		
		while(!hold.isEmpty() && result.size() < limit) {
			StationLocker curr = hold.poll();
			
			if(curr.validEnd) {
				result.add(curr.code);
				result.add(curr.fullname);
			}
			
			for(StationLocker sl : curr.next.values()) {
				hold.add(sl);
			}
		}
		
		
		List<String> temp = new ArrayList<>(result);
		Collections.sort(temp);
		
		return temp;
	}
	
	public StationLocker locate(String word) {
		StationLocker itr = this;
		for(char c : word.toCharArray()) {
			itr = itr.next.get(c);
			if(itr == null) return itr;
		}
		return itr;
	}
}
