package com.tony.dao;

import java.util.List;

import com.tony.util.Page;


public interface PageDao<T> {

	/** 
	* 分页查询 
	* @param currentPage 当前第几页 
	* @param pageSize 每页大小 
	* @return 封闭了分页信息(包括记录集list)的Bean 
	*/ 
	public Page<T> queryForPage(String hql,int pageSize,int currentPage);
	
	/** 
	* 分页查询 
	* @param currentPage 当前第几页 
	* @param values 查询条件中的参数
	* @param pageSize 每页大小 
	* @return 封闭了分页信息(包括记录集list)的Bean 
	*/ 
	public Page<T> queryForPage(String hql,Object[] values,int pageSize, int currentPage);
	/**
	* 分页查询实现函数 
	* @param hql 查询的条件 
	* @param offset 开始记录 
	* @param length 一次查询几条记录 
	* @return 
	*/ 
	public  List<T> doQueryForPage(final String hql,final int offset,final int length); 

	/** 
	* 查询所有记录数 
	* @param hql 查询的条件 
	* @return 总记录数 
	*/ 
	public int getAllRowCount(String hql); 

	/**
	* 分页查询实现函数 
	* @param hql 查询的条件 
	* @param values 查询条件中的参数
	* @param offset 开始记录 
	* @param length 一次查询几条记录 
	* @return 
	*/
    public List<T> doQueryForPage(final String hql,final Object[] values,final int offset,final int length);

    /** 
	* 查询所有记录数 
	* @param hql 查询的条件 
	* @param values 查询条件中的参数
	* @return 总记录数 
	*/ 
    public int getAllRowCount(String hql,Object[] values);
    
}
