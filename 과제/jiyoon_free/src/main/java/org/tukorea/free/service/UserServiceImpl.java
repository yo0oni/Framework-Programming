package org.tukorea.free.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.free.domain.UserVO;
import org.tukorea.free.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDAO dao;
	
	@Autowired
	public UserServiceImpl(UserDAO dao) {
		this.dao = dao;
	}
	

	@Override
	public boolean login(String id, String password) {
		UserVO user = dao.readById(id);
		
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
	}

	@Override
	public UserVO selectById(String id) {
		return dao.readById(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, timeout = 10)
	public void saveUsers(UserVO user1, UserVO user2) {
		dao.save(user1);
		dao.save(user2);
	}
}
