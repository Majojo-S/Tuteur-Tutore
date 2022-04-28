package sae;

public class Person {
	private String firstName;
	private String lastName;

	public Person(String fn, String ln) {
		firstName = fn == null ? "" : fn;
		lastName = ln == null ? "" : ln;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String ln) {
		if (ln != null && ln.length() > 0)
			lastName = ln;
	}

}
