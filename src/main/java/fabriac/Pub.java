package fabriac;

public class Pub {

	private final int seats;
	private int persons;

	public Pub(int seats) {
		this.seats = seats;
	}

	public void fill(int persons) {
		this.persons = persons;
	}

	public void add(int persons) {
		this.persons = this.persons + persons;
	}

	public int avaiableSeats() {
		return this.seats - this.persons;
	}

	public boolean areDenied(int toPlace) {
		return avaiableSeats() < toPlace;
	}

}
