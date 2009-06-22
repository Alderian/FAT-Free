/**
 * 
 */
package ar.com.alderian.fatfree.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author oalvarez
 * 
 *         Base DAO to implement basic functionality
 * 
 */
// PersistenceExceptions will be auto-translated due to @Repository
@Repository
// AbstractBaseDaoImpl Will automatically be transactional. Any class that
// extends this Dao is transactional
@Transactional
public abstract class AbstractBaseDaoImpl<T> implements AbstractBaseDao<T> {

	private static final Log log = LogFactory.getLog(AbstractBaseDaoImpl.class);

	@PersistenceContext(unitName = "entityManager")
	protected EntityManager entityManager;

	/**
	 * For implementing some Queries
	 */
	protected abstract String getQueryFindById();

	protected abstract String getQueryFindAll();

	protected abstract String getQueryCountAll();

	/**
	 * If necessary, implement this method to fill static tables. Also you can
	 * use it to initialize the content of a table
	 */
	public abstract void populateDatabase();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ar.com.alderian.fatfree.dao.AbstractBaseDao#persist(java.lang.Object)
	 */
	public void persist(final T t) {
		log.debug("Persisting object " + t.getClass().getName() + " Values "
				+ t.toString());
		entityManager.persist(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.alderian.fatfree.dao.AbstractBaseDao#update(java.lang.Object)
	 */
	public void update(final T t) {
		log.debug("Updating object " + t.getClass().getName() + " Values "
				+ t.toString());
		entityManager.merge(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.alderian.fatfree.dao.AbstractBaseDao#delete(java.lang.Object)
	 */
	public void delete(final T t) {
		log.debug("Removing object " + t.getClass().getName() + " Values "
				+ t.toString());
		entityManager.remove(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.alderian.fatfree.dao.AbstractBaseDao#list()
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> list() {
		List<T> result;

		// log.debug("Listing object " + t.getClass().getName());

		result = (List<T>) entityManager.createQuery(this.getQueryFindAll())
				.getResultList();

		log.debug("Result ---> ");
		if (log.isDebugEnabled()) {
			for (T t : result) {
				log.debug("Value " + t.toString());
			}
		}
		log.debug("<---------- ");

		return result;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.alderian.fatfree.dao.AbstractBaseDao#find(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	public T find(final Long id) {
		T result;

			result = (T) entityManager.createQuery(getQueryFindById())
					.setParameter("id", id).getSingleResult();

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.alderian.fatfree.dao.AbstractBaseDao#count()
	 */
	@Transactional(readOnly = true)
	public int count() {
		int result;

		// log.debug("Counting objects " + t.getClass().getName());

		result = ((Long) entityManager.createQuery(this.getQueryCountAll())
				.getSingleResult()).intValue();

		// log.debug("Object " + t.getClass().getName() + " count " + result);
		return result;
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}