package org.tukorea.di.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scan = new Scanner(System.in);
    public int readSelectedNumber() {
        return Integer.parseInt(scan.nextLine());
    }
}
