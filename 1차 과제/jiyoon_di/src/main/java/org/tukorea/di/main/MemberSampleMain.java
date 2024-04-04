package org.tukorea.di.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.service.MemberService;

public class MemberSampleMain {
	private static ApplicationContext ctx = null;

	public static void main(String[] args) throws Exception {
		ctx = new GenericXmlApplicationContext("applicationContext.xml");

		while (true) {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.println("----------------------------------------");
			System.out.println();
			System.out.println("           학생 정보 관리 시스템");
			System.out.println();
			System.out.println("----------------------------------------");
			System.out.println("1. 전체 학생 정보 출력");
			System.out.println("2. 개인 학생 정보 출력");
			System.out.println("3. 개인 학생 정보 생성");
			System.out.println("4. 개인 학생 정보 삭제");
			System.out.println("5. 개인 학생 정보 수정");
			System.out.println("9. 프로그램 종료");
			System.out.println("----------------------------------------");
			System.out.print(" 번호 선택 >> ");

			try {
				int sel = Integer.parseInt(scan.nextLine());
				System.out.println("----------------------------------------");
				switch (sel) {
				case 1:
					printStudentInformationList();
					continue;
				case 2:
					printStudentInformation();
					continue;
				case 3:
					createStudentInformation();
					continue;
				case 4:
					deleteStudentInformation();
					continue;
				case 5:
					modifyStudentInformation();
					continue;
				case 9:
					System.out.println("안녕히 가세요.");
					return;
				default:
					throw new IllegalArgumentException();
				}
			} catch (NumberFormatException e) {
				System.out.println("----------------------------------------");
				System.out.println("[Error] 잘못된 입력입니다. 숫자를 입력해 주세요.");
				continue;
			} catch (IllegalArgumentException e) {
				System.out.println("[Error] 잘못된 번호입니다. 다시 입력해 주세요.");
				continue;
			}
		}
	}

	private static void modifyStudentInformation() throws Exception {
		MemberService memberService = ctx.getBean(MemberService.class);
		JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);

		System.out.print(" 학생 아이디 입력 >> ");
		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			String id = scan.next();

			System.out.println("----------------------------------------");
			System.out.println("아이디 존재 여부를 검사 중입니다···");
			System.out.println("----------------------------------------");
			String query = "SELECT COUNT(*) FROM STUDENT WHERE id = ?";
			int count = jdbcTemplate.queryForObject(query, Integer.class, id);

			if (count == 0) {
				throw new IllegalArgumentException();
			}

			System.out.println("----------------------------------------");
			System.out.println("존재하는 아이디입니다. 수정 가능합니다.");
			System.out.println("----------------------------------------");
			System.out.print(" password >> ");
			String passwd = scan.next();
			System.out.print(" username >> ");
			String username = scan.next();
			System.out.print(" snum     >> ");
			String snum = scan.next();
			System.out.print(" depart   >> ");
			String depart = scan.next();
			System.out.print(" mobile   >> ");
			String mobile = scan.next();
			System.out.print(" email    >> ");
			String email = scan.next();
			System.out.println("----------------------------------------");

			StudentVO vo = new StudentVO();
			vo.setId(id);
			vo.setPasswd(passwd);
			vo.setUsername(username);
			vo.setSnum(snum);
			vo.setDepart(depart);
			vo.setMobile(mobile);
			vo.setEmail(email);

			memberService.modifyMember(vo);

			System.out.println("----------------------------------------");
			System.out.println("[Notice] 입력하신 학생의 정보가 수정되었습니다.");

		} catch (IllegalArgumentException exception) {
			System.out.println("----------------------------------------");
			System.out.println("[Error] 존재하지 않는 아이디입니다. 다시 입력해 주세요.");

		}
	}

	private static void deleteStudentInformation() throws Exception {
		MemberService memberService = ctx.getBean(MemberService.class);

		System.out.print(" 학생 아이디 입력 >> ");
		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			String id = scan.next();

			if (memberService.deleteMember(id) > 0) {
				System.out.println("----------------------------------------");
				System.out.println("[Notice] 입력하신 학생의 정보가 삭제되었습니다.");
			} else {
				System.out.println("----------------------------------------");
				System.out.println("[Error] 존재하지 않는 아이디입니다. 다시 입력해 주세요.");
			}
		} catch (Exception exception) {
			System.out.println("[Error] 잘못된 입력입니다. 다시 입력해 주세요.");
		}
	}

	private static void createStudentInformation() throws Exception {
		MemberService memberService = ctx.getBean(MemberService.class);
		JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);

		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);

			System.out.print(" id       >> ");
			String id = scan.next();

			System.out.println("----------------------------------------");
			System.out.println("아이디 중복 여부를 검사 중입니다···");
			System.out.println("----------------------------------------");
			String query = "SELECT COUNT(*) FROM STUDENT WHERE id = ?";
			int count = jdbcTemplate.queryForObject(query, Integer.class, id);

			if (count > 0) {
				throw new DuplicateKeyException("");
			}

			System.out.println("----------------------------------------");
			System.out.println("사용 가능한 아이디입니다.");
			System.out.println("----------------------------------------");
			System.out.print(" password >> ");
			String passwd = scan.next();
			System.out.print(" username >> ");
			String username = scan.next();
			System.out.print(" snum     >> ");
			String snum = scan.next();
			System.out.print(" depart   >> ");
			String depart = scan.next();
			System.out.print(" mobile   >> ");
			String mobile = scan.next();
			System.out.print(" email    >> ");
			String email = scan.next();
			System.out.println("----------------------------------------");

			StudentVO vo = new StudentVO();
			vo.setId(id);
			vo.setPasswd(passwd);
			vo.setUsername(username);
			vo.setSnum(snum);
			vo.setDepart(depart);
			vo.setMobile(mobile);
			vo.setEmail(email);

			memberService.addMember(vo);

			System.out.println("----------------------------------------");
			System.out.println("[Notice] 입력하신 학생의 정보가 생성되었습니다.");

		} catch (DuplicateKeyException exception) {
			System.out.println("----------------------------------------");
			System.out.println("[Error] 이미 존재하는 아이디입니다. 다른 아이디를 입력해 주세요.");

		}
	}

	private static void printStudentInformation() throws Exception {
		MemberService memberService = ctx.getBean(MemberService.class);
		System.out.print(" 학생 아이디 입력 >> ");

		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			String id = scan.next();

			System.out.println("----------------------------------------");
			StudentVO svo = memberService.readMember(id);
			System.out.println("----------------------------------------");
			System.out.println("id       : " + svo.getId());
			System.out.println("password : " + svo.getPasswd());
			System.out.println("username : " + svo.getUsername());
			System.out.println("snum     : " + svo.getSnum());
			System.out.println("depart   : " + svo.getDepart());
			System.out.println("mobile   : " + svo.getMobile());
			System.out.println("email    : " + svo.getEmail());
		} catch (NullPointerException exception) {
			System.out.println("[Error] 존재하지 않는 아이디입니다. 다시 입력해 주세요.");
		}
	}

	private static void printStudentInformationList() throws Exception {
		MemberService memberService = ctx.getBean(MemberService.class);
		try {
			List<StudentVO> list = memberService.readMemberList();
			for (StudentVO svo : list) {
				System.out.println("----------------------------------------");
				System.out.println("id       : " + svo.getId());
				System.out.println("password : " + svo.getPasswd());
				System.out.println("username : " + svo.getUsername());
				System.out.println("snum     : " + svo.getSnum());
				System.out.println("depart   : " + svo.getDepart());
				System.out.println("mobile   : " + svo.getMobile());
				System.out.println("email    : " + svo.getEmail());
			}
		} catch (DataAccessException exception) {
			System.out.println("[Error] 현재 학생 정보가 없는 상태입니다. 다음에 다시 시도해 주세요.");
		}
	}
}
