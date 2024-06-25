package org.tukorea.free.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tukorea.free.domain.ScheduleVO;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "org.tukorea.free.mapper.ScheduleMapper";

	@Override
	public void saveSchedule(ScheduleVO schedule) {
		sqlSession.insert(NAMESPACE + ".insertSchedule", schedule);
	}

	@Override
	public List<ScheduleVO> readList() {
		List<ScheduleVO> vos = sqlSession.selectList(NAMESPACE + ".selectAll");
		return vos;
	}

	@Override
	public ScheduleVO selectById(int id) {
		return sqlSession.selectOne(NAMESPACE + ".select", id);
	}

	@Override
	public List<ScheduleVO> selectByUserId(String userId) {
		return sqlSession.selectList(NAMESPACE + ".selectMy", userId);
	}

	@Override
	public void delete(int id) {
		sqlSession.delete(NAMESPACE + ".delete", id);

	}

	@Override
	public void update(ScheduleVO schedule) {
		sqlSession.update(NAMESPACE + ".update", schedule);
	}
}
