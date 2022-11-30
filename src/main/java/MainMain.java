import hTests.EddieBlackTongue;
import hTests.FredFlintStone;
import hTests.Test;
import orm.DbConnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainMain {

	public static void main(String[] args) {

		DbConnection<EddieBlackTongue> test = new DbConnection<>();

		EddieBlackTongue test2 = new EddieBlackTongue(1, "test");

		test.create(test2);
	}
}
