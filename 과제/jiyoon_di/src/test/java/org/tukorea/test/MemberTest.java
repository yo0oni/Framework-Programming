package org.tukorea.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.service.MemberService;

import static org.junit.Assert.assertThrows;

import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
@Transactional
public class MemberTest {
    @Autowired
    MemberService memberService;

    @Test
    public void addDuplicateStudentId() throws Exception {
        final StudentVO student1 = new StudentVO();
        student1.setId("test");
        student1.setPasswd("");
        student1.setDepart("");
        student1.setEmail("");
        student1.setMobile("");
        student1.setSnum("");
        student1.setUsername("");
        

        final StudentVO student2 = new StudentVO();
        student2.setId("test");
        student2.setPasswd("");
        student2.setDepart("");
        student2.setEmail("");
        student2.setMobile("");
        student2.setSnum("");
        student2.setUsername("");

        memberService.addMember(student1);

        assertThrows(RuntimeException.class, () -> {
            memberService.addMember(student2);
        });
    }
    
    @Test
    public void modifyStudentInformation() throws Exception {
    	final StudentVO student = new StudentVO();
    	student.setId("happy");
    	student.setPasswd("happy");
    	student.setDepart("happy");
    	student.setEmail("happy");
    	student.setMobile("happy");
    	student.setSnum("happy");
    	student.setUsername("happy");
    	
    	memberService.addMember(student);
    	
    	final StudentVO modify = new StudentVO();
    	modify.setId("happy");
    	modify.setPasswd("nonhappy");
    	modify.setDepart("nonhappy");
    	modify.setEmail("nonhappy");
    	modify.setMobile("nonhappy");
    	modify.setSnum("nonhappy");
    	modify.setUsername("nonhappy");
    	
    	memberService.modifyMember(modify);
    	
    	String expected = "nonhappy";
    	String actual = memberService.readMember("happy").getPasswd();
    	Assert.assertEquals(actual, expected);
    	
    }
}
