package com.akhi.store.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.akhi.store.general.User;
import com.akhi.store.service.UserServiceImplDao;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private DataSource dataSource;

	private static org.apache.log4j.Logger log = Logger
			.getLogger(UserDaoImpl.class);

	@Override
	public User findById(Long id, boolean lock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByExample(User exampleInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User makePersistent(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeTransient(User entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findByIdAndPassword(String id, String password) {
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>UserDaoImpl findByIdAndPassword" + dataSource);
		return null;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
