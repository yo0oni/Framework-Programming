package org.tukorea.di.view;

import org.tukorea.di.constant.TextConstant;

public class OutputView {
    public void printSystemBanner() {
        printLine();
        System.out.println();
        System.out.println("           학생 정보 관리 시스템");
        System.out.println();
        printLine();
        System.out.println("1. 전체 학생 정보 출력");
        System.out.println("2. 개인 학생 정보 출력");
        System.out.println("3. 개인 학생 정보 생성");
        System.out.println("4. 개인 학생 정보 삭제");
        System.out.println("5. 개인 학생 정보 수정");
        System.out.println("9. 프로그램 종료");
        printLine();
        printSelectNumber();
    }

    private void printSelectNumber() {
        System.out.print(" 번호 선택 >> ");
    }

    public void printLine() {
        System.out.println(TextConstant.LINE);
    }

    public void printBye() {
        System.out.println("안녕히 가세요.");
    }

    public void printException(NumberFormatException e) {
        System.out.println("[Error] 잘못된 입력입니다. 숫자를 입력해 주세요.");
    }

    public void printException(IllegalArgumentException e) {
        System.out.println("[Error] 잘못된 번호입니다. 다시 입력해 주세요.");
    }
}
