package com.mail.mailService.entity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringClass {

	public static void main(String[] args) {

		String str = "INDIAAA";

		List<Character> collect = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(e->e.getValue()>1).map(Map.Entry::getKey)
				.collect(Collectors.toList());
		
		System.out.println(collect);
	}
}
