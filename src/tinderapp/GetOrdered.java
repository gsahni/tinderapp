package tinderapp;

import java.util.Comparator;

public class GetOrdered implements Comparator<User> {

	private User user;

	public GetOrdered(User u1) {
		this.user = u1;
	}

	@Override
	public int compare(User o1, User o2) {

		if (o1.getSex() == o2.getSex()) {
			if (o1.getSex() != user.getSex()) {
				// make more comparisons
				double distanceo1 = Location.findDistance(user.getLocation(), o1.getLocation());
				double distanceo2 = Location.findDistance(user.getLocation(), o2.getLocation());
				if (distanceo1 <= distanceo2) {
					return -1;
				} else if (distanceo1 > distanceo2) {
					return 1;
				} else {
					int matchInterestsOfUser1 = User.matchInterests(user, o1);
					int matchInterestsOfUser2 = User.matchInterests(user, o2);
					return matchInterestsOfUser2 - matchInterestsOfUser1;
				}
			} else {
				return -1;
			}
		} else {
			if (o1.getSex() != user.getSex()) {
				return -1;
			} else {
				return 1;
			}
		}
	}
}