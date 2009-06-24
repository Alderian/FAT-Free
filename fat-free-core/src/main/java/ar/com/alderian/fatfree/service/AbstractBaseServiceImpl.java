/**
 * 
 */
package ar.com.alderian.fatfree.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.alderian.fatfree.entity.AbstractBaseEntity;

/**
 * @author oalvarez
 * 
 *         Base DAO to implement basic functionality
 * 
 *         PersistenceExceptions will be auto-translated due to @Repository.
 *         AbstractBaseDaoImpl Will automatically be transactional due to @Transactional
 *         Any class that extends this Dao is Transactional and Repository
 * 
 * @param <T>
 */
@Repository
@Transactional
public abstract class AbstractBaseServiceImpl<T extends AbstractBaseEntity>
		implements AbstractBaseService<T> {

	private static final Log log = LogFactory
			.getLog(AbstractBaseServiceImpl.class);

	protected EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.alderian.fatfree.dao.AbstractBaseDao#setEntityManager(javax.
	 * persistence.EntityManager)
	 */
	@PersistenceContext(unitName = "entityManager")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

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
		final List<T> result;

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
		final T result;

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
		final int result;

		result = ((Long) entityManager.createQuery(this.getQueryCountAll())
				.getSingleResult()).intValue();

		return result;
	}

}
