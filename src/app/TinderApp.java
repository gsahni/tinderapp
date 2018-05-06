package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import models.Location;
import models.User;

public class TinderApp {
	public static void main(String[] args) {

		User u1 = createUser(20, "Gourav", 'M', new Location(10, 50),
				new ArrayList<String>(Arrays.asList("music", "sex", "coding", "travel", "porn")));
		
		User u2 = createUser(22, "Swati", 'F', new Location(11, 45),
				new ArrayList<String>(Arrays.asList("cricket", "music", "travel", "porn")));
		
		User u3 = createUser(19, "Saloni", 'M', new Location(5, 52),
				new ArrayList<String>(Arrays.asList("Dancing", "travel", "porn")));
		
		User u4 = createUser(23, "Sweety", 'F', new Location(2, 34),
				new ArrayList<String>(Arrays.asList("porn")));
		
		User u5 = createUser(20, "Mita", 'F', new Location(10, 50),
				new ArrayList<String>(Arrays.asList("cricket", "music2", "travel", "porn")));
		
		User u6 = createUser(25, "Samiksha", 'F', new Location(1, 44),
				new ArrayList<String>(Arrays.asList("porn")));

		List<User> users = new ArrayList<>(Arrays.asList(u1, u2, u3, u4, u5, u6));

		
		
		
		
		System.out.println("Users present in the system");

		User.printUsers(users);

		System.out.println("Enter your user Id");

		Scanner reader1 = new Scanner(System.in);

		int userId = reader1.nextInt();

		User currentUser = null;

		for (User user : users) {
			if (user.getId() == userId) {
				users.remove(user);
				currentUser = user;
				break;
			}
		}

		Collections.sort(users, new GetOrdered(currentUser));

		List<User> crushes = new ArrayList<>();
		for (User user : users) {
			System.out.println(user.getName());
			@SuppressWarnings("resource")
			Scanner reader = new Scanner(System.in);
			System.out.println("Enter 1 for right swipe, 0 for left swipe");
			int userInput = reader.nextInt();
			if (userInput == 1) {
				crushes.add(user);
			}
		}
		currentUser.setMyCrushes(crushes);
		System.out.println("Printing likes of " + currentUser.getName());

		for (User crush : currentUser.getMyCrushes()) {
			System.out.println(crush.getName());
		}

	}

	private static User createUser(int age, String name, char sex, Location location, List<String> interest) {
		User user = new User();
		user.setAge(age);
		user.setName(name);
		user.setSex(sex);
		user.setLocation(location);
		user.setInterests(interest);
		user.setId();
		return user;
	}
}
