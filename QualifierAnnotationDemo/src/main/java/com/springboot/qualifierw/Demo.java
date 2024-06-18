package com.springboot.qualifierw;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo {

	public static void main(String[] args) {
		
		Person p1 = new Person(1, "abd", 12200);
		Person p2 = new Person(2, "avbd", 122080);
		Person p3 = new Person(3, "acbd", 122400);
		
		List<Person>  list = new ArrayList<>();
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		
		Map<String, Person> collect = list
			.stream()
			.filter(pers -> pers.getSalary() > 12200)
			.collect(Collectors.toMap(Person::getName, person -> person));
		
		
		collect.forEach((name,person) -> System.out.println(name +" :"+ person));
		
	}
}
