package com.tony.dao;

import java.util.List;

import com.tony.util.Page;


public interface PageDao<T> {

	/** 
	* ��ҳ��ѯ 
	* @param currentPage ��ǰ�ڼ�ҳ 
	* @param pageSize ÿҳ��С 
	* @return ����˷�ҳ��Ϣ(������¼��list)��Bean 
	*/ 
	public Page<T> queryForPage(String hql,int pageSize,int currentPage);
	
	/** 
	* ��ҳ��ѯ 
	* @param currentPage ��ǰ�ڼ�ҳ 
	* @param values ��ѯ�����еĲ���
	* @param pageSize ÿҳ��С 
	* @return ����˷�ҳ��Ϣ(������¼��list)��Bean 
	*/ 
	public Page<T> queryForPage(String hql,Object[] values,int pageSize, int currentPage);
	/**
	* ��ҳ��ѯʵ�ֺ��� 
	* @param hql ��ѯ������ 
	* @param offset ��ʼ��¼ 
	* @param length һ�β�ѯ������¼ 
	* @return 
	*/ 
	public  List<T> doQueryForPage(final String hql,final int offset,final int length); 

	/** 
	* ��ѯ���м�¼�� 
	* @param hql ��ѯ������ 
	* @return �ܼ�¼�� 
	*/ 
	public int getAllRowCount(String hql); 

	/**
	* ��ҳ��ѯʵ�ֺ��� 
	* @param hql ��ѯ������ 
	* @param values ��ѯ�����еĲ���
	* @param offset ��ʼ��¼ 
	* @param length һ�β�ѯ������¼ 
	* @return 
	*/
    public List<T> doQueryForPage(final String hql,final Object[] values,final int offset,final int length);

    /** 
	* ��ѯ���м�¼�� 
	* @param hql ��ѯ������ 
	* @param values ��ѯ�����еĲ���
	* @return �ܼ�¼�� 
	*/ 
    public int getAllRowCount(String hql,Object[] values);
    
}
