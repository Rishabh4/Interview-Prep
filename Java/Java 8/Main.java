package com.rishabh;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

//1. Find unique characters in a word and announce the winner with most unique characters in the name 
		List<String> names = Arrays.asList("Rishabh", "Anshul", "Abhishek", "Avinashi");

//		Converting into a map with name as key & number of unique characters as value
		Map<String, Long> map = names.stream().collect(Collectors.toMap(Function.identity(),
				name -> name.chars().distinct().count(), (a, b) -> a, LinkedHashMap::new));
//		Sorting the list based on value
		String winner = map.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.findFirst().get().getKey();

		System.out.println(winner);

//2. Sorting the string alphabetically
//		Method 1
		String str = "ththththth";
		String sortedString = Stream.of(str.split("")).sorted().collect(Collectors.joining());
//		Method 2
		char[] cha = "ththththth".toCharArray();
		Arrays.sort(cha);
		String sortedString1 = String.valueOf(cha);
		System.out.println(sortedString + "," + sortedString1);

//3. Separate odd & even in a given list
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Map<Boolean, List<Integer>> intMap = intList.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
		intMap.entrySet().forEach((i) -> System.out.print(i + ","));
		System.out.println();

//4. Remove duplicate elements from list
		List<Integer> dupList = Arrays.asList(1, 2, 3, 1, 5, 1, 7, 2, 9, 2);
		dupList.stream().distinct().forEach(i -> System.out.print(i + ","));
		System.out.println();

//5. Frequency of each character in a string
		String str2 = "RishabhJain";
//		Method 1
		Map<Character, Long> mapChar = str2.chars().mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println(mapChar);

//		Method 2
		System.out.println(Stream.of(str2.toLowerCase().split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

//6. Frequency of each element in an array
		List<String> dupStrList = new ArrayList<>(
				Arrays.asList("Rishabh", "Anshul", "Abhishek", "Abhishek", "Avinashi", "Rishabh"));
		System.out.println(dupStrList.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())));

//7. Sort the list in reverse order
		List<Integer> dupList1 = Arrays.asList(1, 2, 3, 1, 5, 1, 7, 2, 9, 2);
		dupList1.stream().sorted(Comparator.reverseOrder()).forEach(i -> System.out.print(i + ","));
		System.out.println();

//8. Join list of string with prefix, suffix and delimiter
		List<String> strList = new ArrayList<>(Arrays.asList("Rishabh", "Anshul", "Abhishek", "Avinashi"));
		String newStrList = strList.stream().collect(Collectors.joining(",", "pre", "suf"));
		System.out.println(newStrList);

//9. Print multiple of 5 form the list
		List<Integer> intList5 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		intList5.stream().filter(i -> i % 5 == 0).forEach(a -> System.out.print(a + ","));
		System.out.println();

//10. Max & min in a list
		List<Integer> intList1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Integer max = intList1.stream().max((o1, o2) -> o1.compareTo(o2)).get();
		Integer max1 = intList1.stream().max(Comparator.naturalOrder()).get();
		System.out.println(max + "," + max1);
		Integer min = intList1.stream().collect(Collectors.minBy((o1, o2) -> o1.compareTo(o2))).get();
		System.out.println(min);

//11. Merge 2 unsorted array into  single sorted array
		Integer[] unsortedArr1 = { 21, 52, 3, 43, 51, 6, 76, 8, 98, 30 };
		Integer[] unsortedArr2 = { 56, 42, 3, 23, 43, 16, 36, 88, 95, 330 };

		Stream.concat(Arrays.asList(unsortedArr1).stream(), Arrays.asList(unsortedArr2).stream()).sorted()
				.forEach(x -> System.out.print(x + ","));
		System.out.println();

		Stream.of(unsortedArr1, unsortedArr2).flatMap(Stream::of).sorted().forEach(x -> System.out.print(x + ","));
		System.out.println();

//12. Merge 2 unsorted array into  single sorted array without duplicates
		Stream.of(unsortedArr1, unsortedArr2).flatMap(Stream::of).distinct().sorted()
				.forEach(x -> System.out.print(x + ","));
		System.out.println();

//13. Anagram program in java 8
		String a = "actad";
		String b = "dcaat";
		System.out.println(isAnagram(a, b));

//14. 3 max and min number from the list
		List<Integer> ranList = getRandomListOfNNumber(20);
		ranList.stream().sorted().limit(3).forEach(x -> System.out.print(x + ","));
		System.out.println();
		ranList.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(x -> System.out.print(x + ","));
		System.out.println();

//15. Sum of All Digits of a number
		int num = 123456;
		Integer sum = Stream.of(String.valueOf(num).split("")).collect(Collectors.summingInt(Integer::parseInt));
		System.out.println(sum);

//16. Second largest number in an integer array
		Integer[] randArr = { 21, 52, 3, 43, 51, 6, 76, 8, 98, 30 };
		List<Integer> intArr = Arrays.asList(randArr);
		Integer secHighest = intArr.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(secHighest);

//17. Sort list of strings in increasing order of their length
		List<String> strList1 = new ArrayList<>(Arrays.asList("Rishabh", "Anshul", "Abhishek", "Kunal", "Avinash",
				"Alankrit", "Yashasvi", "Tejaswini", "ria", "rama"));
		List<String> sortedStrList1 = strList1.stream().sorted(Comparator.comparing(String::length))
				.collect(Collectors.toList());
		System.out.println(sortedStrList1);

//18. Common elements between 2 array
//		Method 1
		List<Integer> li = Stream.concat(Stream.of(unsortedArr1), Stream.of(unsortedArr2))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(i -> i.getValue() > 1).map(Entry::getKey).toList();
		System.out.println(li);

//		Method 2
		List<Integer> list1 = Stream.of(unsortedArr1).toList();
		List<Integer> list2 = Stream.of(unsortedArr2).toList();
		List<Integer> li1 = list1.stream().filter(list2::contains).toList();
		System.out.println(li1);

//19. Sum & avg of all elements of an array
		IntSummaryStatistics stats = list1.stream().collect(Collectors.summarizingInt(Integer::intValue));
		System.out.println(stats.getSum() + "," + stats.getAverage());

//20. Reverse each word of a string
		String str3 = "Rishabh Jain is a good boy.";
		System.out.println(Stream.of(str3.split(" ")).map(word -> new StringBuffer(word).reverse())
				.collect(Collectors.joining(" ")));

//21. Sum of first 10 natural numbers
		System.out.println(IntStream.range(1, 11).sum());

//22. Reverse an Integer array
		int[] revArra = IntStream.rangeClosed(1, unsortedArr1.length).map(i -> unsortedArr1[unsortedArr1.length - i])
				.toArray();
		for (int i : revArra) {
			System.out.print(i + ",");
		}
		System.out.println();

//23. Find strings which starts with number
		String str4 = "Rishabh 1Jain is a 3good boy";
		String numStr = Stream.of(str4.split(" ")).filter(i -> i.matches("^[0-9].*$")).collect(Collectors.joining(" "));
		String numStr1 = Stream.of(str4.split(" ")).filter(i -> Character.isDigit(i.charAt(0)))
				.collect(Collectors.joining(" "));
		System.out.println(numStr + "," + numStr1);

//24. Pallindrome program
//		Method 1
		String pallindromeStr = "javaj";
		System.out.println("String is Pallindrome :=" + pallindromeStr.equals(
				Stream.of(pallindromeStr).map(i -> new StringBuffer(i).reverse()).collect(Collectors.joining())));

//		Method 2
		Boolean isPallindrome = IntStream.range(0, pallindromeStr.length() / 2)
				.noneMatch(i -> pallindromeStr.charAt(i) != pallindromeStr.charAt(pallindromeStr.length() - i - 1));
		System.out.println("String is Pallindrome :=" + isPallindrome);

//		Method 3
		isPallindrome = IntStream.range(0, pallindromeStr.length() / 2)
				.allMatch(i -> pallindromeStr.charAt(i) == pallindromeStr.charAt(pallindromeStr.length() - i - 1));
		System.out.println("String is Pallindrome :=" + isPallindrome);

//25. Find duplicate elements from an array
//		Method 1
		List<Integer> commElement = Arrays.asList(12, 23, 343, 12, 12, 23, 435, 453, 5453, 2, 312, 2, 254).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(i -> i.getValue() > 1).map(Entry::getKey).toList();
		System.out.println(commElement);

//		Method 2
		Set<Integer> set = new HashSet<>();
		System.out.println(Arrays.asList(12, 23, 343, 12, 12, 23, 435, 453, 5453, 2, 312, 2, 254).stream()
				.filter(i -> !set.add(i)).collect(Collectors.toSet()));

//26. Last elements of an array
		List<Integer> randList = getRandomListOfNNumber(10);
		Integer lastItem = randList.stream().skip(randList.size() - 1).findFirst().get();
		System.out.println(lastItem);

//27. Fibonacci series
		Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] }).limit(10).map(f -> f[0])
				.forEach(i -> System.out.print(i + " "));
		System.out.println();

//28. age of person in years
		LocalDate dob = LocalDate.of(1992, 01, 04);
		LocalDate today = LocalDate.now();
		System.out.println("Age of Rishabh is " + ChronoUnit.YEARS.between(dob, today));



//29. Convert the list in a map, so that even indexed item is key and odd indexed item is value
		List<String> names = Arrays.asList("Rishabh", "Anshul", "Abhishek", "Avinashi", "Rish");
		if(names.size() %2 != 0) {
            		names.add("null");
        	}
		Map<String, String> map = IntStream.range(0, names.size()).filter(i -> i % 2 == 0).boxed().collect(Collectors.toMap(names::get, c -> names.get(c + 1), (a, b) -> a, LinkedHashMap::new));
		System.out.println(map);
	}

//30. Find the longest substring with non-repeating characters
	public static String lengthOfLongestSubstring(String s) {
	        // HashMap to store the most recent index of each character
	        HashMap<Character, Integer> map = new HashMap<>();
	        
	        int maxLength = 0;
	        int start = 0; // Left pointer for the sliding window
		String str = "";
	        
	        // Iterate through the string with the right pointer
	        for (int end = 0; end < s.length(); end++) {
	            char currentChar = s.charAt(end);
	            
	            // If the character is already in the window, move the left pointer
	            // to the right of the last occurrence of the current character
	            if (map.containsKey(currentChar)) {
	                start = Math.max(start, map.get(currentChar) + 1);
	            }
	            
	            // Update or add the current character's index to the map
	            map.put(currentChar, end);
	            
	            // Calculate the length of the current valid window
		    if(maxLength < Math.max(maxLength, end - start + 1)) {
			    maxLength = Math.max(maxLength, end - start + 1);
			    str = s.substring(start, end+1);
		    }
	        }
	        
	        return str;
	}

	private static List<Integer> getRandomListOfNNumber(int n) {
		Random ran = new Random();
		List<Integer> intList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			intList.add(ran.nextInt(1, n + 1));
		}
		System.out.println("random lisr created = " + intList);
		return intList;
	}

	private static boolean isAnagram(String a, String b) {
		return getStringAsMap(a).equals(getStringAsMap(b));
	}

	private static String getStringAsMap(String str) {
		return Stream.of(str.toLowerCase().split("")).sorted()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).keySet().toString()
				.replace(", ", "");
	}

	private static long logic(String input) {
		return input.chars() // IntStream
				// convert to lowercase & then to Character object Stream
				.mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i)))
				// store in a LinkedHashMap with the count
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream() // EntrySet stream
				.filter(entry -> entry.getValue() == 1L) // extracts characters with a count of 1
				.map(entry -> entry.getKey()) // get the keys of EntrySet
				.count(); // get the first entry from the keys

	}

}
