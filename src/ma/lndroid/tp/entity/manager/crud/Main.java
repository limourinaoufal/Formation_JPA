package ma.lndroid.tp.entity.manager.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import ma.lndroid.tp.JpaManager;
import ma.lndroid.tp.entity.manager.crud.dto.StudentEntity;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = JpaManager.getEntityManagerFactory();
		EntityManager em = null;
		EntityTransaction entityTransaction = null;

		insertingAnEntity(emf, em, entityTransaction);
		findingAnEntity(emf, em, 2);
		updateAnEntity(emf, em,entityTransaction, 2, "HELLO");
		deletingAnEntity(emf, em,entityTransaction, 2);
		
		JpaManager.closeEntityManagerFactory();

	}

	private static void deletingAnEntity(EntityManagerFactory emf,
			EntityManager em, EntityTransaction entityTransaction, int id) {
		System.out.println("#DELETE AN ENTITY FROM DB: id=>{"+id+"}");
		try {
			em = emf.createEntityManager();
			entityTransaction = em.getTransaction();
			entityTransaction.begin();
			
			StudentEntity s = em.find(StudentEntity.class, id);
				System.out.println("\t-BEFORE DEL =>"+s);
			em.remove(s);
			s = em.find(StudentEntity.class, id);
				System.out.println("\t-AFTER DEL =>"+s);
				
				entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(entityTransaction != null)
				entityTransaction.rollback();
		} finally {
			if (em != null)
				em.close();
		}
	}

	private static void updateAnEntity(EntityManagerFactory emf,
			EntityManager em,EntityTransaction entityTransaction, int id, String newName) {
		System.out.println("#UPDATE AN ENTITY FROM DB: id=>{"+id+"} WITH NAME:{"+newName+"}.");
		try {
			em = emf.createEntityManager();
			entityTransaction = em.getTransaction();
			entityTransaction.begin();
			StudentEntity s = em.find(StudentEntity.class, id);
				System.out.println("\t-BEFORE UPDTAE =>"+s);
			s.setName(newName);
				System.out.println("\t-AFTER UPDATE =>"+s);
				
				entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(entityTransaction != null)
				entityTransaction.rollback();
		} finally {
			if (em != null)
				em.close();
		}
	}

	private static void findingAnEntity(EntityManagerFactory emf,
			EntityManager em, int id) {
		System.out.println("#FINDING AN ENTITY FROM DB: id=>{"+id+"}.");
		try {
			em = emf.createEntityManager();

			StudentEntity s = em.find(StudentEntity.class, id);

			System.out.println("\t"+s);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null)
				em.close();
		}
	}

	private static void insertingAnEntity(EntityManagerFactory emf,
			EntityManager em, EntityTransaction entityTransaction) {
		System.out.println("#INSERTING AN ENTITY  TO DB:");
		try {
			em = emf.createEntityManager();
			entityTransaction = em.getTransaction();

			entityTransaction.begin();

			StudentEntity s1 = new StudentEntity(1, "AAAA", 10);
			StudentEntity s2 = new StudentEntity(2, "AAAA", 10);
			StudentEntity s3 = new StudentEntity(3, "AAAA", 10);
			
			System.out.println("\t"+s1);
			System.out.println("\t"+s2);
			System.out.println("\t"+s3);

			em.persist(s1);
			em.persist(s2);
			em.persist(s3);

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
