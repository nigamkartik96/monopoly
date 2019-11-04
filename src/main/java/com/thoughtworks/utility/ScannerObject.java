package com.thoughtworks.utility;

import java.util.Scanner;

public class ScannerObject {
    static private Scanner scanner;

    static {
        new ScannerObject();
    }

    private ScannerObject() {
        if (scanner == null) scanner = new Scanner(System.in);
    }

    static public Scanner getScannerObject() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
