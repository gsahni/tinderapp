package tinderapp;

import java.util.List;

// lets keep this classs only as Pojo,
// make a seprate package for modal
public class User {

	private String name;
	private int age; //Prefer taking as an Object, same for all
	private char sex;
	private Location location;
	private List<String> interests;
	private int id;
	private static int currentId = 0;
	private List<User> myCrushes;

	public User() {
	}

	public List<User> getMyCrushes() {
		return myCrushes;
	}

	public void setMyCrushes(List<User> myCrushes) {
		this.myCrushes = myCrushes;
	}

	// Better practice to use this.
//	public User(String name, int age, char sex, Location location, List<String> interests) {
//		this.name = name;
//		this.age = age;
//		this.sex = sex;
//		this.location = location;
//		this.interests = interests;
//		this.id = ++currentId;
//	}

	public int getId() {
		return id;
	}

	public void setId() {
		this.id = ++currentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char c) {
		this.sex = c;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	// move this business logic out from this modal class
	public static int matchInterests(User o1, User o2) {
		List<String> interestOfUser1 = o1.interests;
		List<String> interestOfUser2 = o2.interests;
		int matchCount = 0;
		for (String interests : interestOfUser1) {
			if (interestOfUser2.contains(interests)) {
				matchCount++;
			}
		}
		return matchCount;
	}

	public static void printUsers(List<User> users) {
		for (User user : users) {
			System.out.println(user.name);
		}
	}

}
