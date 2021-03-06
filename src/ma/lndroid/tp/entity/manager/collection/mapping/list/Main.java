package ma.lndroid.tp.entity.manager.collection.mapping.list;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import ma.lndroid.tp.JpaManager;
import ma.lndroid.tp.entity.manager.collection.mapping.list.dto.Address;
import ma.lndroid.tp.entity.manager.collection.mapping.list.dto.ListEmployee;
import ma.lndroid.tp.entity.manager.crud.dto.StudentEntity;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = JpaManager.getEntityManagerFactory();
		EntityManager em = null;
		EntityTransaction entityTransaction = null;

		insertingAnEntity(emf, em, entityTransaction);

		JpaManager.closeEntityManagerFactory();

	}

	private static void insertingAnEntity(EntityManagerFactory emf,
			EntityManager em, EntityTransaction entityTransaction) {
		System.out.println("#INSERTING AN ENTITY  TO DB:");
		try {
			em = emf.createEntityManager();
			entityTransaction = em.getTransaction();

			entityTransaction.begin();

			ListEmployee e1 = new ListEmployee("EMP1");
			Address a1 = new Address("STREET_E1_1", "CITY_E1_1", "COUNTRY_E1_1");
			Address a2 = new Address("STREET_E1_2", "CITY_E1_2", "COUNTRY_E1_2");
			e1.getAdresses().add(a1);
			e1.getAdresses().add(a2);

			ListEmployee e2 = new ListEmployee("EMP1");
			Address a3 = new Address("STREET_E2_1", "CITY_E2_1", "COUNTRY_E2_1");
			Address a4 = new Address("STREET_E2_2", "CITY_E2_2", "COUNTRY_E2_2");
			e2.getAdresses().add(a3);
			e2.getAdresses().add(a4);

			System.out.println("\t" + e1);
			System.out.println("\t" + e2);

			em.persist(e1);
			em.persist(e2);

			entityTransaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (entityTransaction != null)
				entityTransaction.rollback();
		} finally {
			if (em != null)
				em.close();
		}
	}

}
