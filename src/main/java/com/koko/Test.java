package com.koko;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Sandeep", "Sumit");

		names.stream().filter(Filter.nameStartWithPrefix(scanner.nextLine()))
				.map(Mapper.getDistinctCharactersCount())
				.forEachOrdered(System.out::println);
	}
}

class Filter {
	public static Predicate<? super String> nameStartWithPrefix(String prefix) {
		return (name) -> name.startsWith(prefix);
	}
}

class Mapper {
	public static Function<String, CharactersCount> getDistinctCharactersCount() {
		return s -> new CharactersCount(s, (int) s.chars().distinct().count());
	}
}

class CharactersCount {

	private final String name;
	private final Integer distinctCharacterCount;

	public CharactersCount(String name, Integer distinctCharacterCount) {
		this.name = name;
		this.distinctCharacterCount = distinctCharacterCount;
	}

	@Override
	public String toString() {
		return "\"" + this.name + "\" has " + this.distinctCharacterCount + " distinct characters.";
	}

}