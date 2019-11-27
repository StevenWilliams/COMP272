package org.stevenw.AU272.A2;

import java.util.Arrays;

public class HashtableClient {
	public static void main(String[] args) {
		HashTable<Integer> table = new HashTable<>();
		table.add(1);
		table.add(5);
		table.add(21);
		table.add(26);
		table.add(39);
		table.add(14);
		table.add(15);
		table.add(16);
		table.add(17);
		table.add(18);
		table.add(19);
		table.add(20);
		table.add(111);
		table.add(145);
		table.add(146);
		table.printTableArray();
	}
}
