package ar.com.alderian.fatfree.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface AbstractBaseDao<T> {

	public void setEntityManager(EntityManager entityManager);
	public void populateDatabase();
	
	/**
	 * Persist Object
	 * 
	 * @param t
	 *            object to persist
	 */
	public void persist(final T t);

	/**
	 * Update Object
	 * 
	 * @param t
	 *            Object to update
	 */
	public void update(final T t);

	/**
	 * Delete Object
	 * 
	 * @param t
	 *            Object to Delete
	 */
	public void delete(final T t);

	/**
	 * List All instances of Object
	 * 
	 * Method is read-only
	 * 
	 * @return List of all instance of Object
	 */
	public List<T> list();
	
	/**
	 * Find an instance of an Object by Object Id
	 * 
	 * @param id
	 *            The Object id to find
	 * 
	 * @return The Object
	 */
	public T find(final Long id);
	
	/**
	 * Counts every instance of Object
	 * 
	 * @return the count of instances of object
	 */
	public int count();
	
}