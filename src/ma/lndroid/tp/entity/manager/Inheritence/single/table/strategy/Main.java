package ma.lndroid.tp.entity.manager.Inheritence.single.table.strategy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import ma.lndroid.tp.JpaManager;
import ma.lndroid.tp.entity.manager.Inheritence.single.table.strategy.dto.ActiveEmployeeSTS;
import ma.lndroid.tp.entity.manager.Inheritence.single.table.strategy.dto.EmployeeSTS;
import ma.lndroid.tp.entity.manager.Inheritence.single.table.strategy.dto.RetiredEmployeeSTS;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = JpaManager.getEntityManagerFactory();
		EntityManager em = null;
		EntityTransaction entityTransaction = null;
		
		try {
			em = emf.createEntityManager();
			entityTransaction =em.getTransaction();
				
				EmployeeSTS e1 = new EmployeeSTS("E1");
				EmployeeSTS e2 = new EmployeeSTS("E2");
				
				ActiveEmployeeSTS e3 = new ActiveEmployeeSTS(33333, 33,"E3");
				ActiveEmployeeSTS e4 = new ActiveEmployeeSTS(44444, 44,"E4");
				
				RetiredEmployeeSTS e5 = new RetiredEmployeeSTS(55555,"E5");
				RetiredEmployeeSTS e6 = new RetiredEmployeeSTS(66666,"E6");
			
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
