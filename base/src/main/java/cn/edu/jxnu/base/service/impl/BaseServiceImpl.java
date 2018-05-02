package cn.edu.jxnu.base.service.impl;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import cn.edu.jxnu.base.dao.IBaseDao;
import cn.edu.jxnu.base.entity.BaseEntity;
import cn.edu.jxnu.base.service.IBaseService;

/**
 * 系统基接口服务层实现
 * 
 * @author 梦境迷离
 * @time 2018年4月10日 下午5:53:59.
 * @version V1.0
 */
@Transactional
public abstract class BaseServiceImpl<T extends BaseEntity, ID extends Serializable> implements IBaseService<T, ID> {

	public abstract IBaseDao<T, ID> getBaseDao();

	@Override
	public T find(ID id) {
		return getBaseDao().findOne(id);
	}

	@Override
	public List<T> findAll() {
		return getBaseDao().findAll();
	}

	@Override
	public List<T> findList(ID[] ids) {
		List<ID> idList = Arrays.asList(ids);
		return getBaseDao().findAll(idList);
	}

	@Override
	public List<T> findList(Specification<T> spec, Sort sort) {
		return getBaseDao().findAll(spec, sort);
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return getBaseDao().findAll(pageable);
	}

	@Override
	public long count() {
		return getBaseDao().count();
	}

	@Override
	public long count(Specification<T> spec) {
		return getBaseDao().count(spec);
	}

	@Override
	public boolean exists(ID id) {
		return getBaseDao().exists(id);
	}

	@Override
	public void save(T entity) {
		getBaseDao().save(entity);
	}

	public void save(Iterable<T> entitys) {
		getBaseDao().save(entitys);
	}

	@Override
	public T update(T entity) {
		return getBaseDao().saveAndFlush(entity);
	}

	@Override
	public void delete(ID id) {
		getBaseDao().delete(id);
	}

	@Override
	public void deleteByIds(@SuppressWarnings("unchecked") ID... ids) {
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				ID id = ids[i];
				this.delete(id);
			}
		}
	}

	@Override
	public void delete(T[] entitys) {
		List<T> tList = Arrays.asList(entitys);
		getBaseDao().delete(tList);
	}

	@Override
	public void delete(Iterable<T> entitys) {
		getBaseDao().delete(entitys);
	}

	@Override
	public void delete(T entity) {
		getBaseDao().delete(entity);
	}

	@Override
	public List<T> findList(Iterable<ID> ids) {
		return getBaseDao().findAll(ids);
	}

	@Override
	public Page<T> findAll(Specification<T> spec, Pageable pageable) {
		return getBaseDao().findAll(spec, pageable);
	}

}
