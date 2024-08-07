package com.springboot.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	private static Integer usersCount = 0;
	static {
		users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user){
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	public User findUserById(Integer userId){
		return users.stream().filter(user -> user.getId() == userId).findFirst().orElse(null);
	}

	public void deleteUserById(Integer userId) {
		Predicate<? super User> predicate = user -> user.getId().equals(userId);
		users.removeIf(predicate);
	}

}
