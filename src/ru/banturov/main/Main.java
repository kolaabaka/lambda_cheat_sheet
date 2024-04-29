package ru.banturov.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		LambdaTest lambdaTest = new LambdaTest();		
		lambdaTest.Do(() -> System.out.println("Work1"));
		
		List <String> ls = new ArrayList<>();
		
		ls.add("asdqwwwwwwwwwww");
		ls.add("asdasdadads");
		ls.add("asas");
		ls.add("a");
		
//		Comaparator<String> comparator = (s1, s2)-> {
//			if(s1.length() > s2.length()) {
//				return 1;
//			} else if(s1.length() < s2.length()) {
//				return -1;
//			}else {
//				return 0;
//			}
//		};
//		
//		ls.sort(comparator);
		
		ls.sort((s1, s2)->{
			if(s1.length() > s2.length()) {
				return 1;
			} else if(s1.length() < s2.length()) {
				return -1;
			}else {
				return 0;
			}
		});
		
		System.out.print(ls);
		
		int[] arr = new int[]{1, 2 ,3};
		//map
		arr = Arrays.stream(arr).map(a -> a * a * a).toArray();
		System.out.println(Arrays.toString(arr));
		
		List <Integer> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		//filter
		list = list.stream().filter(a-> a % 2 == 0 || a % 3 == 0).map(a -> a * a).collect(Collectors.toList());
		
		//forEach
		list.stream().filter(a-> a % 2 == 0).forEach(a -> System.out.println(a));
		
		System.out.println(list.toString());
		
		
		//reduce
		int sumList = list.stream().reduce((acc, b) -> acc + b).get();
		int multArr = Arrays.stream(arr).reduce((acc, a) -> acc * a).getAsInt();
		int multArr2 = Arrays.stream(arr).reduce(0,(acc, a) -> acc * a + 1); // тоже самое что сверху но явно указвыается начало итерации
		System.out.println(sumList);
		System.out.println(multArr);
		System.out.println(multArr2);
		
		//лямбды можно использовать с любой коллекцией
		
		Set <Integer> st = new HashSet<>();
		st.add(12);
		st.add(3);
		st.add(5);
		st.add(6);
		st = st.stream().filter(a -> a % 2 == 0).map(a -> a * 3).collect(Collectors.toSet());
		
		System.out.println(st);
	}

}
