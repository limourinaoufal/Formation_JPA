package ma.lndroid.tp.entity.manager.mapping.one.to.many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import ma.lndroid.tp.JpaManager;
import ma.lndroid.tp.entity.manager.mapping.one.to.many.dto.LibraryOneToMany;
import ma.lndroid.tp.entity.manager.mapping.one.to.many.dto.StudentOneToMany;



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

			StudentOneToMany s1 =new StudentOneToMany("ST_1");
				LibraryOneToMany l1 = new LibraryOneToMany("LIB_1");
					s1.getLibrary().add(l1);	

					
					StudentOneToMany s2 =new StudentOneToMany("ST_2");
					LibraryOneToMany l2 = new LibraryOneToMany("LIB_2");
					s2.getLibrary().add(l2);
					
					
					LibraryOneToMany l3 = new LibraryOneToMany("LIB_3");
					s2.getLibrary().add(l3);

			em.persist(s1);
			em.persist(s2);
			
			System.out.println(s1);
			System.out.println(s2);
			
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
