package hTests;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EddieBlackTongue {

	@Id
	@Column(unique = true, nullable = false, updatable = false)
	private int id;

	private String stringTest;

	public EddieBlackTongue(int id, String stringTest) {
		this.id = id;
		this.stringTest = stringTest;
	}

	public EddieBlackTongue() {

	}

	public String getStringTest() {
		return stringTest;
	}

	public int getId() {
		return id;
	}
}
