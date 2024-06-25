package org.tukorea.free.service;

import org.tukorea.free.domain.UserVO;

public interface UserService {
    boolean login(String id, String password);
    UserVO selectById(String id);
	void saveUsers(UserVO user1, UserVO user2);
}