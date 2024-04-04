package org.tukorea.di.view;

public class OutputView {
    public void printSystemBanner() {
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
    }
}
