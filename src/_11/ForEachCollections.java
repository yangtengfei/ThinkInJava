package _11;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class ForEachCollections {
	public static void main(String[] args) {
		Collection<String> cs = new LinkedList<String>();
		Collections.addAll(cs, "a bc sde as grg");
		for (String string : cs) {
			System.out.println(string + " ");
		}
	}
}
