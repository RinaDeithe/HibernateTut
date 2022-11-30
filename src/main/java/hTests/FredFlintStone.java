package hTests;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class FredFlintStone {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column()
	private boolean isReal;

	public FredFlintStone(int id, String name, int age, boolean isReal) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.isReal = isReal;
	}

	public FredFlintStone() {

	}

	public boolean isReal() {
		return isReal;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
