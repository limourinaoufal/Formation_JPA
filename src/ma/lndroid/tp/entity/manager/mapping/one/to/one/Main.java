package ma.lndroid.tp.entity.manager.mapping.one.to.one;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import ma.lndroid.tp.JpaManager;
import ma.lndroid.tp.entity.manager.collection.mapping.list.dto.Address;
import ma.lndroid.tp.entity.manager.collection.mapping.list.dto.ListEmployee;
import ma.lndroid.tp.entity.manager.crud.dto.StudentEntity;
import ma.lndroid.tp.entity.manager.mapping.many.to.many.dto.StudentManyToMany;
import ma.lndroid.tp.entity.manager.mapping.one.to.one.dto.LibraryOneToOne;
import ma.lndroid.tp.entity.manager.mapping.one.to.one.dto.StudentOneToOne;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = JpaManager.getEntityManagerFactory();
		EntityManager em = null;
		EntityTransaction entityTransaction = null;

		insertingAnEntity(emf, em, entityTransaction);
		deletingAnEntity(emf, em, entityTransaction, 2);

		JpaManager.closeEntityManagerFactory();

	}
	
	private static void deletingAnEntity(EntityManagerFactory emf,
			EntityManager em, EntityTransaction entityTransaction, int id) {
		System.out.println("#DELETE AN ENTITY FROM DB: id=>{"+id+"}");
		try {
			em = emf.createEntityManager();
			entityTransaction = em.getTransaction();
			entityTransaction.begin();
			
			LibraryOneToOne s = em.find(LibraryOneToOne.class, id);
				System.out.println("\t-BEFORE DEL =>"+s);

			em.remove(s);
			s = em.find(LibraryOneToOne.class, id);
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

	private static void insertingAnEntity(EntityManagerFactory emf,
			EntityManager em, EntityTransaction entityTransaction) {
		System.out.println("#INSERTING AN ENTITY  TO DB:");
		try {
			em = emf.createEntityManager();
			entityTransaction = em.getTransaction();

			entityTransaction.begin();

			StudentOneToOne s1 =new StudentOneToOne("ST_1");
				LibraryOneToOne l1 = new LibraryOneToOne("LIB_1");
					l1.setStudent(s1);	
					
			StudentOneToOne s2 =new StudentOneToOne("ST_2");
				LibraryOneToOne l2 = new LibraryOneToOne("LIB_2");
					l2.setStudent(s2);	
			
			em.persist(l1);
			em.persist(l2);
			
			System.out.println(l1);
			System.out.println(l2);
			
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
