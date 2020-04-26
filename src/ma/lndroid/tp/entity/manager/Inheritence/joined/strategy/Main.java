package ma.lndroid.tp.entity.manager.Inheritence.joined.strategy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import ma.lndroid.tp.JpaManager;
import ma.lndroid.tp.entity.manager.Inheritence.joined.strategy.dto.ActiveEmployeeJS;
import ma.lndroid.tp.entity.manager.Inheritence.joined.strategy.dto.EmployeeJS;
import ma.lndroid.tp.entity.manager.Inheritence.joined.strategy.dto.RetiredEmployeeJS;


public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = JpaManager.getEntityManagerFactory();
		EntityManager em = null;
		EntityTransaction entityTransaction = null;
		
		try {
			em = emf.createEntityManager();
			entityTransaction =em.getTransaction();
				
				EmployeeJS e1 = new EmployeeJS("E1");
				EmployeeJS e2 = new EmployeeJS("E2");
				
				ActiveEmployeeJS e3 = new ActiveEmployeeJS(33333, 33,"E3");
				ActiveEmployeeJS e4 = new ActiveEmployeeJS(44444, 44,"E4");
				
				RetiredEmployeeJS e5 = new RetiredEmployeeJS(55555,"E5");
				RetiredEmployeeJS e6 = new RetiredEmployeeJS(66666,"E6");
			
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
			if(entityTransaction != null) entityTransaction.rollback();
		}finally{
			if(em != null) em.close();
		}
		
		JpaManager.closeEntityManagerFactory();

	}

}
