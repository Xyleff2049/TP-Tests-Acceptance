package fabriac;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class PubSteps {
	private Pub pub;
	private int toPlace;
	private HashMap<String, Person> persons;

	@Given("Mr Pignon and Mr Leblanc go to Le Juste which is a cocktail pub")
	public void goToPub() {
		toPlace = 2;
		persons = new HashMap<>();
	}

	@Given("^There's only (\\d+) seats in the pub$")
	public void setup(int arg) {
		pub = new Pub(arg);
	}

	@When("^There's (\\d+) persons in the pub already$")
	public void fill(int arg) {
		pub.fill(arg);
	}

	@Then("^They are denied entry$")
	public void denied() {
		assertTrue(pub.areDenied(toPlace));
	}

	@Then("They sit")
	public void theySit() {
		assertFalse(pub.areDenied(toPlace));
		pub.add(toPlace);
		persons.put("Mr Pignon", new Person());
		persons.put("Mr Leblanc", new Person());
	}

	@Then("Another person can't get in")
	public void anotherPersonCanTGetIn() {
		assertTrue(pub.areDenied(1));
	}

	@When("They each order a cocktail")
	public void theyEachOrderACocktail() {
		persons.forEach((key, person) -> {
			person.incrementNote(10);
			person.drinkCocktail();
		});
	}

	@When("Mr Leblanc pays the whole")
	public void mrLeblancPaysTheWhole() {
		Person MrPignon = persons.get("Mr Pignon");
		Person MrLeblanc = persons.get("Mr Leblanc");
		MrLeblanc.payNoteFor(MrLeblanc);
		MrLeblanc.payNoteFor(MrPignon);
	}

	@Then("Mr Pignon is happy")
	public void mrPignonIsHappy() {
		assertEquals(1, persons.get("Mr Pignon").getCocktails());
	}

	@When("They pay separately")
	public void theyPaySeparately() {
		persons.get("Mr Pignon").payNote();
		persons.get("Mr Leblanc").payNote();
	}

	@Then("Mr Pignon is sad")
	public void mrPignonIsSad() {
		assertTrue(1 < persons.get("Mr Pignon").getCocktails());
	}
}
