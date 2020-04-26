package ma.lndroid.tp.entity.manager.Inheritence.table.per.entity.strategy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import ma.lndroid.tp.JpaManager;
import ma.lndroid.tp.entity.manager.Inheritence.table.per.entity.strategy.dto.ActiveEmployeeTPC;
import ma.lndroid.tp.entity.manager.Inheritence.table.per.entity.strategy.dto.EmployeeTPC;
import ma.lndroid.tp.entity.manager.Inheritence.table.per.entity.strategy.dto.RetiredEmployeeTPC;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = JpaManager.getEntityManagerFactory();
		EntityManager em = null;
		EntityTransaction entityTransaction = null;

		try {
			em = emf.createEntityManager();
			entityTransaction = em.getTransaction();

			EmployeeTPC e1 = new EmployeeTPC("E1");
			EmployeeTPC e2 = new EmployeeTPC("E2");

			ActiveEmployeeTPC e3 = new ActiveEmployeeTPC(33333, 33, "E3");
			ActiveEmployeeTPC e4 = new ActiveEmployeeTPC(44444, 44, "E4");

			RetiredEmployeeTPC e5 = new RetiredEmployeeTPC(55555, "E5");
			RetiredEmployeeTPC e6 = new RetiredEmployeeTPC(66666, "E6");

			em.persist(e1);
			em.persist(e2);
			em.persist(e3);
			em.persist(e4);
			em.persist(e5);
			em.persist(e6);

			entityTransaction.begin();
			entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (entityTransaction != null)
				entityTransaction.rollback();
		} finally {
			if (em != null)
				em.close();
		}

		JpaManager.closeEntityManagerFactory();

	}

}
