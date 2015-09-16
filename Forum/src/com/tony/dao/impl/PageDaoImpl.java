package com.tony.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.tony.dao.PageDao;
import com.tony.util.Page;

@Repository("pageDao")
public class PageDaoImpl<T> extends HibernateDaoSupport implements PageDao<T> {

	@Override
	public Page<T> queryForPage(String hql, int pageSize, int currentPage) {
		int allRow = getAllRowCount(hql);// 总记录数
		int totalPage = Page.countTotalPage(pageSize, allRow);// 总页数
		final int offset = Page.countOffset(pageSize, currentPage);// 当前页开始记录
		final int length = pageSize;// 每页记录数
		final int currentPage1 = Page.countCurrentPage(currentPage);
		List<T> list = doQueryForPage(hql, offset, length);// "一页"的记录

		// 把分页信息保存到Bean中
		Page<T> page = new Page<T>();
		page.setPageSize(pageSize);
		page.setCurrentPage(currentPage1);
		page.setAllRow(allRow);
		page.setTotalPage(totalPage);
		page.setList(list);
		page.init();
		return page;
	}

	@Override
	public Page<T> queryForPage(String hql, Object[] values, int pageSize,
			int currentPage) {
		int allRow = getAllRowCount(hql, values);// 总记录数
		int totalPage = Page.countTotalPage(pageSize, allRow);// 总页数
		final int offset = Page.countOffset(pageSize, currentPage);// 当前页开始记录
		final int length = pageSize;// 每页记录数
		final int currentPage1 = Page.countCurrentPage(currentPage);
		List<T> list = doQueryForPage(hql, values, offset, length);// "一页"的记录

		// 把分页信息保存到Bean中
		Page<T> page = new Page<T>();
		page.setPageSize(pageSize);
		page.setCurrentPage(currentPage1);
		page.setAllRow(allRow);
		page.setTotalPage(totalPage);
		page.setList(list);
		page.init();
		return page;
	}

	public List<T> doQueryForPage(final String hql, final int offset,
			final int length) {

		@SuppressWarnings("unchecked")
		List<T> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						query.setFirstResult(offset);
						query.setMaxResults(length);
						List<T> list = query.list();
						return list;
					}
				});
		return list;
	}

	public int getAllRowCount(String hql) {
		return this.getHibernateTemplate().find(hql).size();
	}

	public List<T> doQueryForPage(final String hql, final Object[] values,
			final int offset, final int length) {

		@SuppressWarnings("unchecked")
		List<T> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);

						for (int i = 0; i < values.length; i++) {
							query.setParameter(i, values[i]);
						}

						query.setFirstResult(offset);
						query.setMaxResults(length);
						List<T> list = query.list();
						return list;
					}
				});
		return list;
	}

	public int getAllRowCount(String hql, Object[] values) {
		return this.getHibernateTemplate().find(hql, values).size();
	}

}
