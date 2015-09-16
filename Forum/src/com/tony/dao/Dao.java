package com.tony.dao;


public interface Dao {
	
	/**
	 * 保存一个对象
	 * @param entity
	 */
	public void save(Object entity);
	
	/**
	 * 更新一个对象
	 * @param entity
	 */
	public void update(Object entity);
	
	/**
	 * 运用泛型的方式对传入的类型根据id进行删除
	 * @param <T>
	 * @param entityClass 实体类型
	 * @param entityid 实体id
	 */
	public <T> void delete(Class<T> entityClass,Object entityid);
	
	/**
	 * 运用泛型的方式同时删除传入的多个id所对应的对象
	 * @param <T>
	 * @param entityClass 实体类型
	 * @param entityid 实体id
	 */
	public <T> void deletes(Class<T> entityClass,Object[] entityid);
	
	/**
	 * 对指定对象根据id进行查找
	 * @param <T>
	 * @param entityClass 实体类型
	 * @param entityId 实体id
	 * @return
	 */
	public <T> T find(Class<T> entityClass,Object entityId);

}
