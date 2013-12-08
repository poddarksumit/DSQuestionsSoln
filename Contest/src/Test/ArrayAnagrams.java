/**
 * 
 */
package Test;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * This class is used to
 * 
 * @author Sumit 10-Feb-2013
 * 
 */
public class ArrayAnagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = { "cat", "dog", "tac", "god", "act" };
		arrayANagItr(str);
	}

	public static void arrayANagItr(String[] str) {
		Hashtable<MapHashCode, String> tab = new Hashtable<MapHashCode, String>();
		for (int i = 0; i < str.length; i++) {
			String a = str[i];
			MapHashCode code = new MapHashCode(a);
			tab.put(code, code.getS());
		}

		Iterator itr = tab.System.out.println(tab);
	}

	public static void arrayAna(String[] str) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		// int val
		return super.hashCode();
	}

}

class MapHashCode {
	String s;

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	MapHashCode(String s) {
		super();
		this.s = s;
	}

	@Override
	public int hashCode() {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result = result + (s.charAt(i) - 'a');
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MapHashCode other = (MapHashCode) obj;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}

}