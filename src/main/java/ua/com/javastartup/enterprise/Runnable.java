package ua.com.javastartup.enterprise;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Runnable {

	public static void main(String[] args) throws Exception {

		EntityManager em = DatabaseConfig.EMF.createEntityManager();
		System.out.println(em.getClass());
		try {
			Query q = em.createQuery("select "
					+ "new ua.com.javastartup.enterprise.PersonNameStatistic"
					+ "(count(p), p.name) "
					+ "from Person p group by p.name");
			System.out.println(q.getResultList());

		} finally {
			em.close();
			DatabaseConfig.EMF.close();
		}
	}

}
