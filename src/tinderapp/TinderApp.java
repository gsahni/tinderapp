package tinderapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TinderApp {
	public static void main(String[] args) {
		
		User u1 = createUser(20, "Gourav", 'M', new Location(10, 50),
				new ArrayList<String>(Arrays.asList("music", "sex", "coding", "travel", "porn")));

		User u2 = new User();
		u2.setAge(22);
		u2.setName("Swati");
		u2.setSex('F');
		u2.setLocation(new Location(11, 45));
		u2.setInterests(new ArrayList<String>(Arrays.asList("cricket", "music", "travel", "porn")));
		u2.setId();

		User u3 = new User();
		u3.setAge(19);
		u3.setName("Saloni");
		u3.setSex('M');
		u3.setLocation(new Location(5, 52));
		u3.setInterests(new ArrayList<String>(Arrays.asList("Dancing", "travel", "porn")));
		u3.setId();

		User u4 = new User();
		u4.setAge(23);
		u4.setName("Sweety");
		u4.setSex('F');
		u4.setLocation(new Location(2, 34));
		u4.setInterests(new ArrayList<String>(Arrays.asList("porn")));
		u4.setId();

		User u5 = new User();
		u5.setAge(20);
		u5.setName("Mita");
		u5.setSex('F');
		u5.setLocation(new Location(10, 50));
		u5.setInterests(new ArrayList<String>(Arrays.asList("cricket", "music2", "travel", "porn")));
		u5.setId();

		User u6 = new User();
		u6.setAge(25);
		u6.setName("Samiksha");
		u6.setSex('F');
		u6.setLocation(new Location(1, 44));
		u6.setInterests(new ArrayList<String>(Arrays.asList("porn")));
		u6.setId();

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
