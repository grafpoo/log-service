package services.log;

import java.util.ArrayList;
import java.util.List;

public class MatchThing {
	List<String> matches = new ArrayList<>();

	public void addMatch(String newMatch) {
		matches.add(newMatch);
	}

	public List<String> asList() {
		return matches;
	}
}
