package fsassignment.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StringLocker {
	
	HashMap<Character, StringLocker> next = new HashMap<>();
	boolean validEnd;
	String currWord;
	
	public StringLocker() {}
	
	public void addWord(String word) {
		StringLocker itr = this;
		for(char c : word.toCharArray()) {
			itr.next.putIfAbsent(c, new StringLocker());
			itr = itr.next.get(c);
		}
		itr.validEnd = true;
		itr.currWord = word;
	}
	
	public List<String> fuzzySearch(String prefix, int limit) {
		List<String> result = new ArrayList<>(limit);
		
		StringLocker itr = this.locate(prefix);
		
		Queue<StringLocker> hold = new LinkedList<>();
		
		if(itr != null) hold.add(itr);
		
		while(!hold.isEmpty() && result.size() < limit) {
			StringLocker curr = hold.poll();
			
			if(curr.validEnd) result.add(curr.currWord);
			
			for(StringLocker sl : curr.next.values()) {
				hold.add(sl);
			}
		}
		
		return result;
	}
	
	private StringLocker locate(String word) {
		StringLocker itr = this;
		for(char c : word.toCharArray()) {
			itr = itr.next.get(c);
			if(itr == null) return itr;
		}
		return itr;
	}
}
