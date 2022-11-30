package hTests;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

// @Entity for at specificere overfor ORM at det er et table/row i ens table
@Entity
// Hvis table ikke er oprettet forinden, så bliver tablet nanvgivet det samme som ens klasse.
public class EddieBlackTongue {

	//@Id for at specificerer primære key
	@Id
	//@Column for at fortælle at dette er en kulonne og for at sætte afgrænsninger.
	@Column(nullable = false, updatable = false)
	//Genere et unikt ID, hvis Id'et ikke allerede er sat.
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	//Kan også se at det er en column uden at sætte en column på.
	@Column
	private String stringTest;

	//Constructor med de værdier der skal bruges til at finde en EddieBlackTongue fra databasen.
	public EddieBlackTongue(int id) {
		this.id = id;
	}

	//Constructor uden ID, da det auto genereres af vores ORM. Dette er for at oprette en row i vores database, hvor den ovenover skal bruges til at finde objekter
	public EddieBlackTongue(String stringTest) {
		this.stringTest = stringTest;
	}

	//Hibernate KRÆVER en tom constructor. Der er blevet lavet en constructor med input istedet for at lave setters.
	// LAV IKKE SETTERS. Brug en constructor istedet. Dette er fordi DbConnection.class er en class<T>, og derfor ikke kan sætte værdier inden i den.
	public EddieBlackTongue() {
	}

	public String getStringTest() {
		return stringTest;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "{\"EddieBlackTongue\":{"
				+ "\"id\":\"" + id + "\""
				+ ",\"stringTest\":\"" + stringTest + "\""
				+ "}}";
	}
}
