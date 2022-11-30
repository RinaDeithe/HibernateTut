package hTests;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test {
	private long test;
	private long test2;

	@Id
	@Column(name = "test")
	public long getTest() {
		return test;
	}

	public void setTest(long test) {
		this.test = test;
	}

	@Basic
	@Column(name = "test2")
	public long getTest2() {
		return test2;
	}

	public void setTest2(long test2) {
		this.test2 = test2;
	}
}
