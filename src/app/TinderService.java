package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import models.User;

public class TinderService implements TinderInterface {

	public TinderService()  {
	}

	@Override
	public void getMeCards(User user, List<User> users) {
		
		Collections.sort(users, new GetOrdered(user));
		List<User> crushes = new ArrayList<>();
		
		for (User card : users) {
			System.out.println(card.getName());
			
			@SuppressWarnings("resource")
			Scanner reader = new Scanner(System.in);
			
			System.out.println("Enter 1 for right swipe, 0 for left swipe");
			
			int userInput = reader.nextInt();
			
			if (userInput == 1) {
				crushes.add(card);
			}
		}
		user.setMyCrushes(crushes);
	}

	@Override
	public void showMyCrushes(User user) {
		System.out.println("Printing crushes of " + user.getName());
		
		for (User crush : user.getMyCrushes()) {
			System.out.println(crush.getName());
		}
		
	}

}
