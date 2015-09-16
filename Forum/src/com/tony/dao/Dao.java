package com.tony.dao;


public interface Dao {
	
	/**
	 * ����һ������
	 * @param entity
	 */
	public void save(Object entity);
	
	/**
	 * ����һ������
	 * @param entity
	 */
	public void update(Object entity);
	
	/**
	 * ���÷��͵ķ�ʽ�Դ�������͸���id����ɾ��
	 * @param <T>
	 * @param entityClass ʵ������
	 * @param entityid ʵ��id
	 */
	public <T> void delete(Class<T> entityClass,Object entityid);
	
	/**
	 * ���÷��͵ķ�ʽͬʱɾ������Ķ��id����Ӧ�Ķ���
	 * @param <T>
	 * @param entityClass ʵ������
	 * @param entityid ʵ��id
	 */
	public <T> void deletes(Class<T> entityClass,Object[] entityid);
	
	/**
	 * ��ָ���������id���в���
	 * @param <T>
	 * @param entityClass ʵ������
	 * @param entityId ʵ��id
	 * @return
	 */
	public <T> T find(Class<T> entityClass,Object entityId);

}
