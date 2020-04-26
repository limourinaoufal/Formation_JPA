package ma.lndroid.tp;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaManager {

	private final static String PATH = "Formation_JPA";

	private static EntityManagerFactory entityManagerFactory = null;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(PATH);
		}
		return entityManagerFactory;
	}
	
	public static void closeEntityManagerFactory () {
		if(entityManagerFactory != null) 
			entityManagerFactory.close();
	}
	
	

}
