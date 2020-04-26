package ma.lndroid.tp.entity.manager.collection.mapping.map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import ma.lndroid.tp.JpaManager;
import ma.lndroid.tp.entity.manager.collection.mapping.map.dto.Address;
import ma.lndroid.tp.entity.manager.collection.mapping.map.dto.MapEmployee;
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

			MapEmployee e1 = new MapEmployee("EMP1");
			Address a1 = new Address("STREET_E1_1", "CITY_E1_1", "COUNTRY_E1_1");
			Address a2 = new Address("STREET_E1_2", "CITY_E1_2", "COUNTRY_E1_2");
			e1.getAdresses().put(1, a1);
			e1.getAdresses().put(2, a2);

			MapEmployee e2 = new MapEmployee("EMP1");
			Address a3 = new Address("STREET_E2_1", "CITY_E2_1", "COUNTRY_E2_1");
			Address a4 = new Address("STREET_E2_2", "CITY_E2_2", "COUNTRY_E2_2");
			e2.getAdresses().put(1, a3);
			e2.getAdresses().put(2, a4);

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
