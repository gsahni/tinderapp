package app;

import java.util.List;

import models.User;

public interface TinderInterface {
	public void showMyCrushes(User user);

	public void getMeCards(User user, List<User> users);
}
