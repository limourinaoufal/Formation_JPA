package ma.lndroid.tp.entity.manager.mapping.many.to.one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import ma.lndroid.tp.JpaManager;
import ma.lndroid.tp.entity.manager.mapping.many.to.one.dto.LibraryManyToOne;
import ma.lndroid.tp.entity.manager.mapping.many.to.one.dto.StudentManyToOne;
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
			
			LibraryManyToOne l1 = new LibraryManyToOne("LIB_1");
				
			
			StudentManyToOne s1 =new StudentManyToOne("ST_1");
			s1.setLibrary(l1);	

					
			StudentManyToOne s2 =new StudentManyToOne("ST_2");
			s2.setLibrary(l1);
					
			StudentManyToOne s3 =new StudentManyToOne("ST_3");
			s3.setLibrary(l1);
			

			em.persist(s1);
			em.persist(s2);
			em.persist(s3);
			
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
			
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
