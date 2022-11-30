import hTests.EddieBlackTongue;
import orm.DbConnection;

public class MainMain {

	public static void main(String[] args) {

		DbConnection<EddieBlackTongue> test = new DbConnection<>();

		EddieBlackTongue test2 = new EddieBlackTongue("blah");

		test.create(test2);

		System.out.println(test.read(test2, 0));
	}
}
