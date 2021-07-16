package fabriac;

public class Person {

	private int note;
	private int cocktails;

	public Person() {
		this.note = 0;
		this.cocktails = 0;
	}

	public void incrementNote(int money) {
		this.note = this.note + money;
	}

	public void payNote() {
		this.note = 0;
	}

	public void payNoteFor(Person person) {
		person.payNote();
	}

	public void drinkCocktail() {
		this.cocktails++;
	}

	public int getCocktails() {
		return this.cocktails;
	}

}
