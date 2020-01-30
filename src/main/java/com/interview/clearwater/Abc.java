package com.interview.clearwater;

public class Abc {

	public static String[] adjectives = { "Nice", "Pretty", "Fun", "Spicy" };
	public static String[] verbs = { "Runs", "Trots", "Walks", "Neighs", "Swims", "Files" };

	public static void main(String[] args) {

		for (int i = 2; i < 5; i++) {
			System.out.println(generateRandomSentence("Horse",i));
		}
	}

	private static String generateRandomSentence(String string, Integer seed) {
		
		return "The " +adjectives[seed % adjectives.length] + " " + string +" " + verbs[seed % verbs.length];
	}

}
