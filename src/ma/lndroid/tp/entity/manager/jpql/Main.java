package ma.lndroid.tp.entity.manager.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ma.lndroid.tp.JpaManager;
import ma.lndroid.tp.entity.manager.jpql.dto.StudentEntityJpql;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = JpaManager.getEntityManagerFactory();
		EntityManager em = null;
		EntityTransaction entityTransaction = null;

		insertingAnEntityByJpql(emf, em, entityTransaction);
		
		findingAnEntityByNameJpql(emf, em, "AAAA-2");
		
		updateAnEntityJpql(emf, em,entityTransaction, 2, "HELLO");
			findingAnEntityByNameJpql(emf, em, "HELLO");
		
			deletingAnEntityJpql(emf, em,entityTransaction, 2);
			findingAnEntityByNameJpql(emf, em, "HELLO");
			
			findingInfoFromDbJpql(emf, em);

		JpaManager.closeEntityManagerFactory();

	}

	private static void findingInfoFromDbJpql(EntityManagerFactory emf,
			EntityManager em) {
		System.out.println("#FIND FILTER INFO INTO DB: ");
		try {
			em = emf.createEntityManager();

			Query q = null;
			StudentEntityJpql s = null;
			
			q = em.createQuery("SELECT s FROM StudentEntityJpql s WHERE s.age between ?1 and ?2");
			q.setParameter(1, 21);
			q.setParameter(2, 23);
			List<StudentEntityJpql> ls = q.getResultList();
			for(StudentEntityJpql ss:ls)
				System.out.println("\t data between : 21 and 23 =>  "+ss);
		
			q = em.createQuery("SELECT s FROM StudentEntityJpql s WHERE s.name like '%-1%'");
				 s = (StudentEntityJpql) q.getSingleResult();
					System.out.println("\t like by name %-1% "+s);
			
			q = em.createQuery("SELECT count(s.name) FROM StudentEntityJpql s");
					System.out.println("\t count ID :"+q.getSingleResult());
			
			q = em.createQuery("SELECT sum(s.id) FROM StudentEntityJpql s");
						System.out.println("\t sum ID :"+q.getSingleResult());

			q = em.createQuery("SELECT max(s.id) FROM StudentEntityJpql s");
						System.out.println("\t max ID :"+q.getSingleResult());	
						
			q = em.createQuery("SELECT min(s.id) FROM StudentEntityJpql s");
			 			System.out.println("\t min ID :"+q.getSingleResult());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null)
				em.close();
		}
	}

	private static void deletingAnEntityJpql(EntityManagerFactory emf,
			EntityManager em, EntityTransaction entityTransaction, int id) {
		System.out.println("#DELETE AN ENTITY FROM DB: id=>{" + id + "}");
		try {
			em = emf.createEntityManager();
			entityTransaction = em.getTransaction();
			entityTransaction.begin();

			
			
			Query q = em.createQuery("DELETE FROM StudentEntityJpql WHERE id=:pk_seq");
			q.setParameter("pk_seq", id);
			q.executeUpdate();
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

	private static void updateAnEntityJpql(EntityManagerFactory emf,
			EntityManager em, EntityTransaction entityTransaction, int id,
			String newName) {
		System.out.println("#UPDATE AN ENTITY FROM DB: id=>{" + id
				+ "} WITH NAME:{" + newName + "}.");
		try {
			em = emf.createEntityManager();
			entityTransaction = em.getTransaction();
			entityTransaction.begin();
			
			
			 Query q = em.createQuery("UPDATE StudentEntityJpql set name=?1 where id=?2 ");
			q.setParameter(1,newName);
			q.setParameter(2,id);
			q.executeUpdate();
	
			

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

	private static void findingAnEntityByNameJpql(EntityManagerFactory emf,
			EntityManager em, String name) {
		System.out.println("#FINDING AN ENTITY FROM DB: name=>{" + name + "}.");
		try {
			em = emf.createEntityManager();

			Query q = em.createNamedQuery("getByNameSTJpql");
			q.setParameter("jpqlName", name);
			List<StudentEntityJpql> l = q.getResultList();
			for (StudentEntityJpql s : l)
				System.out.println("\t" + s);
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null)
				em.close();
		}
	}

	private static void insertingAnEntityByJpql(EntityManagerFactory emf,
			EntityManager em, EntityTransaction entityTransaction) {
		System.out.println("#INSERTING AN ENTITY  TO DB:");
		try {
			em = emf.createEntityManager();
			entityTransaction = em.getTransaction();

			for (int i = 1; i < 5; i++) {
				entityTransaction.begin();
				StudentEntityJpql s = new StudentEntityJpql("AAAA-" + i, i + 20);
				em.persist(s);
				entityTransaction.commit();
			}

			Query query = em.createQuery("select s from StudentEntityJpql s");
			List<StudentEntityJpql> l = query.getResultList();
			for (StudentEntityJpql s : l)
				System.out.println("\t" + s);

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
