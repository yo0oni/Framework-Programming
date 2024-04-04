package org.tukorea.di.main;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.tukorea.di.controller.MemberManageController;
import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.service.MemberService;
import org.tukorea.di.view.OutputView;

public class MemberSampleMain {

	public static void main(String[] args) {
		MemberManageController  memberManageController = new MemberManageController();
		memberManageController.start();
	}
}
