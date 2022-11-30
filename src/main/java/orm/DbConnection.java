package orm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

// Dette er en class<T>, så derfor skal den specificeres
public class DbConnection<T> {

	//EMF opretter vores EM, som opretter vores ET. Dette kan ses i constructoren.
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
	private EntityManager em;
	private EntityTransaction et;

	// The T object must have a constructor which inputs ALL the information
	public void create(T t) {

		// Skal skabes hvergang den lukkes.
		this.em = emf.createEntityManager();
		this.et = em.getTransaction();

		try {
			et.begin();

			em.persist(t);

			et.commit();
		} finally {
			if (et.isActive()) {
				et.rollback();
			}
			em.close();
		}
	}

	public T read(T t, int id) {

		em.flush();
		this.et = em.getTransaction();

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
		}

		return returnObject;
	}

	public void update(T t) {

		this.em = emf.createEntityManager();
		this.et = em.getTransaction();

		try {
			et.begin();

			em.refresh(t);

			et.commit();
		} finally {
			if (et.isActive()) {
				et.rollback();
			}
			em.close();
		}

	}

	public void delete(T t) {

		this.em = emf.createEntityManager();
		this.et = em.getTransaction();

		try {
			et.begin();

			em.remove(t);

			et.commit();
		} finally {
			if (et.isActive()) {
				et.rollback();
			}
			em.close();
		}

	}
}
