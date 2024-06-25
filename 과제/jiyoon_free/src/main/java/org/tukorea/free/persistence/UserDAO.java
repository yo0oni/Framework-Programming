package org.tukorea.free.persistence;

import org.tukorea.free.domain.UserVO;

public interface UserDAO {

	UserVO readById(String id);
	void update(UserVO user);
	void save(UserVO user);

}
