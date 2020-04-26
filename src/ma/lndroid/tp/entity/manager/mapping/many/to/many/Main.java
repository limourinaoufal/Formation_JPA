package ma.lndroid.tp.entity.manager.mapping.many.to.many;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import ma.lndroid.tp.JpaManager;
import ma.lndroid.tp.entity.manager.crud.dto.StudentEntity;
import ma.lndroid.tp.entity.manager.mapping.many.to.many.dto.LibraryManyToMany;
import ma.lndroid.tp.entity.manager.mapping.many.to.many.dto.StudentManyToMany;

public class Main {

	public static void main(String[] args) {
		System.out.println("START ...");
		EntityManagerFactory emf = JpaManager.getEntityManagerFactory();
		EntityManager em = null;
		EntityTransaction entityTransaction = null;

		insertingAnEntity(emf, em, entityTransaction);
		findingAnEntity(emf, em, 3);
		for(int i=1 ;i<5;i++)
		deletingAnEntity(emf, em, entityTransaction, i);
		
		JpaManager.closeEntityManagerFactory();
		System.out.println("END ...");

	}

	private static void deletingAnEntity(EntityManagerFactory emf,
			EntityManager em, EntityTransaction entityTransaction, int id) {
		System.out.println("#DELETE AN ENTITY FROM DB: id=>{" + id + "}");
		try {
			em = emf.createEntityManager();
			entityTransaction = em.getTransaction();
			entityTransaction.begin();

			StudentManyToMany s = em.find(StudentManyToMany.class, id);
			System.out.println("\t-BEFORE DEL =>" + s);
			
			try {
				em.remove(s);
				entityTransaction.commit();
				System.out.println("Removed Corectly By Cascade");
			} catch (RollbackException e) {
				System.err.println("#Internal Exception: "+e.getClass().getName()+": Cannot delete a parent row by cascade ");
				entityTransaction.begin();
				s = em.find(StudentManyToMany.class, id);
				
				s.setLibrary(null);
				System.out.println("\t-SET LIBRARY OBJECT NULL BEFOR DEL ! => "+s);
				em.remove(s);
				entityTransaction.commit();
			}
			
			s = em.find(StudentManyToMany.class, id);

			System.out.println("\t-AFTER DEL =>" + s);

		} catch (Exception e) {
			e.printStackTrace();
			if (entityTransaction != null && entityTransaction.isActive())
				entityTransaction.rollback();
		} finally {
			if (em != null)
				em.close();
		}
	}

	private static void findingAnEntity(EntityManagerFactory emf,
			EntityManager em, int id) {
		System.out.println("#FINDING AN ENTITY FROM DB: id=>{" + id + "}.");
		try {
			em = emf.createEntityManager();

			StudentManyToMany s = em.find(StudentManyToMany.class, id);

			System.out.println("\t" + s);
			List<LibraryManyToMany> ll = s.getLibrary();
			for (LibraryManyToMany l : ll)
				System.out.println("\t\t" + l);

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

			LibraryManyToMany l1 = new LibraryManyToMany("LIB_1");
			LibraryManyToMany l2 = new LibraryManyToMany("LIB_2");
			LibraryManyToMany l4 = new LibraryManyToMany("LIB_4");

			StudentManyToMany s1 = new StudentManyToMany("ST_1");
			s1.getLibrary().add(l1);
			s1.getLibrary().add(l2);

			StudentManyToMany s2 = new StudentManyToMany("ST_2");
			s2.getLibrary().add(l1);

			StudentManyToMany s3 = new StudentManyToMany("ST_3");
			s3.getLibrary().add(l2);
			
			StudentManyToMany s4 = new StudentManyToMany("ST_4");
			s4.getLibrary().add(l4);

			em.persist(s1);
			em.persist(s2);
			em.persist(s3);
			em.persist(s4);

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
