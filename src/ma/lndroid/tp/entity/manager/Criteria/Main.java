package ma.lndroid.tp.entity.manager.Criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ma.lndroid.tp.JpaManager;
import ma.lndroid.tp.entity.manager.Criteria.dto.StudentEntityCriteria;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = JpaManager.getEntityManagerFactory();
		EntityManager em = null;
		EntityTransaction entityTransaction = null;

		insertingAnEntityByCriteria(emf, em, entityTransaction);

		someOfFeatchSturcturByCriteria(emf, em);

		JpaManager.closeEntityManagerFactory();

	}

	private static void someOfFeatchSturcturByCriteria(
			EntityManagerFactory emf, EntityManager em) {
		try {
			em = emf.createEntityManager();
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Integer> criteriaQuery = criteriaBuilder
					.createQuery(Integer.class);
			Root<StudentEntityCriteria> from = criteriaQuery
					.from(StudentEntityCriteria.class);
			criteriaQuery.select(from.get("id"));
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get("id")));
			criteriaQuery.where(criteriaBuilder.between(from.get("id"), 1, 3));
			TypedQuery<Integer> typeQuery = em.createQuery(criteriaQuery);
			List<Integer> list = typeQuery.getResultList();
			System.out.print("Result Student Id between 1 et 3 : ");
			for (Integer i : list)
				System.out.print(i + " - ");
			System.out.println();

			CriteriaQuery<Object[]> criteriaQuery2 = criteriaBuilder
					.createQuery(Object[].class);
			Root<StudentEntityCriteria> from2 = criteriaQuery2
					.from(StudentEntityCriteria.class);
			criteriaQuery2.multiselect(from.get("age"),
					criteriaBuilder.count(from.get("id")));
			criteriaQuery2.groupBy(from.get("age"));
			criteriaQuery2.having(criteriaBuilder.greaterThan(from.get("age"),
					25));

			System.out
					.println("group => count students by grouppping by Age with clause age > 25 ");
			TypedQuery<Object[]> typeQuery2 = em.createQuery(criteriaQuery2);
			List<Object[]> vv = typeQuery2.getResultList();
			for (Object[] v : vv)
				System.out.println("\t" + v[0] + " => ( " + v[1] + " ) ");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null)
				em.close();
		}

	}

	private static void findingInfoFromDbJpql(EntityManagerFactory emf,
			EntityManager em) {
		System.out.println("#FIND FILTER INFO INTO DB: ");
		try {
			em = emf.createEntityManager();

			Query q = null;
			StudentEntityCriteria s = null;

			q = em.createQuery("SELECT s FROM StudentEntityCriteria s WHERE s.age between ?1 and ?2");
			q.setParameter(1, 21);
			q.setParameter(2, 23);
			List<StudentEntityCriteria> ls = q.getResultList();
			for (StudentEntityCriteria ss : ls)
				System.out.println("\t data between : 21 and 23 =>  " + ss);

			q = em.createQuery("SELECT s FROM StudentEntityCriteria s WHERE s.name like '%-1%'");
			s = (StudentEntityCriteria) q.getSingleResult();
			System.out.println("\t like by name %-1% " + s);

			q = em.createQuery("SELECT count(s.name) FROM StudentEntityCriteria s");
			System.out.println("\t count ID :" + q.getSingleResult());

			q = em.createQuery("SELECT sum(s.id) FROM StudentEntityCriteria s");
			System.out.println("\t sum ID :" + q.getSingleResult());

			q = em.createQuery("SELECT max(s.id) FROM StudentEntityCriteria s");
			System.out.println("\t max ID :" + q.getSingleResult());

			q = em.createQuery("SELECT min(s.id) FROM StudentEntityCriteria s");
			System.out.println("\t min ID :" + q.getSingleResult());
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

			Query q = em
					.createQuery("DELETE FROM StudentEntityCriteria WHERE id=:pk_seq");
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

			Query q = em
					.createQuery("UPDATE StudentEntityCriteria set name=?1 where id=?2 ");
			q.setParameter(1, newName);
			q.setParameter(2, id);
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

	private static void findingAnEntityByNameCriteria(EntityManagerFactory emf,
			EntityManager em, String name) {
		System.out.println("#FINDING AN ENTITY FROM DB: name=>{" + name + "}.");
		try {
			em = emf.createEntityManager();

			Query q = em.createNamedQuery("getByNameSTJpql");
			q.setParameter("jpqlName", name);
			List<StudentEntityCriteria> l = q.getResultList();
			for (StudentEntityCriteria s : l)
				System.out.println("\t" + s);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null)
				em.close();
		}
	}

	private static void insertingAnEntityByCriteria(EntityManagerFactory emf,
			EntityManager em, EntityTransaction entityTransaction) {
		System.out.println("#INSERTING AN ENTITY  TO DB:");
		try {
			em = emf.createEntityManager();
			entityTransaction = em.getTransaction();

			for (int i = 1; i < 10; i++) {
				entityTransaction.begin();
				StudentEntityCriteria s = new StudentEntityCriteria(
						"AAAA-" + i, i + 20);
				if ((i % 2) == 0) {
					StudentEntityCriteria s2 = new StudentEntityCriteria(
							"AAAA-" + i, i + 20);
					em.persist(s2);
				}
				em.persist(s);
				entityTransaction.commit();
			}

			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

			CriteriaQuery<StudentEntityCriteria> criteriaQuery = criteriaBuilder
					.createQuery(StudentEntityCriteria.class);

			Root<StudentEntityCriteria> from = criteriaQuery
					.from(StudentEntityCriteria.class);
			criteriaQuery.select(from);
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get("id")));

			CriteriaQuery<StudentEntityCriteria> select = criteriaQuery
					.select(from);

			TypedQuery<StudentEntityCriteria> typedQuery = em
					.createQuery(select);

			List<StudentEntityCriteria> listStudents = typedQuery
					.getResultList();
			for (StudentEntityCriteria s : listStudents)
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
