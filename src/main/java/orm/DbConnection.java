package orm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DbConnection<T> {

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction et;

	public DbConnection() {
		this.emf = emf = Persistence.createEntityManagerFactory("default");
		this.em = emf.createEntityManager();
		this.et = em.getTransaction();
	}

	// The T object must have a constructor which inputs ALL the information
	public void create(T t) {
		try {
			et.begin();

			em.persist(t);

			et.commit();
		} finally {
			if (et.isActive()) {
				et.rollback();
			}
			em.close();
			emf.close();
		}
	}

	public T read(T t, int id) {

		T returnObject;

		try {
			et.begin();

			returnObject = (T) em.find(t.getClass(), id);

			et.commit();
		} finally {
			if (et.isActive()) {
				et.rollback();
			}
			em.close();
			emf.close();
		}

		return returnObject;
	}

	public void update(T t) {

		try {
			et.begin();

			em.refresh(t);

			et.commit();
		} finally {
			if (et.isActive()) {
				et.rollback();
			}
			em.close();
			emf.close();
		}

	}

	public void delete(T t) {

		try {
			et.begin();

			em.remove(t);

			et.commit();
		} finally {
			if (et.isActive()) {
				et.rollback();
			}
			em.close();
			emf.close();
		}

	}
}
