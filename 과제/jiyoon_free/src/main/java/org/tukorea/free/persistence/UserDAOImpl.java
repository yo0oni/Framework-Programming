package org.tukorea.free.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tukorea.free.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "org.tukorea.free.mapper.UserMapper";

	@Override
	public UserVO readById(String id) {
		return sqlSession.selectOne(namespace + ".selectById", id);
	}

	@Override
	public void update(UserVO user) {
		sqlSession.update(namespace + ".update", user);
	}

	@Override
	public void save(UserVO user) {
		sqlSession.update(namespace + ".insert", user);
	}
}
