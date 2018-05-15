package models;
import java.util.List;

public class User {

	private String name;
	private int age; //Prefer taking as an Object, same for all
	private char sex;
	private Location location;
	private List<String> interests;
	private int id;
	private static int currentId = 0;
	private List<User> myCrushes;

	public List<User> getMyCrushes() {
		return myCrushes;
	}

	public void setMyCrushes(List<User> myCrushes) {
		this.myCrushes = myCrushes;
	}

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

	public static User getUserFromId(List<User> users, int userId) {
		for (User user : users) {
			if (user.id == userId) {
				return user;
			}
		}
		return null;
	}
}
