package org.tukorea.di.persistence;

import java.util.List;

import org.tukorea.di.domain.StudentVO;

public interface MemberDAO {
	void add(StudentVO student);

	StudentVO read(String id);

	List<StudentVO> readList();

	int delete(String id);
	
	void modify(StudentVO student);
}
