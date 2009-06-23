/**
 * 
 */
package ar.com.alderian.fatfree.service;

import java.util.List;

import ar.com.alderian.fatfree.dao.AbstractBaseDao;
import ar.com.alderian.fatfree.entity.AbstractBaseEntity;

/**
 * @author oalvarez
 * 
 * @param <T>
 */
public abstract class AbstractBaseServiceImpl<T extends AbstractBaseEntity>
		implements AbstractBaseService<T> {

	private AbstractBaseDao<T> baseDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.alderian.fatfree.service.AbstractBaseService#count()
	 */
	public int count() {
		return baseDao.count();
	}

	public void create(T t) {
		baseDao.persist(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ar.com.alderian.fatfree.service.AbstractBaseService#delete(java.lang.
	 * Object)
	 */
	public void delete(T t) {
		baseDao.delete(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ar.com.alderian.fatfree.service.AbstractBaseService#find(java.lang.Long)
	 */
	public T find(Long id) {
		return baseDao.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.alderian.fatfree.service.AbstractBaseService#list()
	 */
	public List<T> list() {
		return baseDao.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ar.com.alderian.fatfree.service.AbstractBaseService#update(java.lang.
	 * Object)
	 */
	public void update(T t) {
		baseDao.update(t);

	}

	/**
	 * @return the baseDao
	 */
	public AbstractBaseDao<T> getBaseDao() {
		return baseDao;
	}

	/**
	 * @param baseDao
	 *            the baseDao to set
	 */
	public void setBaseDao(AbstractBaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

}
